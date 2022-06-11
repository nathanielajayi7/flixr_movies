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
import androidx.core.widget.NestedScrollView;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.graphics.Typeface;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.*;
import com.eyalbira.loadingdots.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import com.bumptech.glide.request.RequestOptions;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.jsoup.*;

public class MoreActivity extends  AppCompatActivity  { 
	
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String activityFontName = "";
	private boolean movieType = false;
	private String url = "";
	private double page = 0;
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	
	private NestedScrollView vscroll1;
	private LinearLayout linear1;
	private WrapGridView gridview1;
	private Button button1;
	private ListView listview1;
	
	private RequestNetwork vm;
	private RequestNetwork.RequestListener _vm_request_listener;
	private Intent n = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.more);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
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
		vscroll1 = (NestedScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		gridview1 = (WrapGridView) findViewById(R.id.gridview1);
		button1 = (Button) findViewById(R.id.button1);
		listview1 = (ListView) findViewById(R.id.listview1);
		vm = new RequestNetwork(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_loadNext();
				button1.setEnabled(false);
			}
		});
		
		_vm_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				button1.setEnabled(true);
				final Document d = Jsoup.parse(_response);
				Iterator<Element> _e = d.select("div.video-files").select("article").iterator();
				
				while(_e.hasNext()) {
					Element n = _e.next();
					map = new HashMap<>();
					try {
						map.put("image", n.selectFirst("img").attr("src").toString());
					} catch(Exception e) {
						SketchwareUtil.showMessage(getApplicationContext(), "You've reached the end of the list!!");
						return;
					}
					map.put("name", n.selectFirst("img").attr("title"));
					map.put("link", n.getElementsByAttribute("href").first().attr("href").toString());
					map.put("date", "2021");
					if (map.containsKey("image") && !map.get("image").toString().equals("")) {
						list.add(map);
					}
				}
				gridview1.setAdapter(new Gridview1Adapter(list));
				gridview1.smoothScrollToPosition((int)(list.size() - 1));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
	}
	
	private void initializeLogic() {
		_app_bar.setStateListAnimator(null);
		page = 2;
		_toolbar.setBackgroundColor(0xFF000000);
		_changeActivityFont("gilroy_bold");
		if (getIntent().getStringExtra("type").toLowerCase().equals("movie")) {
			movieType = true;
			url = "https://www.thenetnaija.com/videos/movies/page/";
			setTitle("Movies");
		}
		else {
			movieType = false;
			url = "https://www.thenetnaija.com/videos/series/page/";
			setTitle("Series");
		}
		MyCode.setRoundedRipple(button1, (int)8, (int)8, (int)8, (int)8, 0xFFFFFFFF, (int)0, Color.TRANSPARENT, 0xCCEEEEEE);
		_init();
		
		
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
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add("Exit");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
		public boolean onOptionsItemSelected(MenuItem item){
		final int _id = item.getItemId();
		final String _title = (String) item.getTitle();
		switch(_title) {
			case "Exit": {
				finish();
			}
			default: {
				 
				break;
			}
		}
		return super.onOptionsItemSelected(item);
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
	
	
	public void _RippleEffects (final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _init () {
		list = new Gson().fromJson(getIntent().getStringExtra("json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		gridview1.setAdapter(new Gridview1Adapter(list));
		_loadNext();
	}
	
	
	public void _loadNext () {
		map = new HashMap<>();
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
		vm.setHeaders(map);
		vm.startRequestNetwork(RequestNetworkController.GET, url.concat(String.valueOf((long)(page))), "new", _vm_request_listener);
		page++;
		
	}
	
	
	public void _transitionManager (final View _view, final String _transitionName, final Intent _intent) {
		_view.setTransitionName(_transitionName);
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(this, _view, _transitionName); startActivity(_intent, optionsCompat.toBundle());
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
				_view = _inflater.inflate(R.layout.card, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView linear2 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.linear2);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final RelativeLayout linear4 = (RelativeLayout) _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = (LinearLayout) _view.findViewById(R.id.linear5);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			
			ViewGroup.LayoutParams lp = linear1.getLayoutParams();
						lp.width = (int)(((float)getApplicationContext().getResources().getDisplayMetrics().widthPixels) / 3.0f);
			linear1.requestLayout();
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/medium.ttf"), 0);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/medium.ttf"), 0);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), 1);
			textview2.setVisibility(View.GONE);
			if (_data.get((int)_position).containsKey("name")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("image").toString())).into(imageview1);
				textview1.setText(_data.get((int)_position).get("name").toString());
				textview1.setBackgroundColor(Color.TRANSPARENT);
				linear4.setVisibility(View.VISIBLE);
			}
			else {
				textview1.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)7, 0xFF323232));
				linear4.setVisibility(View.GONE);
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (movieType) {
						n.setClass(getApplicationContext(), InfoActivity.class);
					}
					else {
						n.setClass(getApplicationContext(), SeriesActivity.class);
					}
					n.putExtra("image", _data.get((int)_position).get("image").toString());
					n.putExtra("link", _data.get((int)_position).get("link").toString());
					n.putExtra("name", _data.get((int)_position).get("name").toString());
					try {
						_transitionManager(imageview1, "movie_img", n);
					} catch(Exception e) {
						startActivity(n);
					}
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