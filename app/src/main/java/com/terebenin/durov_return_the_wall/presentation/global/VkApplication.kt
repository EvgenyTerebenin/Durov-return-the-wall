package com.terebenin.durov_return_the_wall.presentation.global

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.threetenabp.AndroidThreeTen
import com.terebenin.durov_return_the_wall.data.datasource.storage.Prefs
import com.terebenin.durov_return_the_wall.di.AppComponent
import com.terebenin.durov_return_the_wall.di.DaggerAppComponent

class VkApplication : Application() {

    companion object {
        val appComponent: AppComponent = DaggerAppComponent.create()
        private lateinit var context: Context
        lateinit var gson: Gson
        lateinit var prefs: Prefs

        fun setContext(con: Context) {
            context = con
        }
    }

    override fun onCreate() {
        super.onCreate()
        setContext(this)
        initGson()
        initSharedPreferences()
        initAndroidThreeTen()
    }

    private fun initAndroidThreeTen() {
        AndroidThreeTen.init(this)
    }

    private fun initSharedPreferences() {
        prefs = Prefs(context, gson)
    }

    private fun initGson() {
        gson = GsonBuilder()
            .create()
    }
}