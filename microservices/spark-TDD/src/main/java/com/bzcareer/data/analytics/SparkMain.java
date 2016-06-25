package com.bzcareer.data.analytics;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class SparkMain {

	public static void main(String[] args) {
		String logFile = "/usr/local/spark/README.md";
		SparkConf conf = new SparkConf().setAppName("Search Data Report");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> logData = sc.textFile(logFile).cache();

		long s = logData.filter(searchForLetter("s"))
				.filter(searchForLetter("sn")).count();
		long d = logData.filter(searchForLetter("d")).count();
		System.out.println("searching for letter s or sn and found: " + s);
		System.out.println("searching for the letter d and found: " + d);
	}

	private static Function<String, Boolean> searchForLetter(final String search) {
		return new Function<String, Boolean>() {
			public Boolean call(String s) {
				return s.contains(search);
			}
		};
	}

}
