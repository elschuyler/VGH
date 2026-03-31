package com.vianai.greenhouse
import android.webkit.WebView
import androidx.collection.LruCache

class PaneManager {
    private val webViewCache = LruCache<String, WebView>(3)
    private var activePaneId: String? = null
    fun registerWebView(paneId: String, webView: WebView) {
        webViewCache.put(paneId, webView)
    }
    fun unregisterWebView(paneId: String) {
        webViewCache.remove(paneId)
    }
    fun onResume(paneId: String) {
        activePaneId?.let { webViewCache.get(it)?.onPause() }
        webViewCache.get(paneId)?.onResume()
        activePaneId = paneId
    }
    fun onPauseInactive(currentActive: VghPane) {
        VghPane.values().forEach { pane ->
            if (pane != currentActive) {
                webViewCache.get(pane.name.lowercase())?.onPause()
            }
        }
    }
    fun destroyUnderPressure() {
        webViewCache.get("research")?.destroy()
        webViewCache.remove("research")
    }
    fun getWebView(paneId: String): WebView? = webViewCache.get(paneId)
}
