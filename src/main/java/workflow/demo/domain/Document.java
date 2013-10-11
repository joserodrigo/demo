package workflow.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
// import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.IndexColumn;

@Entity
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long documId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", insertable = false)
	private Date fechaactual;

	@Column
	private String hora;

	@Column
	private String echeck;

	// relacion con tipo de documento
	@ManyToOne
	@JoinColumn(name = "docId")
	private DocumentType tipoDocumento;

	// relacion con usuario
	@ManyToOne
	@JoinColumn(name = " usuarioId")
	private Usuario usuario;

	// relacion con type uno en forma ordenada(list)
	@OneToMany
	@JoinColumn(name = "documId")
	@IndexColumn(name = "adx")
	private List<TypeOne> typeOne;

	// relacion con doccattached en forma ordenada(list)
	@OneToMany
	@JoinColumn(name = "documId")
	@IndexColumn(name = "adx")
	private List<DocCattached> docCattached;

	// relacion con history en forma ordenada(list)
	@OneToMany
	@JoinColumn(name = "documId")
	@IndexColumn(name = "adx")
	private List<History> history;

	// relacion con checkruteo en forma ordenada(list)
	@OneToMany
	@JoinColumn(name = "documId")
	private List<CheckRuteo> checkRuteo;

	public Document() {

		super();
		this.tipoDocumento = new DocumentType();
		this.usuario = new Usuario();
	}

	public Document(String hora, String echeck, DocumentType tipoDocumento,
			Usuario usuario) {

		this.hora = hora;
		this.echeck = echeck;
		this.tipoDocumento = tipoDocumento;
		this.usuario = usuario;
		// this.fechaactual = fechaactual;
	}

	public void setDocumId(Long documId) {

		this.documId = documId;
	}

	public Long getDocumId() {

		return documId;
	}

	public void setFechaactual(Date fechaactual) {

		this.fechaactual = fechaactual;
	}

	public Date getFechaactual() {

		return fechaactual;
	}

	public void setHora(String hora) {

		this.hora = hora;
	}

	public String getHora() {

		return hora;
	}

	public void setEcheck(String echeck) {

		this.echeck = echeck;
	}

	public String getEcheck() {

		return echeck;
	}

	public DocumentType getTipoDocumento() {

		return tipoDocumento;
	}

	public void setTipoDocumento(DocumentType tipoDocumento) {

		this.tipoDocumento = tipoDocumento;
	}

	public void setUsuario(Usuario usuario) {

		this.usuario = usuario;
	}

	public Usuario getUsuario() {

		return usuario;
	}

	public void setTypeOne(List<TypeOne> typeOne) {

		this.typeOne = typeOne;
	}

	public List<TypeOne> getTypeOne() {

		return typeOne;
	}

	public void setDocCattached(List<DocCattached> docCattached) {

		this.docCattached = docCattached;
	}

	public List<DocCattached> getDocCattached() {

		return docCattached;
	}

	public void setHistory(List<History> history) {

		this.history = history;
	}

	public List<History> getHistory() {

		return history;
	}

	public void setCheckRuteo(List<CheckRuteo> checkRuteo) {

		this.checkRuteo = checkRuteo;
	}

	public List<CheckRuteo> getCheckRuteo() {

		return checkRuteo;
	}


}
