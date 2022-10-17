import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

	public void compute() {
		Scanner scanner = new Scanner(System.in);

		// code: 1001
		String codeString = scanner.nextLine();
		int[] code = new int[codeString.length()];
		// int[] code = { 1, 0, 0, 1 };
		for (int i = 0; i < codeString.length(); i++) {
			code[i] = codeString.charAt(i) - '0';
		}

		// input: 101110
		String input = scanner.nextLine();
		// data: 101110000
		int[] data = stringToIntData(input, code.length);
		int[] checksum = getChecksum(code, data);
		System.out.println("checksum / result: " + Arrays.toString(checksum));

//		int[] newData = new int[input.length() + code.length - 1];
//		for (int i = 0; i < input.length(); i++) {
//			newData[i] = input.charAt(i) - '0';
//		}
//		for (int i = 0; i < checksum.length; i++) {
//			newData[i + input.length()] = checksum[i];
//		}
//		System.out.println("Data + checksum: " + Arrays.toString(newData));
//
//		int[] newChecksum = getChecksum(code, newData);
//		System.out.println("result(0): " + Arrays.toString(newChecksum));

	}

	private int[] getChecksum(int[] code, int[] data) {
//		 the last index is "length + 1" because it starts with 0.
//		 <Calculate the number of iterations> 
//		 ex) 1111000: 0123 1234 2345 3456
//		 repeat 4 times = 7(data.length) - 4(code.length) + 1

		for (int i = 0; i < (data.length - code.length) + 1; i++) {

			if (data[i] == 1) {
				for (int j = 0; j < code.length; j++) {
					data[i + j] = code[j] ^ data[i + j];
				}
			} else {
				for (int j = 0; j < code.length; j++) {
					data[i + j] = 0 ^ data[i + j];
				}
			}
		}

		int[] checksum = new int[code.length - 1];
		for (int i = 0; i < checksum.length; i++) {
			checksum[i] = data[(data.length - code.length) + 1 + i];
		}

		return checksum;
	}

	private int[] stringToIntData(String input, int codeLength) {
		int[] data = new int[input.length() + codeLength - 1];
		for (int i = 0; i < input.length(); i++) {
			data[i] = input.charAt(i) - '0';
		}
		for (int j = input.length(); j < data.length; j++) {
			data[j] = 0;
		}
		return data;
	}
}
