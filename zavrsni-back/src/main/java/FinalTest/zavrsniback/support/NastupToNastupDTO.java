package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Nastup;
import FinalTest.zavrsniback.web.dto.NastupDTO;

@Component
public class NastupToNastupDTO implements Converter<Nastup, NastupDTO> {

	@Override
	public NastupDTO convert(Nastup source) {
		NastupDTO nastupDTO = new NastupDTO();

		nastupDTO.setId(source.getId());
		nastupDTO.setFestivalId(source.getFestival().getId());
		nastupDTO.setNazivFestivala(source.getFestival().getNaziv());
		nastupDTO.setIzvodjacId(source.getIzvodjac().getId());
		nastupDTO.setNazivIzvodjaca(source.getIzvodjac().getIme());

		return nastupDTO;
	}

	public List<NastupDTO> convert(List<Nastup> nastupi) {
		List<NastupDTO> NastupDTOS = new ArrayList<>();

		for (Nastup nastup : nastupi) {
			NastupDTOS.add(convert(nastup));
		}
		return NastupDTOS;
	}

}
