package com.example.online_shopping.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.domain.OrderAddress;
import com.example.online_shopping.repository.OrderAddressRepository;
import com.example.online_shopping.service.OrderAddressService;
import com.example.online_shopping.service.dto.OrderAddressDTO;
import com.example.online_shopping.service.mapper.OrderAddressMapper;

@Service
public class OrderAddressServiceImpl implements OrderAddressService {

	private final Logger log = LoggerFactory.getLogger(OrderAddressServiceImpl.class);

	@Autowired
	OrderAddressRepository orderAddressRepository;

	@Autowired
	OrderAddressMapper orderAddressMapper;

	@Override
	public OrderAddressDTO save(OrderAddressDTO orderAddressDTO) {
		log.debug("Request to save OrderAddress : {}", orderAddressDTO);
		OrderAddress orderAddress = orderAddressMapper.toEntity(orderAddressDTO);
		orderAddress = orderAddressRepository.save(orderAddress);
		OrderAddressDTO result = orderAddressMapper.toDto(orderAddress);
		return result;
	}

	@Override
	public List<OrderAddressDTO> findAll() {
		log.debug("Request to get all OrderAddress");
		return orderAddressRepository.findAll().stream().map(orderAddressMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Optional<OrderAddressDTO> findOne(Long id) {
		log.debug("Request to get OrderAddress : {}", id);
		return orderAddressRepository.findById(id).map(orderAddressMapper::toDto);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete OrderAddress : {}", id);
		orderAddressRepository.deleteById(id);
	}

}
