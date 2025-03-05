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
import pojo.Pacienti;
import DAO.PacientiDao;

/**
 *
 * @author vali
 */
public class PacientiDaoImpl implements PacientiDao{

    public void adaugaPacienti(Pacienti pacient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(pacient);
        transaction.commit();
        session.close();
    }

    public List<Pacienti> afiseazaPacienti() {
        List<Pacienti> listaPacienti = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createQuery("From Pacienti");
        listaPacienti = query.list();
        return listaPacienti;
    }

    public void modificaPacienti(int idpacient, String nume, String prenume, String adresa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Pacienti detaliipacienti = (Pacienti) session.load(Pacienti.class, idpacient);
        detaliipacienti.setNume(nume);
        detaliipacienti.setPrenume(prenume);
        detaliipacienti.setAdresa(adresa);
        session.update(detaliipacienti);
        transaction.commit();
        session.close();
    }

    public void stergePacient(Pacienti pacient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(pacient);
        transaction.commit();
        session.close();
    }
}
