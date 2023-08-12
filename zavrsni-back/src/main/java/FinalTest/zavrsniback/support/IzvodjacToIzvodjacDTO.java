package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Izvodjac;
import FinalTest.zavrsniback.web.dto.IzvodjacDTO;

@Component
public class IzvodjacToIzvodjacDTO implements Converter<Izvodjac, IzvodjacDTO> {

	@Override
	public IzvodjacDTO convert(Izvodjac source) {
		IzvodjacDTO izvodjacDTO = new IzvodjacDTO();

		izvodjacDTO.setId(source.getId());
		izvodjacDTO.setIme(source.getIme());
		izvodjacDTO.setZanr(source.getZanr());
		izvodjacDTO.setDrzava(source.getDrzava());
		izvodjacDTO.setBrojClanova(source.getBrojClanova());
		izvodjacDTO.setBrojNastupa(source.getNastupi().size());

		return izvodjacDTO;
	}

	public List<IzvodjacDTO> convert(List<Izvodjac> izvodjaci) {
		List<IzvodjacDTO> izvodjaciDTOS = new ArrayList<>();

		for (Izvodjac izvodjac : izvodjaci) {
			izvodjaciDTOS.add(convert(izvodjac));
		}
		return izvodjaciDTOS;
	}

}
