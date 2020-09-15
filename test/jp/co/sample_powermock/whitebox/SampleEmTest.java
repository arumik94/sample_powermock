package jp.co.sample_powermock.whitebox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest()
public class SampleEmTest {

	@Test
	public void test_getInternalState() throws Exception {
		// 準備
		SampleEm em = new SampleEm("value");
		// privateフィールドの値を取得する
		String field = Whitebox.getInternalState(em, "field");
	}

	@Test
	public void test_setInternalState() throws Exception {
		// 準備
		SampleEm em = new SampleEm("value");
		// privateフィールドに値を設定する
		Whitebox.setInternalState(em, "field", "newValue");
	}

	@Test
	public void test_invokeMethod() throws Exception {
		// 準備
		SampleEm em = new SampleEm("value");
		// privateメソッドを呼び出す
		Whitebox.invokeMethod(em, "setField", "newValue");
	}
}
