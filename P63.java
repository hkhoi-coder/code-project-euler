import java.math.BigInteger;

/**
 *
 * @author hkhoi
 */
public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		final BigInteger NINE = new BigInteger("9");
		int counter = 0;
		for (BigInteger i = BigInteger.ONE; i.compareTo(NINE) <= 0;
				i = i.add(BigInteger.ONE)) {
			int pow = 1;
			while (true) {
				BigInteger temp = i.pow(pow);
				int dig = temp.toString().length();
				if (dig < pow++) {
					break;
				} else {
					++counter;
				}
			}
		}
		System.out.println(counter);
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed);
	}

	static int numDig(long a) {
		return (int) Math.log10(a) + 1;
	}
}
