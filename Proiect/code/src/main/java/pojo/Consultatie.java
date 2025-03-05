package pojo;



import java.util.Date;

public class Consultatie  implements java.io.Serializable {

	private Integer idconsultatie;
	private Medici medici;
	private Pacienti pacienti;
	private Date dataConsultatie;
	private String diagnostic;
	private String medicament;

	public Consultatie() {
	}

	public Consultatie(Medici medici, Pacienti pacienti, Date dataConsultatie, String diagnostic, String medicament) {
		this.medici = medici;
		this.pacienti = pacienti;
		this.dataConsultatie = dataConsultatie;
		this.diagnostic = diagnostic;
		this.medicament = medicament;
	}

	public Integer getIdconsultatie() {
		return this.idconsultatie;
	}

	public void setIdconsultatie(Integer idconsultatie) {
		this.idconsultatie = idconsultatie;
	}
	public Medici getMedici() {
		return this.medici;
	}

	public void setMedici(Medici medici) {
		this.medici = medici;
	}
	public Pacienti getPacienti() {
		return this.pacienti;
	}

	public void setPacienti(Pacienti pacienti) {
		this.pacienti = pacienti;
	}
	public Date getDataConsultatie() {
		return this.dataConsultatie;
	}

	public void setDataConsultatie(Date dataConsultatie) {
		this.dataConsultatie = dataConsultatie;
	}
	public String getDiagnostic() {
		return this.diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public String getMedicament() {
		return this.medicament;
	}

	public void setMedicament(String medicament) {
		this.medicament = medicament;
	}
}




