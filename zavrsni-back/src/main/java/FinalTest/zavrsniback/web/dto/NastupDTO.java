package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Positive;

public class NastupDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	private Long festivalId;

	private String nazivFestivala = "";

	private Long izvodjacId;

	private String nazivIzvodjaca = "";

	public NastupDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFestivalId() {
		return festivalId;
	}

	public void setFestivalId(Long festivalId) {
		this.festivalId = festivalId;
	}

	public String getNazivFestivala() {
		return nazivFestivala;
	}

	public void setNazivFestivala(String nazivFestivala) {
		this.nazivFestivala = nazivFestivala;
	}

	public Long getIzvodjacId() {
		return izvodjacId;
	}

	public void setIzvodjacId(Long izvodjacId) {
		this.izvodjacId = izvodjacId;
	}

	public String getNazivIzvodjaca() {
		return nazivIzvodjaca;
	}

	public void setNazivIzvodjaca(String nazivIzvodjaca) {
		this.nazivIzvodjaca = nazivIzvodjaca;
	}

}
