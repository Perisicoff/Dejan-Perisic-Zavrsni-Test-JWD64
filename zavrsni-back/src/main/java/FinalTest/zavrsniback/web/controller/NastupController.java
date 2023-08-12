package FinalTest.zavrsniback.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Nastup;
import FinalTest.zavrsniback.service.NastupService;
import FinalTest.zavrsniback.support.NastupDTOToNastup;
import FinalTest.zavrsniback.support.NastupToNastupDTO;
import FinalTest.zavrsniback.web.dto.NastupDTO;

@RestController
@RequestMapping(value = "/api/nastupi", produces = MediaType.APPLICATION_JSON_VALUE)
public class NastupController {

	@Autowired
	private NastupService nastupService;

	@Autowired
	private NastupToNastupDTO toNastupDTO;

	@Autowired
	private NastupDTOToNastup toNastup;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<NastupDTO>> get(@RequestParam(required = false, defaultValue = "") Long festivalId,
			@RequestParam(required = false, defaultValue = "") Long izvodjacId,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {

		Page<Nastup> nastupi = nastupService.search(festivalId, izvodjacId, pageNo);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(nastupi.getTotalPages()));

		return new ResponseEntity<>(toNastupDTO.convert(nastupi.getContent()), headers, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<NastupDTO> get(@PathVariable Long id) {
		Nastup Nastup = nastupService.findOne(id);

		if (Nastup != null) {
			return new ResponseEntity<>(toNastupDTO.convert(Nastup), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NastupDTO> create(@Valid @RequestBody NastupDTO nastupDTO) {
		Nastup nastup = toNastup.convert(nastupDTO);

		if (nastup.getFestival() == null || nastup.getIzvodjac() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Nastup sacuvaniNastup = nastupService.save(nastup);

		return new ResponseEntity<>(toNastupDTO.convert(sacuvaniNastup), HttpStatus.CREATED);
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NastupDTO> update(@PathVariable Long id, @Valid @RequestBody NastupDTO nastupDTO) {

		if (!id.equals(nastupDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Nastup nastup = toNastup.convert(nastupDTO);
		Nastup sacuvanoNastup = nastupService.update(nastup);

		return new ResponseEntity<>(toNastupDTO.convert(sacuvanoNastup), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Nastup obrisaniNastup = nastupService.delete(id);

		if (obrisaniNastup != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
