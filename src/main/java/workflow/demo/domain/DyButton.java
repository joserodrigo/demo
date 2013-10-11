package workflow.demo.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class DyButton implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long buttonId;
	
	@Column
	private String buttondesc;
	
	@Column
	private Boolean tipo;
	
	@Column
	private Integer action;
	
	// bi-directional many-to-one association to ButtonRuteo
	@OneToMany
	@JoinColumn(name="buttonId")
	private Set<ButtonRuteo> buttonRuteo;
	
	public DyButton() {
		super();
	}
    
	public DyButton(String buttondesc,Boolean tipo, Integer action ) {
		this.buttondesc = buttondesc;
		this.tipo = tipo;
		this.action = action;
	}
	public void setButtonId(Long buttonId) {

		this.buttonId = buttonId;
	}

	public Long getButtonId() {

		return buttonId;
	}

	public void setButtondesc(String buttondesc) {

		this.buttondesc = buttondesc;
	}

	public String getButtondesc() {

		return buttondesc;
	}

	public void setTipo(Boolean tipo) {

		this.tipo = tipo;
	}

	public Boolean getTipo() {

		return tipo;
	}

	public void setAction(Integer action) {

		this.action = action;
	}

	public Integer getAction() {

		return action;
	}

	public void setButtonRuteo(Set<ButtonRuteo> buttonRuteo) {

		this.buttonRuteo = buttonRuteo;
	}

	public Set<ButtonRuteo> getButtonRuteo() {

		return buttonRuteo;
	}
	
}
