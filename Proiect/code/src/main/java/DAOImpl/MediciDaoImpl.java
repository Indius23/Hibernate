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
import pojo.Medici;
import DAO.MediciDao;

/**
 *
 * @author vali
 */
public class MediciDaoImpl implements MediciDao{

    public void adaugaMedici(Medici medic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(medic);
        transaction.commit();
        session.close();
    }

    public List<Medici> afiseazaMedici() {
        List<Medici> listaMedici = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.query.Query query = session.createQuery("From Medici");
        listaMedici = query.list();
        return listaMedici;
    }

    public void modificaMedici(int idmedic, String nume, String prenume, String sectie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Medici detaliimedici = (Medici) session.load(Medici.class, idmedic);
        detaliimedici.setNume(nume);
        detaliimedici.setPrenume(prenume);
        detaliimedici.setSectie(sectie);
        session.update(detaliimedici);
        transaction.commit();
        session.close();
    }

    public void stergeMedic(Medici medic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(medic);
        transaction.commit();
        session.close();
    }
}
