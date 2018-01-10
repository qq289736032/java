package com.jisen.DelayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyDelayedElement implements Delayed {
	
	private String ele;
	@Override
	public int compareTo(Delayed arg0) {
		boolean equals = this.equals(arg0);
		return equals?1:0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		TimeUnit milliseconds = unit.MILLISECONDS;
		long millis = milliseconds.toMillis(1000);
		return millis;
	}
	
	
	
	public MyDelayedElement() {
		super();
	}
	

	public MyDelayedElement(String ele) {
		super();
		this.ele = ele;
	}

	@Override
	public String toString() {
		return "MyDelayedElement [ele=" + ele + "]";
	}

	public String getEle() {
		return ele;
	}

	public void setEle(String ele) {
		this.ele = ele;
	}
	
	

}
