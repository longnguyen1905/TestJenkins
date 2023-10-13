package constants;


import helpers.PropertiesHelper;

public class ConstantGlobal {
    static {
        if (PropertiesHelper.getValue("ENV").equals("live")){
            PropertiesHelper.loadLive();
        }else {
            PropertiesHelper.loadSat();
        }
    }

    public final static String BROWSER = PropertiesHelper.getValue("BROWSER");
    public final static boolean HEADLESS = Boolean.parseBoolean(PropertiesHelper.getValue("HEADLESS"));
    public final static String URL = PropertiesHelper.getValue("URL");
    public final static String USERNAME = PropertiesHelper.getValue("USERNAME");
    public final static String PASSWORD = PropertiesHelper.getValue("PASSWORD");
    public final static long STEP_TIME = Long.parseLong(PropertiesHelper.getValue("STEP_TIME"));
    public final static long EXPLICIT_TIMEOUT = Long.parseLong(PropertiesHelper.getValue("EXPLICIT_TIMEOUT"));
    public final static long PAGE_LOAD_TIMEOUT = Long.parseLong(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"));
    public final static String ENV = PropertiesHelper.getValue("ENV");
    public final static String SCREENSHOT_FAIL = PropertiesHelper.getValue("SCREENSHOT_FAIL");
    public final static String SCREENSHOT_PASS = PropertiesHelper.getValue("SCREENSHOT_PASS");
    public final static String SCREENSHOT_STEP = PropertiesHelper.getValue("SCREENSHOT_STEP");
    public final static String RECORD_VIDEO = PropertiesHelper.getValue("RECORD_VIDEO");
    public final static String RECORD_VIDEO_PATH = PropertiesHelper.getValue("RECORD_VIDEO_PATH");
    public final static String EXTENT_REPORT_PATH = PropertiesHelper.getValue("EXTENT_REPORT_PATH");

    public final static String URL_TOURNAMENT = PropertiesHelper.getValue("URL_TOURNAMENT");
    public final static String URL_TERM_AND_CONDITION = PropertiesHelper.getValue("URL_TERMS_AND_CONDITION");
    public final static String URL_RESULTS = PropertiesHelper.getValue("URL_RESULTS");
    public final static String URL_UPCOMING = PropertiesHelper.getValue("URL_UPCOMING");
    public final static String URL_EARN = PropertiesHelper.getValue("URL_EARN");
    public final static String URL_TELEGRAM = PropertiesHelper.getValue("URL_TELEGRAM");
    public final static String URL_PROFILE = PropertiesHelper.getValue("URL_PROFILE");
    public final static String URL_DEPOSIT = PropertiesHelper.getValue("URL_DEPOSIT");
    public final static String URL_SEARCH = PropertiesHelper.getValue("URL_SEARCH");
    public final static String URL_REFERRAL_TELE = PropertiesHelper.getValue("URL_REFERRAL_TELE");
    public final static String URL_REFERRAL_FB = PropertiesHelper.getValue("URL_REFERRAL_FB");
    public final static Boolean PROFILE = Boolean.parseBoolean(PropertiesHelper.getValue("PROFILE"));
    public final static String TON_ADDRESS = PropertiesHelper.getValue("TON_ADDRESS");
    public final static String URL_LOGGED = PropertiesHelper.getValue("URL_LOGGED");

}
