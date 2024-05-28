package pl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.LogicaNegocio;
import dl.AppUser;
import dl.Guardado;
import dl.Itinerario;
import dl.Valoracion;

@Named
@ViewScoped

public class AdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB

	private LogicaNegocio ln;

	private String Destino;
	private String Descripcion;
	private String Precio;
	private String Grupo;
	private String Enlace;
	private String nombrexIt;
	private String nombre;
	private String contra;
	private int nota;
	private String comentario;
	private int idIt;
	private boolean c= false;
	
	private List<Itinerario> listaIt;
	private List<Itinerario> listaItSelec= new ArrayList<Itinerario>();
	private Itinerario itinerario = new Itinerario();
	private List<AppUser> listaUs;
	private List<Guardado> guar;
	private List<Valoracion> ListaVal;
	
	
	
	public boolean isC() {
		return c;
	}

	public void setC(boolean c) {
		this.c = c;
	}

	public int getIdIt() {
		return idIt;
	}

	public void setIdIt(int idIt) {
		this.idIt = idIt;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public List<Valoracion> getListaVal() {
		
		return ListaVal;
	}

	public void setListaVal(List<Valoracion> listaVal) {
		ListaVal = listaVal;
	}

	public List<Guardado> getGuar() {
		
		
		if (guar == null) {

			guar = ln.getGuardado();

			
		}
		return guar;
	}

	public void setGuar(List<Guardado> guar) {
		this.guar = guar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public String getPrecio() {
		return Precio;
	}

	public void setPrecio(String precio) {
		Precio = precio;
	}

	public String getGrupo() {
		return Grupo;
	}

	public void setGrupo(String grupo) {
		Grupo = grupo;
	}

	public String getEnlace() {
		return Enlace;
	}

	public void setEnlace(String enlace) {
		Enlace = enlace;
	}

	public List<Itinerario> getListaIt() {

		if (listaIt == null) {

			listaIt = ln.getItinerarios();
		}

		return listaIt;
	}

	public void setListaIt(List<Itinerario> listaIt) {
		this.listaIt = listaIt;
	}
	

	public List<AppUser> getListaUs() {
		
		if (listaUs == null) {
			listaUs = ln.getAppUser();
		}
		;
		return listaUs;
	}

	public void setListaUs(List<AppUser> listaUs) {
		this.listaUs = listaUs;
	}

	public List<Itinerario> getListaItSelec() {
		
		return listaItSelec;
	}

	public void setListaItSelec(List<Itinerario> listaItSelec) {

		this.listaItSelec = listaItSelec;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public String getNombrexIt() {
		return nombrexIt;
	}

	public void setNombrexIt(String nombrexIt) {
		this.nombrexIt = nombrexIt;
	}
	
	public String publicarItinerario() {
		
		ln.publicaIT(itinerario);
		
		return "Buscar";
	}

	public String guardarItinerario(int idIt) {
		
		ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		String nombre= context.getRemoteUser();
		
		guar=  ln.guardaIt(idIt,nombre,contra, nombre);
		
		
		return "Guardado";
	}

	public void buscarItinerario() {
		
		listaItSelec=ln.getListaSelect(Destino);
		
	}
		
	
	
	public String eliminaItinerario(int idgu) {
		
		ln.eliminaItinerario(idgu);
		
		return "Guardado";
	}
	
	
	public void valorar(int idItinerario) {
		
		idIt=idItinerario;
		ListaVal= ln.getVal(idItinerario);
		c=true;
	
	}
	
	public void addValoracion() {
		ln.addVal(nota,comentario, idIt);
		ListaVal= ln.getVal(idIt);
		
	}
	
	public boolean check() {
		
		c= true;
		return c;
	}

	

}
