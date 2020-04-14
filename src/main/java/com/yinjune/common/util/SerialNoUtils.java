package com.yinjune.common.util;

import com.yinjune.common.enums.SerialNoTypeEnum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class SerialNoUtils {
    private static long orderNum = 0L;
    private static String date;


    /**
     * 生成流水号 定长 22位
     *
     * @return
     */
    public static synchronized String generateSerialNo(SerialNoTypeEnum serialNoTypeEnum) {
        //17位时间标志
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        //加订单类型 加3位随机数 1-10
        int random=(new Random().nextInt()+1)*100;
        String serialNo = str + serialNoTypeEnum.getType() + random;
        return serialNo;
    }

}
