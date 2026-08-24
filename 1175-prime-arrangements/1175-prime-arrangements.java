class Solution {
    public int numPrimeArrangements(int n) {
        long MOD = 1000000007;
        
        int primeCount = 0;

        // Count prime numbers from 1 to n
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }

        // primeCount! 
        long primeFact = 1;
        for (int i = 2; i <= primeCount; i++) {
            primeFact = (primeFact * i) % MOD;
        }

        // (n - primeCount)!
        long nonPrimeFact = 1;
        for (int i = 2; i <= n - primeCount; i++) {
            nonPrimeFact = (nonPrimeFact * i) % MOD;
        }

        return (int)((primeFact * nonPrimeFact) % MOD);
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}