    package com.example.w1_jason;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Initizer {

    List<AllOther> alist = new ArrayList<AllOther>();
    int i = 0;
    int j = 0;
    public RequestQueue mq;
    MainActivity oj = new MainActivity();

    void omier(){
        while(true){
            if(i==-1){
                break;
            }
//            alist.add(oj.jsonparse2(i,j));
            j++;
        }
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        System.out.println(alist);
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
//        AllOther op = new AllOther();
    }

    void resetter(){
        i++;
        j = 0;
    }

    void hell(){
        i = -1;
        j = -1;
    }

//    AllOther jsonparse(int i, int j) {
//        mq= Volley.newRequestQueue(getApplicationContext());
//        String url="https://my-json-server.typicode.com/ricky1550/pariksha/db";
//        AllOther ol = new AllOther();
//        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray jsonArray=response.getJSONArray("facilities");
//                    JSONObject jolu = jsonArray.getJSONObject(i);
////                    String ola = jolu.getString("name");
//                    JSONArray joa = jolu.getJSONArray("options");
//                    JSONObject facilityitem=joa.getJSONObject(j);
//                    String firstname=facilityitem.getString("name");
//                    String icon=facilityitem.getString("icon");
//                    int id=facilityitem.getInt("id");
//                    ol.setIcon(icon);
//                    ol.setName(firstname);
//                    ol.setId(id);
//
//                } catch (JSONException e) {
//                    if(j==0){
//                        hell();
//                    }
//                    e.printStackTrace();
//                    resetter();
//                }
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//        mq.add(request);
//        return ol;
//    }

}
