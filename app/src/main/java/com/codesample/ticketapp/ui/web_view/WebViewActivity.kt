package com.codesample.ticketapp.ui.web_view

import android.annotation.SuppressLint
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.codesample.ticketapp.R
import com.codesample.ticketapp.base.BaseActivity
import com.codesample.ticketapp.constants.IntentKey
import com.codesample.ticketapp.databinding.ActivityWebViewBinding
import org.koin.android.ext.android.inject

class WebViewActivity : BaseActivity<ActivityWebViewBinding, WebViewViewModel>() {
    private val mViewModel : WebViewViewModel by inject()

    override fun getLayoutId(): Int {
        return R.layout.activity_web_view
    }

    override fun onCreated() {
        setupData()
        setupWebView()
    }

    private fun setupData() {
        mViewModel.link.value = intent.getStringExtra(IntentKey.LINK)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        mViewDataBinding.webView.settings.javaScriptEnabled = true
        mViewDataBinding.webView.settings.domStorageEnabled = true
        mViewDataBinding.webView.loadUrl(mViewModel.link.value ?: "")
        mViewDataBinding.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                mViewDataBinding.progressBar.visibility = View.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

                return true
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) { }
        }
    }
}