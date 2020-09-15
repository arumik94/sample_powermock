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
		// 準備
		String name = "John ";
		String expected = "Hello, John.";

		// モック化
		PowerMockito.mockStatic(Utility.class);
		// モッククラスと戻り値を設定
		PowerMockito.doReturn("John").when(Utility.class);
		// ↑で設定した戻り値を返すメソッドを設定
		Utility.trim(anyString());

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// 結果確認
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void test_doThrow() throws Exception {
		// 準備
		String name = "John ";
		Exception expected_exception = new Exception("error!");

		// モック化
		PowerMockito.mockStatic(Utility.class);
		// モッククラスと例外を設定
		PowerMockito.doThrow(expected_exception).when(Utility.class);
		// ↑で設定した例外を返すメソッドを設定
		Utility.trim(anyString());

		// 実行
		UseUtility obj = new UseUtility();
		obj.getMessage(name);
	}

	@Test
	public void test_doCallRealMethod() throws Exception {
		// 準備
		String name = "John ";
		String expected = "Hello, John .";

		// モック化
		PowerMockito.mockStatic(Utility.class);
		// モッククラスと実物を呼びだす設定
		PowerMockito.doCallRealMethod().when(Utility.class);
		// 実物を呼ぶメソッドを設定
		Utility.trim(anyString());

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// 結果確認
		assertEquals(expected, actual);
	}

	@Test
	public void test_doNothing() throws Exception {
		// 実行準備
		// モック化
		PowerMockito.mockStatic(Utility.class);
		// モッククラスと何もしない設定
		PowerMockito.doNothing().when(Utility.class);
		// 何もしないメソッドを設定
		Utility.clearDatabase();

		// 実行
		UseUtility obj = new UseUtility();
		boolean actual = obj.setUp();

		// 結果確認
		assertTrue(actual);
	}

	@Test
	public void test_thenReturn() throws Exception {
		// 準備
		String name = "John ";
		String expected = "Hello, John.";

		// モック化
		PowerMockito.mockStatic(Utility.class);
		// 戻り値を設定
		PowerMockito.when(Utility.trim(anyString())).thenReturn("John");

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// 結果確認
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void test_thenThrow() throws Exception {
		// 準備
		String name = "John ";
		Exception expected_exception = new Exception("error!");

		// モック化
		PowerMockito.mockStatic(Utility.class);
		// 例外を設定
		PowerMockito.when(Utility.trim(anyString())).thenThrow(expected_exception);

		// 実行
		UseUtility obj = new UseUtility();
		obj.getMessage(name);
	}

	@Test
	public void test_thenCallRealMethod() throws Exception {
		// 準備
		String name = "John ";
		String expected = "Hello, John .";

		// モック化
		PowerMockito.mockStatic(Utility.class);
		// 実物を呼ぶ設定
		PowerMockito.when(Utility.trim(anyString())).thenCallRealMethod();

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// 結果確認
		assertEquals(expected, actual);
	}

	@Test
	public void test_verify() throws Exception {
		// 準備
		String name = "John ";
		String expected = "Hello, John.";

		// モック化
		PowerMockito.mockStatic(Utility.class);
		// モッククラスと戻り値を設定
		PowerMockito.doReturn("John").when(Utility.class);
		// ↑で設定した戻り値を返すメソッドを設定
		Utility.trim(anyString());

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(name);

		// 結果確認
		assertEquals(expected, actual);
		// 1回呼ばれたことを確認
		PowerMockito.verifyStatic(Utility.class);
		Utility.trim(anyString());
	}
}
