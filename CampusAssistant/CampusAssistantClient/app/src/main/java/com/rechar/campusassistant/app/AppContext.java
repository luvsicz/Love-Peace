package com.rechar.campusassistant.app;


public class AppContext {
    static final  String  ip ="liurechar.utools.club";
    public static final String HOST = "https://"+ip;
    //public static final String HOST = "http://192.168.157.1";
//    public static final String HOST = "http://192.168.10.101";
//    public static final String HOST = "http://172.26.92.1";
    public static final String WEBPROJECTNAME = "/MSCMS";
    public static final String URL_GETNEWS = HOST +WEBPROJECTNAME+ "/News" +
            "Servlet";
    public static final String URL_GETNEXTNEWS = HOST+WEBPROJECTNAME+"/getnextnews.action";
    public static final String URL_LOGIN = HOST+WEBPROJECTNAME+"/applogin.action";
    public static final String URL_REGISTER = HOST+WEBPROJECTNAME+"/appregister.action";
    public static final String URL_MODIFY_AVATAR = HOST+WEBPROJECTNAME+"/modifyavatar.action";
    public static final String URL_SUPPRESS_PIC = HOST+WEBPROJECTNAME+"/uploads/";
    public static final String URL_NEWS_DETAIL = HOST+WEBPROJECTNAME+"/getnewsdetail.action";
    public static final String URL_CACHE_NEWS = HOST+WEBPROJECTNAME+"/cachenews.action";
    public static final String PATH_PICCAHE = "sdcard/MSTF/PIC";
}
