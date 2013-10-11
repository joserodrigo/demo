package workflow.demo.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "section")
public class Section implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sectionId")
	private Long sectionId;

	@Column(name = "sectiondesc")
	private String sectiondesc;

	// relacion One to Many con funcionario
	@OneToMany
	@JoinColumn(name = "sectionId")
	@IndexColumn(name = "adx")
	private List<Official> Official;

	public Section() {

		super();
	}

	public Section(String sectiondesc) {

		this.sectiondesc = sectiondesc;
	}

	public void setSectionId(Long sectionId) {

		this.sectionId = sectionId;
	}

	public Long getSectionId() {

		return sectionId;
	}

	public void setSectiondesc(String sectiondesc) {

		this.sectiondesc = sectiondesc;
	}

	public String getSectiondesc() {

		return sectiondesc;
	}

	public void setOfficial(List<Official> official) {

		Official = official;
	}

	public List<Official> getOfficial() {

		return Official;
	}

}
