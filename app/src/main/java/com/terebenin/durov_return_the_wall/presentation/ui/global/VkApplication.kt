package com.terebenin.durov_return_the_wall.presentation.ui.global

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.terebenin.durov_return_the_wall.data.datasource.storage.Prefs

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
        gson = GsonBuilder()
            .create()
        prefs = Prefs(context, gson)
    }


}