package dl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the valoracion database table.
 * 
 */
@Entity
@Table(name="valoracion")
@NamedQuery(name="Valoracion.findAll", query="SELECT v FROM Valoracion v")
@NamedQuery(name="Valoracion.findAllxDest", query="SELECT v FROM Valoracion v WHERE v.itinerario= :itinerario")
public class Valoracion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idvaloracion;
	private String comentario;
	private int nota;
	private Itinerario itinerario;

	public Valoracion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdvaloracion() {
		return this.idvaloracion;
	}

	public void setIdvaloracion(int idvaloracion) {
		this.idvaloracion = idvaloracion;
	}


	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public int getNota() {
		return this.nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
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