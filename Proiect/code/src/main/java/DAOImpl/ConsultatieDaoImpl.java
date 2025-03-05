/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Consultatie;
import DAO.ConsultatieDao;
import java.util.Date;
import pojo.Medici;
import pojo.Pacienti;


public class ConsultatieDaoImpl implements ConsultatieDao{

    public void adaugaConsultatie(Consultatie consultatie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(consultatie);
        transaction.commit();
        session.close();
    }

    public List<Consultatie> afiseazaConsultatie() {
        List<Consultatie> listaConsultatie = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createQuery("From Consultatie");
        listaConsultatie = query.list();
        return listaConsultatie;
    }

    public void modificaConsultatie(Integer idconsultatie, Pacienti pacient, Medici medic, Date dataConsultatie, String diagnostic, String medicament) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Consultatie detaliiconsultatiei;
        detaliiconsultatiei = (Consultatie) session.load(Consultatie.class, idconsultatie);
        detaliiconsultatiei.setPacienti(pacient);
        detaliiconsultatiei.setMedici(medic);
        detaliiconsultatiei.setDataConsultatie(dataConsultatie);
        detaliiconsultatiei.setDiagnostic(diagnostic);
        detaliiconsultatiei.setMedicament(medicament);
        session.update(detaliiconsultatiei);
        transaction.commit();
        session.close();
    }

    public void stergeConsultatie(Consultatie consultatie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(consultatie);
        transaction.commit();
        session.close();
    }
}
