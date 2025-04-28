package com.example.online_shopping.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.online_shopping.domain.Order;
import com.example.online_shopping.service.dto.OrderDTO;



@Mapper(componentModel = "spring", uses = { ProductMapper.class,UserMapper.class ,OrderAddressMapper.class,})
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
	
	@Mapping(source = "product.id", target = "productId")
	@Mapping(source = "user.id", target = "userId")
	@Mapping(source = "orderAddress.id", target = "orderAddressId")
	OrderDTO toDto(Order user);

	@Mapping(source = "productId", target = "product")
	@Mapping(source = "userId", target = "user")
	@Mapping(source = "orderAddressId", target = "orderAddress")
	Order toEntity(OrderDTO orderDTO);

	default Order fromId(Long id) {
		if (id == null) {
			return null;
		}
		Order order = new Order();
		order.setId(id);
		return order;
	}

}
