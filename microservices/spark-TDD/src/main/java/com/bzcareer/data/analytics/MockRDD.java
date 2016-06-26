package com.bzcareer.data.analytics;

import java.util.List;
import java.util.Map;

import org.apache.spark.api.java.function.Function;

public class MockRDD<T> {

	List<T> data = null;
	List<Function<String, Boolean>> callback;
	private Integer count = 0;
	Map<String, Integer> score;

	public MockRDD(List<T> input) {
		data = input;

	}

	MockRDD<T> filter(Function<String, Boolean> func) {
		callback.add(func);
		return this;
	}

	public Integer count() throws Exception {

		for (Function<String, Boolean> function : callback) {
			for (T d : data) {
				Integer num = score.get(d);
				Boolean value = function.call((String) d);
				if (value)
					num++;

				score.put((String) d, num);
				// System.out.println(value);
			}
		}
		return count;
	}

}
