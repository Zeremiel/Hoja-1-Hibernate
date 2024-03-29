package BBDD_Modelo_;

import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "seguro", catalog = "seguros", uniqueConstraints = @UniqueConstraint(columnNames = "nif"))
public class Seguro implements java.io.Serializable 
{
	private Integer idSeguro;
	private String nif;
	private String nombre;
	private String ape1;
	private String ape2;
	private Integer edad;
	private Integer sexo;
	private String casado;
	private Integer numHijos;
	private Date fechaCreacion;
	public enum TipoSeguro {HOGAR,COCHE,MOTO,VIAJE};	
	private TipoSeguro tipoSeguro;
	private boolean mayorEdad;
	private Date fechaNacimiento;
	private LocalTime horaContacto; 
	private char[] claves;
	private String comentarios;
	
	public Seguro() {}

	public Seguro(String nif) {
		this.nif = nif;
	}

	public Seguro(String nif, String nombre, String ape1, String ape2, Integer edad, Integer sexo, String casado,
			Integer numHijos, Date fechaCreacion, TipoSeguro tipoSeguro, boolean mayorEdad) {
		this.nif = nif;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.edad = edad;
		this.sexo = sexo;
		this.casado = casado;
		this.numHijos = numHijos;
		this.fechaCreacion = fechaCreacion;
		this.tipoSeguro = tipoSeguro;
		this.mayorEdad = mayorEdad;
	}	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idSeguro", unique = true, nullable = false)
	public Integer getIdSeguro() {
		return this.idSeguro;
	}

	public void setIdSeguro(Integer idSeguro) {
		this.idSeguro = idSeguro;
	}

	@Column(name = "nif", unique = true, nullable = false)
	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ape1")
	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	@Column(name = "ape2")
	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	@Column(name = "edad")
	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Column(name = "sexo")
	public Integer getSexo() {
		return this.sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	@Column(name = "casado", length = 1)
	public String getCasado() {
		return this.casado;
	}

	public void setCasado(String casado) {
		this.casado = casado;
	}

	@Column(name = "numHijos")
	public Integer getNumHijos() {
		return this.numHijos;
	}

	public void setNumHijos(Integer numHijos) {
		this.numHijos = numHijos;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaCreacion", length = 19)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoSeguro")
	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}
	
	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	
		
	
	@Column(name = "fechaNacimiento")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	@Column(name = "horaContacto")
	public LocalTime getHoraContacto() {
		return horaContacto;
	}

	public void setHoraContacto(LocalTime horaContacto) {
		this.horaContacto = horaContacto;
	}

	@Column(name = "mayorEdad")
	public boolean isMayorEdad() {
		return mayorEdad;
	}

	public void setMayorEdad(boolean mayorEdad) {
		this.mayorEdad = mayorEdad;
	}
	
	@Lob
	@Column(name="claves")
	public char[] getCodigo() {
		return claves;
	}

	public void setCodigo(char[] claves) {
		this.claves = claves;
	}

	@Override
	//Este es el metodo ToString que devuelve la info del seguro
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", nif=" + nif + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2="
				+ ape2 + ", edad=" + edad + ", sexo=" + sexo + ", casado=" + casado + ", numHijos=" + numHijos
				+ ", fechaCreacion=" + fechaCreacion + ", tipoSeguro=" + tipoSeguro + "]";
	}
	@Lob
	@Column(name="comentarios")
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public boolean calculaMayorEdad(int edad)
	{
		return edad >= 18;
	}
	
	

}
