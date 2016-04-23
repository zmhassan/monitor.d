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

import com.bzcareer.monitord.core.model.JobDAO;

public class JobValidator {

	private static Validator validator;
	
	@BeforeClass
	public static void bootStrap(){
		ValidatorFactory fact = Validation.buildDefaultValidatorFactory();
		validator = fact.getValidator();
	}
	
	@Test
	public void testInvalidServerNameAndIPForNull(){
		JobDAO job= new JobDAO();
		Set<ConstraintViolation<JobDAO>> constraint= validator.validate(job);
		assertThat( constraint , hasSize(5));
 		assertEquals("may not be null", constraint.iterator().next().getMessage());
	}
 
}
