package jp.co.sample_powermock.statictest;

public class UseUtility {

	public String getMessage(String name) throws Exception {

		String trimmedName = Utility.trim(name);

		return "Hello, " + trimmedName + ".";
	}

	public boolean setUp() {

		Utility.clearDatabase();

		// è»ó™

		return true;
	}
}
