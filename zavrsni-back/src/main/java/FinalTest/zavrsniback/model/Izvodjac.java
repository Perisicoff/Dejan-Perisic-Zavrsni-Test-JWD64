package FinalTest.zavrsniback.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Izvodjac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String ime = "";

	@Column(nullable = false)
	private String zanr = "";

	@Column(nullable = false)
	private String drzava = "";

	@Column
	private int brojClanova;

	@OneToMany(mappedBy = "izvodjac")
	private List<Nastup> nastupi = new ArrayList<>();

	public Izvodjac() {
	}

	public Izvodjac(String ime, String zanr, String drzava, int brojClanova, List<Nastup> nastupi) {
		this.ime = ime;
		this.zanr = zanr;
		this.drzava = drzava;
		this.brojClanova = brojClanova;
		this.nastupi = nastupi;
	}

	public Izvodjac(Long id, String ime, String zanr, String drzava, int brojClanova, List<Nastup> nastupi) {
		this.id = id;
		this.ime = ime;
		this.zanr = zanr;
		this.drzava = drzava;
		this.brojClanova = brojClanova;
		this.nastupi = nastupi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public int getBrojClanova() {
		return brojClanova;
	}

	public void setBrojClanova(int brojClanova) {
		this.brojClanova = brojClanova;
	}

	public List<Nastup> getNastupi() {
		return nastupi;
	}

	public void setNastupi(List<Nastup> nastupi) {
		this.nastupi = nastupi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Izvodjac other = (Izvodjac) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Izvodjac [id=" + id + ", ime=" + ime + ", zanr=" + zanr + ", drzava=" + drzava + ", brojClanova="
				+ brojClanova + ", nastupi=" + nastupi + "]";
	}

}
