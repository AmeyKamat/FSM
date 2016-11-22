package fsm.domain.UI;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@javax.persistence.Table(name="EMPLOYEE")
public class EmployeeUI {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "brid")
	private String brid;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "group_id")
	private GroupUI group;

	@OneToOne(mappedBy = "deskEmployee")
	private DeskUI desk;

	@OneToOne(mappedBy = "userEmployee")
	private UserUI user;

	public EmployeeUI() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrid() {
		return brid;
	}

	public void setBrid(String brid) {
		this.brid = brid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GroupUI getGroup() {
		return group;
	}

	public void setGroup(GroupUI group) {
		this.group = group;
	}

	public DeskUI getDesk() {
		return desk;
	}

	public void setDesk(DeskUI desk) {
		this.desk = desk;
	}

	public UserUI getUser() {
		return user;
	}

	public void setUser(UserUI user) {
		this.user = user;
	}

}
