package com.bzcareer.monitord.core.docker;

import java.util.HashMap;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificateException;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.messages.ContainerConfig;

public class DockerManager implements ProvisionManager {
	DockerClient docker;
	String playbookUrl;
	String keyPathUrl;
	String name;

	static DockerManager newInstance() {
		return new DockerManager();

	}

	@Override
	public DockerManager withName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public DockerManager withAnsiblePlayBook(String playbookUrl) {
		this.playbookUrl = playbookUrl;
		return this;
	}

	@Override
	public DockerManager withKeyUri(String key) {
		keyPathUrl = key;
		return this;
	}

	@Override
	public String toString() {
		return "DockerManager [playbookUrl=" + playbookUrl + ", keyPathUrl=" + keyPathUrl + "]";
	}

	public void runPlayBook(DockerManager manager)
			throws DockerCertificateException, DockerException, InterruptedException {
		createClient();
		// TODO: Call 'createWorker()'

	}

	private DockerClient createClient() throws DockerCertificateException {
		docker = DefaultDockerClient.fromEnv().build();
		return docker;
	}

	// TODO: Need to call worker and pass in ansible playbook url and keyfile
	// location.
	private void createWorker(String name) throws DockerException, InterruptedException {
		docker.createContainer(
				ContainerConfig.builder().image("ansible/centos7-ansible").labels(new HashMap<String, String>() {
					{
						put("builder_name", name);
					}
				}).build(), name);
	}

}
