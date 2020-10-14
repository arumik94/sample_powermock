package jp.co.sample_powermock.enumtest;

public enum SampleEnum {
	
	ELEM1("val1"),
	ELEM2("val2");
	
	private String val;
	
	private SampleEnum(String val) {
		this.val = val;
	}
	
	public String getVal() {
		return this.val;
	}
}
