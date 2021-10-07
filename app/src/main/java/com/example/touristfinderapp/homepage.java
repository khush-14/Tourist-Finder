package com.example.touristfinderapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homepage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homepage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //intialize recycler view
    RecyclerView recyclerView;
    List<modelClassApp> appList;

    public homepage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homepage.
     */
    // TODO: Rename and change types and number of parameters
    public static homepage newInstance(String param1, String param2) {
        homepage fragment = new homepage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_homepage, container, false);

        recyclerView = view.findViewById(R.id.ScrollView);

        appList = new ArrayList<>();

        //thus app list will store modelClassApp objects
        // this object will contain two thingd image and content
        appList.add(new modelClassApp(R.drawable.hotel, "Visit Our Assure hotel provide all luxury facility and Environment like home"));
        appList.add(new modelClassApp(R.drawable.trip, getString(R.string.tripTrends)));
        appList.add(new modelClassApp(R.drawable.offers, getString(R.string.offersTrends)));

        // when we intialize Recycler View then with the help of LinearLayoutManager we will define recycler view layout
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);

        // now make object of adapter class
        CustomAdapter adapter = new CustomAdapter(this.getActivity(),appList);
        recyclerView.setAdapter(adapter);
        return view;

    }
}