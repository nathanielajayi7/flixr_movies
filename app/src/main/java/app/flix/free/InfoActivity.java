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
import java.net.*;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.database.Cursor;
import javax.net.ssl.*;

public class InfoActivity extends  AppCompatActivity  { 
	
	
	private String infoImg = "";
	private String activityFontName = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String ytLink = "";
	private String redirectLink = "";
	private boolean isDownloading = false;
	private double n = 0;
	private  long downloadId = 0;
	private String path = "";
	private String btn_id = "";
	private String IMDb = "";
	private String yi = "";
	
	private ArrayList<HashMap<String, Object>> videoList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> actors = new ArrayList<>();
	private ArrayList<String> links = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> subs = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout background;
	private LinearLayout nested;
	private LinearLayout info_back;
	private LinearLayout line;
	private LinearLayout linear10;
	private LinearLayout layouts_holder;
	private ImageView info_img_blurred;
	private GridView gridview1;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private TextView info_title;
	private LinearLayout linear18;
	private LinearLayout download_info;
	private TextView textview6;
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout linear5;
	private ImageView imageview6;
	private LinearLayout info_image_back;
	private ImageView info_img;
	private TextView textview10;
	private LinearLayout linear17;
	private LinearLayout play_jnfo;
	private ImageView imageview8;
	private TextView textview9;
	private ImageView imageview2;
	private TextView textview2;
	private ImageView imageview7;
	private LoadingDots linear19;
	private TextView textview5;
	private LinearLayout linear11;
	private LinearLayout linear13;
	private LinearLayout episodes_line_back;
	private TextView textview7;
	private LinearLayout episodes_line;
	private LinearLayout more_line_back;
	private TextView textview8;
	private LinearLayout more_line;
	private LinearLayout layout1;
	private LinearLayout layout2;
	private HorizontalListView linear16;
	private SimpleListView listview1;
	
