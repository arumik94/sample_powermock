package jp.co.sample_powermock.enumtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SampleEnum.class)
public class SampleEnumTest {

	@Test
	public void test() throws Exception {

		// ���Ғl
		String expected_elem1 = "test";
		String expected_elem2 = "val2";

		// Enum�����b�N������
		SampleEnum mocked = Mockito.mock(SampleEnum.class);

		// ���\�b�h�ɖ߂�l��ݒ肵�ăX�^�u������
		Mockito.when(mocked.getVal()).thenReturn(expected_elem1);
		// �������Ăт������\�b�h������ꍇ
		// Mockito.when(mocked.getVal()).thenCallRealMethod();

		// Enum�̗v�f�Ƀ��b�N�������I�u�W�F�N�g���Z�b�g����
		Whitebox.setInternalState(SampleEnum.class, "ELEM1", mocked);

		// ���s
		String actual_elem1 = SampleEnum.ELEM1.getVal(); // "test"���Ԃ�
		String actual_elem2 = SampleEnum.ELEM2.getVal(); // "val2"���Ԃ�

		// ���ʊm�F
		assertEquals(expected_elem1, actual_elem1);
		assertEquals(expected_elem2, actual_elem2);
	}
}
