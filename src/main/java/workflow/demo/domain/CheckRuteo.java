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
@Table(name="checkruteo")
public class CheckRuteo implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="checkruteoId")
    private Long checkruteoId;
    
    @Column(name="tildo")
    private Boolean tildo;
    
    //bi-directional many-to-one association to ruteo
    @ManyToOne
    @JoinColumn(name="ruteoId")
    private Routing routing;
    
    //bi-directional many-to one association to dycheckoption
    @ManyToOne
    @JoinColumn(name="checkId")
    private DyCheckOption dyCheckOption;
    
    //bi-directional many-to one association to document
    @ManyToOne
    @JoinColumn(name="documId")
    private Document document;
    
    public CheckRuteo() {
    	super();
    	this.setRouting(new Routing());
    	this.setDyCheckOption(new DyCheckOption());
        this.document = new Document();
    }
    
    public CheckRuteo(Routing routing,DyCheckOption dyCheckOption,Document document, Boolean tildo) {
    	this.routing = routing;
    	this.dyCheckOption = dyCheckOption;
    	this.document = document;
    	this.tildo = tildo;
    }
	public void setCheckruteoId(Long checkruteoId) {

		this.checkruteoId = checkruteoId;
	}

	public Long getCheckruteoId() {

		return checkruteoId;
	}

	public void setTildo(Boolean tildo) {

		this.tildo = tildo;
	}

	public Boolean getTildo() {

		return tildo;
	}

	public void setRouting(Routing routing) {

		this.routing = routing;
	}

	public Routing getRouting() {

		return routing;
	}

	public void setDyCheckOption(DyCheckOption dyCheckOption) {

		this.dyCheckOption = dyCheckOption;
	}

	public DyCheckOption getDyCheckOption() {

		return dyCheckOption;
	}

	public void setDocument(Document document) {

		this.document = document;
	}

	public Document getDocument() {

		return document;
	}    
}
