package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import com.example.online_shopping.service.dto.TblStatusTypesDTO;

public interface TblStatusTypesService {

	TblStatusTypesDTO save(TblStatusTypesDTO tblStatusTypesDTO);

	List<TblStatusTypesDTO> findAll();

	Optional<TblStatusTypesDTO> findOne(String id);

	void delete(String id);

}
