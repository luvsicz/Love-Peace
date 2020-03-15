package com.rechar.campusassistant.app;


import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyManager {
    private static final  String TAG="VolleyManager";
    private static VolleyManager instance;
    private RequestQueue requestQueue;

    public static VolleyManager createInstance(Context context){
        Log.e(TAG, "createInstance: " );
        if(context!=null){
            if(instance==null){
                instance = new VolleyManager(context);
            }
        }else{
            throw new IllegalArgumentException("Context must be set");
        }

        return instance;
    }

    private VolleyManager(Context context) {
        Log.e(TAG, "VolleyManager: "+context.toString() );
        requestQueue = Volley.newRequestQueue(context);
    }

    public RequestQueue getRequestQueue(){
        Log.e(TAG, "getRequestQueue: " );
        return requestQueue;
    }
}
