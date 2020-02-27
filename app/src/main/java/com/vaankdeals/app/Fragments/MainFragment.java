package com.vaankdeals.app.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.vaankdeals.app.Adapter.SwipeAdapter;
import com.vaankdeals.app.Model.DealItem;
import com.vaankdeals.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    ViewPager2 swipeViewPager;
    SwipeAdapter swipeAdapter;
    private RequestQueue mRequestQueue;
    List<Object> mDealList = new ArrayList<>();

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRequestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        parseJson();
        swipeViewPager = rootView.findViewById(R.id.swipeViewPager);
        swipeAdapter = new SwipeAdapter(getActivity(),mDealList);
        swipeViewPager.setAdapter(swipeAdapter);

        return rootView;
    }
    private void parseJson() {
        String url = "https://api.myjson.com/bins/8vqmc";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("server_response");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject ser = jsonArray.getJSONObject(i);
                                String deal_title = ser.getString("deal_title");
                                String deal_image = ser.getString("deal_image");

                                mDealList.add(new DealItem(deal_title, deal_image));
                            }
                            // Just call notifyDataSetChanged here

                            swipeAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }
}
