package FinalTest.zavrsniback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Festival;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, Long> {

}
