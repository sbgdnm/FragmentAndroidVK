package com.example.vkfragmentlike;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HorizontalScrollView horizontalScrollView;
    private LinearLayout linearLayout;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private final String KEY_HorizontalScrollView_STATE = "horizontalScrollViewState";
    private static Bundle mBundle;
    RecycleViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setVerticalScrollBarEnabled(false);

        recyclerView = view.findViewById(R.id.recycle_view);
        adapter = new RecycleViewAdapter(this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser)
            if(adapter != null) {
                //adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                adapter.checkData();
                adapter.notifyDataSetChanged();
                Log.d("HomeFragment", "Data is checked!");
            }
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//
//        // save RecyclerView state
//        mBundle = new Bundle();
//        Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
//        mBundle.putParcelable(KEY_HorizontalScrollView_STATE, listState);
//    }
//
    @Override
    public void onResume() {
        super.onResume();

        if(adapter != null) {
            //adapter.notifyItemRangeChanged(0, adapter.getItemCount());
            adapter.checkData();
            adapter.notifyDataSetChanged();
            Log.d("HomeFragment", "Data is checked!");
        }
    }

//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putIntArray("ARTICLE_SCROLL_POSITION",
//                new int[]{ horizontalScrollView.getScrollX(), horizontalScrollView.getScrollY()});
//    }
//
//    public void onViewStateRestored(Bundle savedInstanceState) {
//        super.onViewStateRestored(savedInstanceState);
//        final int[] position = savedInstanceState.getIntArray("ARTICLE_SCROLL_POSITION");
//        if(position != null)
//            horizontalScrollView.post(new Runnable() {
//                public void run() {
//                    horizontalScrollView.scrollTo(position[0], position[1]);
//                }
//            });
//    }
}
