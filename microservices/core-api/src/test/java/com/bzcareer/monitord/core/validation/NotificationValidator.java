package com.bzcareer.monitord.core.validation;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bzcareer.monitord.core.model.NotificationDAO;

public class NotificationValidator {

	private static Validator validator;
	
	@BeforeClass
	public static void bootStrap(){
		ValidatorFactory fact = Validation.buildDefaultValidatorFactory();
		validator = fact.getValidator();
	}
	
	@Test
	public void testInvalidServerNameAndIPForNull(){
		NotificationDAO notify= new NotificationDAO();
		Set<ConstraintViolation<NotificationDAO>> constraint= validator.validate(notify);
		assertThat( constraint , hasSize(3));
 		assertEquals("may not be null", constraint.iterator().next().getMessage());
	}
 
}
