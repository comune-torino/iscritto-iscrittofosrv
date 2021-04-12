package it.csi.iscritto.iscrittofosrv.util.itext;

import java.awt.Color;

import com.lowagie.text.Font;

public final class FontConfigurator extends AbstractConfigurator<Font> {

	public static FontConfigurator newInstance() {
		return new FontConfigurator();
	}

	public FontConfigurator setColor(Color color) {
		this.setProperty("color", color);
		return this;
	}

	public FontConfigurator setColor(int red, int green, int blue) {
		this.setProperty("color", new Color(red, green, blue));
		return this;
	}

	public FontConfigurator setFamily(String family) {
		this.setProperty("family", family);
		return this;
	}

	public FontConfigurator setSize(Float size) {
		this.setProperty("size", size);
		return this;
	}

	public FontConfigurator setStyle(Integer style) {
		this.setProperty("style", style);
		return this;
	}

	public FontConfigurator setStyle(String style) {
		this.setProperty("style", style);
		return this;
	}

}
