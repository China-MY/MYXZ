package com.myxz.common.utils;

/**
 * 处理并记录日志文件
 * 
 * @author myxz
 */
public class LogUtils
{
    public static String getBlock(Object msg)
    {
        if (msg == null)
        {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}
