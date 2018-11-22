package com.laioffer.tinnews.profile;

import android.view.View;

public class ProfilePresenter implements ProfileContract.Presenter {


    private ProfileContract.View view;
    private ProfileContract.Model model;

    ProfilePresenter() {
        this.model = new ProfileModel();
        this.model.setPresenter(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(ProfileContract.View view) {
        this.view = view;
        this.view.setView();
    }


    @Override
    public void onViewDetached() {
        this.view = null;
    }

    //4.6
    @Override
    public void onCacheCleared() {
        if (view != null) {
            view.onCacheCleared();
        }
    }

    //4.6
    @Override
    public View.OnClickListener getCacheClearListener() {
        return view -> {
            model.deleteAllNewsCache();
        };
    }


    @Override
    public View.OnClickListener getOnCountryChangeListener(String country) {
        return view -> {
            model.setDefaultCountry(country);
        };
    }

}
