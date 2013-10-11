package workflow.demo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long deparId;
	
	@Column
	private String depardesc;
	
	public Department() {
		super();
	}
	
	public Department(String depardesc) {
		this.setDepardesc(depardesc);
	}

	public void setDeparId(Long deparId) {

		this.deparId = deparId;
	}

	public Long getDeparId() {

		return deparId;
	}

	public void setDepardesc(String depardesc) {

		this.depardesc = depardesc;
	}

	public String getDepardesc() {

		return depardesc;
	}
}
