package me.locus0;

/**
 * Created on 2020/1/9.
 *
 * @author LingChuan
 */
public class BloomFilter {

    private static final int LENGTH = 1217;

    private static final int HASH_TIMES = 4;

    private static final int DEFAULT_K = 3;

    private static final int[] PRIMES = { 113, 151, 211, 281 };

    private int length = LENGTH;

    private byte[] data = new byte[LENGTH];

    private int k = 3;

    public void put(int key) {

        for (int i = 0; i < k; i++) {
            int prime = PRIMES[i];
            int hash = rehash(Math.abs(key * prime)) % LENGTH;
            data[hash] = 1;
        }
    }

    public boolean contains(int key) {
        for (int i = 0; i < k; i++) {
            int prime = PRIMES[i];
            int hash = rehash(Math.abs(key * prime)) % LENGTH;
            if (data[hash] == 0) {
                return false;
            }
        }
        return true;
    }

    private int rehash(int hash) {
        return hash ^ (hash >>> (Integer.SIZE / 2));
    }

}
