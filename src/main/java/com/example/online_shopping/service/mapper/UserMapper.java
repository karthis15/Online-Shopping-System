package com.example.online_shopping.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.online_shopping.domain.User;
import com.example.online_shopping.service.dto.UserDTO;

@Mapper(componentModel = "spring", uses = { TblCountriesMasterMapper.class, TblStatusTypesMapper.class })
public interface UserMapper extends EntityMapper<UserDTO, User> {

	@Mapping(source = "countriesMaster.id", target = "countryId")
	@Mapping(source = "isOnline.id", target = "isOnline")
	UserDTO toDto(User user);

	@Mapping(source = "countryId", target = "countriesMaster")
//	@Mapping(source = "email", target = "email")
//	@Mapping(source = "login", target = "login")
	@Mapping(source = "isOnline", target = "isOnline")
	User toEntity(UserDTO userDTO);

	default User fromId(String id) {
		if (id == null) {
			return null;
		}
		User user = new User();
		user.setId(id);
		return user;
	}

}
