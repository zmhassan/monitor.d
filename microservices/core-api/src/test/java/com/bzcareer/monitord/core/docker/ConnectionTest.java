package com.bzcareer.monitord.core.docker;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificateException;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;

public class ConnectionTest {
 
	private static final String DOCKER_IMG_NAME = "mongo";
	//private static final String DOCKER_IMG_NAME = "ansible/centos7-ansible";
	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionTest.class);

    @Ignore("Disabling Because Travis CI isn't ready")
	@Test
	public void test() {
		try {
 
			final DockerClient docker = createClient();		
			String name="TESTING123456Mongo";
			docker.pull(DOCKER_IMG_NAME);
			final ContainerConfig config = ContainerConfig.builder()
				    .image(DOCKER_IMG_NAME).attachStdout(true)
				    .build();
			final ContainerCreation creation = docker.createContainer(config, name);
		 
			docker.startContainer(creation.id());
			LOGGER.info("Number of Containers: " + docker.info().containers());
			LOGGER.info("Number of CPUs: " + docker.info().cpus());
			LOGGER.info("Number of Images: " + docker.info().images());

		} catch (DockerCertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DockerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This will point to the environment variable when running. This is only
	// for testing purposes
	private DockerClient createClient() throws DockerCertificateException {
 		final DockerClient docker = DefaultDockerClient.fromEnv().build();
		return docker;
	}
}
