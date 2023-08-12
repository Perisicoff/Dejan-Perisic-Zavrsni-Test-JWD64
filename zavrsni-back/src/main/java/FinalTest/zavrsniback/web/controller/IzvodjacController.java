package FinalTest.zavrsniback.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Izvodjac;
import FinalTest.zavrsniback.service.IzvodjacService;
import FinalTest.zavrsniback.support.IzvodjacDTOToIzvodjac;
import FinalTest.zavrsniback.support.IzvodjacToIzvodjacDTO;
import FinalTest.zavrsniback.web.dto.IzvodjacDTO;

@RestController
@RequestMapping(value = "/api/izvodjaci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IzvodjacController {

	@Autowired
	private IzvodjacService izvodjacService;

	@Autowired
	private IzvodjacToIzvodjacDTO toIzvodjacDTO;

	@Autowired
	private IzvodjacDTOToIzvodjac toIzvodjac;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<IzvodjacDTO>> getAll() {
		List<Izvodjac> izvodjaci = izvodjacService.findAll();
		return new ResponseEntity<>(toIzvodjacDTO.convert(izvodjaci), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IzvodjacDTO> create(@Valid @RequestBody IzvodjacDTO IzvodjacDTO) {
		Izvodjac izvodjac = toIzvodjac.convert(IzvodjacDTO);

		if (izvodjac == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Izvodjac sacuvanoIzvodjac = izvodjacService.save(izvodjac);

		return new ResponseEntity<>(toIzvodjacDTO.convert(sacuvanoIzvodjac), HttpStatus.CREATED);
	}

}
