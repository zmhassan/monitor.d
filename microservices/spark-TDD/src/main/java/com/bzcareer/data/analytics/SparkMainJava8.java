package com.bzcareer.data.analytics;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class SparkMainJava8 {
	public static void main(String[] args) {
		String logFile = "/usr/local/spark/README.md";
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("Search Data Report");
		
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> logData = sc.textFile(logFile).cache();
		long s = logData.filter(line -> line.contains("s")).count();
		long d = logData.filter(line -> line.contains("d")).count();
		System.out.println("searching for letter s or sn and found: " + s);
		System.out.println("searching for the letter d and found: " + d);
	}

}
