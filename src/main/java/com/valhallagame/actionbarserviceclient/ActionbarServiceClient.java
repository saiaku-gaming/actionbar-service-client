package com.valhallagame.actionbarserviceclient;

import java.io.IOException;

import com.valhallagame.actionbarserviceclient.message.RemoveActionbarActionParameter;
import com.valhallagame.actionbarserviceclient.message.SetActionbarItemActionParameter;
import com.valhallagame.actionbarserviceclient.message.SetActionbarTraitActionParameter;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;

public class ActionbarServiceClient {

	private static RestCaller restCaller = new RestCaller();

	private static ActionbarServiceClient actionbarServiceClient;

	private String actionbarServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.CHARACTER_SERVICE_PORT;

	private ActionbarServiceClient() {
	}

	public static void init(String actiobarServiceServerUrl) {
		ActionbarServiceClient client = get();
		client.actionbarServiceServerUrl = actiobarServiceServerUrl;
	}

	public static ActionbarServiceClient get() {
		if (actionbarServiceClient == null) {
			actionbarServiceClient = new ActionbarServiceClient();
		}
		return actionbarServiceClient;
	}

	public RestResponse<String> setActionbarTraitAction(String username, Integer index, String traitName)
			throws IOException {
		SetActionbarTraitActionParameter input = new SetActionbarTraitActionParameter(username, index, traitName);
		return restCaller.postCall(actionbarServiceServerUrl + "/v1/actionbar/set-actionbar-trait-action", input,
				String.class);
	}

	public RestResponse<String> setActionbarItemAction(String username, Integer index, String itemName)
			throws IOException {
		SetActionbarItemActionParameter input = new SetActionbarItemActionParameter(username, index, itemName);
		return restCaller.postCall(actionbarServiceServerUrl + "/v1/actionbar/set-actionbar-item-action", input,
				String.class);
	}

	public RestResponse<String> removeActionbarAction(String username, Integer index)
			throws IOException {
		RemoveActionbarActionParameter input = new RemoveActionbarActionParameter(username, index);
		return restCaller.postCall(actionbarServiceServerUrl + "/v1/actionbar/remove-actionbar-action", input,
				String.class);
	}
}
