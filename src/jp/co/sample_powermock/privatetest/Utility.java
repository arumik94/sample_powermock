package jp.co.sample_powermock.privatetest;

import java.util.HashMap;
import java.util.Map;

public class Utility {

	public Utility() {
		// �ȗ�
	}

	public Map<String, String> getUserInfo(String id) throws Exception {

		this.connectDatabase("env");

		Map<String, String> userInfo = new HashMap<>();
		userInfo.put(id, this.getName(id));

		return userInfo;
	}

	private String getName(String id) throws Exception {
		// �������̑z��
		return "";
	}

	private void connectDatabase(String env) {
		// ���s�������Ȃ������̑z��
	}
}
