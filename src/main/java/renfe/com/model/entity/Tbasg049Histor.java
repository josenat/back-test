package renfe.com.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBASG049_HISTOR")
public class Tbasg049Histor {

	@Id
	@Column(name = "T049_IDHISTORICO")
	private Long t049Idhistorico;

	@Column(name = "T049_FECHA")
	private Date t049Fecha;

	@Column(name = "T049_OPERACION")
	private String t049Operacion;

	@Column(name = "T049_REGISTRO")
	private String t049Registro;

	@Column(name = "T049_TABLA")
	private String t049Tabla;

	@Column(name = "T049_USUARIO")
	private String t049Usuario;

	public Long getT049Idhistorico() {
		return this.t049Idhistorico;
	}

	public void setT049Idhistorico(Long t049Idhistorico) {
		this.t049Idhistorico = t049Idhistorico;
	}

	public Date getT049Fecha() {
		return this.t049Fecha;
	}

	public String getT049Operacion() {
		return this.t049Operacion;
	}

	public String getT049Registro() {
		return this.t049Registro;
	}

	public String getT049Tabla() {
		return this.t049Tabla;
	}

	public String getT049Usuario() {
		return this.t049Usuario;
	}

	public void setT049Fecha(Date t049Fecha) {
		this.t049Fecha = t049Fecha;
	}

	public void setT049Operacion(String t049Operacion) {
		this.t049Operacion = t049Operacion;
	}

	public void setT049Registro(String t049Registro) {
		this.t049Registro = t049Registro;
	}

	public void setT049Tabla(String t049Tabla) {
		this.t049Tabla = t049Tabla;
	}

	public void setT049Usuario(String t049Usuario) {
		this.t049Usuario = t049Usuario;
	}

}