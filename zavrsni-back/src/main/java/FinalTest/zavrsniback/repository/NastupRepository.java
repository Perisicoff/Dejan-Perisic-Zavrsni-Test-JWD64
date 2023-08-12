package FinalTest.zavrsniback.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Nastup;

@Repository
public interface NastupRepository extends JpaRepository<Nastup, Long> {

	@Query("SELECT n FROM Nastup n WHERE"
			+ "(:festivalId IS NULL OR n.festival.id LIKE :festivalId) AND"
			+ "(:izvodjacId IS NULL OR n.izvodjac.id LIKE :izvodjacId)")
	Page<Nastup> search(@Param("festivalId") Long festivalId,@Param("izvodjacId") Long izvodjacId, Pageable pageable);
}
