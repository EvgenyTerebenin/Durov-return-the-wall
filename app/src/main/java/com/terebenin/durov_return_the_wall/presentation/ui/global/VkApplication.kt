package com.terebenin.durov_return_the_wall.presentation.ui.global

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.terebenin.durov_return_the_wall.BuildConfig
import com.terebenin.durov_return_the_wall.data.datasource.storage.Prefs
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class VkApplication : Application() {

    companion object {
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
    }

    private fun initSharedPreferences() {
        prefs = Prefs(context, gson)
    }

    private fun initGson() {
        gson = GsonBuilder()
            .create()
    }
}