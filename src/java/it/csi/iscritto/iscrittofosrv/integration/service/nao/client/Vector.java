
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vector", namespace = "http://xml.apache.org/xml-soap")
public class Vector {

	protected List<VisuraSoggetto> values;

	@XmlElement(name = "item")
	public List<VisuraSoggetto> getItems() {
		if (values == null) {
			values = new ArrayList<VisuraSoggetto>();
		}

		return this.values;
	}

}
