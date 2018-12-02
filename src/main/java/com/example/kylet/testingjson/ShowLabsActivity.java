package com.example.kylet.testingjson;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowLabsActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private static List<Lab> myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_labs);
        myData = new ArrayList<>();

        mRecyclerView = findViewById(R.id.my_recycler_view);

        mRecyclerView.hasFixedSize();

        mAdapter = new MyAdapter(myData);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);


        context = getApplicationContext();

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://online.labstats.com/api/public/GetPublicApiData/1005", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray array = response.getJSONArray("Groups");
                            for (int x = 0; x < array.length(); x++) {
                                JSONObject group = array.getJSONObject(x);
                                int available = group.getInt("Available");
                                int total = group.getInt("Total");
                                int labId = group.getInt("Id");
                                String name = group.getString("Label");

                                Lab lab = new Lab(available, total, labId, name);
                                myData.add(lab);
                            }
                            mAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
                ){
                public Map<String, String> getHeaders() throws AuthFailureError{
                    Map<String, String> params = new HashMap<>();
                    params.put("Authorization", "314b4b80-96f4-4e4c-a061-2b0e5870400b");
                    params.put("Content-Type", "application/json");
                    params.put("cache-control", "no-cache");
                    return params;
                }
        };

        requestQueue.add(jsonObjectRequest);
        String test = myData.toString();
        test.charAt(1);
    }
}

