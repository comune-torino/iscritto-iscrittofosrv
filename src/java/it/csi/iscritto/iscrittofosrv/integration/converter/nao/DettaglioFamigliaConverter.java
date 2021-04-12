package it.csi.iscritto.iscrittofosrv.integration.converter.nao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.StringUtils;

import it.csi.iscritto.iscrittofosrv.dto.nao.ComponenteFamiglia;
import it.csi.iscritto.iscrittofosrv.dto.nao.DettaglioFamiglia;
import it.csi.iscritto.iscrittofosrv.dto.nao.ResidenzaFamiglia;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils;

public class DettaglioFamigliaConverter extends AbstractConverter<DettaglioFamigliaConverter.Data, DettaglioFamiglia> {

	@Override
	public DettaglioFamiglia convert(Data source) {
		DettaglioFamiglia target = null;
		if (source != null && CollectionUtils.isNotEmpty(source.getComponentiFamiglia())) {
			target = new DettaglioFamiglia();

			target.setResidenzaFamiglia(source.getResidenzaFamiglia());
			target.setMaggiorenni(getMaggiori(source.getComponentiFamiglia()));
			target.setMinorenni(getMinori(source.getComponentiFamiglia()));
			target.setRichiedente(getRichiedente(source.getComponentiFamiglia()));
			target.setConiuge(getConiuge(source.getComponentiFamiglia()));

			adapt(target);
		}

		return target;
	}

	public static final List<ComponenteFamiglia> getMaggiori(List<ComponenteFamiglia> componenti) {
		return ConvertUtils.filter(componenti, new Predicate<ComponenteFamiglia>() {
			@Override
			public boolean evaluate(ComponenteFamiglia componente) {
				return ComponenteFamigliaConverter.isMaggiore(componente);
			}
		});
	}

	public static final List<ComponenteFamiglia> getMinori(List<ComponenteFamiglia> componenti) {
		return ConvertUtils.filter(componenti, new Predicate<ComponenteFamiglia>() {
			@Override
			public boolean evaluate(ComponenteFamiglia componente) {
				return ComponenteFamigliaConverter.isMinore(componente);
			}
		});
	}

	public static final ComponenteFamiglia getRichiedente(List<ComponenteFamiglia> componenti) {
		if (CollectionUtils.isNotEmpty(componenti)) {
			for (ComponenteFamiglia componente : componenti) {
				if (Boolean.TRUE.equals(componente.getRichiedente())) {
					return componente;
				}
			}
		}

		return null;
	}

	public static final ComponenteFamiglia getConiuge(List<ComponenteFamiglia> componenti) {
		if (CollectionUtils.isNotEmpty(componenti)) {
			for (ComponenteFamiglia componente : componenti) {
				if (Boolean.TRUE.equals(componente.getConiugeRichiedente())) {
					return componente;
				}
			}
		}

		return null;
	}

	private static void adapt(DettaglioFamiglia target) {
		final List<ComponenteFamiglia> maggiori = target.getMaggiorenni();

		if (CollectionUtils.isEmpty(maggiori)) {
			return;
		}

		final String numRichiedente = Optional.ofNullable(target.getRichiedente()).orElse(new ComponenteFamiglia()).getNumeroIndividuale();
		if (StringUtils.isNoneBlank(numRichiedente)) {
			ConvertUtils.remove(maggiori, new Predicate<ComponenteFamiglia>() {
				@Override
				public boolean evaluate(ComponenteFamiglia componente) {
					return numRichiedente.equals(componente.getNumeroIndividuale());
				}
			});
		}
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private ResidenzaFamiglia residenzaFamiglia;
		private List<ComponenteFamiglia> componentiFamiglia;

		public ResidenzaFamiglia getResidenzaFamiglia() {
			return residenzaFamiglia;
		}

		public void setResidenzaFamiglia(ResidenzaFamiglia residenzaFamiglia) {
			this.residenzaFamiglia = residenzaFamiglia;
		}

		public List<ComponenteFamiglia> getComponentiFamiglia() {
			return componentiFamiglia;
		}

		public void setComponentiFamiglia(List<ComponenteFamiglia> componentiFamiglia) {
			this.componentiFamiglia = componentiFamiglia;
		}
	}

}
