package com.laioffer.tinnews.profile;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.common.ViewModelAdapter;
import com.laioffer.tinnews.mvp.MvpFragment;
import com.laioffer.tinnews.save.detail.TitleViewModel;

public class TinProfileFragment extends MvpFragment<ProfileContract.Presenter> implements ProfileContract.View {
    private ViewModelAdapter viewModelAdapter;

    public static TinProfileFragment newInstance() {
        TinProfileFragment fragment = new TinProfileFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tin_profile, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModelAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(viewModelAdapter);
        return view;
    }


    @Override
    public ProfileContract.Presenter getPresenter() {
        return new ProfilePresenter();
    }

    @Override
    public void setView() {
        if (!viewModelAdapter.isEmpty()) {
            return;
        }

        viewModelAdapter.addViewModel(new TitleViewModel(getString(R.string.setting), R.layout.setting_title_layout));

        //4.7
        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.clear_cache), presenter.getCacheClearListener()));
        //5.2
        viewModelAdapter.addViewModel(new TitleViewModel(getString(R.string.change_source), R.layout.setting_title_layout));
        //5.5
        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.us), presenter.getOnCountryChangeListener(getString(R.string.us))));
        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.de), presenter.getOnCountryChangeListener(getString(R.string.de))));
    }

    @Override
    public void onCacheCleared() {
        //4.7
        Toast.makeText(getContext(), "Cache has been cleared", Toast.LENGTH_SHORT).show();
    }


}
