package com.example.online_shopping.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.online_shopping.domain.TblCountriesMaster;
import com.example.online_shopping.repository.TblCountriesMasterRepository;
import com.example.online_shopping.service.TblCountriesMasterService;
import com.example.online_shopping.service.dto.TblCountriesMasterDTO;
import com.example.online_shopping.service.mapper.TblCountriesMasterMapper;

@Service
public class TblCountriesMasterServiceImpl implements TblCountriesMasterService {

	private final Logger log = LoggerFactory.getLogger(TblCountriesMasterServiceImpl.class);

	private final TblCountriesMasterRepository countriesMasterRepository;

	private final TblCountriesMasterMapper countriesMasterMapper;

	public TblCountriesMasterServiceImpl(TblCountriesMasterRepository countriesMasterRepository,
			TblCountriesMasterMapper countriesMasterMapper) {
		this.countriesMasterRepository = countriesMasterRepository;
		this.countriesMasterMapper = countriesMasterMapper;
	}

	@Override
	public TblCountriesMasterDTO save(TblCountriesMasterDTO countriesMasterDTO) {
		log.debug("Request to save CountriesMaster : {}", countriesMasterDTO);
		TblCountriesMaster countriesMaster = countriesMasterMapper.toEntity(countriesMasterDTO);
		countriesMaster = countriesMasterRepository.save(countriesMaster);
		return countriesMasterMapper.toDto(countriesMaster);
	}

	@Override
	public List<TblCountriesMasterDTO> findAll() {
		log.debug("Request to get all CountriesMasters");
		return countriesMasterRepository.findAll().stream().map(countriesMasterMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Optional<TblCountriesMasterDTO> findOne(String id) {
		log.debug("Request to get CountriesMaster : {}", id);
		return countriesMasterRepository.findById(id).map(countriesMasterMapper::toDto);
	}

	@Override
	public void delete(String id) {
		log.debug("Request to delete CountriesMaster : {}", id);
		countriesMasterRepository.deleteById(id);
	}

	}
