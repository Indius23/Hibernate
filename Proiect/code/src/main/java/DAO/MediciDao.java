    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.Medici;

/**
 *
 * @author vali
 */
public interface MediciDao {
    public void adaugaMedici (Medici medic);
    public List<Medici> afiseazaMedici();
    public void modificaMedici (int idmedic, String nume, String prenume, String sectie);
    public void stergeMedic (Medici medic);
}

    
