import java.math.BigInteger;

/**
 *
 * @author hkhoi
 */
public class Main {

    public static void main(String[] args) {
		long start = System.currentTimeMillis();

		BigInteger a = new BigInteger("28433");
		BigInteger b = new BigInteger("2");

		b = b.pow(7830457);
		a = a.multiply(b);
		a = a.add(BigInteger.ONE);

		BigInteger c = new BigInteger("10000000000");
		a = a.mod(c);

		System.out.println(a);

		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed);
	}
}
