package com.diginori.nascape;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class ActMain extends Activity {
    private Context mContext;
    private WebView mWebView;
    private EditText mEtAddress;
    private Button mBtnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        this.mContext = this;

        mWebView = (WebView) findViewById(R.id.wv_act_main);
        mWebView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);

        mEtAddress = (EditText) findViewById(R.id.et_address_act_main);

        mBtnGo = (Button) findViewById(R.id.btn_go_act_main);
        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlStr = mEtAddress.getText().toString();

                if(urlStr.isEmpty()) {
                    urlStr = "digiNORI.com/4";
                }

                if (!urlStr.startsWith("http://")) {
                    urlStr = "http://" + urlStr;
                }
                mWebView.loadUrl(urlStr);
            }
        });
    }
}
