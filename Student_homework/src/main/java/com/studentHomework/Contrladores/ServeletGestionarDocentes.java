package com.studentHomework.Contrladores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.studentHomework.modelo.Docente;
import com.studentHomeworkDao.DocenteDao;

/**
 * Servlet implementation class ServeletGestionarDocentes
 */
public class ServeletGestionarDocentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletGestionarDocentes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Docente d = new Docente();
		DocenteDao dao = new DocenteDao();

		String id = null;
		String nombre = null;
		String apellido = null;
		String numero_Dui = null;
		String telefono = null;
		String edad = null;
		String contrasena = null;
		String turno = null;
		String estado=null;
		String Direccion = null;

		Date fecha = null;
		String Fechas=null;
		
		try {

			 id= request.getParameter("Id");
			nombre = request.getParameter("nombre");
			apellido = request.getParameter("apellido");
			numero_Dui = request.getParameter("Dui");
			telefono = request.getParameter("telefono");
			edad = request.getParameter("edad");
			estado= request.getParameter("estado");
			contrasena = request.getParameter("contrasena");
			Direccion = request.getParameter("Direccion");
			turno = request.getParameter("turno");
			SimpleDateFormat simple= new SimpleDateFormat("yyyy/mm/dd"); 
			Fechas=request.getParameter("Fechas");
		   fecha= simple.parse(Fechas);
			 
		
			
			// estado=request.getParameter("activo");

			d.setIdDocente(Integer.parseInt(id));
			d.setNombre_Dct(nombre);
			d.setApellido_Dct(apellido);
			d.setDui(numero_Dui);
			d.setTelefono(telefono);
			d.setEdad(Integer.parseInt(edad));
			d.setContrasena(contrasena);
			d.setTurno(turno);
			d.setEstado(estado);
			d.setDireccion(Direccion);
			d.setFechaNacimiento(fecha);

		} catch (Exception e) {
			// TODO: handle exception
		}
		String acction = request.getParameter("btn");

		if (acction.equals("EstadoActivo")) {

d.setIdDocente(Integer.parseInt(id));    

d.setEstado("activo");

			dao.cambiarEstado(d);
			System.out.println("lo lograste");
			
			
		}else if(acction.equals("GUARDAR_ACTUALIZACION")) {
			d.setIdDocente(Integer.parseInt(id));
			d.setNombre_Dct(nombre);
			d.setApellido_Dct(apellido);
			d.setDui(numero_Dui);
			d.setTelefono(telefono);
			d.setEdad(Integer.parseInt(edad));
			d.setContrasena(contrasena);
			d.setTurno(turno);
			d.setEstado(estado);
			d.setDireccion(Direccion);
			d.setFechaNacimiento(fecha);
		dao.Actualizar(d);
		}
		
		else if(acction.equals("EstadoInactivo")) {
			d.setIdDocente(Integer.parseInt(id));
			d.setNombre_Dct(nombre);
			d.setApellido_Dct(apellido);
			d.setDui(numero_Dui);
			d.setTelefono(telefono);
			d.setEdad(Integer.parseInt(edad));
			d.setContrasena(contrasena);
			d.setTurno(turno);
			d.setEstado("inactivo");
			d.setDireccion(Direccion);
			
		
			
			dao.cambiarEstado(d);
				
		}else if(acction.equals("Eliminar")) {
			d.setIdDocente(Integer.parseInt(id));
			dao.EliminarD(d);
		}
		response.sendRedirect("gestionar.jsp");	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		DocenteDao d=new DocenteDao();

		Gson json= new Gson();
		try {
			response.getWriter().append(json.toJson(d.ListaDocente()));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
		}
}
