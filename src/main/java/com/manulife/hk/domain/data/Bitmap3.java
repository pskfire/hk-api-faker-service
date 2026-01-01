package com.manulife.hk.domain.data;

public class Bitmap3 {

    private long[] data;
    private int size; // 以 bit 为单位的实际大小

    public Bitmap3(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }
        this.size = initialSize;
        int numLongs = (initialSize + 63) / 64; // 向上取整
        this.data = new long[numLongs];
    }

    // 确保容量足够容纳 index 位
    private void ensureCapacity(int index) {
        if (index >= size) {
            int newSize = Math.max(size * 2, index + 1);
            int oldLength = data.length;
            int newLength = (newSize + 63) / 64;
            long[] newData = new long[newLength];
            System.arraycopy(data, 0, newData, 0, oldLength);
            data = newData;
            size = newSize;
        }
    }

    public void set(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        ensureCapacity(index);
        int wordIndex = index / 64;
        int bitIndex = index % 64;
        data[wordIndex] |= (1L << bitIndex);
    }

    public void clear(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index >= size) return; // 超出当前范围，无需清除
        int wordIndex = index / 64;
        int bitIndex = index % 64;
        data[wordIndex] &= ~(1L << bitIndex);
    }

    public boolean get(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index >= size) return false; // 超出范围默认为 0
        int wordIndex = index / 64;
        int bitIndex = index % 64;
        return (data[wordIndex] & (1L << bitIndex)) != 0;
    }

    public int size() {
        return size;
    }

    // 可选：打印内部状态（用于调试）
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(get(i) ? '1' : '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // 初始化Bitmap，预设能存0~1000的数（测试几十亿级别只需调整初始化容量）
        Bitmap3 bitmap = new Bitmap3(1000);

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
