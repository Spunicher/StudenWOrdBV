package com.studentHomeworkDao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.studentHomework.modelo.Docente;



public class DocenteDao {
	
public List<Docente> ListaDocente(){
		
		List<Docente> listaD = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		
		emf= Persistence.createEntityManagerFactory("Student_homework");
	     em=emf.createEntityManager();
		try {
			
	 em.getTransaction().begin();
	 listaD=em.createQuery("FROM Docente").getResultList();
	 
	 em.getTransaction().commit();
	 
	} catch (Exception e) {
		// TODO: handle exception
	System.out.println("saludos"+e);
	
	}
	return listaD;
	}
	public void agregarD(Docente d) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("Student_homework");
	     em=emf.createEntityManager();
		
	     em.getTransaction().begin();
			em.persist(d);
			em.flush();
			em.getTransaction().commit();	
	}

	public void Actualizar(Docente d) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("Student_homework");
		   em=emf.createEntityManager();
		d.getIdDocente();
		d.getNombre_Dct();
		d.getApellido_Dct();
		d.getDui();
		d.getTelefono();
		d.getEdad();
		d.getContrasena();
		d.getTurno();
		d.getEstado();
		d.getDireccion();
		d.getFechaNacimiento();
		
		
		em.getTransaction().begin();
		em.merge(d);
		
		em.flush();
	
		em.getTransaction().commit();
	}
	public void cambiarEstado(Docente d) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("Student_homework");
		   em=emf.createEntityManager();
			d.getIdDocente();
			d.getNombre_Dct();
			d.getApellido_Dct();
			d.getDui();
			d.getTelefono();
			d.getEdad();
			d.getContrasena();
			d.getTurno();
			d.getEstado();
			d.getDireccion();
					
		em.getTransaction().begin();
			em.merge(d);
			em.flush();
		
			em.getTransaction().commit();
		
	}
	public void EliminarD(Docente d) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("Student_homework");
		   em=emf.createEntityManager();
		   d= em.getReference(Docente.class,d.getIdDocente());
		   em.getTransaction().begin();
		em.remove(d);
		
		em.flush();

		em.getTransaction().commit();
	}
	
}
