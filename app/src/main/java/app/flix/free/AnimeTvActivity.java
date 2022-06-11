package app.flix.free;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
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
import java.util.ArrayList;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebViewClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.bumptech.glide.Glide;
import org.jsoup.*;
import com.eyalbira.loadingdots.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.widget.NestedScrollView;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.jsoup.*;
import org.apache.commons.codec.net.URLCodec;
import java.net.*;

public class AnimeTvActivity extends  AppCompatActivity  { 
	
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private HashMap<String, Object> info = new HashMap<>();
	private HashMap<String, Object> map = new HashMap<>();
	private String activityFontName = "";
	private double rate = 0;
	
	private ArrayList<HashMap<String, Object>> episodeList = new ArrayList<>();
	
	private CollapsingToolbarLayout collapsingtoolbar1;
	private NestedScrollView vscroll1;
	private LinearLayout linear8;
	private Toolbar
 toolbar;
	private RelativeLayout linear1;
	private ImageView image;
	private RealtimeBlurView blur;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private WebView webview1;
	private TextView textview5;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private WrapGridView gridview1;
	private TextView textview1;
	private TextView textview3;
	private TextView textview2;
	private View wave;
	private TextView textview4;
	private ProgressBar progressbar2;
	private TextView textview6;
	
	private RequestNetwork rak;
	private RequestNetwork.RequestListener _rak_request_listener;
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.anime_tv);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_app_bar = (AppBarLayout) findViewById(R.id._app_bar);
		_coordinator = (CoordinatorLayout) findViewById(R.id._coordinator);
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		collapsingtoolbar1 = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar1);
		vscroll1 = (NestedScrollView) findViewById(R.id.vscroll1);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		toolbar = (Toolbar
) findViewById(R.id.toolbar);
		linear1 = (RelativeLayout) findViewById(R.id.linear1);
		image = (ImageView) findViewById(R.id.image);
		blur = (RealtimeBlurView) findViewById(R.id.blur);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		gridview1 = (WrapGridView) findViewById(R.id.gridview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview2 = (TextView) findViewById(R.id.textview2);
		wave = (View) findViewById(R.id.wave);
		textview4 = (TextView) findViewById(R.id.textview4);
		progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
		textview6 = (TextView) findViewById(R.id.textview6);
		rak = new RequestNetwork(this);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				webview1.evaluateJavascript("(function() { var element = document.getElementsByClassName('episodes range active')[0]; return decodeURIComponent(element.innerHTML);})();",
				         new ValueCallback<String>() {
					            @Override
					            public void onReceiveValue(String html) {
						         
						               if(!html.equals("null")){
							              String s = _s(html);
							s = s.split("href")[0];
							
							s = URLDecoder.decode(s);
							s = _fix(s);
							
							int value = Integer.parseInt(s.split("Episode")[1].replaceAll("[^0-9]", ""));
							
							_episode(value);
							//webview1.loadUrl("");
							((ViewGroup)webview1.getParent()).removeView(webview1);
							webview1 = null;
								}
								            }
						    });
				super.onPageFinished(_param1, _param2);
			}
		});
		
		gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				i.setClass(getApplicationContext(), AnimeWatchActivity.class);
				i.putExtra("link", episodeList.get((int)_position).get("link").toString());
				i.putExtra("image", info.get("anime_cover_image_url").toString());
				i.putExtra("name", info.get("anime_name").toString().concat(" Episode ".concat(String.valueOf((long)(_position + 1)))));
				startActivity(i);
			}
		});
		
		_rak_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try {
					
								Document d = Jsoup.parse(_response);
							_pro(d.getElementsByAttributeValue("class","average").first().text());
					
					textview2.setText(textview2.getText().toString().concat(d.getElementsByAttributeValue("class","description").first().text()));
					
					
								for(Element span : d.getElementsByClass("cast").first().getElementsByTag("span")){
										switch(span.text()){
												case "Released":
													textview3.setText(textview3.getText().toString().concat(span.nextElementSibling().text()));
													break;
												case "Genres":
													String genre = "Anime";
													for (Element sibling : span.nextElementSiblings()){
								
															genre = genre.concat(",").concat(sibling.text());
													}
												textview1.setText(textview1.getText().toString().concat(genre));
													break;
										}
								}
								
									
					
				} catch(Exception e) {
					
((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.getMessage()));
					return;
				}
				linear10.setVisibility(View.VISIBLE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		_app_bar.removeView(_toolbar);
		setSupportActionBar(toolbar);
		
		
		Window window = this.getWindow();
		    window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		    //window.setStatusBarColor(getColor(R.color.colorPrimaryDark));
		
		
		_app_bar.setStateListAnimator(null);
		
		CollapsingToolbarLayout collapsingToolbar  = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar1);
		            collapsingToolbar.setCollapsedTitleTypeface(Typeface.createFromAsset(getAssets(), "fonts/product.ttf"));
		            collapsingToolbar.setExpandedTitleTypeface(Typeface.createFromAsset(getAssets(), "fonts/product.ttf"));
		
		((View) collapsingToolbar.getParent()).setBackgroundColor(0xFF000000);
		info = new Gson().fromJson(getIntent().getStringExtra("json"), new TypeToken<HashMap<String, Object>>(){}.getType());
		setTitle(info.get("anime_name").toString());
		_Glide(image, info.get("anime_cover_image_url").toString());
		
		map = new HashMap<>();
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
		rak.setHeaders(map);
		rak.startRequestNetwork(RequestNetworkController.GET, info.get("anime_id").toString(), "new", _rak_request_listener);
		_changeActivityFont("product");
		
		//webview1.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
		webview1.getSettings().setLoadsImagesAutomatically(false);
		//webview1.getSettings().setBlockNetworkLoads(true);
		webview1.getSettings().setBlockNetworkImage(true);
		webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webview1.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
		webview1.getSettings().setAllowFileAccess(true);
		webview1.getSettings().setAppCacheEnabled(true);
		webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webview1.getSettings().setLoadWithOverviewMode(true);
		webview1.getSettings().setUseWideViewPort(true);
		webview1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webview1.getSettings().setDomStorageEnabled(true);
		webview1.getSettings().setSaveFormData(true);
		webview1.loadUrl(info.get("anime_id").toString());
	}
	public String _s (final String _s) {
				
				return (_s.substring((int)(1), (int)(_s.length() - 1)));
		}
		
		
		public String _fix (final String _s) {
				return (_s.replaceFirst("\u003C", ""));
			
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _Glide (final ImageView _v, final String _url) {
		Glide.with(this).load(Uri.parse(_url)).placeholder(_v.getDrawable()).into(_v);
			
		
	}
	
	
	public void _changeActivityFont (final String _fontname) {
		activityFontName = _fontname.trim();
		if (activityFontName.contains(".ttf")) {
			activityFontName = activityFontName.replace(".ttf", "");
		}
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		try {
			Typeface activityTypeFace = Typeface.createFromAsset(getAssets(), "fonts/" + activityFontName + ".ttf");
			if ((v instanceof ViewGroup)) {
				ViewGroup activityFontGroup = (ViewGroup) v;
				for (int i = 0;
				i < activityFontGroup.getChildCount();
				i++) {
					View child = activityFontGroup.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(activityTypeFace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(activityTypeFace);
					}
					else {
						if ((v instanceof Switch )) {
							((Switch) v).setTypeface(activityTypeFace);
						}
						else {
							if ((v instanceof CheckBox )) {
								((CheckBox) v).setTypeface(activityTypeFace);
							}
							else {
								if ((v instanceof Button)) {
									((Button) v).setTypeface(activityTypeFace);
								}
							}
						}
					}
				}
			}
		}catch(Exception e){	SketchwareUtil.showMessage(getApplicationContext(), e.toString());
		}
	}
	
	
	public void _pro (final String _s) {
		rate = Double.parseDouble(_s);
		textview4.setText(_s);
		
	}
	
	
	public void _episode (final double _n) {
		for(int i= 0; i < (int)(_n); i++) {
			map = new HashMap<>();
			map.put("link", "https://kissanimefree.net/episode/".concat(info.get("anime_id").toString().substring((int)(0), (int)(info.get("anime_id").toString().length() - 1)).replace("https://kissanimefree.net/", "").concat("-episode-".concat(String.valueOf((long)(i + 1))))));
			map.put("number", String.valueOf((long)(i + 1)));
			episodeList.add(map);
		}
		linear14.setVisibility(View.GONE);
		gridview1.setAdapter(new Gridview1Adapter(episodeList));
	}
	
	
	public class Gridview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.episode_number, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.cardview1);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			
			ViewGroup.LayoutParams lp = linear1.getLayoutParams();
						lp.width = (int)(((float)getApplicationContext().getResources().getDisplayMetrics().widthPixels) / 8f);
			lp.height = (int)(((float)getApplicationContext().getResources().getDisplayMetrics().widthPixels) / 8f);
			linear1.requestLayout();
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), Typeface.NORMAL);
			textview1.setText(_data.get((int)_position).get("number").toString());
			
			return _view;
		}
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
