package com.example.online_shopping.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.online_shopping.domain.TblTimeZone;
import com.example.online_shopping.repository.TblTimeZoneRepository;
import com.example.online_shopping.service.TblTimeZoneService;
import com.example.online_shopping.service.dto.TblTimeZoneDTO;
import com.example.online_shopping.service.mapper.TblTimeZoneMapper;

@Service
public class TblTimeZoneServiceImpl implements TblTimeZoneService {

	private final Logger log = LoggerFactory.getLogger(TblTimeZoneServiceImpl.class);

	private final TblTimeZoneRepository tblTimeZoneRepository;

	private final TblTimeZoneMapper tblTimeZoneMapper;

	public TblTimeZoneServiceImpl(TblTimeZoneRepository tblTimeZoneRepository, TblTimeZoneMapper tblTimeZoneMapper) {
		this.tblTimeZoneRepository = tblTimeZoneRepository;
		this.tblTimeZoneMapper = tblTimeZoneMapper;
	}

	@Override
	public TblTimeZoneDTO save(TblTimeZoneDTO tblTimeZoneDTO) {
		log.debug("Request to save TblTimeZone : {}", tblTimeZoneDTO);
		TblTimeZone tblTimeZone = tblTimeZoneMapper.toEntity(tblTimeZoneDTO);
		tblTimeZone = tblTimeZoneRepository.save(tblTimeZone);
		TblTimeZoneDTO result = tblTimeZoneMapper.toDto(tblTimeZone);
		return result;
	}

	@Override
	public List<TblTimeZoneDTO> findAll() {
		log.debug("Request to get all TblTimeZone");
		return tblTimeZoneRepository.findAll().stream().map(tblTimeZoneMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Optional<TblTimeZoneDTO> findOne(Long id) {
		log.debug("Request to get TblTimeZone : {}", id);
		return tblTimeZoneRepository.findById(id).map(tblTimeZoneMapper::toDto);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete TblTimeZone : {}", id);
		tblTimeZoneRepository.deleteById(id);
	}
}
