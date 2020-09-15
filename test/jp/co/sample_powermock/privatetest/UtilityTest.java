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
		// 準備
		String id = "0001";
		String expected = "0001:TestUser";

		// スパイ化
		Utility spy = PowerMockito.spy(new Utility());
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// スパイ化したクラスのprivateメソッドの戻り値を設定
		PowerMockito.doReturn("TestUser").when(spy, "getName", anyString());

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// 結果確認
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void test_doThrow() throws Exception {
		// 準備
		String id = "0001";
		Exception expected_exception = new Exception("error!");

		// スパイ化
		Utility spy = PowerMockito.spy(new Utility());
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// スパイ化したクラスのprivateメソッドで返す例外を設定
		PowerMockito.doThrow(expected_exception).when(spy, "getName", anyString());

		// 実行
		UseUtility obj = new UseUtility();
		obj.getMessage(id);
	}

	@Test
	public void test_doCallRealMethod() throws Exception {
		// 準備
		String id = "0001";
		String expected = "0001:";

		// スパイ化
		Utility spy = PowerMockito.spy(new Utility());
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// スパイ化したクラスのprivateメソッドで実物を呼び出すよう設定
		PowerMockito.doCallRealMethod().when(spy, "getName", anyString());

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// 結果確認
		assertEquals(expected, actual);
	}

	@Test
	public void test_doNothing() throws Exception {
		// 準備
		String id = "0001";
		String expected = "0001:";

		// スパイ化
		Utility spy = PowerMockito.spy(new Utility());
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// スパイ化したクラスのprivateメソッドで何もしないよう設定
		PowerMockito.doNothing().when(spy, "connectDatabase", anyString());

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// 結果確認
		assertEquals(expected, actual);
	}

	@Test
	public void test_thenReturn() throws Exception {
		// 準備
		String id = "0001";
		String expected = "0001:TestUser";

		// スパイ化
		Utility spy = PowerMockito.spy(new Utility());
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// スパイ化したクラスのprivateメソッドの戻り値を設定
		PowerMockito.when(spy, "getName", anyString()).thenReturn("TestUser");

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// 結果確認
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void test_thenThrow() throws Exception {
		// 準備
		String id = "0001";
		Exception expected_exception = new Exception("error!");

		// スパイ化
		Utility spy = PowerMockito.spy(new Utility());
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// スパイ化したクラスのprivateメソッドで返す例外を設定
		PowerMockito.when(spy, "getName", anyString()).thenThrow(expected_exception);

		// 実行
		UseUtility obj = new UseUtility();
		obj.getMessage(id);
	}

	@Test
	public void test_thenCallRealMethod() throws Exception {
		// 準備
		String id = "0001";
		String expected = "0001:";

		// スパイ化
		Utility spy = PowerMockito.spy(new Utility());
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// スパイ化したクラスのprivateメソッドで実物を呼び出すよう設定
		PowerMockito.when(spy, "getName", anyString()).thenCallRealMethod();

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// 結果確認
		assertEquals(expected, actual);
	}

	@Test
	public void test_verify() throws Exception {
		// 準備
		String id = "0001";
		String expected = "0001:TestUser";

		// スパイ化
		Utility spy = PowerMockito.spy(new Utility());
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(spy);
		// スパイ化したクラスのprivateメソッドの戻り値を設定
		PowerMockito.doReturn("TestUser").when(spy, "getName", anyString());

		// 実行
		UseUtility obj = new UseUtility();
		String actual = obj.getMessage(id);

		// 結果確認
		assertEquals(expected, actual);
		// 1回呼ばれたことを確認
		PowerMockito.verifyPrivate(spy).invoke("getName", anyString());
	}
}
