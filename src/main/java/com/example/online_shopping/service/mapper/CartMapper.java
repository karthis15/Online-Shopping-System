package com.example.online_shopping.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.online_shopping.domain.Cart;
import com.example.online_shopping.service.dto.CartDTO;

@Mapper(componentModel = "spring", uses = { ProductMapper.class,UserMapper.class })
public interface CartMapper extends EntityMapper<CartDTO, Cart> {

	@Mapping(source = "product.id", target = "product")
	@Mapping(source = "user.id", target = "user")
	CartDTO toDto(Cart cart);

	@Mapping(source = "product", target = "product")
	@Mapping(source = "user", target = "user")
	Cart toEntity(CartDTO cartDTO);

	default Cart fromId(Long id) {
		if (id == null) {
			return null;
		}
		Cart cart = new Cart();
		cart.setId(id);
		return cart;
	}

}
