package com.terebenin.durov_return_the_wall.presentation.mvvm.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.terebenin.durov_return_the_wall.BuildConfig.*
import com.terebenin.durov_return_the_wall.data.AccessToken
import com.terebenin.durov_return_the_wall.data.AuthError
import com.terebenin.durov_return_the_wall.presentation.ui.global.VkApplication

class AuthViewModel : ViewModel() {

    val accessToken = MutableLiveData<AccessToken>()
    val currentUrl = MutableLiveData<String>()
    val authError = MutableLiveData<AuthError>()

    val authUrl =
        AUTHORIZE_URI +
                "?client_id=${APP_ID}" +
                "&display=${DISPLAY_TYPE}" +
                "&redirect_uri=${REDIRECT_URI}" +
                "&scope=${SCOPE}" +
                "&response_type=${RESPONSE_TYPE}" +
                "&v=${API_VERSION}"

    fun setAccessToken(url: String) {
        val token = url
            .substringAfter("access_token=")
            .substringBefore("&")
        val expiresIn = url.substringAfter("&expires_in=")
            .substringBefore("&")
        val userId = url
            .substringAfter("user_id=")
        accessToken.value = AccessToken(token, expiresIn, userId)
        saveAccessTokenToPrefs(accessToken.value!!)
    }

    private fun saveAccessTokenToPrefs(it: AccessToken) {
        VkApplication.prefs.accessToken = it
    }

    fun setError(url: String) {
        val error = url
            .substringAfter("#error=")
            .substringBefore("&")
        val errorDescription = url.substringAfter("&error_description=").replace("+", " ")
        authError.value = AuthError(error, errorDescription)
    }
}