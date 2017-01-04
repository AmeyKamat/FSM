package fsm.model.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@javax.persistence.Table(name="fsm_employee")
@JsonIgnoreProperties({ "desk", "user" })
@JsonFilter("filter")
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

	public Employee(String brid, String name) {
		this.brid = brid;
		this.name = name;
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
