package app.flix.free;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.app.Activity;
import android.content.SharedPreferences;
import android.webkit.WebViewClient;
import android.content.ClipData;
import android.content.ClipboardManager;
import org.jsoup.*;
import com.eyalbira.loadingdots.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import org.apache.commons.codec.net.URLCodec;
import org.jsoup.*;
import org.jsoup.nodes.*;

public class AnimeWatchActivity extends  AppCompatActivity  { 
	
	
	private HashMap<String, Object> map = new HashMap<>();
	private String url = "";
	
	private LinearLayout linear1;
	private ProgressBar progressbar1;
	private WebView webview1;
	
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private SharedPreferences ff;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.anime_watch);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		req = new RequestNetwork(this);
		ff = getSharedPreferences("ff", Activity.MODE_PRIVATE);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				if (!_url.contains("/player/?")) {
					finish();
				}
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				webview1.setVisibility(View.VISIBLE);
				progressbar1.setVisibility(View.GONE);
				super.onPageFinished(_param1, _param2);
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try {
					
					final Document d = Jsoup.parse(_response);
					String u = "https:" + d.getElementsByAttributeValue("class","video-content").first().child(0).select("iframe").attr("src");
					webview1.loadUrl(u);
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", u));
				} catch(Exception e) {
					SketchwareUtil.showMessage(getApplicationContext(), "Unable to load video!");
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", getIntent().getStringExtra("link")));
		map = new HashMap<>();
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
		req.setHeaders(map);
		req.startRequestNetwork(RequestNetworkController.GET, getIntent().getStringExtra("link"), "new", _req_request_listener);
		hideSystemUI();		
		
		
		}
			
			@Override
			public void onWindowFocusChanged(boolean hasFocus) {
						super.onWindowFocusChanged(hasFocus);
						if (hasFocus) {
									hideSystemUI();
						}
	}
		private void hideSystemUI() {
						// Enables regular immersive mode.
						// For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
						// Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
						View decorView = getWindow().getDecorView();
						decorView.setSystemUiVisibility(
						View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
						// Set the content to appear under the system bars so that the
						// content doesn't resize when the system bars hide and show.
						| View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
						// Hide the nav bar and status bar
						| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_FULLSCREEN);
			}
			
			// Shows the system bars by removing all the flags
			// except for the ones that make the content appear under the system bars.
			private void showSystemUI() {
						View decorView = getWindow().getDecorView();
						decorView.setSystemUiVisibility(
						View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
			}
			{
				
				
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		webview1.setDownloadListener(new DownloadListener() {
				public void onDownloadStart(String _url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
						
				url = _url;
				if(mimetype.contains("video")){
					_start();
				}
				}
		});
		
	}
	public String _s (final String _s) {
				
				return (_s.substring((int)(1), (int)(_s.length() - 1)));
		}
		
		
		public String _fix (final String _s) {
				return (_s.replaceFirst("\u003C", ""));
			
	}
	public void _start () {
		ff.edit().putString(getIntent().getStringExtra("name"), getIntent().getStringExtra("image")).commit();
		InfoActivity a = new InfoActivity();
		
		a.startDownload(url, getIntent().getStringExtra("name"), "mp4");
		SketchwareUtil.CustomToast(getApplicationContext(), "Downloading...", 0xFFFFFFFF, 18, 0xFFF44336, 56, SketchwareUtil.BOTTOM);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}