
/**
 *
 * @author hkhoi
 */
public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		double primeCounter = 0;
		double total = 0;
		int layer = 1;
		int a = 3, b = 5, c = 7, d = 9;
		while (true) {
			if (isPrime(a)) {
				++primeCounter;
			}
			if (isPrime(b)) {
				++primeCounter;
			}
			if (isPrime(c)) {
				++primeCounter;
			}
			total = layer * 4 + 1;
			double per = primeCounter / total;
//			System.out.println("layer = " + layer + " per = " + per);
			if (per < 0.1) {
				break;
			}
			++layer;
			int inc = layer * 2;
			a = d + inc;
			b = a + inc;
			c = b + inc;
			d = c + inc;
		}
		System.out.println(layer * 2 + 1);
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed);
	}

	static boolean isPrime(int a) {
		if (a == 1 || a % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(a); ++i) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
}
