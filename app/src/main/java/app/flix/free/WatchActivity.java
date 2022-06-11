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
import android.widget.LinearLayout;
import android.view.View;
import org.jsoup.*;
import com.eyalbira.loadingdots.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import com.ctrip.videoapplication.video.*;

public class WatchActivity extends  AppCompatActivity  { 
	
	
	private boolean flag = false;
	private String activityFontName = "";
	private  TourVideoController controller;
	
	private RelativeLayout linear1;
	private TourVideoPlayer player;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.watch);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (RelativeLayout) findViewById(R.id.linear1);
		player = (TourVideoPlayer) findViewById(R.id.player);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		
		player.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
	}
	
	private void initializeLogic() {
		_changeActivityFont("product");
		_load();
		linear3.setClickable(true);
		linear5.setClickable(true);
		_doubleClick(linear3);
		_doubleClick(linear5);
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
	public void onPause() {
		super.onPause();
		player.release();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (SketchwareUtil.getRandom((int)(0), (int)(1)) > 0) {
			return;
		}
		
	}
	public void _load () {
		
		        controller = new TourVideoController(this);
		        String videoUrl = getIntent().getStringExtra("link");
		
		 controller.setUrl(videoUrl);
		       controller.setImage(getIntent().getStringExtra("image"));
		if(getIntent().getStringExtra("sub") != null){
			controller.setSubtitle(getIntent().getStringExtra("sub"));
		}
		 player.setController(controller);
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
	
	
	public void _doubleClick (final View _v) {
		_v.setOnClickListener(new DoubleClickListener(){
			@Override
			public void onDoubleClick() {
				if (_v.getId() == R.id.linear3) {
					if (controller != null) {
						if (controller.getPlayer() != null) {
							if (controller.getPlayer().getCurrentPosition() > 10000) {
								controller.seekTo(controller.getPlayer().getCurrentPosition() - 10000);
							}
						}
					}
				}
				if (_v.getId() == R.id.linear5) {
					if (controller != null) {
						if (controller.getPlayer() != null) {
							controller.seekTo(controller.getPlayer().getCurrentPosition() + 10000);
						}
					}
				}
			}
		});
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