package fsm.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@javax.persistence.Table(name="fsm_role")
@JsonIgnoreProperties("userRoles")
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "role")
	private String roleName;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "role")
	private Set<UserRole> userRoles;
	
	public Role() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
