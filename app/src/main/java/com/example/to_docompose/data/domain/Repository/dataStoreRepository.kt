package com.example.to_docompose.data.domain.Repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class dataStoreRepository @Inject constructor(
    @ApplicationContext val context: Context
) {
//    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFENCES_NAME)

}