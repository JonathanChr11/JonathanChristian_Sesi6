package com.severianfw.training_mobile.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.severianfw.training_mobile.data.remote.NbaTeamItem;
import com.severianfw.training_mobile.data.repository.NbaTeamRepository;

import java.util.List;

public class OfflineViewModel extends ViewModel {
    private NbaTeamRepository mNbaTeamRepository;

    public OfflineViewModel(Application application) {
        mNbaTeamRepository = new NbaTeamRepository(application);
    }

    public LiveData<List<NbaTeamItem>> getOfflineData() {
        return mNbaTeamRepository.getNbaItems();
    }
}
