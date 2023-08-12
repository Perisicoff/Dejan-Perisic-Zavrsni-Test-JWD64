package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Izvodjac;
import FinalTest.zavrsniback.repository.IzvodjacRepository;
import FinalTest.zavrsniback.service.IzvodjacService;

@Service
public class JPAIzvodjacService implements IzvodjacService {
	
	@Autowired
	private IzvodjacRepository izvodjacRepository;

	@Override
	public Izvodjac findOne(Long id) {
		Optional<Izvodjac> opcijaIzvodjac = izvodjacRepository.findById(id);
		if (opcijaIzvodjac.isPresent()) {
			return opcijaIzvodjac.get();
		}
		return null;
	}

	@Override
	public List<Izvodjac> findAll() {
		return izvodjacRepository.findAll();
	}

	@Override
	public Izvodjac save(Izvodjac Izvodjac) {
		return izvodjacRepository.save(Izvodjac);
	}

}
