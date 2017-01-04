package fsm.model.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@javax.persistence.Table(name="fsm_user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee userEmployee;
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "enabled", columnDefinition = "BIT")
	private boolean enabled;
	
	@NotNull
	@Column(name = "accountNonExpired", columnDefinition = "BIT")
	private boolean accountNonExpired;
	
	@NotNull
	@Column(name = "accountNonLocked", columnDefinition = "BIT")
	private boolean accountNonLocked;
	
	@NotNull
	@Column(name = "credentialsNonExpired", columnDefinition = "BIT")
	private boolean credentialsNonExpired;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "user")
	private Set<UserRole> userRoles;

	/*@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne(mappedBy = "user")
	private UserAttempt userAttempt;*/

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	/*public UserAttempt getUserAttempt() {
		return userAttempt;
	}

	public void setUserAttempt(UserAttempt userAttempt) {
		this.userAttempt = userAttempt;
	}*/
	
}
