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
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;
import android.content.ClipData;
import android.content.ClipboardManager;
import org.jsoup.*;
import com.eyalbira.loadingdots.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import java.net.*;
import com.bumptech.glide.request.RequestOptions;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.jsoup.*;
import javax.net.ssl.*;

public class SodeActivity extends  AppCompatActivity  { 
	
	
	private String infoImg = "";
	private String activityFontName = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String first = "";
	private double tab_int = 0;
	private  boolean[] state;
	private HashMap<String, Object> mp = new HashMap<>();
	private String json = "";
	private String imdb = "";
	private String ytLink = "";
	private HashMap<String, Object> links = new HashMap<>();
	private String activeLink = "";
	private String yi = "";
	private double activepos = 0;
	
	private ArrayList<HashMap<String, Object>> season = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> filte = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> episode = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout background;
	private LinearLayout nested;
	private LinearLayout info_back;
	private LinearLayout layouts_holder;
	private ImageView info_img_blurred;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private TextView info_title;
	private LinearLayout linear18;
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout linear5;
	private ImageView imageview6;
	private LinearLayout info_image_back;
	private CardView cardview1;
	private ImageView info_img;
	private TextView textview10;
	private LinearLayout linear17;
	private LinearLayout linear19;
	private ImageView imageview8;
	private TextView textview9;
	private ImageView imageview9;
	private TextView textview11;
	private LinearLayout layout2;
	private TextView text;
	private TextView textview12;
	private TextView textview13;
	private TabLayout tablayout1;
	private SimpleListView listview1;
	
