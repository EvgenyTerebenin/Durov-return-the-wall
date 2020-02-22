package com.terebenin.durov_return_the_wall.presentation.ui.global

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class Application : Application() {

//    val prefs = Prefs(this, gson)

    companion object {
        lateinit var gson: Gson
        lateinit var accessToken: String
    }

    override fun onCreate() {
        super.onCreate()

        gson = GsonBuilder()
//            .registerTypeAdapter(BindableDate::class.java, GsonBindableDateAdapter())
//            .registerTypeAdapter(Uri::class.java, GsonUriAdapter())
            .create()

    }


}