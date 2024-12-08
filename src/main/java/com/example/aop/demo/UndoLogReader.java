package com.example.aop.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

/**
 * undo log 读取
 *
 * @author chang qi
 * @date 2024/12/7
 */
public class UndoLogReader {
    public static void main(String[] args) {
        byte[] undologBytes;
        String cloudFileIbd = "cloud_file.ibd";
        byte[] page = new byte[16 * 1024];
        try (InputStream is = UndoLogReader.class.getClassLoader().getResourceAsStream("static/cloud_file.ibd")){
            if (is == null) {
                return;
            }
//            is.read(page);

//            65664 65686      65687      65699 65718     65730 65748     65749
            undologBytes = is.readAllBytes();
//            String.format("%8s", Integer.toBinaryString(undologBytes[65690] & 0xFF).replace(' ', '0');
//            new String(undologBytes, 65221, 10000, Charset.forName("utf-8"))
//            new String(undologBytes, 100009, 1000, Charset.forName("utf-8"));
//            14
//            new String(undologBytes, 100045, 1000, Charset.forName("utf-8"));
//            36
//            new String(undologBytes, 100081, 1000, Charset.forName("utf-8"))
            System.out.println();
        } catch (IOException e) {

        }
    }
}
