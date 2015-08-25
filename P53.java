/**
 *
 * @author hkhoi
 */
public class Main {

    public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int lim = 100;
		int max = 1_000_000;

		int[][] table = new int[lim + 1][lim + 1];
		int counter = 0;

		for (int row = 0; row <= lim; ++row) {
			table[row][0] = table[row][row] = 1;
			for (int col = 1; col <= row - 1; ++col) {
				table[row][col] = table[row - 1][col] + table[row - 1][col - 1];
				if (table[row][col] > 1_000_000 || table[row][col] < 0) {
					++counter;
				}
			}
		}

		System.out.println(counter);
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed);
	}
}
