package com.rs.waterLevelIndicator.utils;

public class Constans {
    public static final String sqlTotla = "select count(*) as total from ";

    public static String mWhichDevIsSelected = "";

    public static String DEFAULT_SELECTED_DEV = "1";

    public static String WATER_UP_WARRNING = "水位上限报警";

    public static String WATER_DOWN_WARRNING= "水位下限报警";

    public static String SETTING_HIGH= "安装高度";

    public static String CMD_DEFAULT = "02";

    public static String CMD_HIGH = "02";

    public static String CMD_HIGH_LIMIT = "03";

    public static String CMD_DOWN_LIMIT = "04";

    public static String SET_HIGH_MSG = "head,01,devid"+DEFAULT_SELECTED_DEV+"cmd,"+CMD_HIGH;

    public static String SET_HIGHLIMIT_MSG = "head,01,devid"+DEFAULT_SELECTED_DEV+"cmd,"+CMD_HIGH_LIMIT;

    public static String SET_DOWNLIMIT_MSG = "head,01,devid"+DEFAULT_SELECTED_DEV+"cmd,"+CMD_DOWN_LIMIT;



    public static String HEAD_SERVER = "01";

    public static String HEAD_CLIENT = "02";

}
