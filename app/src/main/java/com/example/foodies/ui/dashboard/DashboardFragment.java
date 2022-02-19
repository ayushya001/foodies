package com.example.foodies.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodies.AyushAdapter;
import com.example.foodies.R;
import com.example.foodies.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DashboardFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    ListView mylist;
    String[]arr = {"Order History","My Rewards","Contact us","About us"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


        // find listview by id
        mylist = view.findViewById(R.id.l1);

        AyushAdapter ad = new AyushAdapter(getContext(),android.R.layout.simple_list_item_1, arr);
        mylist.setAdapter(ad);


        // set onclick listener on imageView
//        l1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "ImageView Clicked of Fragment 1", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }


    }