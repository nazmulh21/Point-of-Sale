package com.nazmul.eShop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
//its not optional class its work with  Purchase Controller. 
//@Component
public class RandomStringGenerator {
	ConcurrentMap<String, AtomicInteger> sequence = new ConcurrentHashMap<>();

	public String getSequence(String initials, Integer nextInt, Integer nextTotal) {
		if (nextInt == null) {
			nextInt = 0;
		}
		
		if (nextTotal == null) {
			nextTotal = 0;
		}

		AtomicInteger chk = new AtomicInteger(nextInt);

		AtomicInteger totalincrement = new AtomicInteger(nextTotal);
		AtomicInteger ai = sequence.putIfAbsent(initials, chk);
		if (ai == null) {
			ai = chk;
		}
		int val = ai.incrementAndGet();
		int totalvalIn = totalincrement.incrementAndGet();
		return initials + String.format("%03d", val) + String.format("%03d", totalvalIn);
	}

	/*
	 * public static void main(String[] args) { String initial = new
	 * SimpleDateFormat("ddMMyy").format(new Date());
	 * 
	 * int nextInt = 0; RandomStringGenerator randObj = new RandomStringGenerator();
	 * String retu = randObj.getSequence(initial, nextInt, null); String retu2 =
	 * randObj.getSequence(initial, nextInt, 2);
	 * 
	 * }
	 */
}
