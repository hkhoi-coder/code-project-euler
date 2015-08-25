import java.math.BigInteger;

/**
 *
 * @author hkhoi
 */
public class Main {

    public static void main(String[] args) {
		long start = System.currentTimeMillis();

		final BigInteger BIGTWO = new BigInteger("2");

		final Fraction ONE = new Fraction(BigInteger.ONE, BigInteger.ONE);
		final Fraction TWO = new Fraction(BIGTWO, BigInteger.ONE);
		Fraction a = new Fraction(BigInteger.ONE, BIGTWO);
		Fraction temp;

		int counter = 0;

		for (int i = 2; i <= 1000; ++i) {
			a = a.add(TWO);
			a.flip();

			temp = a.add(ONE);
//			temp.print();
			if (temp.isUpMoreThanDown()) {
//				temp.print();
				++counter;
			}
		}

		System.out.println(counter);

		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed);
	}

	static class Fraction {
		private BigInteger up, down;

		private BigInteger gcd(BigInteger a, BigInteger b) {
			while (!b.equals(BigInteger.ZERO)) {
				BigInteger t = b;
				b = a.mod(b);
				a = t;
			}
			return a;
		}

		public Fraction(BigInteger u, BigInteger d) {
			BigInteger gcd = gcd(u, d);
			u = u.divide(gcd);
			d = d.divide(gcd);
			up = u;
			down = d;
		}

		public Fraction add(Fraction that) {
			BigInteger up, down;
			down = this.down.multiply(that.down);
			up = this.up.multiply(that.down).add(this.down.multiply(that.up));
			BigInteger gcd = gcd(up, down);
			up = up.divide(gcd);
			down = down.divide(gcd);

			return new Fraction(up, down);
		}

		public Fraction flip() {
			BigInteger temp = up;
			up = down;
			down = temp;

			return this;
		}

		public boolean isUpMoreThanDown() {
			return up.toString().length() > down.toString().length();
		}

		public void print() {
			System.out.printf("%s/%s\n", up.toString(), down.toString());
		}
	}
}
