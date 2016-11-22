package fsm.domain.UI;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@javax.persistence.Table(name="USER")
public class UserUI {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "employee_id")
	private EmployeeUI userEmployee;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleUI role;
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;

	public UserUI() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeUI getUserEmployee() {
		return userEmployee;
	}

	public void setUserEmployee(EmployeeUI userEmployee) {
		this.userEmployee = userEmployee;
	}

	public RoleUI getRole() {
		return role;
	}

	public void setRole(RoleUI role) {
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