	private RequestNetwork requestRelatedMovies;
	private RequestNetwork.RequestListener _requestRelatedMovies_request_listener;
	private ObjectAnimator oa = new ObjectAnimator();
	private ObjectAnimator oa1 = new ObjectAnimator();
	private RequestNetwork dl;
	private RequestNetwork.RequestListener _dl_request_listener;
	private Intent towatch = new Intent();
	private Intent yt = new Intent();
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private SharedPreferences ff;
	private Intent vlx = new Intent();
	private RequestNetwork imdbj;
	private RequestNetwork.RequestListener _imdbj_request_listener;
	private RequestNetwork download_link;
	private RequestNetwork.RequestListener _download_link_request_listener;
	private RequestNetwork subdl;
	private RequestNetwork.RequestListener _subdl_request_listener;
	private ProgressDialog pb;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.info);
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
		nested = (LinearLayout) findViewById(R.id.nested);
		info_back = (LinearLayout) findViewById(R.id.info_back);
		line = (LinearLayout) findViewById(R.id.line);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		layouts_holder = (LinearLayout) findViewById(R.id.layouts_holder);
		info_img_blurred = (ImageView) findViewById(R.id.info_img_blurred);
		gridview1 = (GridView) findViewById(R.id.gridview1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		info_title = (TextView) findViewById(R.id.info_title);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		download_info = (LinearLayout) findViewById(R.id.download_info);
		textview6 = (TextView) findViewById(R.id.textview6);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		info_image_back = (LinearLayout) findViewById(R.id.info_image_back);
		info_img = (ImageView) findViewById(R.id.info_img);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		play_jnfo = (LinearLayout) findViewById(R.id.play_jnfo);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview9 = (TextView) findViewById(R.id.textview9);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		linear19 = (LoadingDots) findViewById(R.id.linear19);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		episodes_line_back = (LinearLayout) findViewById(R.id.episodes_line_back);
		textview7 = (TextView) findViewById(R.id.textview7);
		episodes_line = (LinearLayout) findViewById(R.id.episodes_line);
		more_line_back = (LinearLayout) findViewById(R.id.more_line_back);
		textview8 = (TextView) findViewById(R.id.textview8);
		more_line = (LinearLayout) findViewById(R.id.more_line);
		layout1 = (LinearLayout) findViewById(R.id.layout1);
		layout2 = (LinearLayout) findViewById(R.id.layout2);
		linear16 = (HorizontalListView) findViewById(R.id.linear16);
		listview1 = (SimpleListView) findViewById(R.id.listview1);
		requestRelatedMovies = new RequestNetwork(this);
		dl = new RequestNetwork(this);
		req = new RequestNetwork(this);
		ff = getSharedPreferences("ff", Activity.MODE_PRIVATE);
		imdbj = new RequestNetwork(this);
		download_link = new RequestNetwork(this);
		subdl = new RequestNetwork(this);
		
		download_info.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				if (!redirectLink.equals("")) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", redirectLink));
				}
				return true;
				}
			 });
		
		download_info.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (androidx.core.content.ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != android.content.pm.PackageManager.PERMISSION_DENIED) {
					if (isDownloading) {
						if (downloadId > 0) {
							try {
								((DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE)).remove(downloadId);
							} catch(Exception e) {
								 
							}
							imageview7.setImageResource(R.drawable.downloads);
							textview5.setText("Download movie");
							downloadId = 0;
							_showCustomSnackBar("Download cancelled!");
							isDownloading = false;
						}
					}
					else {
						if (redirectLink.startsWith("http")) {
							startDownload(redirectLink, getIntent().getStringExtra("name"), "mp4");
							ff.edit().putString(getIntent().getStringExtra("name"), infoImg).commit();
							_showCustomSnackBar("Downloading...");
							isDownloading = _getDownloadStatus();
						}
					}
				}
				else {
					androidx.core.app.ActivityCompat.requestPermissions(InfoActivity.this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
				}
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				supportFinishAfterTransition();
			}
		});
		
		info_img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vlx.setClass(getApplicationContext(), ImageActivity.class);
				vlx.putExtra("image", infoImg);
				try {
					_ActivityTranlation(info_img, "movie", vlx);
				} catch(Exception e) {
					startActivity(vlx);
				}
			}
		});
		
		linear17.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				
				return true;
				}
			 });
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (ytLink.equals("")) {
					com.google.android.material.snackbar.Snackbar.make(vscroll1, "This video does not have a trailer available!", com.google.android.material.snackbar.Snackbar.LENGTH_INDEFINITE)
					.setAction("DISMISS", new OnClickListener() {
						@Override
						public void onClick(View v) {
							 
						}
					}).show();
				}
				else {
					yt.setClass(getApplicationContext(), TrailerActivity.class);
					yt.putExtra("embed", ytLink);
					startActivity(yt);
				}
			}
		});
		
		play_jnfo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!redirectLink.equals("")) {
					towatch.setClass(getApplicationContext(), WatchActivity.class);
					towatch.putExtra("link", redirectLink);
					towatch.putExtra("image", getIntent().getStringExtra("image"));
					if (!subs.isEmpty()) {
						path = FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/Flixr/".concat(getIntent().getStringExtra("name").concat(".srt")));
						if (FileUtil.isExistFile(path)) {
							if (FileUtil.isFile(path)) {
								towatch.putExtra("sub", subs.get((int)0).get("link").toString());
							}
						}
					}
					towatch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(towatch);
					
				}
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_navLineAnim(episodes_line, true, oa);
				_navLineAnim(more_line, false, oa1);
				textview8.setTextColor(0xFF9E9E9E);
				textview7.setTextColor(0xFFFFFFFF);
				layout1.setVisibility(View.VISIBLE);
				layout2.setVisibility(View.GONE);
			}
		});
		
		linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_navLineAnim(more_line, true, oa1);
				_navLineAnim(episodes_line, false, oa);
				textview7.setTextColor(0xFF9E9E9E);
				textview8.setTextColor(0xFFFFFFFF);
				layout1.setVisibility(View.GONE);
				layout2.setVisibility(View.VISIBLE);
			}
		});
		
		_requestRelatedMovies_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
				final Document doc = Jsoup.parse(_response);
				textview6.setText(doc.select("article.post-body").select("p").first().text());
				ytLink = doc.select("article.post-body").select("iframe").first().attr("src");
				try {
					map = new HashMap<>();
					map.put("downloadId", "https://thenetnaija.com" + doc.select("article.post-body").first().getElementsByAttributeValue("title", "Download Subtitle").first().select("a").first().attr("href"));
					map.put("name", getIntent().getStringExtra("name"));
					subs.add(map);
					listview1.setAdapter(new Listview1Adapter(subs));
				} catch(Exception e) {
					 
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_dl_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				Document d = Jsoup.parse(_response);
				
					d = d.normalise();
					//System.out.println(d);
					textview10.setText(d.getElementsByClass("size-number").first().text());
					btn_id = d.getElementsMatchingOwnText("Download").select("button").first().className();
					
												
											//	String _s = d.select("div.file-share").last().child(0).child(0).child(0).child(1).child(0).child(0).child(1).select("input").attr("value");
									//			_s = _s + "?d=1";
											
								//	redirectLink = _s;
								//	textview10.setText(d.getElementsByAttributeValue("class","info-list").first().child(3).text());
									
									
									/*****
new Thread(new Runnable() {
  @Override
  public void run() {
    try {
      URL myUrl = new URL(redirectLink);
      URLConnection urlConnection = myUrl.openConnection();
      urlConnection.connect();
      long file_size = urlConnection.getContentLength();
      
      InfoActivity.this.textview10.setText(String.valueOf(file_size / 1024 / 1024) + "MB");
      
    } catch (java.io.IOException e) {
      e.printStackTrace();
    }
  }
}).start();

*/
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_req_request_listener = new RequestNetwork.RequestListener() {
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
		
		_imdbj_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				Document d = Jsoup.parse(_response);
				try {
					d.select("div.col-xs-12");
				} catch(Exception e) {
					return ;
				}
				actors.clear();
				Elements box = d.select("div.col-xs-12");
							Iterator<Element> in = 
							box.next().select("div").select("div").iterator();
							int i = 0;
							while(in.hasNext()){
									Element e = in.next();
					try{
						e.child(2).child(0).select("li");
					}catch(Exception exc){
						break;
					}
									if(i == 2){
											for(Element n : e.child(2).child(0).
											select("li")){
										map = new HashMap<>();
							
							
											map.put("name", n.text());
											map.put("image", n.selectFirst("a").select("img").attr("src"));
											actors.add(map);
										}
										break;
									}
									i++;
							}
				linear16.setAdapter(new Gridview1Adapter(actors));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_download_link_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try {
					map = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				} catch(Exception e) {
					imageview7.setVisibility(View.VISIBLE);
					download_info.removeView(linear19);
					textview5.setText("Error getting link");
					return ;
				}
				try {
					redirectLink = ((com.google.gson.internal.LinkedTreeMap<String,Object>)map.get("data")).get("url").toString();
					isDownloading = _getDownloadStatus();
					_clear();
				} catch(Exception e) {
					imageview7.setVisibility(View.VISIBLE);
					download_info.removeView(linear19);
					textview5.setText("Error getting link");
					return ;
				}
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_subdl_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				pb.dismiss();
				try {
					map = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				} catch(Exception e) {
					_showCustomSnackBar("Unable to initiate download! :(");
					return ;
				}
				if ((boolean)map.get("status")) {
					btn_id = ((com.google.gson.internal.LinkedTreeMap<String,Object>)map.get("data")).get("url").toString();
					startDownload(btn_id, getIntent().getStringExtra("name"), "srt");
					_showCustomSnackBar("Downloading subtitle...");
				}
				else {
					_showCustomSnackBar("Unable to initiate download! :(");
					return ;
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				try {
					pb.dismiss();
				} catch(Exception e) {
					 
				}
			}
		};
	}
	
	private void initializeLogic() {
		info_img_blurred.setImageResource(R.drawable.divider_line);
		
		linear16.setOnScrollStateChangedListener(new HorizontalListView.OnScrollStateChangedListener(){
									@Override 
									public void onScrollStateChanged(HorizontalListView.OnScrollStateChangedListener.ScrollState s){
												if(s == HorizontalListView.OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE){
										
										vscroll1.requestDisallowInterceptTouchEvent(false);
										//viewPager.requestDisallowInterceptTouchEvent(true);
					//viewPager.beginFakeDrag();
									}else{
										vscroll1.requestDisallowInterceptTouchEvent(true);
										//viewPager.requestDisallowInterceptTouchEvent(true);
												}
									}
						});
		try {
			_transitionComplete(info_img, "movie_img");
		} catch(Exception e) {
			 
		}
		infoImg = getIntent().getStringExtra("image");
		_setImageFromURL(info_img, getIntent().getStringExtra("image"));
		info_title.setText(getIntent().getStringExtra("name"));
		_requestBlurredImage();
		_LOGIC_UI();
		requestRelatedMovies.setHeaders(map);
		requestRelatedMovies.startRequestNetwork(RequestNetworkController.GET, getIntent().getStringExtra("link"), "", _requestRelatedMovies_request_listener);
		dl.setHeaders(map);
		dl.startRequestNetwork(RequestNetworkController.GET, getIntent().getStringExtra("link").concat("/download"), "", _dl_request_listener);
		
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
			return (_getRedirectedUrl(getIntent().getStringExtra("link").concat("/download")));
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
			download_link.startRequestNetwork(RequestNetworkController.GET, "https://api.sabishare.com/token/download/".concat(yi), "link_1", _download_link_request_listener);
		}
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		new DownloadLink().execute("");
		
	}
	public void _LOGIC_UI () {
		_addCardView(info_image_back, 0, SketchwareUtil.getDip(getApplicationContext(), (int)(15)), SketchwareUtil.getDip(getApplicationContext(), (int)(7)), 0, true, "#FFFFFF");
		_changeActivityFont("product");
		_rippleRoundStroke(download_info, "#66EEEEEE", "#B3EEEEEE", 10, 0, "#0078FF");
		_rippleRoundStroke(play_jnfo, "#FFFFFF", "#BDBDBD", 10, 0, "#0078FF");
		_rippleRoundStroke(linear17, "#FFFFFF", "#BDBDBD", 10, 0, "#0078FF");
		_transparentStatusBar();
		_RippleEffects("#EEEEEE", imageview6);
		_setImageViewRipple(imageview7, "#FFFFFF", "#FFFFFF");
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), 0);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), 0);
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
				
				blurred = blurRenderScript(InfoActivity.this,bitmap, b);
				
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
	
	
	public void _removeListViewSelect (final ListView _listview) {
		_listview.setSelector(android.R.color.transparent);
	}
	
	
	public void _addCardView (final View _layoutView, final double _margins, final double _cornerRadius, final double _cardElevation, final double _cardMaxElevation, final boolean _preventCornerOverlap, final String _backgroundColor) {
		androidx.cardview.widget.CardView cv = new androidx.cardview.widget.CardView(this);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		int m = (int)_margins;
		lp.setMargins(m,m,m,m);
		cv.setLayoutParams(lp);
		int c = Color.parseColor(_backgroundColor);
		cv.setCardBackgroundColor(c);
		cv.setRadius((float)_cornerRadius);
		cv.setCardElevation((float)_cardElevation);
		cv.setMaxCardElevation((float)_cardMaxElevation);
		cv.setPreventCornerOverlap(_preventCornerOverlap);
		if(_layoutView.getParent() instanceof LinearLayout){
			ViewGroup vg = ((ViewGroup)_layoutView.getParent());
			vg.removeView(_layoutView);
			vg.removeAllViews();
			vg.addView(cv);
			cv.addView(_layoutView);
		}else{
			
		}
	}
	
	
	public void _RippleEffects (final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#FF757575")}), GG, null);
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
	
	
	public void _transitionComplete (final View _view, final String _transitionName) {
		_view.setTransitionName(_transitionName);
	}
	
	
	public void _transparentStatusBar () {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.setNavigationBarColor(Color.parseColor("#121212"));
			w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
	}
	
	
	public void _setImageFromURL (final ImageView _image, final String _url) {
		Glide.with(this)
		
		.load(_url)
		.apply(new RequestOptions().override(1000, 1000))
		.into(_image);
		
	}
	
	
	public void _setImageViewRipple (final ImageView _imageview, final String _color1, final String _color2) {
		_imageview.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_color1), Color.parseColor(_color2)}));
	}
	
	
	public void _setNestedView (final View _back, final View _nested) {
		((ViewGroup)_nested.getParent()).removeView(_nested);
		androidx.core.widget.NestedScrollView nsv = new androidx.core.widget.NestedScrollView(this);
		
		((LinearLayout)_back).addView(nsv);
		
		nsv.addView(_nested);
	}
	public class MyListView extends android.widget.GridView {
		
		public MyListView(Context a) {
			super(a);
		}
		
		@Override public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec( Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
			super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom);
			ViewGroup.LayoutParams params = getLayoutParams();
			params.height = getMeasuredHeight();
		}
	}
	private void doSomeEmptyShit(){
	}
	
	
	public void _navLineAnim (final View _view, final boolean _choice, final ObjectAnimator _anim) {
		if (_choice) {
			_anim.setTarget(_view);
			_anim.setPropertyName("translationX");
			_anim.setFloatValues((float)(0));
			_anim.setDuration((int)(200));
			_anim.start();
		}
		else {
			_anim.setTarget(_view);
			_anim.setPropertyName("translationX");
			_anim.setFloatValues((float)(-400));
			_anim.setDuration((int)(300));
			_anim.start();
		}
	}
	private void _textToArray (final String _s) {
				final List<String> st = Arrays.asList(_s.split("\\s*,\\s*"));
				for(int j = 0; j < st.size(); j++) {
						
			map = new HashMap<>();
						map.put("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTPokLzKRRLCpzXc5z2YjAjhRqz92URcOxkaw&usqp=CAU");
						map.put("name", st.get((int)(j)));
						actors.add(map);
						linear16.setAdapter(new Gridview1Adapter(actors));
						
				}
			
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
	
	
	public void _setViewRadius (final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor("#" + _color.replace("#", "")));
		
		gd.setCornerRadius((int)_radius);
		
		_view.setBackground(gd);
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
	
	
	public void _watchVLCUrl (final String _s) {
		vlx.setAction(Intent.ACTION_VIEW);
		vlx = getPackageManager().getLaunchIntentForPackage("org.videolan.vlc");
		vlx.putExtra("url", _s);
		vlx.setDataAndTypeAndNormalize(Uri.parse(_s), "video/*");
		vlx.putExtra("title", getIntent().getStringExtra("name"));
		vlx.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
		startActivity(vlx);
	}
	
	
	public boolean _getDownloadStatus () {
		boolean downloading = false;
		
		DownloadManager.Query query = new DownloadManager.Query();
						query.setFilterByStatus(DownloadManager.STATUS_RUNNING|DownloadManager.STATUS_PAUSED|DownloadManager.STATUS_SUCCESSFUL);
						Cursor c = ((DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE)).query(query);
		while(c.moveToNext()) {
			if (getIntent().getStringExtra("name").equals(c.getString(c.getColumnIndex(DownloadManager.COLUMN_TITLE)))) {
				if (c.getString(c.getColumnIndex(DownloadManager.COLUMN_STATUS)).equals(DownloadManager.STATUS_SUCCESSFUL)) {
					imageview7.setVisibility(View.GONE);
					textview5.setText("DOWNLOAD COMPLETE");
					((View)textview5.getParent()).setEnabled(false);
					return true;
				}
				else {
					if (c.getString(c.getColumnIndex(DownloadManager.COLUMN_STATUS)).equals(DownloadManager.STATUS_FAILED)) {
						return false;
					}
					else {
						imageview7.setImageResource(R.drawable.ic_clear_white);
						downloading = true;
						downloadId = new Double(c.getInt(c.getColumnIndex(DownloadManager.COLUMN_ID))).longValue();
						textview5.setText("Cancel download");
					}
				}
			}
			else {
				return false;
			}
		}
		return (downloading);
	}
	
	
	public void _clear () {
		imageview7.setVisibility(View.VISIBLE);
		download_info.removeView(linear19);
		textview5.setText("Download Movie");
	}
	
	
	public void _imdb () {
		map = new HashMap<>();
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
		imdbj.setHeaders(map);
		imdbj.startRequestNetwork(RequestNetworkController.GET, IMDb, "new", _imdbj_request_listener);
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
	
	
	public void _ActivityTranlation (final View _view, final String _transitionName, final Intent _intent) {
		_view.setTransitionName(_transitionName);
		
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(InfoActivity.this, _view, _transitionName);
		        startActivity(_intent, optionsCompat.toBundle());
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
				_view = _inflater.inflate(R.layout.author, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final de.hdodenhof.circleimageview.CircleImageView circleimageview1 = (de.hdodenhof.circleimageview.CircleImageView) _view.findViewById(R.id.circleimageview1);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), 1);
			textview1.setText(_data.get((int)_position).get("name").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("image").toString())).into(circleimageview1);
			
			return _view;
		}
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
			
			imageview2.setVisibility(View.GONE);
			textview1.setText(_data.get((int)_position).get("name").toString().concat(" ".concat("(SRT)")));
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), 0);
			_RippleEffects("#44FFFFFF", imageview3);
			imageview3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_data.get((int)_position).containsKey("downloadId")) {
						if (androidx.core.content.ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != android.content.pm.PackageManager.PERMISSION_DENIED) {
							pb = new ProgressDialog(InfoActivity.this);
							pb.setMessage("Attempting to download subtitle...");
							pb.setCancelable(false);
							pb.show();
							btn_id = _getRedirectedUrl(_data.get((int)_position).get("downloadId").toString());
							overrideFonts(imageview3.getContext(), pb.getWindow().getDecorView());
							subdl.startRequestNetwork(RequestNetworkController.GET, "https://api.sabishare.com/token/download/".concat(android.net.Uri.parse(btn_id).getLastPathSegment()), "getUrl", _subdl_request_listener);
						}
						else {
							androidx.core.app.ActivityCompat.requestPermissions(InfoActivity.this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CLEAR_APP_CACHE}, 1000);
						}
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