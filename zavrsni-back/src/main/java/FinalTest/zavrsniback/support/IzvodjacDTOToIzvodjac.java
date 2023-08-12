package FinalTest.zavrsniback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Izvodjac;
import FinalTest.zavrsniback.service.IzvodjacService;
import FinalTest.zavrsniback.web.dto.IzvodjacDTO;

@Component
public class IzvodjacDTOToIzvodjac implements Converter<IzvodjacDTO, Izvodjac> {

	@Autowired
	private IzvodjacService izvodjacService;

	@Override
	public Izvodjac convert(IzvodjacDTO source) {
		Izvodjac entity = null;

		if (source.getId() == null) {
			entity = new Izvodjac();
		} else {
			Izvodjac IzvodjacOptional = izvodjacService.findOne(source.getId());
			if (IzvodjacOptional != null) {
				entity = IzvodjacOptional;
			}
		}

		if (entity != null) {
			entity.setIme(source.getIme());
			entity.setZanr(source.getZanr());
			entity.setDrzava(source.getDrzava());
			entity.setBrojClanova(source.getBrojClanova());

		}

		return entity;
	}

}
