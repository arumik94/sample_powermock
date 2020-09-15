package jp.co.sample_powermock.constructortest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Utility.class, UseUtility.class })
public class UseUtilityTest {

	@Test
	public void test_thenReturn() throws Exception {
		// ����
		// ���b�N��
		Utility mock = PowerMockito.mock(Utility.class);
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(mock);

		// ���s
		UseUtility obj = new UseUtility();
		obj.createUtility();
	}

	@Test(expected = Exception.class)
	public void test_thenThrow() throws Exception {
		// ����
		Exception exception = new Exception("error!");

		// ���b�N��
		PowerMockito.mock(Utility.class);
		// �R���X�g���N�^�Ŕ��������O��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenThrow(exception);

		// ���s
		UseUtility obj = new UseUtility();
		obj.createUtility();
	}

	@Test
	public void test_verify() throws Exception {
		// ����
		// ���b�N��
		Utility mock = PowerMockito.mock(Utility.class);
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(mock);

		// ���s
		UseUtility obj = new UseUtility();
		obj.createUtility();

		// ���ʊm�F
		// 1��Ă΂ꂽ���Ƃ��m�F
		PowerMockito.verifyNew(Utility.class).withNoArguments();
	}
}
