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

		// 期待値
		String expected_elem1 = "test";
		String expected_elem2 = "val2";

		// Enumをモック化する
		SampleEnum mocked = Mockito.mock(SampleEnum.class);

		// メソッドに戻り値を設定してスタブ化する
		Mockito.when(mocked.getVal()).thenReturn(expected_elem1);
		// 実物を呼びたいメソッドがある場合
		// Mockito.when(mocked.getVal()).thenCallRealMethod();

		// Enumの要素にモック化したオブジェクトをセットする
		Whitebox.setInternalState(SampleEnum.class, "ELEM1", mocked);

		// 実行
		String actual_elem1 = SampleEnum.ELEM1.getVal(); // "test"が返る
		String actual_elem2 = SampleEnum.ELEM2.getVal(); // "val2"が返る

		// 結果確認
		assertEquals(expected_elem1, actual_elem1);
		assertEquals(expected_elem2, actual_elem2);
	}
}
