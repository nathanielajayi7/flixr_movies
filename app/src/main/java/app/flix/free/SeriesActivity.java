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
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.graphics.Typeface;
import com.bumptech.glide.Glide;
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

public class SeriesActivity extends  AppCompatActivity  { 
	
	
	private double act_po = 0;
	private String infoImg = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> mp = new HashMap<>();
	private String activityFontName = "";
	private String replacor = "";
	private  BottomSheetDialog dialog;
	private  View prog;
	private  ListView list;
	private String redirectLink = "";
	private String name = "";
	
	private ArrayList<HashMap<String, Object>> season = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> episodes = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout background;
	private RelativeLayout linear12;
	private SimpleListView listview2;
	private WrapGridView gridview2;
	private ImageView imageview9;
	private ImageView imageview10;
	private LinearLayout linear9;
	private LinearLayout linear11;
	private CardView linear10;
	private TextView textview7;
	private ImageView imageview8;
	private ImageView imageview7;
	
	private RequestNetwork request;
	private RequestNetwork.RequestListener _request_request_listener;
	private RequestNetwork vid;
	private RequestNetwork.RequestListener _vid_request_listener;
	private Intent i = new Intent();
	private SharedPreferences ff;
	private Intent vlx = new Intent();
	private AlertDialog.Builder d;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.series);
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
		
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		background = (LinearLayout) findViewById(R.id.background);
		linear12 = (RelativeLayout) findViewById(R.id.linear12);
		listview2 = (SimpleListView) findViewById(R.id.listview2);
		gridview2 = (WrapGridView) findViewById(R.id.gridview2);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear10 = (CardView) findViewById(R.id.linear10);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		request = new RequestNetwork(this);
		vid = new RequestNetwork(this);
		ff = getSharedPreferences("ff", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				onBackPressed();
			}
		});
		
		_request_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				final Document d = Jsoup.parse(_response);
						Element cast = d.getElementsByAttributeValue("class","video-series-latest-seasons").first();
						Iterator<Element> it = cast.child(1).select("li").iterator();
						while(it.hasNext()){
								Element f = it.next();
								map = new HashMap<>();
								map.put("link", f.select("a").attr("href"));
								map.put("name", f.text().toUpperCase());
								if(!map.get("name").toString().equals(""))
								season.add(map);
						}
				listview2.setAdapter(new Listview2Adapter(season));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_vid_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				episodes.clear();
				
				final Document d = Jsoup.parse(_response);
				Iterator<Element> e = d.select("article.a-file").iterator();
				while(e.hasNext()){
					Element n = e.next();
					mp = new HashMap<>();
					mp.put("name", n.select("div.image").select("img").attr("alt").toString());
					mp.put("link", n.select("div.info").select("h3.file-name").select("a").attr("href").toString());
					if(!mp.get("name").toString().equals(""))
					episodes.add(mp);
				}
				list.setAdapter(new Gridview2Adapter(episodes));
				list.setVisibility(View.VISIBLE);
				prog.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		
		
		infoImg = getIntent().getStringExtra("image");
		_requestBlurredImage();
		_setImageFromURL(imageview7, getIntent().getStringExtra("image"));
		textview7.setText(getIntent().getStringExtra("name"));
		_RippleEffects("#55ffffff", imageview8);
		map = new HashMap<>();
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
		request.setHeaders(map);
		request.startRequestNetwork(RequestNetworkController.GET, getIntent().getStringExtra("link"), "new", _request_request_listener);
		getWindow(). getDecorView().setBackgroundColor(0xFF000000);
		try {
			_transitionComplete(imageview7, "movie_img");
		} catch(Exception e) {
			 
		}
		//d = new Downloader(this);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		/*
com.google.android.gms.ads.MobileAds.initialize(this, new com.google.android.gms.ads.initialization.OnInitializationCompleteListener() {
			            @Override
			            public void onInitializationComplete(com.google.android.gms.ads.initialization.InitializationStatus initializationStatus) {
				_loadAd(adview1);
				            }
			        });

