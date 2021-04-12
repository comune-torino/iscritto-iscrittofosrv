package it.csi.iscritto.iscrittofosrv.util.itext;

import java.awt.Color;

import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;

public final class CellConfigurator extends AbstractConfigurator<PdfPCell> {

	public static CellConfigurator newInstance() {
		return new CellConfigurator();
	}

	public CellConfigurator setArabicOptions(Integer arabicOptions) {
		this.setProperty("arabicOptions", arabicOptions);
		return this;
	}

	public CellConfigurator setBackgroundColor(Color backgroundColor) {
		this.setProperty("backgroundColor", backgroundColor);
		return this;
	}

	public CellConfigurator setBorder(Integer border) {
		this.setProperty("border", border);
		return this;
	}

	public CellConfigurator setBorderColor(Color borderColor) {
		this.setProperty("borderColor", borderColor);
		return this;
	}

	public CellConfigurator setBorderColorBottom(Color borderColorBottom) {
		this.setProperty("borderColorBottom", borderColorBottom);
		return this;
	}

	public CellConfigurator setBorderColorLeft(Color borderColorLeft) {
		this.setProperty("borderColorLeft", borderColorLeft);
		return this;
	}

	public CellConfigurator setBorderColorRight(Color borderColorRight) {
		this.setProperty("borderColorRight", borderColorRight);
		return this;
	}

	public CellConfigurator setBorderColorTop(Color borderColorTop) {
		this.setProperty("borderColorTop", borderColorTop);
		return this;
	}

	public CellConfigurator setBorderWidth(Float borderWidth) {
		this.setProperty("borderWidth", borderWidth);
		return this;
	}

	public CellConfigurator setBorderWidthBottom(Float borderWidthBottom) {
		this.setProperty("borderWidthBottom", borderWidthBottom);
		return this;
	}

	public CellConfigurator setBorderWidthLeft(Float borderWidthLeft) {
		this.setProperty("borderWidthLeft", borderWidthLeft);
		return this;
	}

	public CellConfigurator setBorderWidthRight(Float borderWidthRight) {
		this.setProperty("borderWidthRight", borderWidthRight);
		return this;
	}

	public CellConfigurator setBorderWidthTop(Float borderWidthTop) {
		this.setProperty("borderWidthTop", borderWidthTop);
		return this;
	}

	public CellConfigurator setBottom(Float bottom) {
		this.setProperty("bottom", bottom);
		return this;
	}

	public CellConfigurator setCellEvent(PdfPCellEvent cellEvent) {
		this.setProperty("cellEvent", cellEvent);
		return this;
	}

	public CellConfigurator setColspan(Integer colspan) {
		this.setProperty("colspan", colspan);
		return this;
	}

	public CellConfigurator setColumn(ColumnText column) {
		this.setProperty("column", column);
		return this;
	}

	public CellConfigurator setExtraParagraphSpace(Float extraParagraphSpace) {
		this.setProperty("extraParagraphSpace", extraParagraphSpace);
		return this;
	}

	public CellConfigurator setFixedHeight(Float fixedHeight) {
		this.setProperty("fixedHeight", fixedHeight);
		return this;
	}

	public CellConfigurator setFollowingIndent(Float followingIndent) {
		this.setProperty("followingIndent", followingIndent);
		return this;
	}

	public CellConfigurator setGrayFill(Float grayFill) {
		this.setProperty("grayFill", grayFill);
		return this;
	}

	public CellConfigurator setHorizontalAlignment(Integer horizontalAlignment) {
		this.setProperty("horizontalAlignment", horizontalAlignment);
		return this;
	}

	public CellConfigurator setImage(Image image) {
		this.setProperty("image", image);
		return this;
	}

	public CellConfigurator setIndent(Float indent) {
		this.setProperty("indent", indent);
		return this;
	}

	public CellConfigurator setLeft(Float left) {
		this.setProperty("left", left);
		return this;
	}

	public CellConfigurator setMinimumHeight(Float minimumHeight) {
		this.setProperty("minimumHeight", minimumHeight);
		return this;
	}

	public CellConfigurator setNoWrap(Boolean noWrap) {
		this.setProperty("noWrap", noWrap);
		return this;
	}

	public CellConfigurator setPadding(Float padding) {
		this.setProperty("padding", padding);
		return this;
	}

	public CellConfigurator setPaddingLeft(Float paddingLeft) {
		this.setProperty("paddingLeft", paddingLeft);
		return this;
	}

	public CellConfigurator setPaddingRight(Float paddingRight) {
		this.setProperty("paddingRight", paddingRight);
		return this;
	}

	public CellConfigurator setPaddingTop(Float paddingTop) {
		this.setProperty("paddingTop", paddingTop);
		return this;
	}

	public CellConfigurator setPaddingBottom(Float paddingBottom) {
		this.setProperty("paddingBottom", paddingBottom);
		return this;
	}

	public CellConfigurator setPhrase(Phrase phrase) {
		this.setProperty("phrase", phrase);
		return this;
	}

	public CellConfigurator setRight(Float right) {
		this.setProperty("right", right);
		return this;
	}

	public CellConfigurator setRightIndent(Float rightIndent) {
		this.setProperty("rightIndent", rightIndent);
		return this;
	}

	public CellConfigurator setRotation(Integer rotation) {
		this.setProperty("rotation", rotation);
		return this;
	}

	public CellConfigurator setRowspan(Integer rowspan) {
		this.setProperty("rowspan", rowspan);
		return this;
	}

	public CellConfigurator setRunDirection(Integer runDirection) {
		this.setProperty("runDirection", runDirection);
		return this;
	}

	public CellConfigurator setSpaceCharRatio(Float spaceCharRatio) {
		this.setProperty("spaceCharRatio", spaceCharRatio);
		return this;
	}

	public CellConfigurator setTop(Float top) {
		this.setProperty("top", top);
		return this;
	}

	public CellConfigurator setUseDescender(Boolean useDescender) {
		this.setProperty("useDescender", useDescender);
		return this;
	}

	public CellConfigurator setUseBorderPadding(Boolean useBorderPadding) {
		this.setProperty("useBorderPadding", useBorderPadding);
		return this;
	}

	public CellConfigurator setUseVariableBorders(Boolean useVariableBorders) {
		this.setProperty("useVariableBorders", useVariableBorders);
		return this;
	}

	public CellConfigurator setVerticalAlignment(Integer verticalAlignment) {
		this.setProperty("verticalAlignment", verticalAlignment);
		return this;
	}

}
