package clases;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Vector;

public class Aviso {

	private String dni_emple, motivo;
	private LocalDateTime fh_leido, fh_creado;
	private Vector<String> destinatarios;
	private Date date;
	
	public Aviso(String dni_emple, String motivo, LocalDateTime fh_creado, Vector<String> destinatarios) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
		this.fh_creado = fh_creado;
		this.destinatarios = destinatarios;
	}
	
	public Aviso(String dni_emple, String motivo, LocalDateTime fh_creado) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
		this.fh_creado = fh_creado;
	}

	public Aviso(String dni_emple, String motivo, Date date) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
		this.date = date;
	}
	
	public Aviso(String dni_emple, String motivo) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
	}

	public String getDni_emple() {
		return dni_emple;
	}

	public String getMotivo() {
		return motivo;
	}

	public LocalDateTime getFh_leido() {
		return fh_leido;
	}

	public LocalDateTime getFh_creado() {
		return fh_creado;
	}

	public Vector<String> getDestinatarios() {
		return destinatarios;
	}

	public Date getDate() {
		return date;
	}
	
	
	
} 
