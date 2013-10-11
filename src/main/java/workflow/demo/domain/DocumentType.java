package workflow.demo.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.IndexColumn;

@Entity
public class DocumentType implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
	private Long docId;
	
	@Column
	private String docdesc;
	
	// relacion con document
	 @OneToMany(cascade=CascadeType.ALL)
	 @JoinColumn(name="docId")
	 @IndexColumn(name="adx")
     private List<Document> document;
	
	public DocumentType() {
		super();
	}
	
	public DocumentType(String docdesc) {
		this.docdesc = docdesc;
	}
	
	public Long getDocId() {
		return docId;
	}
	
	public void setDocId(Long docId) {
		this.docId = docId;
	}
	
	public String getDocdesc() {
		return docdesc;
	}
	
	public void setDocdesc(String docdesc) {
		this.docdesc = docdesc;
	}

	public void setDocument(List<Document> document) {

		this.document = document;
	}

	public List<Document> getDocument() {

		return document;
	}

}
