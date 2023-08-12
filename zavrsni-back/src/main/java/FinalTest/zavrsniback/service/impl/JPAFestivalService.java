package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Festival;
import FinalTest.zavrsniback.repository.FestivalRepository;
import FinalTest.zavrsniback.service.FestivalService;

@Service
public class JPAFestivalService implements FestivalService {

	@Autowired
	private FestivalRepository festivalRepository;

	@Override
	public Festival findOne(Long id) {
		Optional<Festival> opcijaFestival = festivalRepository.findById(id);
		if (opcijaFestival.isPresent()) {
			return opcijaFestival.get();
		}
		return null;
	}

	@Override
	public List<Festival> findAll() {
		return festivalRepository.findAll();
	}

}
