package com.jimmylee;

import java.util.Random;

/**
 * 一个保证概率的抽奖程序。
 * 通过随机排列的数组，按下标一个个取出来，取到什么数获得什么奖励。
 * 奖励取走之后不会出现第二次
 * 
 * @author jimmylee
 * @version 创建时间：2014-6-9  上午11:33:03
 */
public class Lottery {
	private static int[] pool;

	/**
	 * 初始化数量
	 * @param size
	 */
	public static void init(int size) {
		pool = new int[size];
		for (int i = 0; i < size; i++) {
			pool[i] = i;
		}
	}

	/**
	 * 获得随机排列的数组
	 * @param size
	 * @return
	 */
	public static int[] getPool(int size) {
		if (pool == null) {
			init(size);
			Random random = new Random();
			for (int i = 0; i < size; i++) {
				doChange(random.nextInt(size), i, pool);
			}
		}
		return pool;
	}

	/**
	 * 交换位置，打乱数组
	 * @param p1
	 * @param p2
	 * @param pool
	 */
	public static void doChange(int p1, int p2, int[] pool) {
		int temp = pool[p1];
		pool[p1] = pool[p2];
		pool[p2] = temp;
	}

	public static void main(String[] args) {
		int[] pool = Lottery.getPool(10000);
		for (int i = 0; i < 10000; i++) {
			if (pool[i] == 0) {
				System.out.println("5000");
			} else if (pool[i] >= 1 && pool[i] < 11) {
				System.out.println("500");
			} else if (pool[i] >= 11 && pool[i] < 111) {
				System.out.println("200");
			} else if (pool[i] >= 111 && pool[i] < 161) {
				System.out.println("100");
			} else if (pool[i] >= 161 && pool[i] < 461) {
				System.out.println("50");
			} else if (pool[i] >= 461 && pool[i] < 961) {
				System.out.println("20");
			} else if (pool[i] >= 961 && pool[i] < 1961) {
				System.out.println("10");
			} else if (pool[i] >= 1961 && pool[i] < 4961) {
				System.out.println("5");
			} else {
				System.out.println("0");
			}

		}
	}

}
