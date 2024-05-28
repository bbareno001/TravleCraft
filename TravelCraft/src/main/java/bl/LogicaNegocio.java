package bl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.AppUser;
import dl.Guardado;
import dl.Itinerario;
import dl.Valoracion;

@LocalBean
@Stateless

public class LogicaNegocio {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public List<AppUser> getAppUser() {
		return em.createNamedQuery("AppUser.findAll", AppUser.class).getResultList();
	}
	
	public List<Valoracion> getVal(int id){
		
		Itinerario it= em.find(Itinerario.class,id);
		return em.createNamedQuery("Valoracion.findAllxDest", Valoracion.class).setParameter("itinerario", it).getResultList();
	}

	public List<Itinerario> getItinerarios() {
		return em.createNamedQuery("Itinerario.findAll", Itinerario.class).getResultList();
	}

	public List<Itinerario> getListaSelect(String destino) {
		return em.createNamedQuery("Itinerario.findAllxDest", Itinerario.class).setParameter("destino", destino).getResultList();
	}
	
	public List<Valoracion> getValoracion() {
		return em.createNamedQuery("Valoracion.findAll", Valoracion.class).getResultList();
	}

	public List<Guardado> getGuardado() {
		return em.createNamedQuery("Guardado.findAll", Guardado.class).getResultList();
	}

	
	public void anadeAppUser(AppUser usr) {
		
		String rol= "usuario";
		usr.setRoles(rol);
		em.persist(usr);
		
	}
	
	public void addVal(int nota,String comentario, int idInt) {
		
		Valoracion val= new Valoracion();
		val.setNota(nota);
		val.setComentario(comentario);
		Itinerario it= em.find(Itinerario.class, idInt);
		val.setItinerario(it);
		em.persist(val);
		
	}
	
	public void publicaIT(Itinerario it) {
		em.persist(it);
	}
	
	public List<Guardado> guardaIt(int idIt, String nombre, String contra, String user) {
	
		Guardado gu= new Guardado();
		AppUser usuario= em.createNamedQuery("AppUser.findAllxusername", AppUser.class).setParameter("username", user).getSingleResult();
		gu.setAppUser(usuario);
		Itinerario it= em.find(Itinerario.class, idIt);
		gu.setItinerario(it);
		em.persist(gu);
		return em.createNamedQuery("Guardado.findAllxUser", Guardado.class).setParameter("appUser", usuario).getResultList();
		
	
	}
	
	
	public List<Itinerario> buscaGuardados(int idUs){
		
		List<Guardado> ListaGuardados= getGuardado();
		List<Itinerario> ListItiGuar= new ArrayList<Itinerario>();
		
		for(Guardado guar: ListaGuardados ) {
			
			if(idUs== guar.getAppUser().getIdAppUser()) {
				
				ListItiGuar.add(guar.getItinerario());
			}
			
		}
		
		return ListItiGuar;
	}
	
	public void eliminaItinerario(int idgu) {
	
			Guardado gu = new Guardado();
			gu= em.find(Guardado.class, idgu);
			em.remove(gu);
			
		}
		
	
	public void valorar(int idIt, Valoracion valo) {
		
		Itinerario it= new Itinerario();
		it=em.find(Itinerario.class, idIt);
		valo.setItinerario(it);
		
		em.persist(valo);
	}
	
}
