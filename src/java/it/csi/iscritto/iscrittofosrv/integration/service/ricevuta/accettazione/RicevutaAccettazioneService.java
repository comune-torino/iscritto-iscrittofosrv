package it.csi.iscritto.iscrittofosrv.integration.service.ricevuta.accettazione;

import static com.lowagie.text.FontFactory.HELVETICA;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import it.csi.iscritto.iscrittofosrv.dto.domanda.RicevutaAccettazione;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.itext.CellConfigurator;
import it.csi.iscritto.iscrittofosrv.util.itext.PageUtils;

public final class RicevutaAccettazioneService {
	private static final String LOGO_FILE_NAME = "citta-di-torino.png";

	private static final Font HELVETICA_11_NORMAL = FontFactory.getFont(HELVETICA, 11, Font.NORMAL);
	private static final Font HELVETICA_12_NORMAL = FontFactory.getFont(HELVETICA, 12, Font.NORMAL);
	private static final Font HELVETICA_12_BOLD_ITALIC = FontFactory.getFont(HELVETICA, 12, Font.BOLDITALIC);
	private static final Font HELVETICA_14_BOLD = FontFactory.getFont(HELVETICA, 14, Font.BOLD);
	private static final Font HELVETICA_16_BOLD = FontFactory.getFont(HELVETICA, 16, Font.BOLD);

	private static final float MARGIN_LEFT = 30f;
	private static final float MARGIN_RIGHT = 30f;
	private static final float MARGIN_TOP = 25f;
	private static final float MARGIN_BOTTOM = 25f;
	private static final float[] COLUMN_WIDTHS = new float[] { 100f };

	public static byte[] createDocument(RicevutaAccettazione ricevuta) throws Exception {
		byte[] result;

		Document document = new Document(
				PageSize.A4,
				MARGIN_LEFT,
				MARGIN_RIGHT,
				MARGIN_TOP,
				MARGIN_BOTTOM);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, baos);
		writer.setPageEvent(new PdfPageEventHelper());

		document.open();
		document.add(buildMainContent(ricevuta));
		document.close();
		result = baos.toByteArray();

		result = addFooter(document, result);

