package com.valhallagame.actionbarserviceclient.message;

import org.hibernate.validator.constraints.NotBlank;

import com.valhallagame.common.validation.CheckLowercase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetActionbarItemActionParameter {
	@NotBlank
	@CheckLowercase
	private String username;
	private Integer index;
	private String itemName;
}
