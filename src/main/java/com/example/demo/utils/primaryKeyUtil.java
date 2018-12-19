package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @param $
 * @author liuyong
 * @ClassName primaryKeyUtil
 * @Descrrption TODO
 * @return $
 * @date 20181207$ 1046$
 */
public class primaryKeyUtil {

    public static int Guid=100;

    public static String makePrimaryKey(){

        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmssSSS" );
        Date d= new Date();
        String str = sdf.format(d);
        str = 'c' + str + Guid++;

        return str;
    }
}
