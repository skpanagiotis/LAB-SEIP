package operations;

import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

/**
 * This class tests the IntegerOperations class
 * 
 * @author PANAGIOTIS
 *
 */

public class IntegerOperationsTest {
	IntegerOperations io = new IntegerOperations();

	/***
	 * This method tests reverseSign with positive number input.
	 */
	@Test
	public void test_reverseSign_positiveinput() {
		Assert.assertEquals(-5, io.reverseSign(5));
	}

	/***
	 * This method tests reverseSign with negative number input.
	 */
	@Test
	public void test_reverseSign_negativeinput() {
		Assert.assertEquals(3, io.reverseSign(-3));
	}

	/***
	 * This method tests reverseSign with zero number input.
	 */
	@Test
	public void test_reverseSign_zeroinput() {
		Assert.assertEquals(0, io.reverseSign(0));
	}

	/***
	 * This method tests add with two positive numbers input
	 */
	@Test
	public void test_add_good() {
		Assert.assertEquals(12, io.add(4, 8));
	}

	/***
	 * This method tests add with two negative numbers input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_xn_yn() {
		io.add(-3, -2);
	}

	/***
	 * This method tests add with x positive and y negative input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_xp_yn() {
		io.add(3, -2);
	}

	/***
	 * This method test add with x negative and y positive input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_xn_yp() {
		io.add(-3, 2);
	}

	/***
	 * This method tests if by adding the two inputs is made a number more than
	 * 2,147,483,647
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_int_overflow() {
		io.add(10, 2147483640);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/***
	 * This method test if powerOfTwo with negative input will throw
	 * IllegalArgumentException.
	 */
	@Test
	public void test_powerOfTwo_negative_RuleException() {
		thrown.expect(IllegalArgumentException.class);
		io.powerOfTwo(-5);
	}

	/***
	 * This method test if powerOfTwo with input more than 31 will throw
	 * IllegalArgumentException.
	 */
	@Test
	public void test_powerOfTwo_moreThan31() {
		thrown.expect(IllegalArgumentException.class);
		io.powerOfTwo(36);
	}

}
