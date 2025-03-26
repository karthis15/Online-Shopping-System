package com.example.online_shopping.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.online_shopping.domain.TblCountriesMaster;
import com.example.online_shopping.service.dto.TblCountriesMasterDTO;

@Mapper(componentModel = "spring", uses = { TblTimeZoneMapper.class })
public interface TblCountriesMasterMapper extends EntityMapper<TblCountriesMasterDTO, TblCountriesMaster> {

	@Mapping(source = "tblTimeZone.id", target = "timeZone")
	TblCountriesMasterDTO toDto(TblCountriesMaster tblCountriesMaster);

	@Mapping(source = "timeZone", target = "tblTimeZone")
	TblCountriesMaster toEntity(TblCountriesMasterDTO tblCountriesMasterDTO);

	default TblCountriesMaster fromId(String id) {
		if (id == null) {
			return null;
		}
		TblCountriesMaster countriesMaster = new TblCountriesMaster();
		countriesMaster.setId(id);
		return countriesMaster;
	}
}
