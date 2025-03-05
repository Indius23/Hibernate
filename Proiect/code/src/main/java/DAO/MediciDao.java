
package DAO;

import java.util.List;
import pojo.Medici;


public interface MediciDao {
    public void adaugaMedici (Medici medic);
    public List<Medici> afiseazaMedici();
    public void modificaMedici (int idmedic, String nume, String prenume, String sectie);
    public void stergeMedic (Medici medic);
}

    
