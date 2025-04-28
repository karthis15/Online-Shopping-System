package com.example.online_shopping.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class CategoryDTO {

	private Long id;

	private String name;

	private String imageName;

	private Boolean isActive;

}