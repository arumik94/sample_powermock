package jp.co.sample_powermock.privatetest;

import java.util.HashMap;
import java.util.Map;

public class Utility {

	public Utility() {
		// 省略
	}

	public Map<String, String> getUserInfo(String id) throws Exception {

		this.connectDatabase("env");

		Map<String, String> userInfo = new HashMap<>();
		userInfo.put(id, this.getName(id));

		return userInfo;
	}

	private String getName(String id) throws Exception {
		// 未実装の想定
		return "";
	}

	private void connectDatabase(String env) {
		// 実行したくない処理の想定
	}
}
