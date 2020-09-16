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
		// é¿çs
		SampleEm em = new SampleEm();
		boolean result = em.judge();

		// åãâ ämîF
		assertFalse(result);
	}
}
