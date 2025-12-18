package com.naresh.outputs;

/**
 * Demonstrates the behavior of Boolean constructors and parsing methods.
 * Note: The `new Boolean(String)` constructor has been deprecated since Java 9
 * and `Boolean.parseBoolean(String)` should be preferred.
 */
public class BooleanParsingDemo {
	public static void main(String[] args) {

		// Boolean.parseBoolean(String)
		// This static method returns `true` if and only if the string argument is not null and is equal, ignoring case, to the string "true".
		System.out.println("Boolean.parseBoolean(\"true\"): " + Boolean.parseBoolean("true")); // true

		// new Boolean(String) - DEPRECATED
		// The behavior is the same as parseBoolean.
		System.out.println("new Boolean(\"true\"): " + new Boolean("true"));     // true
		System.out.println("new Boolean(\"trUE\"): " + new Boolean("trUE"));   // true

		// new Boolean(null) - DEPRECATED
		// Passing null or any string other than "true" (case-insensitive) results in false.
		System.out.println("new Boolean(null): " + new Boolean(null));       // false

		// All wrapper classes like Integer, Double, Boolean, etc., do not have a no-argument default constructor.
		// The following line would cause a compile error if uncommented:
		// System.out.println(new Integer());
	}
}