	private RequestNetwork items;
	private RequestNetwork.RequestListener _items_request_listener;
	private RequestNetwork episodes;
	private RequestNetwork.RequestListener _episodes_request_listener;
	private ProgressDialog pb;
	private RequestNetwork re;
	private RequestNetwork.RequestListener _re_request_listener;
	private Intent i = new Intent();
	private SharedPreferences ff;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.sode);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		background = (LinearLayout) findViewById(R.id.background);
		nested = (LinearLayout) findViewById(R.id.nested);
		info_back = (LinearLayout) findViewById(R.id.info_back);
		layouts_holder = (LinearLayout) findViewById(R.id.layouts_holder);
		info_img_blurred = (ImageView) findViewById(R.id.info_img_blurred);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		info_title = (TextView) findViewById(R.id.info_title);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		info_image_back = (LinearLayout) findViewById(R.id.info_image_back);
		cardview1 = (CardView) findViewById(R.id.cardview1);
		info_img = (ImageView) findViewById(R.id.info_img);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview9 = (TextView) findViewById(R.id.textview9);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		textview11 = (TextView) findViewById(R.id.textview11);
		layout2 = (LinearLayout) findViewById(R.id.layout2);
		text = (TextView) findViewById(R.id.text);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview13 = (TextView) findViewById(R.id.textview13);
		tablayout1 = (TabLayout) findViewById(R.id.tablayout1);
		listview1 = (SimpleListView) findViewById(R.id.listview1);
		items = new RequestNetwork(this);
		episodes = new RequestNetwork(this);
		re = new RequestNetwork(this);
		ff = getSharedPreferences("ff", Activity.MODE_PRIVATE);
		
		info_img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ImageActivity.class);
				i.putExtra("image", infoImg);
				try {
					_ActivityTranlation(info_img, "movie", i);
				} catch(Exception e) {
					startActivity(i);
				}
			}
		});
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!ytLink.equals("")) {
					i.setClass(getApplicationContext(), TrailerActivity.class);
					i.putExtra("embed", ytLink);
					startActivity(i);
				}
			}
		});
		
		linear19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!imdb.equals("")) {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse(imdb));
					startActivity(i);
				}
			}
		});
		
		_items_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				final Document d = Jsoup.parse(_response);
				 try{
								
								ytLink = d.select("article.post-body").select("iframe").first().attr("src");
					
								text.setText(d.select("article.post-body").select("p").first().text());
								
								/*
			Iterator it =_e.getElementsByClass("quote-content").first().select("p").iterator();

			while(it.hasNext()){
				Element f = (Element)it.next();
				if(f.text().toLowerCase().contains("imdb")){
					imdb = f.text().split(":",2)[1].trim();
				}
				if(f.text().toLowerCase().contains("premiere")){
				 textview12.setText("Premiered on: " + f.text().split(":",2)[1].trim());
				}
				if(f.text().toLowerCase().contains("star")){
					textview13.setText("Star Casts: " + f.text().split(":",2)[1].trim());
				}
				if(f.text().toLowerCase().contains("genre")){
					System.out.println(f.text().split(":",2)[1].trim());
				}
			}
			*/
							//"https://www.sabishare.com/file/wweoUWcFR69-black-bear-2020-netnaija-com-mp4").get();
					}catch(Exception e){
						    finish();
						//	System.out.println(e);
					}
				
				for (Element e : d.select("div.video-seasons").select("h3").select("a")){
								map = new HashMap<>();
								map.put("link", e.attr("href"));
								map.put("name", e.text());
								
								if(!map.get("name").toString().equals("")){
									season.add(map);
									tablayout1.addTab(tablayout1.newTab().setText(map.get("name").toString()));
									state = new boolean[tablayout1.getChildCount()];
									state[(int)tab_int] = true;
									if(first.equals("")){
										    first = map.get("name").toString();
										   _getEp();
									}
							}
						}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_episodes_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
				final Document d = Jsoup.parse(_response);
				
				/*
Iterator<Element> e = d.select("article.a-file").iterator();
while(e.hasNext()){
Element n = e.next();
mp = new HashMap<>();
mp.put("season", tablayout1.getTabAt((int)tab_int).getText( ).toString());
mp.put("name", n.select("div.image").select("img").attr("alt").toString());
mp.put("link", n.select("div.info").select("h3.file-name").select("a").attr("href").toString());
if(!mp.get("name").toString().equals("")){
episode.add(mp);
}
}


*/
				for (Element e : d.select("div.video-files").select("article")){
								System.out.println(e.select("h2").select("a").attr("href"));
								mp = new HashMap<>();
					mp.put("season", tablayout1.getTabAt((int)tab_int).getText( ).toString());
					mp.put("name", e.select("h2").select("a").text().toString());
					mp.put("link", e.select("h2").select("a").attr("href").toString());
					if(!mp.get("name").toString().equals("")){
						episode.add(mp);
						
						}
					}
				if (episode.size() > 0) {
					listview1.setAdapter(new Listview1Adapter(_getSeason(episode.get((int)episode.size() - 1).get("season").toString())));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
				_closeDialog();
				try {
						pb.dismiss();
				} catch(Exception excp) {
						 
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_re_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
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
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("image"))).into(info_img);
		info_title.setText(getIntent().getStringExtra("name"));
		try {
			_transitionComplete(info_img, "movie_img");
		} catch(Exception e) {
			 
		}
		_requestBlurredImage();
		_LOGIC_UI();
		map = new HashMap<>();
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
		items.setHeaders(map);
		items.startRequestNetwork(RequestNetworkController.GET, getIntent().getStringExtra("link"), "new", _items_request_listener);
		tablayout1.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener(){
								@Override 
								public void onTabUnselected(TabLayout.Tab tab){
										
								}
								
								@Override 
								public void onTabReselected(TabLayout.Tab tab){
										tab_int = tab.getPosition();
								}
								@Override
								public void onTabSelected(TabLayout.Tab tab){
									    
									final int _position = tab.getPosition();
									if(episode.size() > 0){
					//SketchwareUtil.showMessage(getApplicationContext(), "Clicked");
					tab_int = _position;
					if (_getSeason(season.get((int)_position).get("name").toString()).isEmpty()) {
							first = season.get((int)_position).get("name").toString();
							pb = new ProgressDialog(SodeActivity.this);
							pb.setMessage("Getting episodes...");
						//	pb.setProgressStyle(ProgressDialog.STYLE_SPINNER);
							pb.setCancelable(false);
							pb.show();
							overrideFonts(SodeActivity.this, pb.getWindow().getDecorView());
							map = new HashMap<>();
							map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
							episodes.setHeaders(map);
							episodes.startRequestNetwork(RequestNetworkController.GET, season.get((int)_position).get("link").toString(), "new", _episodes_request_listener);
					}
					else {
							listview1.setAdapter(new Listview1Adapter(_getSeason(season.get((int)_position).get("name").toString())));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
									}
									}
							});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private class DownloadLink extends AsyncTask<String, Integer, String> {
		@Override
		protected void onPreExecute() {
			
		}
		
		@Override
		protected String doInBackground(String... params) {
			String _param = params[0];
			return (_getRedirectedUrl(activeLink));
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			int _value = values[0];
			
		}
		
		@Override
		protected void onPostExecute(String _result) {
			if (_result.contains("sabishare")) {
					yi = Uri.parse(_result).getLastPathSegment();
					try {
							yi = yi.split("-",2)[0];
					} catch(Exception e) {
							 
					}
			}
			else {
					yi = _result.replace(Uri.parse(_result).getLastPathSegment(), "");
					yi = Uri.parse(yi).getLastPathSegment();
											
			}
			new RequestNetwork(SodeActivity.this).startRequestNetwork(RequestNetworkController.GET, "https://api.sabishare.com/token/download/".concat(yi), "", new RequestNetwork.RequestListener() {
							@Override
							public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
									final String _tag = _param1;
									final String _response = _param2;
									final HashMap<String, Object> _responseHeaders = _param3;
					pb.dismiss();
					try {
						map = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
						SketchwareUtil.showMessage(getApplicationContext(), "Link acquired successfully, select any preferred actions now");
					} catch(Exception e) {
						SketchwareUtil.showMessage(getApplicationContext(), "Process failed!");
						return ;
					}
					try {
						links.put("Episode ".concat(String.valueOf((long)(activepos + 1))), ((com.google.gson.internal.LinkedTreeMap<String,Object>)map.get("data")).get("url").toString());
						ff.edit().putString(activeLink, infoImg).commit();
					} catch(Exception e) {
						SketchwareUtil.showMessage(getApplicationContext(), "Process failed!");
						return ;
					}
							}
							
							@Override
							public void onErrorResponse(String _param1, String _param2) {
									final String _tag = _param1;
									final String _message = _param2;
									pb.dismiss();
					SketchwareUtil.showMessage(getApplicationContext(), "Process failed!");
							}
					});
		}
	}
	
	public void _transitionComplete (final View _view, final String _transitionName) {
		_view.setTransitionName(_transitionName);
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
				
				int b = (int)25;
				
				blurred = blurRenderScript(SodeActivity.this,bitmap, b);
				
			}catch(Exception e){}
			
			return blurred;
			
		}
		@Override protected void onPostExecute(Bitmap result) {
			
			info_img_blurred.setImageBitmap(result);
			
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
	
	
	public void _transparentStatusBar () {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.setNavigationBarColor(Color.parseColor("#121212"));
			w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
	}
	
	
	public void _LOGIC_UI () {
		_changeActivityFont("product");
		_rippleRoundStroke(linear17, "#FFFFFF", "#BDBDBD", 10, 0, "#0078FF");
		_rippleRoundStroke(linear19, "#55fFFFFF", "#88BDBDBD", 10, 0, "#0078FF");
		_transparentStatusBar();
		_RippleEffects("#EEEEEE", imageview6);
	}
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
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
	
	
	public ArrayList<HashMap<String, Object>> _getSeason (final String _s) {
		filte.clear();
		for(int j= 0; j < (int)(episode.size()); j++) {
			if (episode.get((int)j).get("season").toString().equals(_s)) {
				json = new Gson().toJson(episode.get((int)(j)));
				map = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>(){}.getType());
				filte.add(map);
			}
		}
		return filte;
	}
	
	
	public void _getEp () {
		pb = new ProgressDialog(SodeActivity.this);
		pb.setMessage("Getting episodes...");
		pb.setCancelable(false);
		pb.show();
		overrideFonts(this, pb.getWindow().getDecorView());
		map = new HashMap<>();
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
		episodes.setHeaders(map);
		episodes.startRequestNetwork(RequestNetworkController.GET, season.get((int)0).get("link").toString(), "new", _episodes_request_listener);
	}
	
	
	public void _closeDialog () {
		if (pb != null) {
			pb.dismiss();
			pb = null;
		}
	}
	
	
	public void _ActivityTranlation (final View _view, final String _transitionName, final Intent _intent) {
		_view.setTransitionName(_transitionName);
		
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(SodeActivity.this, _view, _transitionName);
		        startActivity(_intent, optionsCompat.toBundle());
	}
	
	
	public void _getLink (final double _n) {
		activepos = _n;
		pb = new ProgressDialog(SodeActivity.this);
		pb.setMessage("Please wait...");
		pb.setCancelable(false);
		pb.show();
		activeLink = _getRedirectedUrl(episode.get((int)_n).get("link").toString().concat("/download"));
		new DownloadLink().execute("");
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
	
	
	public String _getRedirectedUrl (final String _s) {
		String s = "";
		try{
					URL url = new URL(_s);
					HttpsURLConnection ucon = (HttpsURLConnection) url.openConnection();
					ucon.setInstanceFollowRedirects(false);
					URL secondURL = new URL(ucon.getHeaderField("Location"));
					URLConnection conn = secondURL.openConnection();
					conn.connect();
					return conn.getURL().toString();
				}catch(Exception _e){
					//	System.out.println(e);
			
			try{
										
									java.net.URLConnection con = new java.net.URL(_s).openConnection();
									
									con.connect();
									
									java.io.InputStream is = con.getInputStream();
									s =  con.getURL().toString();
									is.close();
							}catch(Exception e){
										
							}
		}
				return s;
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
			
			linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)SketchwareUtil.getDip(getApplicationContext(), (int)(10)), 0xFF212121));
			textview1.setText("Episode ".concat(String.valueOf((long)(_position + 1))));
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), 0);
			_RippleEffects("#44ffffff", imageview2);
			_RippleEffects("#44ffffff", imageview3);
			imageview2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (links.containsKey("Episode ".concat(String.valueOf((long)(_position + 1))))) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", links.get("Episode ".concat(String.valueOf((long)(_position + 1)))).toString()));
						SketchwareUtil.showMessage(getApplicationContext(), "Link copied to clipboard!");
					}
					else {
						_getLink(_position);
					}
				}
			});
			imageview3.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					if (links.containsKey("Episode ".concat(String.valueOf((long)(_position + 1))))) {
						startDownload(links.get("Episode ".concat(String.valueOf((long)(_position + 1)))).toString(), getIntent().getStringExtra("name"), "mp4");
					}
					else {
						_getLink(_position);
					}
					return true;
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