package com.example.demo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @param $
 * @author liuyong
 * @ClassName testDate
 * @Descrrption TODO
 * @return $
 * @date $ $
 */
public class testDate {

    public static int Guid=100;

    @Test
    public void testDate(){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmssSSS" );
        Date d= new Date();
        String str = sdf.format(d);
        str = 'c' + str + Guid++;

        System.out.println(str);
    }
}
