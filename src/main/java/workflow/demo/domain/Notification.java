package workflow.demo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Notificacion")
public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "noti_Id")
	private Long notiId;

	@Column(name = "notificacion")
	private String notificacion;

	// bi-directional many-to-one association to usuario
	@ManyToOne
	@JoinColumn(name = "usuarioId")
	private Usuario usuario;

	// bi-directional many-to-one association to ruteo
	@ManyToOne
	@JoinColumn(name = "ruteoId")
	private Routing ruteo;

	public Notification() {

		super();
	}

	public Notification(String notificacion, Usuario usuario, Routing ruteo) {

		this.notificacion = notificacion;
		this.usuario = usuario;
		this.ruteo = ruteo;
	}

	public void setNotiId(Long notiId) {

		this.notiId = notiId;
	}

	public Long getNotiId() {

		return notiId;
	}

	public void setNotificacion(String notificacion) {

		this.notificacion = notificacion;
	}

	public String getNotificacion() {

		return notificacion;
	}

	public void setUsuario(Usuario usuario) {

		this.usuario = usuario;
	}

	public Usuario getUsuario() {

		return usuario;
	}

	public void setRuteo(Routing ruteo) {

		this.ruteo = ruteo;
	}

	public Routing getRuteo() {

		return ruteo;
	}
}
