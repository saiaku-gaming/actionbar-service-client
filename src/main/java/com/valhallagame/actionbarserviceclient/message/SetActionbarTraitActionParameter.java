package com.valhallagame.actionbarserviceclient.message;

import org.hibernate.validator.constraints.NotBlank;

import com.valhallagame.common.validation.CheckLowercase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetActionbarTraitActionParameter {
	@NotBlank
	@CheckLowercase
	private String characterName;
	private Integer index;
	private String traitName;
}
