package jp.co.sample_powermock.privatetest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Utility.class, UseUtility.class })
public class UtilityTest {

	@Test
	public void test_doReturn() throws Exception {
		// ����
		String id = "0001";
		String expected = "0001:TestUser";

		// �X�p�C��
		Utility spy = PowerMockito.spy(new Utility());
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// �X�p�C�������N���X��private���\�b�h�̖߂�l��ݒ�
		PowerMockito.doReturn("TestUser").when(spy, "getName", anyString());

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// ���ʊm�F
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void test_doThrow() throws Exception {
		// ����
		String id = "0001";
		Exception expected_exception = new Exception("error!");

		// �X�p�C��
		Utility spy = PowerMockito.spy(new Utility());
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// �X�p�C�������N���X��private���\�b�h�ŕԂ���O��ݒ�
		PowerMockito.doThrow(expected_exception).when(spy, "getName", anyString());

		// ���s
		UseUtility obj = new UseUtility();
		obj.getMessage(id);
	}

	@Test
	public void test_doCallRealMethod() throws Exception {
		// ����
		String id = "0001";
		String expected = "0001:";

		// �X�p�C��
		Utility spy = PowerMockito.spy(new Utility());
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// �X�p�C�������N���X��private���\�b�h�Ŏ������Ăяo���悤�ݒ�
		PowerMockito.doCallRealMethod().when(spy, "getName", anyString());

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// ���ʊm�F
		assertEquals(expected, actual);
	}

	@Test
	public void test_doNothing() throws Exception {
		// ����
		String id = "0001";
		String expected = "0001:";

		// �X�p�C��
		Utility spy = PowerMockito.spy(new Utility());
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// �X�p�C�������N���X��private���\�b�h�ŉ������Ȃ��悤�ݒ�
		PowerMockito.doNothing().when(spy, "connectDatabase", anyString());

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// ���ʊm�F
		assertEquals(expected, actual);
	}

	@Test
	public void test_thenReturn() throws Exception {
		// ����
		String id = "0001";
		String expected = "0001:TestUser";

		// �X�p�C��
		Utility spy = PowerMockito.spy(new Utility());
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// �X�p�C�������N���X��private���\�b�h�̖߂�l��ݒ�
		PowerMockito.when(spy, "getName", anyString()).thenReturn("TestUser");

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// ���ʊm�F
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void test_thenThrow() throws Exception {
		// ����
		String id = "0001";
		Exception expected_exception = new Exception("error!");

		// �X�p�C��
		Utility spy = PowerMockito.spy(new Utility());
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// �X�p�C�������N���X��private���\�b�h�ŕԂ���O��ݒ�
		PowerMockito.when(spy, "getName", anyString()).thenThrow(expected_exception);

		// ���s
		UseUtility obj = new UseUtility();
		obj.getMessage(id);
	}

	@Test
	public void test_thenCallRealMethod() throws Exception {
		// ����
		String id = "0001";
		String expected = "0001:";

		// �X�p�C��
		Utility spy = PowerMockito.spy(new Utility());
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// �X�p�C�������N���X��private���\�b�h�Ŏ������Ăяo���悤�ݒ�
		PowerMockito.when(spy, "getName", anyString()).thenCallRealMethod();

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// ���ʊm�F
		assertEquals(expected, actual);
	}

	@Test
	public void test_verify() throws Exception {
		// ����
		String id = "0001";
		String expected = "0001:TestUser";

		// �X�p�C��
		Utility spy = PowerMockito.spy(new Utility());
		// �R���X�g���N�^�ŕԋp����C���X�^���X��ݒ�
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// �X�p�C�������N���X��private���\�b�h�̖߂�l��ݒ�
		PowerMockito.doReturn("TestUser").when(spy, "getName", anyString());

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// ���ʊm�F
		assertEquals(expected, actual);
		// 1��Ă΂ꂽ���Ƃ��m�F
		PowerMockito.verifyPrivate(spy).invoke("getName", anyString());
	}
}
