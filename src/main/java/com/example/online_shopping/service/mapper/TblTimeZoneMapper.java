package com.example.online_shopping.service.mapper;

import org.mapstruct.Mapper;

import com.example.online_shopping.domain.TblTimeZone;
import com.example.online_shopping.service.dto.TblTimeZoneDTO;

@Mapper(componentModel = "spring", uses = {})
public interface TblTimeZoneMapper extends EntityMapper<TblTimeZoneDTO, TblTimeZone> {

	TblTimeZoneDTO toDto(TblTimeZone tblTimeZone);

	TblTimeZone toEntity(TblTimeZoneDTO tblTimeZoneDTO);

	default TblTimeZone fromId(Long id) {
		if (id == null) {
			return null;
		}
		TblTimeZone tblTimeZone = new TblTimeZone();
		tblTimeZone.setId(id);
		return tblTimeZone;
	}
}
