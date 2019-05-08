package operations;

import org.junit.Assert;
import org.junit.Test;

import filehandlers.FileIO;

import static org.mockito.Mockito.*;

/***
 * This class include the tests for findMaxInFile and reverseArray methods of
 * ArrayOperrations class.
 * 
 * @author PANAGIOTIS
 *
 */
public class ArrayOperrationsTest {
	ArrayOperrations ao;

	/***
	 * This method tests the findMaxInFile method for the case that the given file
	 * does not exist.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_findMaxInFile_filenotexist() {
		FileIO fio = mock(FileIO.class);
		IntegerOperations io = mock(IntegerOperations.class);

		ao = new ArrayOperrations(fio, io);

		String filepath = "src/test/resources/test_valid.txt";

		when(fio.readFile(filepath)).thenReturn(new int[] {});
		ao.findMaxInFile(filepath);

	}

	/***
	 * This method tests the findMaxInFile method for the case that the given file
	 * is correct and finds the max value.
	 */
	@Test
	public void test_findMaxInFile_good() {
		FileIO fio = mock(FileIO.class);
		IntegerOperations io = mock(IntegerOperations.class);

		ao = new ArrayOperrations(fio, io);

		String filepath = "src/test/resources/test_valid.txt";

		when(fio.readFile(filepath)).thenReturn(new int[] { 1, 2, 4, 8 });

		int maxvalue = 8;

		Assert.assertEquals(maxvalue, ao.findMaxInFile(filepath));
	}

	/***
	 * This method tests the reversrArray method for the case that the given file
	 * does not exist.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_reverseArray_emptyArray() {
		FileIO fio = mock(FileIO.class);
		IntegerOperations io = mock(IntegerOperations.class);

		ao = new ArrayOperrations(fio, io);

		String filepath = "src/test/resources/test_valid.txt";

		when(fio.readFile(filepath)).thenReturn(new int[] {});
		ao.reverseArray(filepath);

	}

	/***
	 * This method tests the reverseArray method for the case that the given file is
	 * correct and converts to an array and the array is reversed with the right
	 * way.
	 */
	@Test
	public void test_reverseArray_good() {
		FileIO fio = mock(FileIO.class);
		IntegerOperations io = mock(IntegerOperations.class);

		ao = new ArrayOperrations(fio, io);

		String filepath = "src/test/resources/test_ar.txt";

		when(fio.readFile(filepath)).thenReturn(new int[] { 1, 2, -3, -4 });

		when(io.reverseSign(1)).thenReturn(-1);
		when(io.reverseSign(2)).thenReturn(-2);
		when(io.reverseSign(-3)).thenReturn(3);
		when(io.reverseSign(-4)).thenReturn(4);

		Assert.assertArrayEquals(new int[] { -1, -2, 3, 4 }, ao.reverseArray(filepath));
	}

}