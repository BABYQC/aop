package com.example.aop.demo;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

/**
 * @Author: chang qi
 * @Date: 2024/12/24
 */
public class IdDemo {
    private static final long WORKER_ID_BITS = 5L;
    // 最大支持机器节点数0~31，一共32个
    @SuppressWarnings({"PointlessBitwiseExpression", "FieldCanBeLocal"})
    private static final long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);
    private static final long DATA_CENTER_ID_BITS = 5L;
    private static final long MAX_DATA_CENTER_ID = -1L ^ (-1L << DATA_CENTER_ID_BITS);
    public static void main(String[] args) {

        long workCenterId = IdUtil.getDataCenterId(MAX_DATA_CENTER_ID);
        System.out.println(workCenterId);

    }

    /**
     * 取mac地址的后两个字节，一个字节是8位，两个字节16位
     * 其中最后一个字节在前面，倒数第二个字节在后面
     * 最后右移6位，对剩余的0位mod maxDatacenterId
     *
     * eg: mac地址：0E:EE:10:F7:5A:9F
     * 这里只用到5A（0101 1010）和9F（1001 1111）
     * 先组合起来变为9F 5A: 1001 1111  0101 1010
     * 右移6位：0010 0111 1101 = 637
     * id = 40794 % (maxDatacenterId + 1)
     *
     *
     * @param maxDatacenterId
     * @return
     */
    public static long getDataCenterId(long maxDatacenterId) {
        long id = 1L;
        final byte[] mac = NetUtil.getLocalHardwareAddress();
        if (null != mac) {
            id = ((0x000000FF & (long) mac[mac.length - 2])
                    | (0x0000FF00 & (((long) mac[mac.length - 1]) << 8))) >> 6;
            id = id % (maxDatacenterId + 1);
        }

        return id;
    }
}
