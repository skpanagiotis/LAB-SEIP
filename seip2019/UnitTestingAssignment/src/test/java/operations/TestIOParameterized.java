package operations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/***
 * This class tests powerOfTwo method of IntegerOperations with Parameters
 * 
 * @author PANAGIOTIS
 *
 */

@RunWith(Parameterized.class)
public class TestIOParameterized {
	
	@Parameter (value = 0)
	public int power;
	@Parameter (value = 1)
	public int result;
	
	
	IntegerOperations io = new IntegerOperations();

	/***
	 * This method creates and array with parameters for testing.
	 * 
	 * @return an array with parameters
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 0, 1 }, { 1, 2 }, { 3, 8 }, { 4, 16 } };

		return Arrays.asList(data);
	}

	/***
	 * This method test with parameters the powerOfTwo method.
	 */
	@Test
	public void test_powerOfTwo_good() {
		Assert.assertEquals(result, io.powerOfTwo(power));
	}

}
