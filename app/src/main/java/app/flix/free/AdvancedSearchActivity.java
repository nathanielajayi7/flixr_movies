package app.flix.free;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;

import android.annotation.SuppressLint;
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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;
import com.bumptech.glide.Glide;
import org.jsoup.*;
import com.eyalbira.loadingdots.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import android.content.res.Configuration;
import com.bumptech.glide.request.RequestOptions;
import androidx.appcompat.widget.TooltipCompat;
import androidx.recyclerview.widget.SimpleItemAnimator;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.jsoup.*;
import java.net.*;
import java.io.*;

public class AdvancedSearchActivity extends  AppCompatActivity  { 
	
	
	private String activityFontName = "";
	private String json = "";
	private double page = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private String s = "";
	private boolean result = false;
	private HashMap<String, Object> mp = new HashMap<>();
	
	private ArrayList<String> str = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> content = new ArrayList<>();
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private SimpleListView listview1;
	private Button button1;
	private Button button2;
	private ProgressBar progressbar1;
	private AutoCompleteTextView autocomplete1;
	private ImageView imageview1;
	private RadioButton radiobutton1;
	private RadioButton radiobutton2;
	private RadioButton radiobutton3;
	
	private Intent vlx = new Intent();
	private Intent toinfo = new Intent();
	private RequestNetwork research;
	private RequestNetwork.RequestListener _research_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.advanced_search);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		listview1 = (SimpleListView) findViewById(R.id.listview1);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		autocomplete1 = (AutoCompleteTextView) findViewById(R.id.autocomplete1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		radiobutton1 = (RadioButton) findViewById(R.id.radiobutton1);
		radiobutton2 = (RadioButton) findViewById(R.id.radiobutton2);
		radiobutton3 = (RadioButton) findViewById(R.id.radiobutton3);
		research = new RequestNetwork(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!s.trim().equals("")) {
					if (!content.isEmpty()) {
						page++;
						map = new HashMap<>();
						map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
						research.setHeaders(map);
						research.startRequestNetwork(RequestNetworkController.GET, "https://www.thenetnaija.com/search/page/".concat(String.valueOf((long)(page)).concat("?t=".concat(s.replaceAll("\\s","+").concat("&folder=videos")).concat("#search-results"))), "new", _research_request_listener);
					}
					button1.setVisibility(View.GONE);
					listview1.setVisibility(View.GONE);
					progressbar1.setVisibility(View.VISIBLE);
					button2.setVisibility(View.GONE);
				}
				try {
					
autocomplete1.clearFocus();
				} catch(Exception e) {
					
 
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (page > 1) {
					if (page == 1) {
						_performSearch(s);
					}
					else {
						page--;
						map = new HashMap<>();
						map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
						research.setHeaders(map);
						research.startRequestNetwork(RequestNetworkController.GET, "https://www.thenetnaija.com/search/page/".concat(String.valueOf((long)(page)).concat("?t=".concat(s.replaceAll("\\s","+").concat("&folder=videos")).concat("#search-results"))), "new", _research_request_listener);
						listview1.setVisibility(View.GONE);
						button1.setVisibility(View.GONE);
						progressbar1.setVisibility(View.VISIBLE);
						button2.setVisibility(View.GONE);
					}
				}
				try {
					
autocomplete1.clearFocus();
				} catch(Exception e) {
					
 
				}
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!autocomplete1.getText().toString().trim().equals("")) {
					s = autocomplete1.getText().toString();
					_performSearch(s);
				}
			}
		});
		
		radiobutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton1.setChecked(true);
				radiobutton2.setChecked(false);
				radiobutton3.setChecked(false);
				/*
autocomplete1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, _info("country")));
*/
			}
		});
		
		radiobutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				/*
autocomplete1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, _info("actor")));
*/
				radiobutton1.setChecked(false);
				radiobutton2.setChecked(true);
				radiobutton3.setChecked(false);
			}
		});
		
		radiobutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				radiobutton1.setChecked(false);
				radiobutton2.setChecked(false);
				radiobutton3.setChecked(true);
				
			}
		});
		
		_research_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				content.clear();
				listview1.setVisibility(View.VISIBLE);
				button1.setVisibility(View.VISIBLE);
				progressbar1.setVisibility(View.GONE);
				button2.setVisibility(View.VISIBLE);
				button1.setEnabled(true);
				final Document d = Jsoup.parse(_response);
										Iterator<Element> h = d.select("article.result").iterator();
				if(h == null){
					
					showMessage("No more content to show");
					
					return;
				}
										while(h.hasNext()){
													Element k = h.next();
													String title = k.select("div.result-info").select("h3.result-title").text();
					
					if(title == null){
						showMessage("No more content to show");
						
						return;
					}
													String imageLink = k.select("div.result-img").select("img").attr("src");
													String link = k.select("div.result-info").select("h3.result-title").select("a").attr("href");
					
					
					if (!link.contains("nollywood")) {
						if (!link.contains("episode")) {
							mp = new HashMap<>();
							mp.put("link", link);
							mp.put("name", title);
							mp.put("image", imageLink);
							mp.put("movie", _getType(mp));
							if (_isValidElement(mp.get("link").toString())) {
								content.add(mp);
							}
						}
					}
				}
				
				listview1.setAdapter(new Listview1Adapter(content));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "Network error");
			}
		};
	}
	
	private void initializeLogic() {
		page = 1;
		json = "[\n{\n	\"name\":\"Chinese\",\n	\"type\":\"country\"\n},{\n	\"name\":\"Korean\",\n	\"type\":\"country\"\n	\n},{\n	\"name\":\"Indonesian\",\n	\"type\":\"country\"\n},\n{\n	\"name\":\"Indian\",\n	\"type\":\"country\"\n	},\n	{\n		\"name\":\"Stu Bennett\",\n		\"type\":\"actor\"\n		},\n		{\n			\"name\":\"Will Smith\",\n			\"type\":\"actor\"\n			},\n{\n\"name\":\"Martin Lawrence\",\n\"type\":\"actor\"\n},\n{\n\"name\":\"Scott Adkins\",\n\"type\":\"actor\"\n},\n{\n    \"name\":\"Action\",\n    \"type\":\"tag\"\n    }\n]";
		lm = new Gson().fromJson(json, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		setTitle("Advanced Search");
		_changeActivityFont("product");
		linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF212121));
		
		autocomplete1.setSingleLine(true);
		radiobutton1.setChecked(true);
		radiobutton2.setChecked(false);
		radiobutton3.setChecked(false);
		autocomplete1.setHintTextColor(0xFF9E9E9E);
		
		AJCode.setRoundedRipple(button1, (int)56, (int)56, (int)56, (int)56, 0xFF111111, (int)2, 0xFFFFFFFF, 0xFFE0E0E0);
		AJCode.setRoundedRipple(button2, (int)56, (int)56, (int)56, (int)56, 0xFF111111, (int)2, 0xFFFFFFFF, 0xFFE0E0E0);
		try {
			
if (Build.VERSION.SDK_INT > 27) {
				autocomplete1.setFocusedByDefault(false);
			}
		} catch(Exception e) {
			
 
		}
		button1.setEnabled(false);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
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
	
	
	public void _setImageFromURL (final ImageView _image, final String _url) {
		Glide.with(this)
		
		.load(_url)
		.apply(new RequestOptions().override(1000, 1000))
		.into(_image);
		
	}
	
	
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public void _transitionManager (final View _view, final String _transitionName, final Intent _intent) {
		_view.setTransitionName(_transitionName);
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(this, _view, _transitionName); startActivity(_intent, optionsCompat.toBundle());
	}
	
	
	public String _getRedirectedUrl (final String _s) {
		String s = "";
		
		
		try{
									
								URLConnection con = new URL(_s).openConnection();
								
								con.connect();
								
								InputStream is = con.getInputStream();
								s =  con.getURL().toString();
								is.close();
						}catch(Exception e){
									
						}
				return s + "?d=1";
	}
	
	
	public ArrayList<String> _info (final String _s) {
		ArrayList<String> list = new ArrayList<>();
		for(int i= 0; i < (int)(lm.size()); i++) {
			if (_s.toLowerCase().equals(lm.get((int)i).get("type").toString().toLowerCase())) {
				list.add(lm.get((int)i).get("name").toString());
			}
		}
		return list;
	}
	
	
	public boolean _getType (final HashMap<String, Object> _m) {
		result = true;
		if (_m.get("name").toString().toLowerCase().contains("series")) {
			result = false;
		}
		if (_m.get("name").toString().toLowerCase().contains("tv")) {
			result = false;
		}
		if (_m.get("link").toString().toLowerCase().contains("series")) {
			result = false;
		}
		return (result);
	}
	
	
	public boolean _is (final String _s) {
		Intent launchIntent = getPackageManager().getLaunchIntentForPackage(_s); 
		
		return (launchIntent != null);
	}
	
	
	public void _performSearch (final String _value) {
		map = new HashMap<>();
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
		research.setHeaders(map);
		research.startRequestNetwork(RequestNetworkController.GET, "https://www.thenetnaija.com/search?t=".concat(_value.replaceAll("\\s","+").concat("&folder=videos")), "new", _research_request_listener);
		listview1.setVisibility(View.GONE);
		button1.setVisibility(View.GONE);
		progressbar1.setVisibility(View.VISIBLE);
		button2.setVisibility(View.GONE);
		try {
			
SketchwareUtil.hideKeyboard(getApplicationContext());
		} catch(Exception e) {
			
 
		}
	}
	
	
	public boolean _isValidElement (final String _s) {
		return (_s.contains("/movies/") || _s.contains("/series/"));
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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


		@SuppressLint("InflateParams")
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.search, null);
			}
			
			final TextView textview12 = (TextView) _view.findViewById(R.id.textview12);
			final LinearLayout background = (LinearLayout) _view.findViewById(R.id.background);
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			
			if (_data.get((int)_position).get("name").toString().contains("Movie:")) {
				_data.get((int)_position).put("name", _data.get((int)_position).get("name").toString().replace("Movie:", "").trim());
			}
			_setImageFromURL(imageview1, _data.get((int)_position).get("image").toString());
			textview1.setText(_data.get((int)_position).get("name").toString());
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.NORMAL);
			textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), Typeface.NORMAL);
			_ICC(imageview2, "#FFFFFF", "#FFFFFF");
			if (_position == 0) {
				textview12.setVisibility(View.GONE);
			}
			else {
				textview12.setVisibility(View.GONE);
			}
			if ((boolean)_data.get((int)(_position)).get("movie")) {
				imageview2.setVisibility(View.VISIBLE);
			}
			else {
				imageview2.setVisibility(View.GONE);
			}
			imageview2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					vlx.setClass(getApplicationContext(), WatchActivity.class);
					vlx.putExtra("link", _getRedirectedUrl(_data.get((int)_position).get("link").toString().concat("/download")).concat("?d=1"));
					vlx.putExtra("image", _data.get((int)_position).get("image").toString());
					startActivity(vlx);
				}
			});
			background.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					toinfo = new Intent();
					if ((boolean)_data.get((int)(_position)).get("movie")) {
						toinfo.setClass(getApplicationContext(), InfoActivity.class);
					}
					else {
						toinfo.setClass(getApplicationContext(), SeriesActivity.class);
					}
					toinfo.putExtra("image", _data.get((int)_position).get("image").toString());
					toinfo.putExtra("name", _data.get((int)_position).get("name").toString());
					toinfo.putExtra("link", _data.get((int)_position).get("link").toString());
					_transitionManager(imageview1, "movie_img", toinfo);
				}
			});
			
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
