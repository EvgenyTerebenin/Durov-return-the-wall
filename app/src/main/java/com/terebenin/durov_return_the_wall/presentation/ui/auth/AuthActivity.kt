package com.terebenin.durov_return_the_wall.presentation.ui.auth

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.terebenin.durov_return_the_wall.R
import com.terebenin.durov_return_the_wall.data.AccessToken
import com.terebenin.durov_return_the_wall.databinding.ActivityAuthBinding
import com.terebenin.durov_return_the_wall.presentation.mvvm.auth.AuthViewModel
import com.terebenin.durov_return_the_wall.presentation.ui.global.VkApplication.Companion.prefs
import com.terebenin.durov_return_the_wall.presentation.ui.main.MainActivity

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
        binding.lifecycleOwner = this
        val viewModel: AuthViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.authViewModel = viewModel
        observeViewModelChanges()
        setupWebView()
        binding.webView.loadUrl(viewModel.authUrl)
        binding.executePendingBindings()
    }

    private fun setupWebView() {
        setWebViewClient()
        setWebSettings(binding.webView.settings)
        clearWebViewBeforeLoading(binding)
    }

    private fun setWebViewClient() {
        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val stringUrl = request?.url.toString()
                    view?.loadUrl(stringUrl)
                    if (stringUrl.contains("access_token")) {
                        binding.authViewModel?.setAccessToken(stringUrl)
                    }
                }
                return false

            }
        }
    }

    private fun observeViewModelChanges() {
        binding.authViewModel?.accessToken?.observe(this, Observer {
            saveAccessTokenToPrefs(it)
            intent = Intent(this@AuthActivity, MainActivity::class.java)
            startActivity(intent)
        })
    }

    private fun saveAccessTokenToPrefs(it: AccessToken) {
        prefs.accessToken = it
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