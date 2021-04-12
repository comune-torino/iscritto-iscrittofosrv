package it.csi.iscritto.iscrittofosrv.util.itext;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

public abstract class AbstractConfigurator<T> implements Configurable<T> {
	private final Map<String, Property> properties = new HashMap<String, Property>();

	protected static final class Property {
		private String name;
		private Object value;

		public Property(String name, Object value) {
			this.setName(name);
			this.setValue(value);
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Object getValue() {
			return this.value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
	}

	protected final void setProperty(String name, Object value) {
		if (value == null) {
			removeProperty(name);
		}
		else {
			addProperty(name, value);
		}
	}

	protected final void removeProperty(String name) {
		if (this.properties.containsKey(name)) {
			this.properties.remove(name);
		}
	}

	protected final void addProperty(String name, Object value) {
		this.properties.put(name, new Property(name, value));
	}

	protected final Collection<Property> getProperties() {
		return Collections.unmodifiableCollection(this.properties.values());
	}

	public T apply(T target) {
		for (Property p : this.properties.values()) {
			try {
				PropertyUtils.setProperty(target, p.getName(), p.getValue());
			}
			catch (Exception e) {
				throw new IllegalArgumentException(e);
			}
		}

		return target;
	}
}
