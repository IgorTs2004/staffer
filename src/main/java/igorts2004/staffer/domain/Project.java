package igorts2004.staffer.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(targetEntity=Employee.class, fetch = FetchType.EAGER)
	@JoinTable(name = "ProjectParticipant", joinColumns = { @JoinColumn(name = "projectId") }, inverseJoinColumns = { @JoinColumn(name = "employeeId") })
	private Set<Employee> participants;

	public Project() {
	}

	public Project(String name) {
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

	public Set<Employee> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Employee> participants) {
		this.participants = participants;
	}

}
