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
		// 準備
		// モック化
		Utility mock = PowerMockito.mock(Utility.class);
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(mock);

		// 実行
		UseUtility obj = new UseUtility();
		obj.createUtility();
	}

	@Test(expected = Exception.class)
	public void test_thenThrow() throws Exception {
		// 準備
		Exception exception = new Exception("error!");

		// モック化
		PowerMockito.mock(Utility.class);
		// コンストラクタで発生する例外を設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenThrow(exception);

		// 実行
		UseUtility obj = new UseUtility();
		obj.createUtility();
	}

	@Test
	public void test_verify() throws Exception {
		// 準備
		// モック化
		Utility mock = PowerMockito.mock(Utility.class);
		// コンストラクタで返却するインスタンスを設定
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(mock);

		// 実行
		UseUtility obj = new UseUtility();
		obj.createUtility();

		// 結果確認
		// 1回呼ばれたことを確認
		PowerMockito.verifyNew(Utility.class).withNoArguments();
	}
}
