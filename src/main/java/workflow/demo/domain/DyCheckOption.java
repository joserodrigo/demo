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
public class DyCheckOption implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long checkId;

	@Column
	private String checkdesc;

	// bi-directional many-to-one association to CheckRuteo
	@OneToMany
	@JoinColumn(name = "checkId")
	private Set<CheckRuteo> checkRuteo;

	public DyCheckOption() {

		super();
	}

	public DyCheckOption(String checkdesc) {

		this.checkdesc = checkdesc;
	}

	public void setCheckId(Long checkId) {

		this.checkId = checkId;
	}

	public Long getCheckId() {

		return checkId;
	}

	public void setCheckdesc(String checkdesc) {

		this.checkdesc = checkdesc;
	}

	public String getCheckdesc() {

		return checkdesc;
	}

	public void setCheckRuteo(Set<CheckRuteo> checkRuteo) {

		this.checkRuteo = checkRuteo;
	}

	public Set<CheckRuteo> getCheckRuteo() {

		return checkRuteo;
	}

}
