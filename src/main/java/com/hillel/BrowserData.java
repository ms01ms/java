package com.hillel;

import org.testng.annotations.DataProvider;

public class BrowserData {
	@DataProvider(name = "browsers")
	public static Object[][] browsers() {
		return new Object[][]{
				{"chrome"},
				{"firefox"}
		};
	}
}

