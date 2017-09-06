package application;

public class Enigma {

	public static String codeText(String code) {

		char[] messageChars = code.toCharArray();

		char[] ringx = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char[] ring1 = { 'B', 'D', 'F', 'H', 'J', 'L', 'N', 'P', 'R', 'T', 'V', 'X', 'Z', 'A', 'C', 'E', 'G', 'I', 'K',
				'M', 'O', 'Q', 'S', 'U', 'W', 'Y' };
		char[] ring2 = { 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H',
				'G', 'F', 'E', 'D', 'C', 'B', 'A' };
		char[] ring3 = { 'Y', 'W', 'U', 'S', 'Q', 'O', 'M', 'K', 'I', 'G', 'E', 'C', 'A', 'B', 'D', 'F', 'H', 'J', 'L',
				'N', 'P', 'R', 'T', 'V', 'X', 'Z' };
		char[] ringb = { 'B', 'A', 'D', 'C', 'F', 'E', 'H', 'G', 'J', 'I', 'L', 'K', 'N', 'M', 'P', 'O', 'R', 'Q', 'T',
				'S', 'V', 'U', 'X', 'W', 'Z', 'Y' };

		char[] outMessage = new char[code.length()];
		int counter = 0;
		for (int i = 0; i < code.length(); i++) {

			OperateOnArray(messageChars, outMessage, ring1, i);
			OperateOnArray(outMessage, outMessage, ring2, i);
			OperateOnArray(outMessage, outMessage, ring3, i);
			OperateOnArray(outMessage, outMessage, ringb, i);
			OperateOnArrayBack(outMessage, ringx, outMessage, ring3, i);
			OperateOnArrayBack(outMessage, ringx, outMessage, ring2, i);
			OperateOnArrayBack(outMessage, ringx, outMessage, ring1, i);

			if (counter < 26) {

				move(ring1, ring1.length, 2);
				counter++;
			}

			else if (counter >= 26 && counter < 52) {
				move(ring2, ring2.length, 1);
				counter++;
			}

			else if (counter >= 52 && counter < 78) {
				move(ring3, ring3.length, 5);
				counter++;
			} else {
				counter = 0;
			}

		}

		return new String(outMessage);
	}

	public static void OperateOnArray(char[] inArray, char[] outArray, char[] ring, int index) {
		if ((int) inArray[index] == 32) // THIS IS SPACE
			outArray[index] = ' ';

		else if ((int) inArray[index] - 65 < 0) // CHAR OUT OF ALPHABET

			outArray[index] = '*';
		else if ((int) inArray[index] > 90) // CHAR OUT OF ALPHABET

			outArray[index] = '*';
		else
			outArray[index] = ring[(int) inArray[index] - 65];
	}

	public static void OperateOnArrayBack(char[] inArray, char[] inArray2, char[] outArray, char[] ring, int index) {
		if ((int) inArray[index] == 32) // THIS IS SPACE
			outArray[index] = ' ';

		else if ((int) inArray[index] - 65 < 0) // CHAR OUT OF ALPHABET

			outArray[index] = '*';
		else if ((int) inArray[index] > 90) // CHAR OUT OF ALPHABET

			outArray[index] = '*';
		else

			for (int i = 0; i < 26; i++) {
				if (ring[i] == inArray[index]) {
					outArray[index] = inArray2[i];
					break;
				}
			}

	}

	public static void move(char[] tab, int n, int k) {
		/* reverse all array */
		reverse(tab, 0, n - 1);
		/* reverse part of array" */
		reverse(tab, 0, k - 1);
		reverse(tab, k, n - 1);
	}

	public static void reverse(char[] tab, int beg, int end) {
		char tmp;

		while (beg < end) {
			tmp = tab[beg];
			tab[beg] = tab[end];
			tab[end] = tmp;
			beg++;
			end--;
		}
	}

}
