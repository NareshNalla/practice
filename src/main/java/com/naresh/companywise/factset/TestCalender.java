package com.naresh.companywise.factset;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestCalender {

	public static void main(String[] args) {
		Calendar[] calenders = new Calendar[10];
		//calenders[0] = new Calendar(); //java.util.Calendar is abstract; cannot be instantiated
		calenders[1] = new GregorianCalendar();
	}
}
