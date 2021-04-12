package it.csi.iscritto.iscrittofosrv.integration.service.nao;

import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.nao.InfoNao;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;

public interface VisuraFamigliaServiceNao {

	InfoNao dettaglioFamigliaPerCodiceFiscale(CallerInfo callerInfo, String codiceFiscale) throws ServiceException;

}
