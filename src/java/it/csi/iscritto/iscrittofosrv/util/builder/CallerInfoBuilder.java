package it.csi.iscritto.iscrittofosrv.util.builder;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.util.audit.KnownUsers;
import it.csi.iscritto.iscrittofosrv.util.audit.LogAuditOperations;

public class CallerInfoBuilder implements Builder<CallerInfo> {
	private CallerInfo callerInfo;

	private CallerInfoBuilder(SecurityContext securityContext, HttpServletRequest httpServletRequest) {
		Validate.notNull(httpServletRequest);
		Validate.notNull(securityContext);

		final String ipAddress = httpServletRequest.getRemoteAddr();
		final String idApp = securityContext.getUserPrincipal().getName();

		this.callerInfo = new CallerInfo();
		this.callerInfo.setIpAddress(ipAddress);
		this.callerInfo.setIdApp(ObjectUtils.defaultIfNull(KnownUsers.findUser(idApp).getIdApp(), idApp));
		this.callerInfo.setUtente(idApp);
	}

	public static CallerInfoBuilder from(SecurityContext securityContext, HttpServletRequest httpServletRequest) {
		return new CallerInfoBuilder(securityContext, httpServletRequest);
	}

	public CallerInfoBuilder operazione(LogAuditOperations operazione) {
		Validate.notNull(operazione);
		this.callerInfo.setOperazione(operazione.getOperationName());

		return this;
	}

	public CallerInfoBuilder operazione(String operazione) {
		Validate.notBlank(operazione);
		this.callerInfo.setOperazione(operazione);

		return this;
	}

	public CallerInfoBuilder oggOper(String oggOper) {
		Validate.notBlank(oggOper);
		this.callerInfo.setOggOper(oggOper);

		return this;
	}

	public CallerInfoBuilder keyOper(String keyOper) {
		this.callerInfo.setKeyOper(keyOper);

		return this;
	}

	@Override
	public CallerInfo build() {
		return SerializationUtils.clone(this.callerInfo);
	}
}
