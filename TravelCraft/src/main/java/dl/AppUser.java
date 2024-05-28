package dl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the AppUser database table.
 * 
 */
@Entity
@NamedQuery(name="AppUser.findAll", query="SELECT a FROM AppUser a")
@NamedQuery(name="AppUser.findAllxusername", query="SELECT a FROM AppUser a WHERE a.username= :username")
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAppUser;
	private String password;
	private String roles;
	private String username;

	public AppUser() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdAppUser() {
		return this.idAppUser;
	}

	public void setIdAppUser(int idAppUser) {
		this.idAppUser = idAppUser;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRoles() {
		return this.roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}