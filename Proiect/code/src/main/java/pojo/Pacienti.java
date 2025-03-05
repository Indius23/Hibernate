package pojo;


import java.util.HashSet;
import java.util.Set;

public class Pacienti  implements java.io.Serializable {

	private Integer idpacient;
	private String nume;
	private String prenume;
	private String adresa;
	private Set consultaties = new HashSet(0);

	public Pacienti() {
	}

	public Pacienti(String nume, String prenume, String adresa, Set consultaties) {
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		this.consultaties = consultaties;
	}

	public Integer getIdpacient() {
		return this.idpacient;
	}

	public void setIdpacient(Integer idpacient) {
		this.idpacient = idpacient;
	}
	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Set getConsultaties() {
		return this.consultaties;
	}

	public void setConsultaties(Set consultaties) {
		this.consultaties = consultaties;
	}
}




