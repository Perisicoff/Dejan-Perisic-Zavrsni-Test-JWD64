package FinalTest.zavrsniback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Nastup;
import FinalTest.zavrsniback.service.FestivalService;
import FinalTest.zavrsniback.service.IzvodjacService;
import FinalTest.zavrsniback.service.NastupService;
import FinalTest.zavrsniback.web.dto.NastupDTO;

@Component
public class NastupDTOToNastup implements Converter<NastupDTO, Nastup> {

	@Autowired
	private NastupService nastupService;

	@Autowired
	private FestivalService festivalService;

	@Autowired
	private IzvodjacService izvodjacService;

	@Override
	public Nastup convert(NastupDTO source) {
		Nastup entity = null;

		if (source.getId() == null) {
			entity = new Nastup();
		} else {
			Nastup NastupOptional = nastupService.findOne(source.getId());
			if (NastupOptional != null) {
				entity = NastupOptional;
			}
		}

		if (entity != null) {
			entity.setFestival(festivalService.findOne(source.getFestivalId()));
			entity.setIzvodjac(izvodjacService.findOne(source.getIzvodjacId()));
		}

		return entity;
	}

}
