package FinalTest.zavrsniback.service;

import java.util.List;

import FinalTest.zavrsniback.model.Festival;

public interface FestivalService {

	Festival findOne(Long id);

	List<Festival> findAll();
}
