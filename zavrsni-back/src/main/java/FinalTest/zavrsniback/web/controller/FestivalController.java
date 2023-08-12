package FinalTest.zavrsniback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Festival;
import FinalTest.zavrsniback.service.FestivalService;
import FinalTest.zavrsniback.support.FestivalToFestivalDTO;
import FinalTest.zavrsniback.web.dto.FestivalDTO;

@RestController
@RequestMapping(value = "/api/festivali", produces = MediaType.APPLICATION_JSON_VALUE)
public class FestivalController {

	@Autowired
	private FestivalService festivalService;

	@Autowired
	private FestivalToFestivalDTO toFestivalDTO;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<FestivalDTO>> getAll() {
		List<Festival> festivali = festivalService.findAll();
		return new ResponseEntity<>(toFestivalDTO.convert(festivali), HttpStatus.OK);
	}

}
