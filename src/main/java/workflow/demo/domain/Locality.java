package workflow.demo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Locality implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locaId;

	@Column
	private String locadesc;

	public Locality() {

		super();
	}

	public Locality(String locadesc) {

		this.locadesc = locadesc;

	}

	public void setLocaId(Long locaId) {

		this.locaId = locaId;
	}

	public Long getLocaId() {

		return locaId;
	}

	public void setLocadesc(String locadesc) {

		this.locadesc = locadesc;
	}

	public String getLocadesc() {

		return locadesc;
	}

}
