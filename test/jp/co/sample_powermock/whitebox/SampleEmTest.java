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
		// ����
		SampleEm em = new SampleEm("value");
		// private�t�B�[���h�̒l���擾����
		String field = Whitebox.getInternalState(em, "field");
	}

	@Test
	public void test_setInternalState() throws Exception {
		// ����
		SampleEm em = new SampleEm("value");
		// private�t�B�[���h�ɒl��ݒ肷��
		Whitebox.setInternalState(em, "field", "newValue");
	}

	@Test
	public void test_invokeMethod() throws Exception {
		// ����
		SampleEm em = new SampleEm("value");
		// private���\�b�h���Ăяo��
		Whitebox.invokeMethod(em, "setField", "newValue");
	}
}
