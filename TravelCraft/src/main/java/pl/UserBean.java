package pl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.LogicaNegocio;
import dl.AppUser;
import dl.Guardado;
import dl.Itinerario;
import dl.Valoracion;

@Named
@ViewScoped

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private LogicaNegocio ln;
	
	private AppUser usuario = new AppUser();
	private List<AppUser> listaUs;
	private List<Guardado> listaGuardados;
	private List<Itinerario> ListIt = new ArrayList<Itinerario>();
	private String nombre;
	private String contra;
	private int idUs;
	private Valoracion val= new Valoracion();
	private int idIt;
	
	
	public int getIdIt() {
		return idIt;
	}

	public void setIdIt(int idIt) {
		this.idIt = idIt;
	}

	public Valoracion getVal() {
		return val;
	}

	public void setVal(Valoracion val) {
		this.val = val;
	}

	public List<Itinerario> getListIt() {
		return ListIt;
	}

	public void setListIt(List<Itinerario> listIt) {
		ListIt = listIt;
	}

	public void setIdUs(int idUs) {
		this.idUs = idUs;
	}

	public List<Guardado> getListaGuardados() {
		
		if (listaGuardados == null) {
			listaGuardados = ln.getGuardado();
		}
		;
		return listaGuardados;
	}

	public void setListaGuardados(List<Guardado> listaGuardaos) {
		this.listaGuardados = listaGuardaos;
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



	public AppUser getUsuario() {
		return usuario;
	}

	public void setUsuario(AppUser usuario) {
		this.usuario = usuario;
	}

	public List<AppUser> getListaUs() {
		
		if( listaUs == null) {
			
			listaUs= ln.getAppUser();
		};
		
		return listaUs;
	}
		

	public void setListaUs(List<AppUser> listaUs) {
		this.listaUs = listaUs;
	}

	public String iniciaSesion() {	
		
	/*	List<AppUser> listCli= getListaUs();
		String devuelve= null;
		
		for(AppUser c : listCli ) {
			
			if(nombre.equals(c.getUsername()) && contra.equals(c.getPassword())) {
				
				devuelve= "Menu";
				
			}else {
				
				devuelve= "Inicio";
			}	*/
		
		
		return "Menu";
		
	}
	
	public String nuevoUsuario() {	
		
		usuario.setUsername(nombre);
		usuario.setPassword(contra);
		
		ln.anadeAppUser(usuario);;
		
		return "Menu";
		
	}
	
	public int getIdUs() {
		
		for(AppUser us: getListaUs()) {
			
			if(nombre.equals(us.getUsername())){
				
				idUs= us.getIdAppUser();
			}
			
		}
		
		return idUs;
		
	}
	
	
	
	public void publicarVal() {
		
		ln.valorar(idIt, val);;
	
	}

}
