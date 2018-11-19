package ru.lopav.app.getwerunfest.web

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.web.*
import ru.lopav.app.getwerunfest.FreeTradingApp
import ru.lopav.app.getwerunfest.R
import ru.lopav.app.getwerunfest.utils.Features

class WebViewActivity: AppCompatActivity() {

    var currentUrl: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web)
        currentUrl = intent.getStringExtra(KEY_URL)
        initWebView()
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = true
            load()
        }
    }

    private fun initWebView() {
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
                currentUrl = url
                return false
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                swipeRefresh.isRefreshing = false
            }
        }
        webView.clearCache(true)
        webView.clearHistory()
        webView.setInitialScale(1)
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        webView.isScrollbarFadingEnabled = false
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        load()
    }

    private fun load() {
        webView.loadUrl(currentUrl)
    }

    companion object {
        const val KEY_URL = "url"
    }
}
