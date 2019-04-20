package operations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;

/***
 * This class tests powerOfTwo method of IntegerOperations with Parameters
 * 
 * @author PANAGIOTIS
 *
 */

@RunWith(Parameterized.class)
public class IntegerOperationsTest_PowerOfTwo_Parameterized {

	private int power;
	private int result;
	private IntegerOperations io;

	@Before
	/***
	 * This method makes an Integer Operations object.
	 */
	public void initialize() {
		io = new IntegerOperations();
	}

	/***
	 * 
	 * @param power: The given power
	 * @param result: The result of 2^power
	 */
	public IntegerOperationsTest_PowerOfTwo_Parameterized(int power, int result) {
		this.power = power;
		this.result = result;
	}

	@Parameters
	/***
	 * This method creates and array with parameters for testing.
	 * 
	 * @return an array with parameters
	 */
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 0, 1 }, { 1, 2 }, { 3, 8 }, { 4, 16 } };

		return Arrays.asList(data);
	}

	/***
	 * This method test with parameters the powerOfTwo method.
	 */
	@Test
	public void test_powerOfTwo_good() {
		assertEquals(result, io.powerOfTwo(power));
	}

}
