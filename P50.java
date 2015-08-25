import java.util.ArrayList;

/**
 *
 * @author hkhoi
 */
public class Main {
    
    public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int lim = 1_000_000;
		boolean[] notPrime = new boolean[lim];
		
		for (int i = 2; i < notPrime.length; ++i) {
			if (!notPrime[i]) {
				try {
					for (int j = i * i; j < notPrime.length; j += i) {
						notPrime[j] = true;
					}
				} catch (IndexOutOfBoundsException ex) {
					// NOTHING
				}
			}
		}
		
		ArrayList<Long> sumList = new ArrayList<>();
		long sum = 0;
		
		sumList.add(sum);
		for (int i = 2; i < notPrime.length; ++i) {
			if (!notPrime[i]) {
				sum += i;
				if (sum > lim) {
					break;
				}
				sumList.add(sum);
			}
		}
		
		int maxChain = -1;
		long result = -1;
		
		for (int i = 1; i < sumList.size(); ++i) {
			for (int j = i + 1; j < sumList.size(); ++j) {
				if (j - i > maxChain) {
					long temp = sumList.get(j) - sumList.get(i - 1);
					if (isPrime(temp)) {
						result = temp;
						maxChain = j - i;
					}
				}
			}
		}
		
		System.out.println(result);
		
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed);
	}
	
	static boolean isPrime(long a) {
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

