import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author hkhoi
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
		long start = System.currentTimeMillis();

		int[][] table = new int[100][100];
		BufferedReader in =
				new BufferedReader(new FileReader("text.txt"));
		StringTokenizer token;
		for (int i = 0; i < 100; ++i) {
			token = new StringTokenizer(in.readLine());
			for (int j = 0; j <= i; ++j) {
				table[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		for (int i = 98; i >= 0; --i) {
			for (int j = 0; j <= i; ++j) {
				int left = table[i][j] + table[i + 1][j];
				int right = table[i][j] + table[i + 1][j + 1];
				table[i][j] = Math.max(left, right);
			}
		}

		System.out.println(table[0][0]);

		in.close();
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed);
	}
}
