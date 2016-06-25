package com.bzcareer.producer;

import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) {
		KafkaMessenger messenger = new KafkaMessenger("localhost:9092");

		try {

			messenger.send("logtest", "apple").get();
			messenger.send("logtest", "orange").get();
			messenger.send("logtest", "watermelon").get();
			messenger.send("logtest", "grape").get();

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			messenger.close();
		}
	}

}
