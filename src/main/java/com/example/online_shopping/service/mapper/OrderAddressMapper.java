package com.example.online_shopping.service.mapper;

import org.mapstruct.Mapper;

import com.example.online_shopping.domain.OrderAddress;
import com.example.online_shopping.service.dto.OrderAddressDTO;

@Mapper(componentModel = "spring", uses = {})
public interface OrderAddressMapper extends EntityMapper<OrderAddressDTO, OrderAddress> {

	OrderAddressDTO toDto(OrderAddress orderAddress);

	OrderAddress toEntity(OrderAddressDTO orderAddressDTO);

	default OrderAddress fromId(Long id) {
		if (id == null) {
			return null;
		}
		OrderAddress orderAddress = new OrderAddress();
		orderAddress.setId(id);
		return orderAddress;
	}

}
