package com.studentHomework.Contrladores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.studentHomework.modelo.Actividad;
import com.studentHomework.modelo.Docente;
import com.studentHomeworkDao.ActividadDao;
import com.studentHomeworkDao.DocenteDao;

/**
 * Servlet implementation class ServeletActividades
 */
public class ServeletActividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletActividades() {
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
		ActividadDao dao= new ActividadDao();
Actividad a = new Actividad();

		String id = null;
		String nombre = null;
		String materia =null;
		String porcentaje = null;
		String estado = null;
		String id_docente = null;
		
		nombre = request.getParameter("nombres");
		materia = request.getParameter("Apellido");
		porcentaje  = request.getParameter("Dui");
		estado = request.getParameter("telefono");
		id_docente = request.getParameter("Edad");
		
		
		try {
			String acction = request.getParameter("btn");

			if (acction.equals("Registrar")) {

				// d.setIdDocente(Integer.parseInt(id));
				a.getId_codAct();
				a.getNombre();
				a.getMateria();
				a.getPoncentaje();
				a.getEstado();
			
				dao.agregarA(a);
				System.out.println("lo lograste");
				response.sendRedirect("login.jsp");
			}else {
				System.out.println("que mal ");
			response.sendRedirect("Registro.jsp");
			
		}
			
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		ActividadDao a=new ActividadDao();

		Gson json= new Gson();
		try {
			response.getWriter().append(json.toJson(a.ListaActvidades()));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
		}
	}


