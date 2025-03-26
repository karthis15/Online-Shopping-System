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

import com.example.online_shopping.service.TblStatusTypesService;
import com.example.online_shopping.service.dto.TblStatusTypesDTO;


@RestController
@RequestMapping("/api")
public class TblStatusTypesResource {

	private final Logger log = LoggerFactory.getLogger(TblStatusTypesResource.class);

	private final TblStatusTypesService tblStatusTypesService;

	public TblStatusTypesResource(TblStatusTypesService tblStatusTypesService) {
		this.tblStatusTypesService = tblStatusTypesService;
	}

	@PostMapping("/tblStatusTypes")
	public TblStatusTypesDTO createOrdersMaster(@RequestBody TblStatusTypesDTO tblStatusTypesDTO) {
		log.debug("REST request to save TblStatusTypes : {}", tblStatusTypesDTO);

		TblStatusTypesDTO result = tblStatusTypesService.save(tblStatusTypesDTO);
		return result;
	}

	@PutMapping("/tblStatusTypes")
	public TblStatusTypesDTO updateOrdersMaster(@RequestBody TblStatusTypesDTO tblStatusTypesDTO) {
		log.debug("REST request to update TblStatusTypes : {}", tblStatusTypesDTO);

		TblStatusTypesDTO result = tblStatusTypesService.save(tblStatusTypesDTO);
		return result;
	}

	@GetMapping("/tblStatusTypes")
	public List<TblStatusTypesDTO> getAllOrdersMasters() {
		log.debug("REST request to get all Orders");
		return tblStatusTypesService.findAll();
	}

	@GetMapping("/tblStatusTypes/{id}")
	public Optional<TblStatusTypesDTO> getOrdersMaster(@PathVariable String id) {
		log.debug("REST request to get TblStatusTypes : {}", id);
		return tblStatusTypesService.findOne(id);
	}

	@DeleteMapping("/tblStatusTypes/{id}")
	public void deleteOrdersMaster(@PathVariable String id) {
		log.debug("REST request to delete TblStatusTypes : {}", id);
		tblStatusTypesService.delete(id);
	}

	
}
