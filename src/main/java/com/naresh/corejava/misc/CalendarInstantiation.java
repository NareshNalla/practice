package com.naresh.corejava.misc;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarInstantiation {

	public static void main(String[] args) {
		Calendar[] calenders = new Calendar[10];
		//calenders[0] = new Calendar();
		calenders[1] = new GregorianCalendar();
		System.out.println(calenders[1]);
	}
}
