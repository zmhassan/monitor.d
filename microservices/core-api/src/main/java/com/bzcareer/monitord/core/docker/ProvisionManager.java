package com.bzcareer.monitord.core.docker;

public interface ProvisionManager {

	public ProvisionManager withAnsiblePlayBook(String url);
	public ProvisionManager withKeyUri(String url);
	ProvisionManager withName(String name);
	
}
