package com.lucio.appframework;

/**
 * App常用公共常量
 */

public class AppConstant {

    //是否在在调试状态:用于控制log、服务器环境等
    public static boolean isDebug = true;

    //测试环境服务器
    private static String DEBUG_HOST = "http://healthsleep.onethird.com.cn/";

    //正式环境服务器
    private static String RELEASE_HOST = "http://healthsleep.onethird.com.cn/";

    //获取当前使用的服务器地址
    public static String getHost() {
        return isDebug ? DEBUG_HOST : RELEASE_HOST;
    }
}
