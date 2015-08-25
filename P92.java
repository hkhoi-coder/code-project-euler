import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hkhoi
 */
public class Main {

	static HashMap<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
		long start = System.currentTimeMillis();

		map.put(1, false);
		map.put(89, true);

		int counter = 0;
		for (int i = 9_999_999; i >= 1; --i) {
			if (end89(i)) {
				++counter;
			}
		}

		System.out.println(counter);

//		System.out.println(end89(85));

		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed);
	}

	static boolean end89(int a) {
		ArrayList<Integer> list = new ArrayList<>();
		while (!map.containsKey(a)) {
			list.add(a);
			a = sumSquare(a);
		}

		if (map.get(a)) {
			for (int i : list) {
				map.put(i, true);
			}
			return true;
		} else {
			for (int i : list ) {
				map.put(i, false);
			}
			return false;
		}
	}

	static int sumSquare(int a) {
		int sum = 0;
		while (a > 0) {
			int temp = a % 10;
			a /= 10;
			sum += (temp * temp);
		}

		return sum;
	}
}
