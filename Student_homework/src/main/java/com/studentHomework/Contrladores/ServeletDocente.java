package com.studentHomework.Contrladores;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentHomework.modelo.Docente;
import com.studentHomeworkDao.DocenteDao;

/**
 * Servlet implementation class ServeletDocente
 */
public class ServeletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletDocente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

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
		// String estado=null;
		String Direccion = null;

		Date fecha = null;
		String Fechas=null;
		
		try {

			// id= request.getParameter("Id");
			nombre = request.getParameter("nombres");
			apellido = request.getParameter("Apellido");
			numero_Dui = request.getParameter("Dui");
			telefono = request.getParameter("telefono");
			edad = request.getParameter("Edad");
			contrasena = request.getParameter("Contras");
			Direccion = request.getParameter("Direccion");
			turno = request.getParameter("turno");
			SimpleDateFormat simple= new SimpleDateFormat("yyyy/mm/dd"); 
			Fechas=request.getParameter("Fecha");
			fecha= simple.parse(Fechas);
			 

		} catch (Exception e) {
			// TODO: handle exception
		}
		String acction = request.getParameter("btn");

		if (acction.equals("Registrar")) {

			// d.setIdDocente(Integer.parseInt(id));
			d.setNombre_Dct(nombre);
			d.setApellido_Dct(apellido);
			d.setDui(numero_Dui);
			d.setTelefono(telefono);
			d.setEdad(Integer.parseInt(edad));
			d.setContrasena(contrasena);
			d.setTurno(turno);
			d.setEstado("activo");
			d.setDireccion(Direccion);
			d.setFechaNacimiento(fecha);
			dao.agregarD(d);
			System.out.println("lo lograste");
			response.sendRedirect("login.jsp");
		}else {
			System.out.println("que mal ");
		response.sendRedirect("Registro.jsp");
		
	}
		
	}
	
}
