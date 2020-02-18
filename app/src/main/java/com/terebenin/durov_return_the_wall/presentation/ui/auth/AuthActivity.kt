package com.terebenin.durov_return_the_wall.presentation.ui.auth

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.terebenin.durov_return_the_wall.R
import com.terebenin.durov_return_the_wall.data.datasource.local.Constants.APP_ID
import com.terebenin.durov_return_the_wall.databinding.ActivityAuthBinding
import com.terebenin.durov_return_the_wall.presentation.mvvm.auth.AuthViewModel

class AuthActivity : AppCompatActivity() {

    private val REDIRECT_URI = "https://oauth.vk.com/blank.html"
    private val AUTHORIZE_URI = "https://oauth.vk.com/authorize"
    private val SCOPE = "friends"
    private val API_VERSION = "5.103"
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)

        val viewModel: AuthViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view?.loadUrl(request?.url.toString())
                    Log.d("TAG_URL", request?.url.toString())
                }
                return false

            }
        }

        val webSettings = binding.webView.settings

        setWebSettings(webSettings)

        clearWebViewBeforeLoading(binding)

        binding.webView.loadUrl("${AUTHORIZE_URI}?client_id=${APP_ID}&display=page&redirect_uri=${REDIRECT_URI}&scope={$SCOPE}&response_type=code&v=${API_VERSION}")

        binding.executePendingBindings()
    }

    private fun clearWebViewBeforeLoading(binding: ActivityAuthBinding) {
        binding.webView.clearHistory()
        binding.webView.clearFormData()
        binding.webView.clearCache(true)
    }

    private fun setWebSettings(webSettings: WebSettings) {
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webSettings.domStorageEnabled = true
        webSettings.javaScriptEnabled = true
        webSettings.setSupportZoom(true)
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
    }
}