package com.bzcareer.monitord.core.docker;

import java.util.function.Function;

import org.junit.Ignore;
import org.junit.Test;

import com.spotify.docker.client.DockerCertificateException;
import com.spotify.docker.client.DockerException;


public class ProvisionManagerTest {

	@Ignore("Need to create docker image from these values passed in")
	@Test
	public void test() {
 		
			DockerManager dm = DockerManager.newInstance()
					.withAnsiblePlayBook("https://github.com/BZCareer/monitor.d/tree/master/ansible")
					.withKeyUri("file:///");
			try {
				dm.runPlayBook(dm);
				
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
			System.out.println(dm);
	}
 
}
