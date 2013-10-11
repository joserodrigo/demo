package workflow.demo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ButtonRuteo implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="buttonruteo_id")
    private Long buttonruteoid;
    
  //bi-directional many-to-one association to ruteo
    @ManyToOne
	@JoinColumn(name="ruteoId")
	private Routing ruteo;
    
  //bi-directional many-to-one association to dybutton
    @ManyToOne
	@JoinColumn(name="buttonId")
	private DyButton dybutton;
    
    public ButtonRuteo() {
    	super();
    	this.ruteo= new Routing();
    	this.dybutton = new DyButton();
    }
    
    public ButtonRuteo(Routing ruteo,DyButton dybutton) {
    	this.ruteo = ruteo;
    	this.dybutton = dybutton;
    }

	public void setButtonruteo_id(Long buttonruteoid) {

		this.buttonruteoid = buttonruteoid;
	}

	public Long getButtonruteoid() {

		return buttonruteoid;
	}

	public void setRuteo(Routing ruteo) {

		this.ruteo = ruteo;
	}

	public Routing getRuteo() {

		return ruteo;
	}

	public void setDybutton(DyButton dybutton) {

		this.dybutton = dybutton;
	}

	public DyButton getDybutton() {

		return dybutton;
	}
}
