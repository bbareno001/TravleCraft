package dl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the guardado database table.
 * 
 */
@Entity
@Table(name="guardado")
@NamedQuery(name="Guardado.findAll", query="SELECT g FROM Guardado g")
@NamedQuery(name="Guardado.findAllxUser", query="SELECT g FROM Guardado g WHERE g.appUser= :appUser")

public class Guardado implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idguardados;
	private AppUser appUser;
	private Itinerario itinerario;

	public Guardado() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdguardados() {
		return this.idguardados;
	}

	public void setIdguardados(int idguardados) {
		this.idguardados = idguardados;
	}


	//uni-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="AppUser_idAppUser")
	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}


	//uni-directional many-to-one association to Itinerario
	@ManyToOne
	public Itinerario getItinerario() {
		return this.itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

}