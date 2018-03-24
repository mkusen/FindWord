package com.findword;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mkusen on 24.03.18..
 */

public class Modell extends Activity{

    private URL url;


    void GetWords(String letters) throws AuthFailureError{

        url = new URL();

        System.out.println(letters + " modell");

    RequestQueue requestQueue = Volley.newRequestQueue(this);
    StringRequest request;
    request = new StringRequest(Request.Method.POST, url.GETRESULT, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            System.out.println(response);
        }

    },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
            @Override
            protected Map<String, String> getParams()  {


                HashMap<String, String> hashMap = new HashMap<>();
               // hashMap.put();

                return hashMap;

            }


        };
        requestQueue.add(request);

    }


}