*/
		
		_LOGIC_UI();
		getWindow().setNavigationBarColor(0xFF000000);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _setImageFromURL (final ImageView _image, final String _url) {
		Glide.with(this)
		
		.load(_url)
		.apply(new RequestOptions().override(1000, 1000))
		.into(_image);
		
	}
	
	
	public void _RippleEffects (final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _LOGIC_UI () {
		_changeActivityFont("product");
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), 0);
		_transparentStatusBar();
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
	
	
	public void _transparentStatusBar () {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.setNavigationBarColor(Color.parseColor("#121212"));
			w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
	}
	
	
	public void _requestBlurredImage () {
		new AsyncTaskEx().execute();
	}
	private class AsyncTaskEx extends AsyncTask<Void, Bitmap, Bitmap> {
		
		@Override protected Bitmap doInBackground(Void... arg0) {
			
			Bitmap blurred = null;
			try {
				java.net.URL url = new java.net.URL(infoImg);
				
				java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection(); connection.setDoInput(true); connection.connect(); java.io.InputStream input = connection.getInputStream();
				
				Bitmap bitmap = BitmapFactory.decodeStream(input);
				
				int b = (int)15;
				
				blurred = blurRenderScript(SeriesActivity.this,bitmap, b);
				
			}catch(Exception e){}
			
			return blurred;
			
		}
		@Override protected void onPostExecute(Bitmap result) {
			
			imageview9.setImageBitmap(result);
			
			return;
		}
		@Override protected void onPreExecute() {
				
			return ;
				}
	}
	public static Bitmap blurRenderScript(Context context,Bitmap smallBitmap, int radius) {
		try {
			smallBitmap = RGB565toARGB888(smallBitmap);
			
		} catch (Exception e) {
		}
		
		Bitmap bitmap = Bitmap.createBitmap(smallBitmap.getWidth(), smallBitmap.getHeight(), Bitmap.Config.ARGB_8888);
		
		android.renderscript.RenderScript renderScript = android.renderscript.RenderScript.create(context);
		
		android.renderscript.Allocation blurInput = android.renderscript.Allocation.createFromBitmap(renderScript, smallBitmap);
		
		android.renderscript.Allocation blurOutput = android.renderscript.Allocation.createFromBitmap(renderScript, bitmap);
		
		android.renderscript.ScriptIntrinsicBlur blur = android.renderscript.ScriptIntrinsicBlur.create(renderScript,
																												android.renderscript.Element.U8_4(renderScript));
		
		blur.setInput(blurInput);
		blur.setRadius(radius);
		blur.forEach(blurOutput);
		blurOutput.copyTo(bitmap);
		renderScript.destroy();
		
		return bitmap;
	}
	
	private static Bitmap RGB565toARGB888(Bitmap img) throws Exception {
		
		int numPixels = img.getWidth() * img.getHeight();
		int[] pixels = new int[numPixels];
		
		img.getPixels(pixels, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());
		
		
		Bitmap result = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);
		
		result.setPixels(pixels, 0, result.getWidth(), 0, 0, result.getWidth(), result.getHeight());
		return result;
	}
	private void doNothing883838() {
	}
	
	
	public void _transitionComplete (final View _view, final String _transitionName) {
		_view.setTransitionName(_transitionName);
	}
	
	
	public void _showDialog () {
		dialog = new BottomSheetDialog(this);
		final View _v = getLayoutInflater().inflate(R.layout.episode_items, null);
		TextView textview1 = _v.findViewById(R.id.textview1);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), 1);
		textview1.setText(replacor.concat(" - ".concat("Episodes")));
		list = (ListView) _v.findViewById(R.id.listview1);
		prog = _v.findViewById(R.id.linear2);
		_RippleEffects("#44FFFFFF", _v.findViewById(R.id.imageview1));
		_v.findViewById(R.id.imageview1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!episodes.isEmpty()) {
					dialog.dismiss();
					episodes.clear();
				}
			}
		});
		dialog.setContentView(_v);
		dialog.setCancelable(false);
		dialog.show();
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
	
	
	public void _setViewRadius (final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor("#" + _color.replace("#", "")));
		
		gd.setCornerRadius((int)_radius);
		
		_view.setBackground(gd);
	}
	public void startDownload(String url, String fileName, String mime){
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
			
				
				
				request.setDescription("Downloading...");
									request.setTitle(fileName);
									request.allowScanningByMediaScanner(); 
								request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
		   .setAllowedOverRoaming(true);	request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION).setShowRunningNotification(true); 
									try{
											    request.setDestinationUri(Uri.fromFile(new java.io.File(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/Flixr/") + fileName + "." + mime)));
				}catch(Exception e){
						    request.setDestinationInExternalPublicDir(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS), ("/Flixr/") + fileName + "." + mime);
				}
				
				DownloadManager manager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
				manager.enqueue(request);
							
			
			
	}
	
	
	public void _showCustomSnackBar (final String _text) {
		ViewGroup parentLayout = (ViewGroup) ((ViewGroup) this .findViewById(android.R.id.content)).getChildAt(0);
		
		_snackBarView = com.google.android.material.snackbar.Snackbar.make(parentLayout, "", com.google.android.material.snackbar.Snackbar.LENGTH_LONG);
		_sblayout = (com.google.android.material.snackbar.Snackbar.SnackbarLayout) _snackBarView.getView();
		
		View _inflate = getLayoutInflater().inflate(R.layout.snackbar, null);
		_sblayout.setPadding(0, 0, 0, 0);
		_sblayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
		LinearLayout back =
		_inflate.findViewById(R.id.linear1);
		
		TextView text =
		_inflate.findViewById(R.id.textview1);
		_setViewRadius(back, 20, "#202125");
		text.setText(_text);
		text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), 0);
		_sblayout.addView(_inflate, 0);
		_snackBarView.show();
	}
	private void _doNothingBlahBlah () {
	}
	com.google.android.material.snackbar.Snackbar _snackBarView;
	com.google.android.material.snackbar.Snackbar.SnackbarLayout _sblayout;
	View _inflate;
	{
	}
	
	
	public boolean _is (final String _s) {
		Intent launchIntent = getPackageManager().getLaunchIntentForPackage(_s); 
		
		return (launchIntent != null);
	}
	
	
	public void _watchWithVLC (final String _s) {
		vlx.setAction(Intent.ACTION_VIEW);
		vlx = getPackageManager().getLaunchIntentForPackage("org.videolan.vlc");
		vlx.setDataAndTypeAndNormalize(Uri.parse(_s), "video/*");
		vlx.putExtra("title", getIntent().getStringExtra("name"));
		vlx.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
		startActivity(vlx);
	}
	
	
	public class Listview2Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.search, null);
			}
			
			final TextView textview12 = (TextView) _view.findViewById(R.id.textview12);
			final LinearLayout background = (LinearLayout) _view.findViewById(R.id.background);
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), 0);
			textview1.setText(_data.get((int)_position).get("name").toString());
			textview1.setTextColor(0xFFFFFFFF);
			Glide.with(getApplicationContext()).load(Uri.parse(infoImg)).into(imageview1);
			textview12.setVisibility(View.GONE);
			imageview2.setVisibility(View.GONE);
			imageview2.setImageResource(R.drawable.ic_arrow_forward_white);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					d.setTitle("Not Available");
					d.setMessage("There has been a system upgrade, and the series are unavailable for now. Dont worry, we push updates to ALL devices and we'll fix this soon!");
					d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					d.create().show();
					
				}
			});
			
			return _view;
		}
	}
	
	public class Gridview2Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Gridview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.episode, null);
			}
			
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			final ImageView imageview3 = (ImageView) _view.findViewById(R.id.imageview3);
			
			linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0x44323232));
			try {
				textview1.setText(_data.get((int)_position).get("name").toString().toUpperCase().replace(replacor, "").trim());
			} catch(Exception e) {
				textview1.setText(_data.get((int)_position).get("name").toString().toUpperCase());
			}
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), 0);
			_RippleEffects("#44FFFFFF", imageview2);
			_RippleEffects("#44FFFFFF", imageview3);
			imageview2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					redirectLink = _getRedirectedUrl(_data.get((int)_position).get("link").toString().concat("/download")).concat("?d=1");
					i.setClass(getApplicationContext(), WatchActivity.class);
					i.putExtra("link", _getRedirectedUrl(_data.get((int)_position).get("link").toString().concat("/download")).concat("?d=1"));
					i.putExtra("image", infoImg);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
					
				}
			});
			imageview3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (androidx.core.content.ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != android.content.pm.PackageManager.PERMISSION_DENIED) {
						redirectLink = _getRedirectedUrl(_data.get((int)_position).get("link").toString().concat("/download")).concat("?d=1");
						if (redirectLink.startsWith("http")) {
							startDownload(redirectLink, getIntent().getStringExtra("name") + " " +  _data.get(_position).get("name").toString(),"mp4");
							ff.edit().putString(getIntent().getStringExtra("name") + " " +  _data.get(_position).get("name").toString(), infoImg).commit();
							SketchwareUtil.showMessage(getApplicationContext(), "Download started!");
							_showCustomSnackBar("Downloading...");
							imageview3.setEnabled(false);
							imageview3.setAlpha((float)(0.5d));
						}
						else {
							SketchwareUtil.showMessage(getApplicationContext(), "Unable to download!");
							_showCustomSnackBar("Unable to retrieve download link, try again!");
						}
					}
					else {
						androidx.core.app.ActivityCompat.requestPermissions(SeriesActivity.this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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