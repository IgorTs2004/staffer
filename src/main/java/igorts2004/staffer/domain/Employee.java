package igorts2004.staffer.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
    @Column(name = "id")
    @GeneratedValue	
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "superiorId")
	private Employee superior;
	
	public Employee() {}
	
	public Employee(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getSuperior() {
		return superior;
	}

	public void setSuperior(Employee superior) {
		this.superior = superior;
	}
	
}
