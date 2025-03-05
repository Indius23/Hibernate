    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.Pacienti;

/**
 *
 * @author vali
 */
public interface PacientiDao {
    public void adaugaPacienti (Pacienti pacient);
    public List<Pacienti> afiseazaPacienti();
    public void modificaPacienti (int idpacient, String nume, String prenume, String adresa);
    public void stergePacient (Pacienti pacient);
}

    
