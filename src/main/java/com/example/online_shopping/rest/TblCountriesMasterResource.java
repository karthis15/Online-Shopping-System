package com.example.online_shopping.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_shopping.service.TblCountriesMasterService;
import com.example.online_shopping.service.dto.TblCountriesMasterDTO;

@RestController
@RequestMapping("/api")
public class TblCountriesMasterResource {

	private final Logger log = LoggerFactory.getLogger(TblCountriesMasterResource.class);

	private final TblCountriesMasterService countriesMasterService;

	public TblCountriesMasterResource(TblCountriesMasterService countriesMasterService) {
		this.countriesMasterService = countriesMasterService;
	}

	@PostMapping("/countries-masters")
	public TblCountriesMasterDTO createCountriesMaster(@RequestBody TblCountriesMasterDTO countriesMasterDTO) {
		log.debug("REST request to save CountriesMaster : {}", countriesMasterDTO);
		return countriesMasterService.save(countriesMasterDTO);
	}

	@PutMapping("/countries-masters")
	public TblCountriesMasterDTO updateCountriesMaster(@RequestBody TblCountriesMasterDTO countriesMasterDTO) {
		log.debug("REST request to save CountriesMaster : {}", countriesMasterDTO);
		return countriesMasterService.save(countriesMasterDTO);
	}

	@GetMapping("/countries-masters")
	public List<TblCountriesMasterDTO> getAllCountriesMasters() {
		log.debug("REST request to get all CountriesMasters");
		return countriesMasterService.findAll();
	}

	@GetMapping("/countries-masters/{id}")
	public Optional<TblCountriesMasterDTO> getCountriesMaster(@PathVariable String id) {
		log.debug("REST request to get CountriesMaster : {}", id);
		return countriesMasterService.findOne(id);
	}

	@DeleteMapping("/countries-masters/{id}")
	public void deleteCountriesMaster(@PathVariable String id) {
		log.debug("REST request to delete CountriesMaster : {}", id);
		countriesMasterService.delete(id);
	}

}
