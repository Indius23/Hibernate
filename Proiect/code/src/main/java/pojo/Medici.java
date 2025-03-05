package pojo;



import java.util.HashSet;
import java.util.Set;

public class Medici  implements java.io.Serializable {


	private Integer idmedic;
	private String nume;
	private String prenume;
	private String sectie;
	private Set consultaties = new HashSet(0);

	public Medici() {
	}

	public Medici(String nume, String prenume, String sectie, Set consultaties) {
		this.nume = nume;
		this.prenume = prenume;
		this.sectie = sectie;
		this.consultaties = consultaties;
	}

	public Integer getIdmedic() {
		return this.idmedic;
	}

	public void setIdmedic(Integer idmedic) {
		this.idmedic = idmedic;
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
	public String getSectie() {
		return this.sectie;
	}

	public void setSectie(String sectie) {
		this.sectie = sectie;
	}
	public Set getConsultaties() {
		return this.consultaties;
	}

	public void setConsultaties(Set consultaties) {
		this.consultaties = consultaties;
	}
}




