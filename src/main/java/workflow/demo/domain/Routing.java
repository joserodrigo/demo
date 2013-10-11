package workflow.demo.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Routing implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long ruteoId;
	
	@Column
	private Integer posorigen;
	
	@Column
	private Integer posdestino;
	
	@Column
	private String ruteodesc;
	
	// bi-directional many-to-one association to Notificacion
	@OneToMany
	@JoinColumn(name="ruteoId")
	private Set<Notification> notificacion;
	
	// bi-directional many-to-one association to ButtonRuteo
	@OneToMany
	@JoinColumn(name="ruteoId")
	private Set<ButtonRuteo> buttonRuteo;
	
	// bi-directional many-to-one association to CheckRuteo
	@OneToMany
	@JoinColumn(name="ruteoId")
	private Set<CheckRuteo> checkruteo;
	
	public Routing() {
		super();
	}
	
	public Routing(Integer posorigen,Integer posdestino,String ruteodesc) {
		this.posorigen = posorigen;
		this.posdestino = posdestino;
		this.ruteodesc = ruteodesc;
	}

	public void setRuteoId(Long ruteoId) {

		this.ruteoId = ruteoId;
	}

	public Long getRuteoId() {

		return ruteoId;
	}

	public void setPosorigen(Integer posorigen) {

		this.posorigen = posorigen;
	}

	public Integer getPosorigen() {

		return posorigen;
	}

	public void setPosdestino(Integer posdestino) {

		this.posdestino = posdestino;
	}

	public Integer getPosdestino() {

		return posdestino;
	}

	public void setRuteodesc(String ruteodesc) {

		this.ruteodesc = ruteodesc;
	}

	public String getRuteodesc() {

		return ruteodesc;
	}

	public void setNotificacion(Set<Notification> notificacion) {

		this.notificacion = notificacion;
	}

	public Set<Notification> getNotificacion() {

		return notificacion;
	}

//	public void setCheckruteo(Set<CheckRuteo> checkruteo) {
//
//		this.checkruteo = checkruteo;
//	}
//
//	public Set<CheckRuteo> getCheckruteo() {
//
//		return checkruteo;
//	}

	public void setButtonRuteo(Set<ButtonRuteo> buttonRuteo) {

		this.buttonRuteo = buttonRuteo;
	}

	public Set<ButtonRuteo> getButtonRuteo() {

		return buttonRuteo;
	}

	public void setCheckruteo(Set<CheckRuteo> checkruteo) {

		this.checkruteo = checkruteo;
	}

	public Set<CheckRuteo> getCheckruteo() {

		return checkruteo;
	}


}
