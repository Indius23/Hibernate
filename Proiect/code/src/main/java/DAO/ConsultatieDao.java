
package DAO;

import java.util.List;
import pojo.Consultatie;
import java.util.Date;
import pojo.Medici;
import pojo.Pacienti;

public interface ConsultatieDao {
    public void adaugaConsultatie (Consultatie consultatie);
    public List<Consultatie> afiseazaConsultatie();
    public void modificaConsultatie (Integer idconsultatie, Pacienti pacient, Medici medic, Date dataConsultatie, String diagnostic, String medicament);
    public void stergeConsultatie (Consultatie consultatie);
}

    
