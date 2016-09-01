package com.qf.baseframework.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;

public class NetworkUtil {

    public  static ConnectivityManager getConectivityManager(Context context){
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static  boolean isNetworkAvailable(Context context){
        if (context != null) {
            NetworkInfo activeNetworkInfo = getConectivityManager(context).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnectedOrConnecting();

            }

        }

        return  false;
    }

    public  static boolean isWifiNetwork(Context context){
        if (context != null) {
            NetworkInfo activeNetworkInfo = getConectivityManager(context).getNetworkInfo(ConnectivityManager.TYPE_WIFI);

            if (activeNetworkInfo != null){
                return  activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnectedOrConnecting();
            }
        }

        return  false;
    }

    public  static boolean isMobileNetwork(Context context){
        if (context != null) {

            NetworkInfo activeNetworkInfo = getConectivityManager(context).getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (activeNetworkInfo != null){
                return  activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnectedOrConnecting();
            }
        }

        return  false;
    }

    public  static boolean isMobileRoamNetwork(Context context){
        if (context != null) {
            NetworkInfo activeNetworkInfo = getConectivityManager(context).getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (activeNetworkInfo != null){
                return  activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnectedOrConnecting() && activeNetworkInfo.isRoaming();
            }
        }

        return  false;
    }

    public  static boolean isBluetoothAvailable(Context context){
        if (context != null) {
            NetworkInfo activeNetworkInfo = getConectivityManager(context).getNetworkInfo(ConnectivityManager.TYPE_BLUETOOTH);

            if (activeNetworkInfo != null){
                return  activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnectedOrConnecting() && activeNetworkInfo.isRoaming();
            }
        }

        return  false;
    }


    public  String GetNetworkType(Context context)//判断网络类型,省略
    {
        String strNetworkType = "";
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    strNetworkType = "WIFI";
                } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    String _strSubTypeName = networkInfo.getSubtypeName();

                    Log.e("cocos2d-x", "Network getSubtypeName : " + _strSubTypeName);

                    // TD-SCDMA  networkType is 17
                    int networkType = networkInfo.getSubtype();
                    switch (networkType) {
                        case TelephonyManager.NETWORK_TYPE_GPRS:
                        case TelephonyManager.NETWORK_TYPE_EDGE:
                        case TelephonyManager.NETWORK_TYPE_CDMA:
                        case TelephonyManager.NETWORK_TYPE_1xRTT:
                        case TelephonyManager.NETWORK_TYPE_IDEN: //api<8 : replace by 11
                            strNetworkType = "2G";
                            break;
                        case TelephonyManager.NETWORK_TYPE_UMTS:
                        case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        case TelephonyManager.NETWORK_TYPE_EVDO_A:
                        case TelephonyManager.NETWORK_TYPE_HSDPA:
                        case TelephonyManager.NETWORK_TYPE_HSUPA:
                        case TelephonyManager.NETWORK_TYPE_HSPA:
                        case TelephonyManager.NETWORK_TYPE_EVDO_B: //api<9 : replace by 14
                        case TelephonyManager.NETWORK_TYPE_EHRPD: //api<11 : replace by 12
                        case TelephonyManager.NETWORK_TYPE_HSPAP: //api<13 : replace by 15
                            strNetworkType = "3G";
                            break;
                        case TelephonyManager.NETWORK_TYPE_LTE:  //api<11 : replace by 13
                            strNetworkType = "4G";
                            break;
                        default:
                            // http://baike.baidu.com/item/TD-SCDMA 中国移动 联通 电信 三种3G制式
                            if (_strSubTypeName.equalsIgnoreCase("TD-SCDMA") || _strSubTypeName.equalsIgnoreCase("WCDMA") || _strSubTypeName.equalsIgnoreCase("CDMA2000")) {
                                strNetworkType = "3G";
                            } else {
                                strNetworkType = _strSubTypeName;
                            }

                            break;
                    }

                    Log.e("cocos2d-x", "Network getSubtype : " + Integer.valueOf(networkType).toString());
                }
            }

            Log.e("cocos2d-x", "Network Type : " + strNetworkType);

        }
        return strNetworkType;
    }

}