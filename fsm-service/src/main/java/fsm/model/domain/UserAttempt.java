package fsm.model.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@javax.persistence.Table(name="fsm_user_attempt")
public class UserAttempt {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "attempts")
	private String attempts;
	
	@NotNull
	@Column(name = "lastModified")
	private Date lastModified;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public UserAttempt() {
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

	public String getAttempts() {
		return attempts;
	}

	public void setAttempts(String attempts) {
		this.attempts = attempts;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
