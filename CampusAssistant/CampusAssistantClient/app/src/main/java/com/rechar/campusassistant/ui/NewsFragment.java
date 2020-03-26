package com.rechar.campusassistant.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.rechar.campusassistant.R;

public class NewsFragment extends Fragment {

  private static final String TAG = "NewsFragment";
  private WebView webView;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.news_fragment, container, false);
    webView = view.findViewById(R.id.webView);
    webSetting();
    return view;
  }

  private void webSetting() {
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setAllowFileAccess(true);
    webView.getSettings().setSupportZoom(true);
    webView.getSettings().setBuiltInZoomControls(true);
    webView.loadUrl("http://baidu.com");
    webView.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.e(TAG, "shouldOverrideUrlLoading: ");
        view.loadUrl(url);
        return true;
      }
    });
    webView.canGoBack();
    webView.setOnKeyListener(new View.OnKeyListener() {

      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
            && event.getAction() == MotionEvent.ACTION_UP
            && webView.canGoBack()) {
          webView.goBack();
          return true;
        }
        return false;
      }
    });
  }

  @Override
  public void onDestroyView() {
    Log.e(TAG, "onDestroyView: ");
    if (webView != null) {
      //rootView is the inflated view of the fragment/activity
      ((ViewGroup) webView.getParent()).removeAllViews();
      webView.removeAllViews();
      super.onDestroyView();
    }
  }

  //销毁Webview
  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy: ");
    if (webView != null) {
      webView.destroy();
    }
    super.onDestroy();
  }
}
