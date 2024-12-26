package com.example.aop.demo;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @Author: chang qi
 * @Date: 2024/12/26
 */
public class DateDemo {

    public static void main(String[] args) {
        Date date = new Date(1734229483000L);
        Date lastNumberWeekday = getLastOffsetWeekday(date, 3);
        System.out.println(lastNumberWeekday);
        System.out.println(DateUtil.isSameDay(new Date(), lastNumberWeekday));
    }

    /**
     * 获取当前月倒数第 #{lastNumber} 个工作日
     *
     * @param date 当天日期时间
     * @param lastNumber 倒数第几个工作日，取值范围从1开始
     * @return
     */
    public static Date getLastOffsetWeekday(Date date, int lastNumber) {
        Date lastOffsetWeekDay = DateUtil.endOfMonth(date);

        for (int i = 0; i < lastNumber - 1; i++) {
            // 移动到工作日
            lastOffsetWeekDay = getBeforeWeekday(lastOffsetWeekDay);

            lastOffsetWeekDay = DateUtil.offsetDay(lastOffsetWeekDay, -1);
        }

        return DateUtil.beginOfDay(getBeforeWeekday(lastOffsetWeekDay));
    }

    /**
     * 比如今天26号是周日，那么获取26之前的最近的工作日，也就是周五24号
     *
     * @param date
     * @return
     */
    private static Date getBeforeWeekday(Date date) {
        while (DateUtil.isWeekend(date)) {
            date = DateUtil.offsetDay(date, -1);
        }
        return date;
    }
    public static Date getLastOffsetWeekdayOfMonth(Date date, int offset) {
        Date lastOffsetWeekDay = DateUtil.endOfMonth(date);
        int i = 0;
        while (i < offset) {
            if (!DateUtil.isWeekend(lastOffsetWeekDay)) {
                // 如果偏移i个工作日，偏移0天就是最后一个工作日，偏移1天就是倒数第二个工作日
                ++i;
            }
            if (i >= offset) break;
            lastOffsetWeekDay = DateUtil.offsetDay(lastOffsetWeekDay, -1);
        }

        return DateUtil.beginOfDay(lastOffsetWeekDay);
    }

}
