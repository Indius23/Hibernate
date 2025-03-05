
package DAO;

import java.util.List;
import pojo.Pacienti;

public interface PacientiDao {
    public void adaugaPacienti (Pacienti pacient);
    public List<Pacienti> afiseazaPacienti();
    public void modificaPacienti (int idpacient, String nume, String prenume, String adresa);
    public void stergePacient (Pacienti pacient);
}

    
