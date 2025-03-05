    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.Consultatie;
import java.util.Date;
import pojo.Medici;
import pojo.Pacienti;

/**
 *
 * @author vali
 */
public interface ConsultatieDao {
    public void adaugaConsultatie (Consultatie consultatie);
    public List<Consultatie> afiseazaConsultatie();
    public void modificaConsultatie (Integer idconsultatie, Pacienti pacient, Medici medic, Date dataConsultatie, String diagnostic, String medicament);
    public void stergeConsultatie (Consultatie consultatie);
}

    
