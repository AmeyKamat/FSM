package fsm.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee userEmployee;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getUserEmployee() {
		return userEmployee;
	}

	public void setUserEmployee(Employee userEmployee) {
		this.userEmployee = userEmployee;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
