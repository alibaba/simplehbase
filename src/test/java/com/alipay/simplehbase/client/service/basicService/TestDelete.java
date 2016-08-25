package com.alipay.simplehbase.client.service.basicService;

import org.junit.Assert;
import org.junit.Test;

import com.alipay.simplehbase.myrecord.MyRecord;
import com.alipay.simplehbase.myrecord.MyRecordRowKey;
import com.alipay.simplehbase.myrecord.MyRecordTestBase;

/**
 * @author xinzhi
 */
public class TestDelete extends MyRecordTestBase {
	@Test
	public void delete() {

		putMockSlims(1);

		MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

		Assert.assertNotNull(simpleHbaseClient.findObject(myRecordRowKey,
				MyRecord.class));

		simpleHbaseClient.delete(myRecordRowKey);

		Assert.assertNull(simpleHbaseClient.findObject(myRecordRowKey,
				MyRecord.class));
	}

	@Test
	public void delete_PutObjectManyTimes() {

		putMockSlims(1);
		sleep(2);
		putMockSlims(1);

		MyRecordRowKey myRecordRowKey = new MyRecordRowKey(0);

		Assert.assertNotNull(simpleHbaseClient.findObject(myRecordRowKey,
				MyRecord.class));

		simpleHbaseClient.delete(myRecordRowKey);

		Assert.assertNull(simpleHbaseClient.findObject(myRecordRowKey,
				MyRecord.class));
	}

}