package com.qf.baseframework;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public interface URl {
    public static String HOST = "http://172.22.35.164";

    public static String PORT = "8060";

    public static String BASE_URL = HOST + ":" + PORT;

    // zhang tao
    public static String LOGIN_URL = BASE_URL + "/ams/auth/login";

    public static String FISH_DISEASE = BASE_URL + "/ams/health/morbidity?";

    public static String FISH_DISEASE_REPORT = BASE_URL
            + "/ams/health/morbidity?{\"pageCurrent\":1,\"pageSize\":10}";

    public static String KNOWLEDGE_BASE = BASE_URL + "/ams/recircle/sensorType/threshold";

    // liu
    public static String FISHPOND = BASE_URL
            + "/ams/device/stip/fishpond/realTime";

    public static String FISHFEED = BASE_URL + "/ams/recircle/line/environment";

    public static String DATADESC = BASE_URL
            + "/ams/device/stip/fishpond/realTime";

    public static String DATACHART = BASE_URL
            + "/ams/device/stip/fishpond/list";

    public static String GETMAXANDMIN = BASE_URL
            + "/ams/recircle/sensorType/threshold";

    // 设备类型
    public static String DEVICETYPE = BASE_URL + "/ams/device/deviceType/items";

    // 设备名称
    public static String DEVICENAME = BASE_URL + "/ams/device/register/items";

    // 设备报修
    public static String DEVICEFIX = BASE_URL + "/ams/device/maintain";

    // 李阳
    public static String HAND_FEEDING_LOG = BASE_URL + "/ams/feed/feedMeal";

    public static String FISHPOND_REF_FISHKIIND = BASE_URL
            + "/ams/sys/fishpondFish";

    public static String DAILY_MEAL = BASE_URL + "/ams/feed/dailyMeal";

    public static String BAIT_PURCHASE = BASE_URL
            + "/ams/feed/baitPurchase/items";

    // liuzhenyu
    public static String FEEDING_STRING = BASE_URL + "/ams/sys/fishpond/id";

    public static String RUN_LOG = BASE_URL + "/ams/sys/log";

    public static String COUNT_CHANGE = BASE_URL + "/ams/breed/amend/count";

    public static String WEIGHT_CHANGE = BASE_URL + "/ams/breed/amend/weight";

    public static String NOW_WEIGHT_CHANGE = BASE_URL
            + "/ams/breed/breedFish/avgWeight";

    public static String NOW_COUNT_CHANGE = BASE_URL
            + "/ams/breed/breedFish/count";

    public static String ADD_WEIGHT_CHANGE = BASE_URL
            + "/ams/breed/amend/weight";

    public static String DEVICE_FIX = BASE_URL + "/ams/device/maintain";

    // lin
    public static String QUEUE_QUERY = BASE_URL + "/ams/feed/lineDetail";

    public static String GROUP_QUERY = BASE_URL + "/ams/feed/group/detail";

    public static String FEED_QUERY = BASE_URL + "/ams/feed/group";

    public static String STRATEGY_QUERY = BASE_URL + "/ams/feed/group/strategy";

    public static String PERCENT_QUERY = BASE_URL + "/ams/feed/group/planMeal";

    public static String LOG_QUEUE = BASE_URL + "/ams/breed/log";

    public static String LOG_WORKSHOP = BASE_URL + "/ams/sys/workshop/items";

    public static String LOG_FISHPOND = BASE_URL + "/ams/sys/fishpond/items";

    // public static String LOG_ADD = BASE_URL + "/ams/breed/log ";

    // JIANZAO
    public static String FISH_POND_LIST = BASE_URL + "/ams/sys/fishpond/items";

    public static String WORK_SHOP_LIST = BASE_URL + "/ams/sys/workshop/items"; // http://localhost:8060/ams/sys/fishpond/workshop/items

    public static String FISH_HEALTH = BASE_URL + "/ams/health/morbidity";

    public static String FISH_POND_SYMPTOM = BASE_URL + "/ams/health/symptom";

    // Wenju
    public static String DEVICE_INFO = BASE_URL + "/ams/device/control";

    public static String DEVICE = BASE_URL + "/ams/device";

    public static String DEVICE_RECYCLE_LINE = BASE_URL + "/ams/recircle/line";

    public static String WHOST = "http://172.22.35.164";
    public static String WPORT = "8050";
    public static String WEB_BASEURL = WHOST + ":" + WPORT;
    public static String WEBURL = WEB_BASEURL
            + "/ams/html/RecircleMonitorMobile.html?";

}
