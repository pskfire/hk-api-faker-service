package com.manulife.hk.domain.data;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bitmap {

    private long[] bits;
    private int maxNum;

    public Bitmap(int initialCapacity) {
        int size = (initialCapacity + 63) >> 6;
        this.bits = new long[size];
        this.maxNum = initialCapacity - 1;
    }

    public Bitmap() {
        this(64);
    }

    private void expandCapacity(int newMaxNum) {
        int newSize = (newMaxNum + 63) >> 6;
        long[] newBits = new long[newSize];
        System.arraycopy(bits, 0, newBits, 0, bits.length);
        this.bits = newBits;
        this.maxNum = newMaxNum;
    }

    public void add(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("Parameter not support");
        }

        if(num > maxNum) {
            expandCapacity(num);
        }

        int index = num >> 6;
        int offset = num & 63;
        log.info("bit.length = {}" + bits.length);
        bits[index] |= (1L << offset);
    }

    public boolean contains(int num) {
        if(num < 0 || num > maxNum) {
            return false;
        }

        int index = num >> 6;
        int offset = num & 63;

        return (bits[index] & (1L << offset)) != 0;
    }

    public void remove(int num) {
        if(num < 0 || num > maxNum) {
            return;
        }

        int index = num >> 6;
        int offset = num & 63;

        bits[index] &= ~(1L << offset);
    }

    public static void main(String[] args) {
        // 初始化Bitmap，预设能存0~1000的数（测试几十亿级别只需调整初始化容量）
        Bitmap bitmap = new Bitmap(1000);

        // 添加测试数字
        bitmap.add(100);
        bitmap.add(500);
        bitmap.add(999);

        // 查询数字是否存在
        System.out.println("100是否存在：" + bitmap.contains(100)); // true
        System.out.println("200是否存在：" + bitmap.contains(200)); // false
        System.out.println("500是否存在：" + bitmap.contains(500)); // true

        // 移除数字后查询
        bitmap.remove(500);
        System.out.println("500是否存在：" + bitmap.contains(500)); // false

        // 测试超大数字（模拟几十亿级别，实际使用时注意内存）
        int bigNum = 1000000000; // 10亿
        bitmap.add(bigNum);
        System.out.println(bigNum + "是否存在：" + bitmap.contains(bigNum)); // true
    }
}
