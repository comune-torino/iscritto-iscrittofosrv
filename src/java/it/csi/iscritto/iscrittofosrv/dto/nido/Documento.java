package it.csi.iscritto.iscrittofosrv.dto.nido;

import java.io.Serializable;

public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Boolean eliminato;
	private File file;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getEliminato() {
		return eliminato;
	}

	public void setEliminato(Boolean eliminato) {
		this.eliminato = eliminato;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
