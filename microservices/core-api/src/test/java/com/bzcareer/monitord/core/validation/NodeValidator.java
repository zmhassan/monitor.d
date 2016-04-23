package com.bzcareer.monitord.core.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bzcareer.monitord.core.model.NodeDAO;

public class NodeValidator {

	private static Validator validator;
	
	@BeforeClass
	public static void bootStrap(){
		ValidatorFactory fact = Validation.buildDefaultValidatorFactory();
		validator = fact.getValidator();
	}
	
	@Test
	public void testInvalidServerNameAndIPForNull(){
		NodeDAO node= new NodeDAO();
		Set<ConstraintViolation<NodeDAO>> constraint= validator.validate(node);
		assertThat( constraint , hasSize(2));
 		assertEquals("may not be null", constraint.iterator().next().getMessage());
	}
	@Test
	public void testValidServerNameAndIPForNull(){
		NodeDAO node= new NodeDAO();
		node.setId("10101010101010100101010101010");
		node.setServerIp("10.0.0.1");
		node.setServerName("infra.yahoo.com");
		Set<ConstraintViolation<NodeDAO>> constraint= validator.validate(node);
		assertThat( constraint , hasSize(0));
 		 
	}
}
