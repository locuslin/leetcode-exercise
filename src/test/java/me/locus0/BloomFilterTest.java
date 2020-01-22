package me.locus0;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created on 2020/1/21.
 *
 * @author LingChuan
 */
public class BloomFilterTest {

    private BloomFilter bloomFilter;

    @Before
    public void setUp() {
        bloomFilter = new BloomFilter();
    }

    @Test
    public void put() {
        int length = 2000;
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int num = ThreadLocalRandom.current().nextInt();
            nums.add(num);
            bloomFilter.put(num);
        }

        int  missContainCount =0;
        for (int num : nums) {
            if (!bloomFilter.contains(num)) {
                System.out.println("actual contains ,but not: " + num);
            }
            while (nums.contains(++num)) {
            }
            if (bloomFilter.contains(num)) {
               // System.out.println("actual not contains ,but not: " + num);
                missContainCount++;
            }
        }
        System.out.println(missContainCount);

    }

}