package fsm.model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@javax.persistence.Table(name="GROUP_S")
public class Group {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "parent_group_id")
	private Group parentGroup;
	
	@OneToMany(mappedBy = "parentGroup")
	private List<Group> childGroups;
	
	@OneToMany(mappedBy = "group")
	private List<Employee> employees;

	public Group() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(Group parentGroup) {
		this.parentGroup = parentGroup;
	}

	public List<Group> getChildGroups() {
		return childGroups;
	}

	public void setChildGroups(List<Group> childGroups) {
		this.childGroups = childGroups;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
