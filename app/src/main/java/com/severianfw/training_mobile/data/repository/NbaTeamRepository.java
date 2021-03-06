package com.severianfw.training_mobile.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.severianfw.training_mobile.data.local.NbaTeamDao;
import com.severianfw.training_mobile.data.local.NbaTeamRoomDatabase;
import com.severianfw.training_mobile.data.remote.NbaTeamItem;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NbaTeamRepository {
    private final NbaTeamDao mNbaTeamDao;
    private final ExecutorService mExecutorService;

    public NbaTeamRepository(Application application) {
        mExecutorService = Executors.newSingleThreadExecutor();
        NbaTeamRoomDatabase db = NbaTeamRoomDatabase.getDatabase(application);
        mNbaTeamDao = db.mNbaTeamDao();
    }

    public LiveData<List<NbaTeamItem>> getNbaItems() {
        return mNbaTeamDao.getNbaTeams();
    }

    public void insert(final NbaTeamItem nbaTeamItem) {
        mExecutorService.execute(() -> mNbaTeamDao.insert(nbaTeamItem));
    }
}
