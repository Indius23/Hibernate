package Controller;

import DAO.MediciDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Medici;
import DAOImpl.MediciDaoImpl;

public class MediciController extends HttpServlet {

	Medici medic = new Medici();
	MediciDaoImpl medicDaoImpl = new MediciDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaMedic") != null) {
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String sectie = request.getParameter("sectie");
			medic.setNume(nume);
			medic.setPrenume(prenume);
			medic.setSectie(sectie);
			medicDaoImpl.adaugaMedici(medic);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Medic.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaMedici") != null) {
			List<Medici> listaMedici = new ArrayList();
			listaMedici = medicDaoImpl.afiseazaMedici();
			request.setAttribute("listaMedici", listaMedici);
			RequestDispatcher rd = request.getRequestDispatcher("tabela_Medici.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaMedic") != null) {
			int id1 = Integer.parseInt(request.getParameter("idmedic"));
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String sectie = request.getParameter("sectie");
			medicDaoImpl.modificaMedici(id1, nume, prenume, sectie);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Medic.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeMedic") != null) {
			int id2 = Integer.parseInt(request.getParameter("idmedic"));
			medic.setIdmedic(id2);
			medicDaoImpl.stergeMedic(medic);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Medic.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}


