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
public class DocCattached implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long doccattaId;

	@Column
	private String cattacheddesc;

	@Column
	private String url;

	@ManyToOne
	@JoinColumn(name = "documId")
	private Document documento;

	public DocCattached() {

		super();
		this.documento = new Document();
	}

	public DocCattached(String cattacheddesc, String url, Document documento) {

		this.cattacheddesc = cattacheddesc;
		this.url = url;
		this.documento = documento;
	}

	public void setDoccattaId(Long doccattaId) {

		this.doccattaId = doccattaId;
	}

	public Long getDoccattaId() {

		return doccattaId;
	}

	public void setCattacheddesc(String cattacheddesc) {

		this.cattacheddesc = cattacheddesc;
	}

	public String getCattacheddesc() {

		return cattacheddesc;
	}

	public void setUrl(String url) {

		this.url = url;
	}

	public String getUrl() {

		return url;
	}

	public void setDocumento(Document documento) {

		this.documento = documento;
	}

	public Document getDocumento() {

		return documento;
	}

}
