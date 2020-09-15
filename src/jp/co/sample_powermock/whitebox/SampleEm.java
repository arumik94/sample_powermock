package jp.co.sample_powermock.whitebox;

public class SampleEm {

	private String field = null;

	public SampleEm(String filed) {
		this.setField(filed);
	}

	public String getField() {
		return field;
	}

	private void setField(String filed) {
		this.field = filed;
	}
}
