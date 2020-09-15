package jp.co.sample_powermock.privatetest;

import java.util.HashMap;
import java.util.Map;

public class Utility {

	public Utility() {
		// È—ª
	}

	public Map<String, String> getUserInfo(String id) throws Exception {

		this.connectDatabase("env");

		Map<String, String> userInfo = new HashMap<>();
		userInfo.put(id, this.getName(id));

		return userInfo;
	}

	private String getName(String id) throws Exception {
		// –¢À‘•‚Ì‘z’è
		return "";
	}

	private void connectDatabase(String env) {
		// Às‚µ‚½‚­‚È‚¢ˆ—‚Ì‘z’è
	}
}
