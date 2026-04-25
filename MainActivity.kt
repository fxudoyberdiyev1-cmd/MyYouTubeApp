package com.example.myyoutubeapp

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // WebView яратамиз ва экранга чиқарамиз
        val webView = WebView(this)
        setContentView(webView)
        
        // YouTube яхши ишлаши учун созламалар
        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        
        // Ссилкалар илова ичида очилиши учун
        webView.webViewClient = WebViewClient()
        
        // YouTube сайтини юклаш
        webView.loadUrl("https://www.youtube.com")
    }

    // Телефондаги "Ортга" тугмаси босилганда сайтда орқага қайтиш
    override fun onBackPressed() {
        val webView = findViewById<WebView>(android.R.id.content).getChildAt(0) as? WebView
        if (webView?.canGoBack() == true) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
