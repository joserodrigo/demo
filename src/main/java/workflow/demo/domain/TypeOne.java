package workflow.demo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TypeOne implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// relacion con document
	@Id
	@ManyToOne
	@JoinColumn(name = "documId")
	private Document documento;
	
	@Column
	private String motivotrabajo;

	@Column
	private Date fechasalida;

	@Column
	private Date fecharegreso;

	// relacion con funcionario
	@ManyToOne
	@JoinColumn(name = "officialId")
	private Official funcionario;
	
	// relacion con localidad
	@ManyToOne
	@JoinColumn(name = "locaId")
	private Locality localidad;

	// relacion con departamento
	@ManyToOne
	@JoinColumn(name = "deparId")
	private Department departamento;
	
	@Column
	private Integer jefesuperior;

	public TypeOne() {

		super();
		this.documento = new Document();
		this.localidad = new Locality();
		this.departamento = new Department();
		this.funcionario = new Official();
	}

	public TypeOne(Document documento, Date fechasalida, Date fecharegreso,
			String motivotrabajo, Integer jefesuperior, Official funcionario,
			Locality localidad, Department departamento) {

		this.documento = documento;
		this.fecharegreso = fechasalida;
		this.fecharegreso = fecharegreso;
		this.motivotrabajo = motivotrabajo;
		this.jefesuperior = jefesuperior;
		this.funcionario = funcionario;
		this.localidad = localidad;
		this.departamento = departamento;
	}

	public void setDocumento(Document documento) {

		this.documento = documento;
	}

	public Document getDocumento() {

		return documento;
	}

	public void setMotivotrabajo(String motivotrabajo) {

		this.motivotrabajo = motivotrabajo;
	}

	public String getMotivotrabajo() {

		return motivotrabajo;
	}

	public void setFechasalida(Date fechasalida) {

		this.fechasalida = fechasalida;
	}

	public Date getFechasalida() {

		return fechasalida;
	}

	public void setFecharegreso(Date fecharegreso) {

		this.fecharegreso = fecharegreso;
	}

	public Date getFecharegreso() {

		return fecharegreso;
	}

	public void setJefesuperior(Integer jefesuperior) {

		this.jefesuperior = jefesuperior;
	}

	public Integer getJefesuperior() {

		return jefesuperior;
	}

	public void setLocalidad(Locality localidad) {

		this.localidad = localidad;
	}

	public Locality getLocalidad() {

		return localidad;
	}

	public void setDepartamento(Department departamento) {

		this.departamento = departamento;
	}

	public Department getDepartamento() {

		return departamento;
	}

	public void setFuncionario(Official funcionario) {

		this.funcionario = funcionario;
	}

	public Official getFuncionario() {

		return funcionario;
	}

}
