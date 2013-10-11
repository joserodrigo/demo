package workflow.demo.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "official")
public class Official implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "officialId")
	private Integer officialId;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "email")
	private String email;

	// relacion Many to One con section del funcionario
	@ManyToOne
	@JoinColumn(name = "sectionId")
	private Section section;

	// relacion One to Many con Viaticos
	@OneToMany
	@JoinColumn(name = "officialId")
	@IndexColumn(name = "adx")
	private List<TypeOne> typeOne;
	
//	private String sectiondesc;

	public Official() {
		super();
		this.section = new Section();
	}
	
	public Official(Integer officialId, String nombre, String apellido,
			String direccion, String telefono, String email) {
		this.officialId = officialId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	public Official(Integer officialId, String nombre, String apellido,
			String direccion, String telefono, String email, Section section) {
		this(officialId, nombre, apellido, direccion, telefono, email);
		setSection(section);
	}
	
//	public Official(String nombre, String apellido, String telefono,
//		String email) {
//
//		this.nombre = nombre;
//		this.apellido = apellido;
//		this.telefono = telefono;
//		this.email = email;				
////        this.sectiondesc = sectiondesc;
//	}


	public void setOfficialId(Integer officialId) {

		this.officialId = officialId;
	}

	public Integer getOfficialId() {

		return officialId;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public String getNombre() {

		return nombre;
	}

	public void setApellido(String apellido) {

		this.apellido = apellido;
	}

	public String getApellido() {

		return apellido;
	}

	public void setDireccion(String direccion) {

		this.direccion = direccion;
	}

	public String getDireccion() {

		return direccion;
	}

	public void setTelefono(String telefono) {

		this.telefono = telefono;
	}

	public String getTelefono() {

		return telefono;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getEmail() {

		return email;
	}

	public void setSection(Section section) {

		this.section = section;
	}

	public Section getSection() {

		return section;
	}

	public void setTypeOne(List<TypeOne> typeOne) {

		this.typeOne = typeOne;
	}

	public List<TypeOne> getTypeOne() {

		return typeOne;
	}

}
