package com.valhallagame.actionbarserviceclient;

import com.valhallagame.actionbarserviceclient.message.GetActionbarParameter;
import com.valhallagame.actionbarserviceclient.message.RemoveActionbarActionParameter;
import com.valhallagame.actionbarserviceclient.message.SetActionbarItemActionParameter;
import com.valhallagame.actionbarserviceclient.message.SetActionbarTraitActionParameter;
import com.valhallagame.actionbarserviceclient.model.ActionbarWrapper;
import com.valhallagame.common.AbstractServiceClient;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestResponse;

import java.io.IOException;

public class ActionbarServiceClient extends AbstractServiceClient {

	private static ActionbarServiceClient actionbarServiceClient;

	private ActionbarServiceClient() {
		serviceServerUrl = "http://localhost:" + DefaultServicePortMappings.ACTIONBAR_SERVICE_PORT;
	}

	public static void init(String serviceServerUrl) {
		ActionbarServiceClient client = get();
		client.serviceServerUrl = serviceServerUrl;
	}

	public static ActionbarServiceClient get() {
		if (actionbarServiceClient == null) {
			actionbarServiceClient = new ActionbarServiceClient();
		}
		return actionbarServiceClient;
	}

	public RestResponse<String> setActionbarTraitAction(String characterName, Integer index, String traitName)
			throws IOException {
		SetActionbarTraitActionParameter input = new SetActionbarTraitActionParameter(characterName, index, traitName);
		return restCaller.postCall(serviceServerUrl + "/v1/actionbar/set-actionbar-trait-action", input,
				String.class);
	}

	public RestResponse<String> setActionbarItemAction(String characterName, Integer index, String itemName)
			throws IOException {
		SetActionbarItemActionParameter input = new SetActionbarItemActionParameter(characterName, index, itemName);
		return restCaller.postCall(serviceServerUrl + "/v1/actionbar/set-actionbar-item-action", input,
				String.class);
	}

	public RestResponse<String> removeActionbarAction(String characterName, Integer index)
			throws IOException {
		RemoveActionbarActionParameter input = new RemoveActionbarActionParameter(characterName, index);
		return restCaller.postCall(serviceServerUrl + "/v1/actionbar/remove-actionbar-action", input,
				String.class);
	}

	public RestResponse<ActionbarWrapper> getActionbar(String characterName)
			throws IOException {
		GetActionbarParameter input = new GetActionbarParameter(characterName);
		return restCaller.postCall(serviceServerUrl + "/v1/actionbar/get-actionbar", input,
				ActionbarWrapper.class);
	}
}
