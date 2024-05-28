package dl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the itinerario database table.
 * 
 */
@Entity
@Table(name="itinerario")
@NamedQuery(name="Itinerario.findAll", query="SELECT i FROM Itinerario i")
@NamedQuery(name="Itinerario.findAllxDest", query="SELECT i FROM Itinerario i WHERE i.destino= :destino")

public class Itinerario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iditinerario;
	private boolean aceptado;
	private String descripcion;
	private String destino;
	private String enlace;
	private String precio;
	private String tipogrupo;

	public Itinerario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIditinerario() {
		return this.iditinerario;
	}

	public void setIditinerario(int iditinerario) {
		this.iditinerario = iditinerario;
	}


	public boolean getAceptado() {
		return this.aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getEnlace() {
		return this.enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}


	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getTipogrupo() {
		return this.tipogrupo;
	}

	public void setTipogrupo(String tipogrupo) {
		this.tipogrupo = tipogrupo;
	}

}