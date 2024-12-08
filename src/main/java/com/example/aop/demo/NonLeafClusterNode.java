package com.example.aop.demo;

import lombok.Data;

/**
 * @author chang qi
 * @date 2024/12/8
 */
@Data
public class NonLeafClusterNode {

    // 元数据, 以字节流的形式获取
    private byte[] rawData;

    // 可变字符串长度
    private int varFieldLen;

    //
    private int nullableFieldBitMap;

    private int infoFlags;

    private int numberOfRecordsOwned;

    private int order;

    private int recordType;

    // 下一条记录的偏移，当前记录 N + offset = nextRecord(记录部分)
    private int nextRecordOffset;
}
