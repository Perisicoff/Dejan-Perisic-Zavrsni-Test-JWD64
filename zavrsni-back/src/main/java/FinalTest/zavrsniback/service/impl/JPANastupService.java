package FinalTest.zavrsniback.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Festival;
import FinalTest.zavrsniback.model.Izvodjac;
import FinalTest.zavrsniback.model.Nastup;
import FinalTest.zavrsniback.repository.FestivalRepository;
import FinalTest.zavrsniback.repository.NastupRepository;
import FinalTest.zavrsniback.service.NastupService;

@Service
public class JPANastupService implements NastupService {

	@Autowired
	private NastupRepository nastupRepository;
	
	@Autowired
	private FestivalRepository festivalRepository;

	@Override
	public Nastup findOne(Long id) {
		Optional<Nastup> opcijaNastup = nastupRepository.findById(id);
		if (opcijaNastup.isPresent()) {
			return opcijaNastup.get();
		}
		return null;
	}

	@Override
	public List<Nastup> findAll() {
		return nastupRepository.findAll();
	}

	@Override
	public Page<Nastup> findAll(int brojStranice) {
		return nastupRepository.findAll(PageRequest.of(brojStranice, 2));
	}

	@Override
	public Nastup save(Nastup nastup) {
		Festival festival = nastup.getFestival();
		Izvodjac izvodjac = nastup.getIzvodjac();
		List <Nastup> nastupiFestivala = festival.getNastupi();
		for (Nastup nastupfestivala : nastupiFestivala) {
			if (nastupfestivala.getIzvodjac().getDrzava().equals(izvodjac.getDrzava())) {
				return null;
			}
		}
		return nastupRepository.save(nastup);
	}

	@Override
	public Nastup update(Nastup nastup) {
		return nastupRepository.save(nastup);
	}

	@Override
	public Nastup delete(Long id) {
		Nastup nastupZaBrisanje = findOne(id);
		if (nastupZaBrisanje != null) {
			nastupRepository.deleteById(id);
			return nastupZaBrisanje;
		}
		return null;
	}

	@Override
	public Page<Nastup> search(Long festivalId, Long izvodjacId, int brojStranice) {
		return nastupRepository.search(festivalId, izvodjacId, PageRequest.of(brojStranice, 2));
	}

}
