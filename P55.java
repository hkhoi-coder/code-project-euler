import java.math.BigInteger;

/**
 *
 * @author hkhoi
 */
public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		BigInteger in = new BigInteger("10");
		BigInteger end = new BigInteger("10000");
		int counter = 0;
		for (BigInteger i = in; i.compareTo(end) < 0; i = i.add(BigInteger.ONE)) {
			if (isLychrel(i)) {
				++counter;
			}
		}

		System.out.println(counter);

		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed);
	}

	static boolean isLychrel(BigInteger a) {
		for (int i = 0; i < 50; ++i) {
			a = a.add(rev(a));
			if (isPal(a)) {
				return false;
			}
		}
		return true;
	}

	static boolean isPal(BigInteger a) {
		String revString = new StringBuilder(a.toString()).reverse().toString();
		BigInteger rev = new BigInteger(revString);
		return a.equals(rev);
	}

	static BigInteger rev(BigInteger a) {
		String revString = new StringBuilder(a.toString()).reverse().toString();
		return new BigInteger(revString);
	}
}
