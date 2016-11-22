package fsm.domain.UI;

import javax.persistence.*;
import java.util.Set;


@Entity
@javax.persistence.Table(name="GROUP")
public class GroupUI {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "parent_group_id")
	private GroupUI parentGroup;
	
	@OneToMany(mappedBy = "parentGroup")
	private Set<GroupUI> childGroups;
	
	@OneToMany(mappedBy = "group")
	private Set<EmployeeUI> employees;

	public GroupUI() {
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

	public GroupUI getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(GroupUI parentGroup) {
		this.parentGroup = parentGroup;
	}

	public Set<GroupUI> getChildGroups() {
		return childGroups;
	}

	public void setChildGroups(Set<GroupUI> childGroups) {
		this.childGroups = childGroups;
	}

	public Set<EmployeeUI> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeUI> employees) {
		this.employees = employees;
	}

}
