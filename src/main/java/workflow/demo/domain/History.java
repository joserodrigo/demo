package workflow.demo.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="historiales")
public class History implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long histId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha",insertable=false)
	private Date fecha;
	
	@Column
	private Time hora;
	
	@Column
	private String histdesc;
	
	 
    @ManyToOne
    @JoinColumn(name="documId")
    private Document documento;
    
    public History() {
    	super();
    	this.documento = new Document();
    }
    
    public History(Date fecha,Time hora,String histdesc,Document documento) {
    	this.fecha = fecha;
    	this.hora = hora;
    	this.histdesc = histdesc;
    	this.documento = documento;
    }

	public void setHistId(Long histId) {

		this.histId = histId;
	}

	public Long getHistId() {

		return histId;
	}

	public void setFecha(Date fecha) {

		this.fecha = fecha;
	}

	public Date getFecha() {

		return fecha;
	}

	public void setHora(Time hora) {

		this.hora = hora;
	}

	public Time getHora() {

		return hora;
	}

	public void setHistdesc(String histdesc) {

		this.histdesc = histdesc;
	}

	public String getHistdesc() {

		return histdesc;
	}

	public void setDocumento(Document documento) {

		this.documento = documento;
	}

	public Document getDocumento() {

		return documento;
	}

}
