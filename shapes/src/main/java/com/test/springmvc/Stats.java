package com.test.springmvc;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Stats implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private AtomicInteger circle = new AtomicInteger();
	private AtomicInteger square = new AtomicInteger();
	private AtomicInteger rectangle = new AtomicInteger();
	private AtomicInteger elipse = new AtomicInteger();
	
	public int getCircle() {
		return circle.get();
	}
	public int incrementCircle() {
		return this.circle.incrementAndGet();
	}
	
	public int getSquare() {
		return square.get();
	}
	public int incrementSquare() {
		return this.square.incrementAndGet();
	}	
	
	public int getRectangle() {
		return rectangle.get();
	}
	public int incrementRectangle() {
		return this.rectangle.incrementAndGet();
	}	
	
	public int getElipse() {
		return elipse.get();
	}
	public int incrementElipse() {
		return this.elipse.incrementAndGet();
	}	

}
