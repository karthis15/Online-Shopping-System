package com.example.online_shopping.service.mapper;

import org.mapstruct.Mapper;

import com.example.online_shopping.domain.TblStatusTypes;
import com.example.online_shopping.service.dto.TblStatusTypesDTO;

@Mapper(componentModel = "spring", uses = {})
public interface TblStatusTypesMapper extends EntityMapper<TblStatusTypesDTO, TblStatusTypes> {

	default TblStatusTypes fromId(String id) {
		if (id == null) {
			return null;
		}
		TblStatusTypes tblStatusTypes = new TblStatusTypes();
		tblStatusTypes.setId(id);
		return tblStatusTypes;
	}
}
