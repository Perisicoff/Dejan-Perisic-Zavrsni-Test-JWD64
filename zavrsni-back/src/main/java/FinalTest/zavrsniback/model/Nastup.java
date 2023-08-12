package FinalTest.zavrsniback.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nastup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Festival festival;

	@ManyToOne
	private Izvodjac izvodjac;

	public Nastup() {
	}

	public Nastup(Festival festival, Izvodjac izvodjac) {
		this.festival = festival;
		this.izvodjac = izvodjac;
	}

	public Nastup(Long id, Festival festival, Izvodjac izvodjac) {
		this.id = id;
		this.festival = festival;
		this.izvodjac = izvodjac;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Izvodjac getIzvodjac() {
		return izvodjac;
	}

	public void setIzvodjac(Izvodjac izvodjac) {
		this.izvodjac = izvodjac;
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
		Nastup other = (Nastup) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Nastup [id=" + id + ", festival=" + festival + ", izvodjac=" + izvodjac + "]";
	}

}
