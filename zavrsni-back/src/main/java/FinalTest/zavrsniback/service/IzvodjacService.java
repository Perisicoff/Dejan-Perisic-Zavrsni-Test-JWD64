package FinalTest.zavrsniback.service;

import java.util.List;

import FinalTest.zavrsniback.model.Izvodjac;

public interface IzvodjacService {

	Izvodjac findOne(Long id);

	List<Izvodjac> findAll();

	Izvodjac save(Izvodjac Izvodjac);

}
