package fsm.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity
@javax.persistence.Table(name="EMPLOYEE")
public class Employee {

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
	private Group group;
	
	@OneToOne(mappedBy = "deskEmployee")
	private Desk desk;
	 
	@OneToOne(mappedBy = "userEmployee")
	private User user;

	public Employee() {
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
