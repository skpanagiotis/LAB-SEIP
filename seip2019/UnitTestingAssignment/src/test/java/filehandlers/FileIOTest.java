package filehandlers;

import org.junit.Test;
import org.junit.Assert;

/***
 * 
 * @author PANAGIOTIS This class includes all the necessary tests for
 *         FileIO.java file.
 */

public class FileIOTest {
	FileIO fio = new FileIO();

	/***
	 * This method tests the readFile method for the case, that the file does not
	 * exist.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_readFile_notexist() {
		String filepath = "src/test/resources/test.txt";
		fio.readFile(filepath);
	}

	/***
	 * This method tests the readFile method for the case, that the file has invalid
	 * data.
	 */
	@Test(expected = NumberFormatException.class)
	public void test_readFile_invalid() {
		String filepath = "src/test/resources/test_invalid.txt";
		fio.readFile(filepath);
	}

	/***
	 * This method tests the readFile method for the case, that the file has valid
	 * data and convert with right way to an array.
	 */
	@Test
	public void test_readFile_good() {
		String filepath = "src/test/resources/test_valid.txt";
		int[] array = { 1, 2, 4, 8 };
		Assert.assertArrayEquals(array, fio.readFile(filepath));
	}

}
