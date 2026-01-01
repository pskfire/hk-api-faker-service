package com.manulife.hk.domain.data;

import java.util.BitSet;

public class Bitmap2 {

    private final long[] bits;

    // 构造函数：根据最大容量初始化数组
    public Bitmap2(int maxValue) {
        this.bits = new long[(maxValue >> 6) + 1]; // maxValue/64 +1
    }

    // 设置位
    public void set(int num) {
        int index = num >> 6;       // 计算数组索引（等价于num/64）
        int offset = num & 0x3F;    // 计算偏移量（等价于num%64）
        bits[index] |= (1L << offset); // 将指定位设为1
    }

    // 清除位
    public void clear(int num) {
        int index = num >> 6;
        int offset = num & 0x3F;
        bits[index] &= ~(1L << offset); // 将指定位清0
    }

    // 查询位
    public boolean get(int num) {
        int index = num >> 6;
        int offset = num & 0x3F;
        return (bits[index] & (1L << offset)) != 0;
    }

    // 统计位数
    public int count() {
        int cnt = 0;
        for (long b : bits) cnt += Long.bitCount(b);
        return cnt;
    }

    // 测试示例
    public static void main(String[] args) {
        // 初始化Bitmap，预设能存0~1000的数（测试几十亿级别只需调整初始化容量）
        BitSet bitmap = new BitSet(1000);

        // 添加测试数字
        bitmap.set(100);
        bitmap.set(500);
        bitmap.set(999);

        // 查询数字是否存在
        System.out.println("100是否存在：" + bitmap.get(100)); // true
        System.out.println("200是否存在：" + bitmap.get(200)); // false
        System.out.println("500是否存在：" + bitmap.get(500)); // true

        // 移除数字后查询
        bitmap.clear(500);
        System.out.println("500是否存在：" + bitmap.get(500)); // false

        // 测试超大数字（模拟几十亿级别，实际使用时注意内存）
        int bigNum = 1000000000; // 10亿
        bitmap.set(bigNum);
        System.out.println(bigNum + "是否存在：" + bitmap.get(bigNum)); // true
    }
}
