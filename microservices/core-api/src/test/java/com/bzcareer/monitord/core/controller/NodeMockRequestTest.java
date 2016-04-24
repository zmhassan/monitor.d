package com.bzcareer.monitord.core.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.bzcareer.monitord.core.model.NodeDAO;
import com.bzcareer.monitord.core.services.NodeService;

@RunWith(MockitoJUnitRunner.class)
public class NodeMockRequestTest {

    @Mock
	private NodeService service;
    
    private NodeController controller;
    
    @Before
    public void setUp(){
    	controller = new NodeController(service);
    }
    
    @Test
    public void shouldCreateNode() throws Exception {
    	final NodeDAO savedNode = stubNodeFactory();
    	final NodeDAO node = createRandomItem();
    	NodeDAO createNode = controller.createNode(node);
    	verify(service, times(1)).create(node);
        assertEquals("Returned node should come from the service", createNode, savedNode);

    }

	private NodeDAO createRandomItem() {
		return new NodeDAO("google.com", "10.0.0.1");
	}

	private NodeDAO stubNodeFactory() {
		final NodeDAO node = new NodeDAO();
		when(service.create(any(NodeDAO.class))).thenReturn(node);
		return node;
	}
}
