package com.noel201296gmail.cine_matic.Network;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by OMOSEFE NOEL OBASEKI on 04/05/2017.
 */
public class NetworkController {

    private RequestQueue mRequestQueue;
    private static Context mCtx;
    private static NetworkController mInstance;

    private NetworkController(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
        // This will Load Images from Network in Separate Thread

    }

    public static synchronized NetworkController getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new NetworkController(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}