		return result;
	}

	public static byte[] addFooter(Document document, byte[] rawDocument) throws IOException, DocumentException {
		PdfReader reader = new PdfReader(rawDocument);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfStamper stamper = new PdfStamper(reader, baos);

		int nPages = reader.getNumberOfPages();
		int ADJ_V = -7;
		int ADJ_H = 0;
		for (int i = 1; i <= nPages; i++) {
			PdfPTable tableFooter = buildFooter();

			float left = document.left();
			float right = document.right();
			float bottom = document.bottom();
			float totalHeight = tableFooter.getTotalHeight();

			tableFooter.setTotalWidth(right - left);
			tableFooter.writeSelectedRows(0, -1, left + ADJ_H, totalHeight + bottom - ADJ_V, stamper.getOverContent(i));
		}

		stamper.close();
		reader.close();

		return baos.toByteArray();
	}

	//////////////////////////////////////////////////////////////////////

	private static PdfPTable buildMainContent(RicevutaAccettazione ricevuta) throws Exception {
		PdfPTable result = new PdfPTable(COLUMN_WIDTHS);
		result.setWidthPercentage(100f);

		addLogo(result, ricevuta);
		addTitle(result, ricevuta);
		addDatiAccettazione(result, ricevuta);
		addDatiRiepilogo(result, ricevuta);
		addTestiInformativi(result, ricevuta);

		return result;
	}

	private static void addLogo(PdfPTable table, RicevutaAccettazione ricevuta) throws Exception {
		CellConfigurator config = CellConfigurator.newInstance()
				.setHorizontalAlignment(Element.ALIGN_CENTER)
				.setVerticalAlignment(Element.ALIGN_CENTER)
				.setBorder(Rectangle.NO_BORDER)
				.setPadding(0f);

		Image img = Image.getInstance(RicevutaAccettazioneService.class.getClassLoader().getResource(LOGO_FILE_NAME));
		img.scaleToFit(150f, 75f);

		table.addCell(config.apply(new PdfPCell(img)));
	}

	private static void addTitle(PdfPTable table, RicevutaAccettazione ricevuta) {
		CellConfigurator config = CellConfigurator.newInstance()
				.setHorizontalAlignment(Element.ALIGN_CENTER)
				.setVerticalAlignment(Element.ALIGN_CENTER)
				.setBorder(Rectangle.NO_BORDER)
				.setPadding(2f);

		addRow(table, config, ContentEnum.TITLE.getText(ricevuta), HELVETICA_16_BOLD);
	}

	private static void addDatiAccettazione(PdfPTable table, RicevutaAccettazione ricevuta) {
		CellConfigurator config = CellConfigurator.newInstance()
				.setHorizontalAlignment(Element.ALIGN_JUSTIFIED)
				.setVerticalAlignment(Element.ALIGN_LEFT)
				.setBorder(Rectangle.NO_BORDER)
				.setPadding(2f);

		PageUtils.addVerticalSpacer(table, 10f);
		addRow(table, config, ContentEnum.PHRASE_001.getText(ricevuta), HELVETICA_12_NORMAL);
		addRow(table, config, ContentEnum.PHRASE_002.getText(ricevuta), HELVETICA_12_NORMAL);
		addRow(table, config, ContentEnum.PHRASE_003.getText(ricevuta), HELVETICA_12_NORMAL);
		addRow(table, config, ContentEnum.PHRASE_004.getText(ricevuta), HELVETICA_12_NORMAL);
		addRow(table, config, ContentEnum.PHRASE_005.getText(ricevuta), HELVETICA_12_NORMAL);

		PageUtils.addVerticalSpacer(table, 10f);
		addRow(table, config, ContentEnum.PHRASE_006.getText(ricevuta), HELVETICA_12_NORMAL);

		if (checkCategoriaScuola(ricevuta, "P")) {
			addRow(table, config, ContentEnum.PHRASE_007_B.getText(ricevuta), HELVETICA_12_NORMAL);
		}
		else {
			addRow(table, config, ContentEnum.PHRASE_007_A.getText(ricevuta), HELVETICA_12_NORMAL);
		}

		addRow(table, config, ContentEnum.PHRASE_009.getText(ricevuta), HELVETICA_12_NORMAL);
		addRow(table, config, ContentEnum.PHRASE_010.getText(ricevuta), HELVETICA_12_NORMAL);
	}

	private static void addDatiRiepilogo(PdfPTable table, RicevutaAccettazione ricevuta) {
		CellConfigurator config = CellConfigurator.newInstance()
				.setHorizontalAlignment(Element.ALIGN_JUSTIFIED)
				.setVerticalAlignment(Element.ALIGN_LEFT)
				.setBorder(Rectangle.NO_BORDER)
				.setPadding(2f);

		PageUtils.addVerticalSpacer(table, 10f);
		if (checkCategoriaScuola(ricevuta, "M", "A")) {
			addRow(table, config, ContentEnum.PHRASE_011_A.getText(ricevuta), HELVETICA_12_NORMAL);
		}
		else if (checkCategoriaScuola(ricevuta, "C")) {
			addRow(table, config, ContentEnum.PHRASE_011_B.getText(ricevuta), HELVETICA_12_NORMAL);
		}
		else if (checkCategoriaScuola(ricevuta, "P")) {
			addRow(table, config, ContentEnum.PHRASE_011_C.getText(ricevuta), HELVETICA_12_NORMAL);
		}

		addRow(table, config, ContentEnum.PHRASE_012.getText(ricevuta), HELVETICA_12_NORMAL);
	}

	private static void addTestiInformativi(PdfPTable table, RicevutaAccettazione ricevuta) {
		CellConfigurator config = CellConfigurator.newInstance()
				.setHorizontalAlignment(Element.ALIGN_JUSTIFIED)
				.setVerticalAlignment(Element.ALIGN_LEFT)
				.setBorder(Rectangle.NO_BORDER)
				.setPadding(2f);

		CellConfigurator titleConfig = CellConfigurator.newInstance()
				.setHorizontalAlignment(Element.ALIGN_CENTER)
				.setVerticalAlignment(Element.ALIGN_CENTER)
				.setBorder(Rectangle.NO_BORDER)
				.setPadding(2f);

		PageUtils.addVerticalSpacer(table, 10f);
		addRow(table, titleConfig, ContentEnum.PHRASE_013.getText(ricevuta), HELVETICA_14_BOLD);

		if (checkCategoriaScuola(ricevuta, "M", "A")) {
			addRow(table, config, ContentEnum.PHRASE_014_1.getText(ricevuta), HELVETICA_12_BOLD_ITALIC);
			if (StringUtils.isNotBlank(ricevuta.getCodTipoPasto())) {
				addRow(table, config, ContentEnum.PHRASE_014_2.getText(ricevuta), HELVETICA_12_NORMAL);
			}
			addRow(table, config, ContentEnum.PHRASE_014_3.getText(ricevuta), HELVETICA_12_NORMAL);
			addRow(table, config, ContentEnum.PHRASE_014_4.getText(ricevuta), HELVETICA_12_NORMAL);
		}

		PageUtils.addVerticalSpacer(table, 10f);
		addRow(table, config, ContentEnum.PHRASE_015.getText(ricevuta), HELVETICA_12_BOLD_ITALIC);

		if (checkCategoriaScuola(ricevuta, "C", "A", "P")) {
			addRow(table, config, ContentEnum.PHRASE_016_A.getText(ricevuta), HELVETICA_12_NORMAL);
		}
		if (checkCategoriaScuola(ricevuta, "M")) {
			addRow(table, config, ContentEnum.PHRASE_016_B.getText(ricevuta), HELVETICA_12_NORMAL);
		}

		PageUtils.addVerticalSpacer(table, 10f);
		addRow(table, config, ContentEnum.PHRASE_017.getText(ricevuta), HELVETICA_12_BOLD_ITALIC);

		if (checkCategoriaScuola(ricevuta, "P")) {
			addRow(table, config, ContentEnum.PHRASE_017_B.getText(ricevuta), HELVETICA_12_NORMAL);
		}
		else {
			addRow(table, config, ContentEnum.PHRASE_017_A.getText(ricevuta), HELVETICA_12_NORMAL);
		}

		//PageUtils.addVerticalSpacer(table, 10f);
		//if (checkCategoriaScuola(ricevuta, "M", "A")) {
		//	addRow(table, config, ContentEnum.PHRASE_018_A_1.getText(ricevuta), HELVETICA_12_BOLD_ITALIC);
		//	addRow(table, config, ContentEnum.PHRASE_018_A_2.getText(ricevuta), HELVETICA_12_NORMAL);
		//	addRow(table, config, ContentEnum.PHRASE_018_A_3.getText(ricevuta), HELVETICA_12_NORMAL);
		//}
		if (checkCategoriaScuola(ricevuta, "C")) {
			addRow(table, config, ContentEnum.PHRASE_018_B.getText(ricevuta), HELVETICA_12_NORMAL);
		}
	}

	private static PdfPTable buildFooter() {
		CellConfigurator config = CellConfigurator.newInstance()
				.setHorizontalAlignment(Element.ALIGN_JUSTIFIED)
				.setVerticalAlignment(Element.ALIGN_BOTTOM)
				.setBorder(Rectangle.TOP)
				.setPadding(0f)
				.setPaddingBottom(5f);

		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(100f);

		Date now = new Date();
		String text = String.format(ContentEnum.FOOTER.getTemplate(),
				DateUtils.toStringDate(now, DateUtils.DEFAULT_DATE_FORMAT),
				DateUtils.toStringDate(now, "HH:mm"));

		addRow(table, config, text, HELVETICA_11_NORMAL);

		return table;
	}

	private static boolean checkCategoriaScuola(RicevutaAccettazione ricevuta, String... values) {
		if (ricevuta == null || values == null) {
			return false;
		}

		String codCategotiaScu = ricevuta.getCodiceCategoriaScu();
		for (String value : values) {
			if (value.equalsIgnoreCase(codCategotiaScu)) {
				return true;
			}
		}

		return false;
	}

	private static void addRow(PdfPTable table, CellConfigurator config, String text, Font font) {
		if (StringUtils.isBlank(text)) {
			return;
		}

		table.addCell(config.apply(new PdfPCell(new Phrase(text, font))));
	}

}
