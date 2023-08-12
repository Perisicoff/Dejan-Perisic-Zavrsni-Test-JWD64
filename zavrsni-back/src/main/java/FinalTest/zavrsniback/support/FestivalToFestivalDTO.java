package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Festival;
import FinalTest.zavrsniback.web.dto.FestivalDTO;

@Component
public class FestivalToFestivalDTO implements Converter<Festival, FestivalDTO> {

	@Override
	public FestivalDTO convert(Festival source) {
		FestivalDTO festivalDTO = new FestivalDTO();

		festivalDTO.setId(source.getId());
		festivalDTO.setNaziv(source.getNaziv());

		return festivalDTO;
	}

	public List<FestivalDTO> convert(List<Festival> festivali) {
		List<FestivalDTO> festivalDTOS = new ArrayList<>();

		for (Festival Festival : festivali) {
			festivalDTOS.add(convert(Festival));
		}

		return festivalDTOS;
	}

}
