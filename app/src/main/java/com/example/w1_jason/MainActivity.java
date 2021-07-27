package com.example.w1_jason;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public TextView mtextview, expview;
    public RequestQueue mq;
    Button b;
//    Initizer ol = new Initizer();
    int i = 0;
    int j = 0;
    int x = 0;
    int y = 0;

    void resetter() {
        i++;
        j = 0;
    }

    void resetter2() {
        x++;
        y = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextview = (TextView) findViewById(R.id.optu);
        b = (Button) findViewById(R.id.bitu);
        expview = (TextView) findViewById(R.id.expu);

        mq = Volley.newRequestQueue(getApplicationContext());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//                ol.omier();
                jsonparse(i, j);
                j++;
//                System.out.println("zzzzzzzzzzzzzzzzzzzzz");
                exclparse(x, y);
                y++;
//                exclparse(0,1);
//                exclparse(1,0);
//                exclparse(1,1);
//                exclparse(2,0);
//                exclparse(2,1);
//                System.out.println("zzzzzzzzzzzzzzzzzzzzz");
            }
        });
    }

    void jsonparse(int i, int j) {
        String url = "https://my-json-server.typicode.com/ricky1550/pariksha/db";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("facilities");
                    JSONObject jolu = jsonArray.getJSONObject(i);
                    String ola = jolu.getString("name");
                    JSONArray joa = jolu.getJSONArray("options");
                    JSONObject facilityitem = joa.getJSONObject(j);
//                    for (int i=0; i<jsonArray.length(); i++){
//                        JSONObject facilityitem=jsonArray.getJSONObject(i);

                    String firstname = facilityitem.getString("name");
                    String icon = facilityitem.getString("icon");
                    int id = facilityitem.getInt("id");
//                        int id=facilityitem.getInt("facility_id");

                    //append +","+icon+","+ String.valueOf(id) +".\n"
                    mtextview.setText(ola + " " + firstname + " " + icon + " " + Integer.toString(id));
                    //Toast.makeText(MainActivity.this, firstname+","+icon+","+String.valueOf(id)+".\n", Toast.LENGTH_SHORT).show();
//                    }
                } catch (JSONException e) {
                    if (j == 0) {
                        mtextview.setText("I am Done");
                    }
                    e.printStackTrace();
                    resetter();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mq.add(request);
    }

    void exclparse(int x, int y) {
        String url = "https://my-json-server.typicode.com/ricky1550/pariksha/db";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                int p = 0;
//                int x = 0;
//                int y = 0;
//                while (x>=0){
//                    while (y>=0){
                try {
                    JSONArray jsonArray = response.getJSONArray("exclusions");
                    JSONArray jolu = jsonArray.getJSONArray(x);
                    JSONObject joma = jolu.getJSONObject(y);
                    String facu = joma.getString("facility_id");
                    String optu = joma.getString("options_id");
                    expview.setText(facu + " " + optu);
                    System.out.println(joma);
//                            break;
//                            y++;
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (y == 0) {
                        expview.setText("I am Done");
                    }
                    resetter2();
//                            if(x>2){
//                                p = 1;
//                                break;
//                            }

                }
            }
//                    x++;
//                    if(p>0){
//                        break;
//                    }
//                }
//
//            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mq.add(request);
    }

//}

//    AllOther jsonparse2(int i, int j) {
//        AllOther lg = new AllOther();
//        String url = "https://my-json-server.typicode.com/ricky1550/pariksha/db";
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray jsonArray = response.getJSONArray("facilities");
//                    JSONObject jolu = jsonArray.getJSONObject(i);
//                    String ola = jolu.getString("name");
//                    JSONArray joa = jolu.getJSONArray("options");
//                    JSONObject facilityitem = joa.getJSONObject(j);
////                    for (int i=0; i<jsonArray.length(); i++){
////                        JSONObject facilityitem=jsonArray.getJSONObject(i);
//
//                    String firstname = facilityitem.getString("name");
//                    String icon = facilityitem.getString("icon");
//                    int id = facilityitem.getInt("id");
//                    lg.setId(id);
//                    lg.setName(firstname);
//                    lg.setIcon(icon);
////                        int id=facilityitem.getInt("facility_id");
//
//                    //append +","+icon+","+ String.valueOf(id) +".\n"
////                    mtextview.setText(ola+" "+firstname+" "+icon+" "+Integer.toString(id));
//                    //Toast.makeText(MainActivity.this, firstname+","+icon+","+String.valueOf(id)+".\n", Toast.LENGTH_SHORT).show();
////                    }
//                } catch (JSONException e) {
//                    if (j == 0) {
//                        ol.hell();
////                        mtextview.setText("I am Done");
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
//        return lg;
//    }
}