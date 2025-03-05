
package Controller;

import DAO.PacientiDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Pacienti;
import DAOImpl.PacientiDaoImpl;

/**
 *
 * @author vali
 */
public class PacientiController extends HttpServlet {

	Pacienti pacient = new Pacienti();
	PacientiDaoImpl pacientDaoImpl = new PacientiDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaPacient") != null) {
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String adresa = request.getParameter("adresa");
			pacient.setNume(nume);
			pacient.setPrenume(prenume);
			pacient.setAdresa(adresa);
			pacientDaoImpl.adaugaPacienti(pacient);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Pacient.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaPacienti") != null) {
			List<Pacienti> listaPacienti = new ArrayList();
			listaPacienti = pacientDaoImpl.afiseazaPacienti();
			request.setAttribute("listaPacienti", listaPacienti);
			RequestDispatcher rd = request.getRequestDispatcher("tabela_Pacienti.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaPacient") != null) {
			int id1 = Integer.parseInt(request.getParameter("idpacient"));
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String adresa = request.getParameter("adresa");
			pacientDaoImpl.modificaPacienti(id1, nume, prenume, adresa);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Pacient.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergePacient") != null) {
			int id2 = Integer.parseInt(request.getParameter("idpacient"));
			pacient.setIdpacient(id2);
			pacientDaoImpl.stergePacient(pacient);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Pacient.jsp");
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


