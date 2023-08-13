package com.example.to_docompose.data.domain.Repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import com.example.to_docompose.util.Constants.PREFENCES_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.prefs.Preferences
import javax.inject.Inject


class dataStoreRepository @Inject constructor(
    @ApplicationContext val context: Context
) {
//    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFENCES_NAME)

}