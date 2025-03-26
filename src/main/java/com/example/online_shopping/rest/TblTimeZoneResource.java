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

import com.example.online_shopping.service.TblTimeZoneService;
import com.example.online_shopping.service.dto.TblTimeZoneDTO;

@RestController
@RequestMapping("/api")
public class TblTimeZoneResource {

	private final Logger log = LoggerFactory.getLogger(TblTimeZoneResource.class);

	private final TblTimeZoneService tblTimeZoneService;

	public TblTimeZoneResource(TblTimeZoneService tblTimeZoneService) {
		this.tblTimeZoneService = tblTimeZoneService;
	}

	@PostMapping("/tblTimeZone")
	public TblTimeZoneDTO createTblTimeZone(@RequestBody TblTimeZoneDTO tblTimeZoneDTO) {
		log.debug("REST request to save TblTimeZone : {}", tblTimeZoneDTO);
		TblTimeZoneDTO result = tblTimeZoneService.save(tblTimeZoneDTO);
		return result;
	}

	@PutMapping("/tblTimeZone")
	public TblTimeZoneDTO updateTblTimeZone(@RequestBody TblTimeZoneDTO tblTimeZoneDTO) {
		log.debug("REST request to update TblTimeZone : {}", tblTimeZoneDTO);

		TblTimeZoneDTO result = tblTimeZoneService.save(tblTimeZoneDTO);
		return result;
	}

	@GetMapping("/tblTimeZone")
	public List<TblTimeZoneDTO> getAllTblTimeZones() {
		log.debug("REST request to get all Orders");
		return tblTimeZoneService.findAll();
	}

	@GetMapping("/tblTimeZone/{id}")
	public Optional<TblTimeZoneDTO> getTblTimeZone(@PathVariable Long id) {
		log.debug("REST request to get TblTimeZone : {}", id);
		return tblTimeZoneService.findOne(id);
	}

	@DeleteMapping("/tblTimeZone/{id}")
	public void deleteTblTimeZone(@PathVariable Long id) {
		log.debug("REST request to delete TblTimeZone : {}", id);
		tblTimeZoneService.delete(id);

	}
}
