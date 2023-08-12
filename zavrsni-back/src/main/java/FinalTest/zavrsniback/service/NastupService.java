package FinalTest.zavrsniback.service;

import java.util.List;

import org.springframework.data.domain.Page;

import FinalTest.zavrsniback.model.Nastup;

public interface NastupService {

	Nastup findOne(Long id);

	List<Nastup> findAll();

	Page<Nastup> findAll(int brojStranice);
	
	Page<Nastup> search(Long festivalId, Long izvodjacId, int brojStranice);

	Nastup save(Nastup nastup);
	
	Nastup update(Nastup nastup);

	Nastup delete(Long id);
}
