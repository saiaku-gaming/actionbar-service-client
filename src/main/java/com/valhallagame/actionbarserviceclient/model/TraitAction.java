package com.valhallagame.actionbarserviceclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraitAction {
	private ActionbarItem actionbarItem;
	private String traitName;
}
