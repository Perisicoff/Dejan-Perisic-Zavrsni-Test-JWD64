package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Positive;

public class FestivalDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	private String naziv = "";

	public FestivalDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
