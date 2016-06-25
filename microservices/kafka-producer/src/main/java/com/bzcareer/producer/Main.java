package com.bzcareer.producer;

public class Main {

	public static void main(String[] args) {
		KafkaMessenger messenger = new KafkaMessenger("localhost:9092");
		messenger.send("logtest", "apple");
		messenger.send("logtest", "orange");
		messenger.send("logtest", "watermelon");
		messenger.send("logtest", "grape");
		messenger.close();
	}

}
