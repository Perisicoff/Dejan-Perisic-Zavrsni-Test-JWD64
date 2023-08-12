package FinalTest.zavrsniback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Izvodjac;

@Repository
public interface IzvodjacRepository extends JpaRepository<Izvodjac, Long> {

}
