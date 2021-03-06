package jp.co.sample_powermock.staticinitializer;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SampleEm.class)
@SuppressStaticInitializationFor("jp.co.sample_powermock.staticinitializer.SampleEm")
public class SampleEmTest {

	@Test
	public void test() throws Exception {
		// 実行
		SampleEm em = new SampleEm();
		boolean result = em.judge();

		// 結果確認
		assertFalse(result);
	}
}
