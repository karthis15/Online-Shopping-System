package com.example.online_shopping.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.domain.TblStatusTypes;
import com.example.online_shopping.repository.TblStatusTypesRepository;
import com.example.online_shopping.service.TblStatusTypesService;
import com.example.online_shopping.service.dto.TblStatusTypesDTO;
import com.example.online_shopping.service.mapper.TblStatusTypesMapper;


@Service
public class TblStatusTypesServiceImpl implements TblStatusTypesService {

	private final Logger log = LoggerFactory.getLogger(TblStatusTypesServiceImpl.class);

	private final TblStatusTypesRepository tblStatusTypesRepository;

	private final TblStatusTypesMapper tblStatusTypesMapper;

	public TblStatusTypesServiceImpl(TblStatusTypesRepository tblStatusTypesRepository,
			TblStatusTypesMapper tblStatusTypesMapper) {
		this.tblStatusTypesRepository = tblStatusTypesRepository;
		this.tblStatusTypesMapper = tblStatusTypesMapper;
	}


	@Autowired
	TblStatusTypesMapper tblstatusmapper;

	@Override
	public TblStatusTypesDTO save(TblStatusTypesDTO tblStatusTypesDTO) {
		log.debug("Request to save TblStatusTypes : {}", tblStatusTypesDTO);
		TblStatusTypes tblOrders = tblStatusTypesMapper.toEntity(tblStatusTypesDTO);
		tblOrders = tblStatusTypesRepository.save(tblOrders);
		TblStatusTypesDTO result = tblStatusTypesMapper.toDto(tblOrders);
		return result;
	}

	@Override
	public List<TblStatusTypesDTO> findAll() {
		log.debug("Request to get all TblStatusTypes");
		return tblStatusTypesRepository.findAll().stream().map(tblStatusTypesMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Optional<TblStatusTypesDTO> findOne(String id) {
		log.debug("Request to get TblStatusTypes : {}", id);
		return tblStatusTypesRepository.findById(id).map(tblStatusTypesMapper::toDto);
	}

	@Override
	public void delete(String id) {
		log.debug("Request to delete TblStatusTypes : {}", id);
		tblStatusTypesRepository.deleteById(id);
	}

}
