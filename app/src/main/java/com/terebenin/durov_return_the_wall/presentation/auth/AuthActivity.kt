package com.terebenin.durov_return_the_wall.presentation.auth

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.terebenin.durov_return_the_wall.R
import com.terebenin.durov_return_the_wall.databinding.ActivityAuthBinding
import com.terebenin.durov_return_the_wall.presentation.global.MainActivity

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private val ACCESS_TOKEN = "access_token"
    private val ERROR = "error"
    private val ERROR_DESCRIPTION = "error_description"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
        binding.lifecycleOwner = this
        val viewModel: AuthViewModel = ViewModelProvider(this).get(
            AuthViewModel::class.java)
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
                    view?.loadUrl(request?.url.toString())
                    binding.authViewModel?.currentUrl?.value = request?.url.toString()
                }
                return false

            }
        }
    }

    private fun observeViewModelChanges() {

        binding.authViewModel?.currentUrl?.observe(this, Observer {
            if (it.contains(ACCESS_TOKEN)) {
                binding.authViewModel?.setAccessToken(it)
            }
            if (it.contains(ERROR) || it.contains(ERROR_DESCRIPTION)) {
                binding.authViewModel?.setError(it)
            }
        })

        binding.authViewModel?.accessToken?.observe(this, Observer {
            intent = Intent(this@AuthActivity, MainActivity::class.java)
            startActivity(intent)
        })

        binding.authViewModel?.authError?.observe(this, Observer {
            Toast.makeText(this, "${it.error}: ${it.description}", Toast.LENGTH_SHORT).show()
        })
    }

    private fun clearWebViewBeforeLoading(binding: ActivityAuthBinding) {
        binding.webView.clearHistory()
        binding.webView.clearFormData()
        binding.webView.clearCache(true)
    }

    private fun setWebSettings(webSettings: WebSettings) {
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webSettings.domStorageEnabled = true
        webSettings.setSupportZoom(true)
        webSettings.javaScriptCanOpenWindowsAutomatically = true
    }
}