package fsm.model.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@javax.persistence.Table(name="fsm_user_role")
public class UserRole {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public UserRole() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public String getRoleName() {
		return role.getRoleName();
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
