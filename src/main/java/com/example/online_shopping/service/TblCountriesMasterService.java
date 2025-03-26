package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import com.example.online_shopping.service.dto.TblCountriesMasterDTO;

public interface TblCountriesMasterService {

	List<TblCountriesMasterDTO> findAll();

	Optional<TblCountriesMasterDTO> findOne(String id);

	void delete(String id);

	TblCountriesMasterDTO save(TblCountriesMasterDTO countriesMasterDTO);

}
