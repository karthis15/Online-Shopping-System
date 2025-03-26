package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import com.example.online_shopping.service.dto.TblTimeZoneDTO;

public interface TblTimeZoneService {

	TblTimeZoneDTO save(TblTimeZoneDTO tblTimeZoneDTO);

	List<TblTimeZoneDTO> findAll();

	Optional<TblTimeZoneDTO> findOne(Long id);

	void delete(Long id);

}
