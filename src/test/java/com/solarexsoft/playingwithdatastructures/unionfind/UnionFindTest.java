package com.solarexsoft.playingwithdatastructures.unionfind;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/10/2.
 * Desc:
 */
public class UnionFindTest {
    private double testUF(UnionFind unionFind, int opCount) {
        int size = unionFind.getSize();
        Random random = new Random();

        long start = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.unionElements(a, b);
        }

        for (int i = 0; i < opCount; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a, b);
        }

        long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }

    @Test
    public void test() {
        int size = 100000;
        int opCount = 100000;

        UnionFindV1 uf1 = new UnionFindV1(size);
        System.out.println("V1 cost " + testUF(uf1, opCount) + " s");
        UnionFindV2 uf2 = new UnionFindV2(size);
        System.out.println("V2 cost " + testUF(uf2, opCount) + " s");

        System.out.println("----------------------------");

        size = 10000000;
        opCount = 10000000;

        UnionFindV3 uf3 = new UnionFindV3(size);
        System.out.println("V3 cost " + testUF(uf3, opCount) + " s");
        UnionFindV4 uf4 = new UnionFindV4(size);
        System.out.println("V4 cost " + testUF(uf4, opCount) + " s");
        UnionFindV5 uf5 = new UnionFindV5(size);
        System.out.println("V5 cost " + testUF(uf5, opCount) + " s");
        UnionFindV6 uf6 = new UnionFindV6(size);
        System.out.println("V6 cost " + testUF(uf6, opCount) + " s");
    }
}