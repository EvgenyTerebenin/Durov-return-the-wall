package com.terebenin.durov_return_the_wall.data.datasource.storage

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.terebenin.durov_return_the_wall.data.AccessToken

class Prefs(
    private val context: Context,
    private val gson: Gson
) {
    private fun getSharedPreferences(prefsName: String) =
        context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    private val AUTH_DATA = "auth_data"
    private val ACCESS_TOKEN = "access_token"
    private val authPrefs by lazy { getSharedPreferences(AUTH_DATA) }

    private val accessTokenType = object : TypeToken<AccessToken>() {}.type

    var accessToken: AccessToken
        get() {
            return gson.fromJson(authPrefs.getString(ACCESS_TOKEN, ""), accessTokenType)
        }
        set(value) {
            authPrefs.edit().putString(ACCESS_TOKEN, gson.toJson(value)).apply()
        }


}
