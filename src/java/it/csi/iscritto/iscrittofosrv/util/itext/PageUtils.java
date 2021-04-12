package it.csi.iscritto.iscrittofosrv.util.itext;

import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

public final class PageUtils {
	private PageUtils() {
		/* NOP */
	}

	public static void addVerticalSpacer(PdfPTable table, float padding) {
		PdfPCell cell = new PdfPCell();
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPaddingBottom(padding);

		table.addCell(cell);
	}

}
