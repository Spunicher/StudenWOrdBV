package com.studentHomeworkDao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.studentHomework.modelo.Actividad;
import com.studentHomework.modelo.Docente;

public class ActividadDao {
public List<Actividad> ListaActvidades(){
	Docente doc= new Docente();
		List<Actividad> listaA = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		
		emf= Persistence.createEntityManagerFactory("Student_homework");
	     em=emf.createEntityManager();
		try {
			
	 em.getTransaction().begin();
	 listaA=em.createQuery("FROM Actvidades where id_docente='"+doc.getIdDocente()+"'").getResultList();
	 
	 em.getTransaction().commit();
	 
	} catch (Exception e) {
		// TODO: handle exception
	System.out.println("saludos"+e);
	
	}
	return listaA;
	}
	public void agregarA(Actividad a) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("Student_homework");
	     em=emf.createEntityManager();
		
	     em.getTransaction().begin();
			em.persist(a);
			em.flush();
			em.getTransaction().commit();	
	}


}
