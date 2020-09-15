package jp.co.sample_powermock.statictest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
public class UseUtilityTest {

	@Test
	public void test_doReturn() throws Exception {
		// ����
		String name = "John ";
		String expected = "Hello, John.";

		// ���b�N��
		PowerMockito.mockStatic(Utility.class);
		// ���b�N�N���X�Ɩ߂�l��ݒ�
		PowerMockito.doReturn("John").when(Utility.class);
		// ���Őݒ肵���߂�l��Ԃ����\�b�h��ݒ�
		Utility.trim(anyString());

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// ���ʊm�F
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void test_doThrow() throws Exception {
		// ����
		String name = "John ";
		Exception expected_exception = new Exception("error!");

		// ���b�N��
		PowerMockito.mockStatic(Utility.class);
		// ���b�N�N���X�Ɨ�O��ݒ�
		PowerMockito.doThrow(expected_exception).when(Utility.class);
		// ���Őݒ肵����O��Ԃ����\�b�h��ݒ�
		Utility.trim(anyString());

		// ���s
		UseUtility obj = new UseUtility();
		obj.getMessage(name);
	}

	@Test
	public void test_doCallRealMethod() throws Exception {
		// ����
		String name = "John ";
		String expected = "Hello, John .";

		// ���b�N��
		PowerMockito.mockStatic(Utility.class);
		// ���b�N�N���X�Ǝ������Ăт����ݒ�
		PowerMockito.doCallRealMethod().when(Utility.class);
		// �������Ăԃ��\�b�h��ݒ�
		Utility.trim(anyString());

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// ���ʊm�F
		assertEquals(expected, actual);
	}

	@Test
	public void test_doNothing() throws Exception {
		// ���s����
		// ���b�N��
		PowerMockito.mockStatic(Utility.class);
		// ���b�N�N���X�Ɖ������Ȃ��ݒ�
		PowerMockito.doNothing().when(Utility.class);
		// �������Ȃ����\�b�h��ݒ�
		Utility.clearDatabase();

		// ���s
		UseUtility obj = new UseUtility();
		boolean actual = obj.setUp();

		// ���ʊm�F
		assertTrue(actual);
	}

	@Test
	public void test_thenReturn() throws Exception {
		// ����
		String name = "John ";
		String expected = "Hello, John.";

		// ���b�N��
		PowerMockito.mockStatic(Utility.class);
		// �߂�l��ݒ�
		PowerMockito.when(Utility.trim(anyString())).thenReturn("John");

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// ���ʊm�F
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void test_thenThrow() throws Exception {
		// ����
		String name = "John ";
		Exception expected_exception = new Exception("error!");

		// ���b�N��
		PowerMockito.mockStatic(Utility.class);
		// ��O��ݒ�
		PowerMockito.when(Utility.trim(anyString())).thenThrow(expected_exception);

		// ���s
		UseUtility obj = new UseUtility();
		obj.getMessage(name);
	}

	@Test
	public void test_thenCallRealMethod() throws Exception {
		// ����
		String name = "John ";
		String expected = "Hello, John .";

		// ���b�N��
		PowerMockito.mockStatic(Utility.class);
		// �������ĂԐݒ�
		PowerMockito.when(Utility.trim(anyString())).thenCallRealMethod();

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// ���ʊm�F
		assertEquals(expected, actual);
	}

	@Test
	public void test_verify() throws Exception {
		// ����
		String name = "John ";
		String expected = "Hello, John.";

		// ���b�N��
		PowerMockito.mockStatic(Utility.class);
		// ���b�N�N���X�Ɩ߂�l��ݒ�
		PowerMockito.doReturn("John").when(Utility.class);
		// ���Őݒ肵���߂�l��Ԃ����\�b�h��ݒ�
		Utility.trim(anyString());

		// ���s
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// ���ʊm�F
		assertEquals(expected, actual);
		// 1��Ă΂ꂽ���Ƃ��m�F
		PowerMockito.verifyStatic(Utility.class);
		Utility.trim(anyString());
	}
}
