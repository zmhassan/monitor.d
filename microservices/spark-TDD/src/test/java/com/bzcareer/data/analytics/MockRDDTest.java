package com.bzcareer.data.analytics;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.apache.spark.api.java.function.Function;
import org.junit.Test;

public class MockRDDTest {

	@Test
	public void testIfValueIsRead() throws Exception {
		String searchData = "APPLES ARE GREEN";
		String charToFind = "A";
		Function<String, Boolean> searchForLetter = searchForLetter(charToFind);
		Boolean found = searchForLetter.call(searchData);
		assertThat("Search for character A should return true", found, is(true));
	}

	private static Function<String, Boolean> searchForLetter(final String search) {
		return new Function<String, Boolean>() {

			private static final long serialVersionUID = 1L;

			public Boolean call(String s) {
				return s.contains(search);
			}
		};

	}

}
