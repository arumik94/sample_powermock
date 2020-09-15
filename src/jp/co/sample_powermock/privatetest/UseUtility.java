package jp.co.sample_powermock.privatetest;

import java.util.Map;

public class UseUtility {

	public String getMessage(String id) throws Exception {

		Utility utility = new Utility();

		Map<String, String> userInfo = utility.getUserInfo(id);

		String message = id + ":" + userInfo.get(id);

		return message;
	}
}
