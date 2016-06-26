package com.bzcareer.kafka;

public class KCMain {

	public static void main(String[] args) {
		KafkaMsgReciever krec= new KafkaMsgReciever();
		krec.consume();
	}
}
