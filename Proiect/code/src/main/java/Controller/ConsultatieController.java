package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Pacienti;
import pojo.Medici;
import pojo.Consultatie;
import DAOImpl.ConsultatieDaoImpl;
import DAOImpl.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author vali
 */
public class ConsultatieController extends HttpServlet {

	Consultatie consultatie = new Consultatie();
	ConsultatieDaoImpl consultatieDaoImpl = new ConsultatieDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaConsultatie") != null) {
			// preluarea parametrilor de interes
			Integer idpacient = java.lang.Integer.parseInt(request.getParameter("idpacient"));
			Integer idmedic = java.lang.Integer.parseInt(request.getParameter("idmedic"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Pacienti pacient = (Pacienti) session.get(Pacienti.class, idpacient);
			Medici medic = (Medici) session.get(Medici.class, idmedic);

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date dataConsultatie = null;
			try {
				dataConsultatie = df.parse(request.getParameter("dataConsultatie"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String diagnostic = request.getParameter("diagnostic");
			String medicament = request.getParameter("medicament");

			consultatie.setPacienti(pacient);
			consultatie.setMedici(medic);
			consultatie.setDataConsultatie(dataConsultatie);
			consultatie.setDiagnostic(diagnostic);
			consultatie.setMedicament(medicament);

			consultatieDaoImpl.adaugaConsultatie(consultatie);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Consultatie.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaConsultatie") != null) {
			List<Consultatie> listaConsultatie = new ArrayList();
			listaConsultatie = consultatieDaoImpl.afiseazaConsultatie();
			request.setAttribute("listaConsultatie", listaConsultatie);
			RequestDispatcher rd = request.getRequestDispatcher("tabela_Consultatie.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaConsultatie") != null) {
			Integer id1 = Integer.parseInt(request.getParameter("idconsultatie"));
			// preluarea parametrilor de interes
			Integer idpacient = java.lang.Integer.parseInt(request.getParameter("idpacient"));
			Integer idmedic = java.lang.Integer.parseInt(request.getParameter("idmedic"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Pacienti pacient = (Pacienti) session.get(Pacienti.class, idpacient);
			Medici medic = (Medici) session.get(Medici.class, idmedic);

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date dataConsultatie = null;
			try {
				dataConsultatie = df.parse(request.getParameter("dataConsultatie"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String diagnostic = request.getParameter("diagnostic");
			String medicament = request.getParameter("medicament");

			consultatieDaoImpl.modificaConsultatie(id1, pacient, medic, dataConsultatie, diagnostic, medicament);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Consultatie.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeConsultatie") != null) {
			Integer id2 = Integer.parseInt(request.getParameter("idconsultatie"));
			consultatie.setIdconsultatie(id2);
			consultatieDaoImpl.stergeConsultatie(consultatie);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Consultatie.jsp");
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


