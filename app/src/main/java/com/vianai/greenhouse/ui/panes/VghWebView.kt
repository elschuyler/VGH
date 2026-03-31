package com.vianai.greenhouse.ui.panes
import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.vianai.greenhouse.PaneManager

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun VghWebView(url: String, paneId: String, paneManager: PaneManager) {
    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                cacheMode = WebSettings.LOAD_NO_CACHE
                loadWithOverviewMode = true
                useWideViewPort = false
            }
            paneManager.registerWebView(paneId, this)
            loadUrl(url)
        }
    }, update = { webView -> if (webView.url != url) webView.loadUrl(url) }, onRelease = { webView -> paneManager.unregisterWebView(paneId) })
}
