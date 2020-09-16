package jp.co.sample_powermock.staticinitializer;

public class SampleEm {
	
	private static String field = null;
	
	static {
		field = "value";
	}
	
	public boolean judge() {
		return "value".equals(field);
	}
}
