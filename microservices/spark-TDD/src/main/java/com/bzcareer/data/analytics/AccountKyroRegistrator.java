package com.bzcareer.data.analytics;

import org.apache.spark.serializer.KryoRegistrator;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.FieldSerializer;

public class AccountKyroRegistrator implements KryoRegistrator {

	@Override
	public void registerClasses(Kryo kryo) {

		kryo.register(Account.class, new FieldSerializer(kryo, Account.class));
	}

}