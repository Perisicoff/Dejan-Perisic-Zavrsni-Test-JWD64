package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class IzvodjacDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	private String ime = "";

	private String zanr = "";

	@Length(min = 4)
	private String drzava = "";

	@Positive(message = "Broj clanova mora biti pozitivan broj.")
	private int brojClanova;
	
	private int brojNastupa;

	public IzvodjacDTO() {
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

	public int getBrojNastupa() {
		return brojNastupa;
	}

	public void setBrojNastupa(int brojNastupa) {
		this.brojNastupa = brojNastupa;
	}

}
