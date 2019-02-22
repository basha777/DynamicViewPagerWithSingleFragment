package d.xaro.dynamicviewpagerwithsinglefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleFragment extends Fragment {

    String title;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<String>  productsArrayList;
    public SingleFragment() {
        // Required empty public constructor
    }

    public static SingleFragment getInstance(String title) {
        SingleFragment singleFragment = new SingleFragment();
        singleFragment.title = title;
        return  singleFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        productsArrayList = new ArrayList<>();
        loadProductsArrayList();

        recyclerViewAdapter = new RecyclerViewAdapter(productsArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    private void loadProductsArrayList() {
    //filter based on title and load into arraylist
        if(title.equals("vegitables")){
            productsArrayList.add("veg");
            productsArrayList.add("veg");
            productsArrayList.add("veg");
        }else if(title.equals("soups")){
            productsArrayList.add("soups");
            productsArrayList.add("soups");
            productsArrayList.add("soups");
            productsArrayList.add("soups");
        }else if(title.equals("cars")){
            productsArrayList.add("car");
            productsArrayList.add("car");
            productsArrayList.add("car");
            productsArrayList.add("car");
            productsArrayList.add("car");
        }
    }

}
