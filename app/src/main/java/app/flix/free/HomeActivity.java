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
import android.database.Cursor;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import com.google.android.material.button.*;
import android.widget.EditText;
import com.airbnb.lottie.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.Timer;
import java.util.TimerTask;
import android.speech.SpeechRecognizer;
import android.speech.RecognizerIntent;
import android.speech.RecognitionListener;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.google.gson.Gson;
import android.graphics.Typeface;
import com.bumptech.glide.Glide;
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
import android.content.res.Configuration;
import com.bumptech.glide.request.RequestOptions;
import androidx.appcompat.widget.TooltipCompat;
import androidx.recyclerview.widget.SimpleItemAnimator;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.jsoup.*;
import java.net.*;
import android.database.ContentObserver;
import java.io.*;

public class HomeActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String activityFontName = "";
	private String tempImageUrl = "";
	private double actionBarAnimNum = 0;
	private String featuredImage = "";
	private String featuredName = "";
	private HashMap<String, Object> temp_map = new HashMap<>();
	private HashMap<String, Object> map = new HashMap<>();
	private double height = 0;
	private boolean isPageScrollEnabled = false;
	private HashMap<String, Object> mp = new HashMap<>();
	private boolean downloadListActive = false;
	private  int i = 0;
	private  HashMap<Integer, Long> a;
	private boolean result = false;
	private double pb = 0;
	private double w = 0;
	private double h = 0;
	private String fileName = "";
	private double pp = 0;
	private HashMap<String, Object> o = new HashMap<>();
	private double delete = 0;
	private String uri = "";
	private  DownloadObserver d;
	private HashMap<String, Object> m = new HashMap<>();
	private String title = "";
	
	private ArrayList<HashMap<String, Object>> videosList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> seriesList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> search = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> downloadList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> animeList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> fzList = new ArrayList<>();
	
	private LinearLayout background;
	private LinearLayout bottom_nav;
	private LinearLayout linear3;
	private LinearLayout viewpager_back;
	private LinearLayout action_bar;
	private LinearLayout base;
	private LinearLayout trash;
	private LinearLayout layout1;
	private LinearLayout layout2;
	private LinearLayout layout3;
	private LinearLayout layout4;
	private ScrollView vscroll1;
	private LinearLayout nested;
	private LinearLayout featured;
	private LinearLayout new_view;
	private ImageView featured_image;
	private LinearLayout linear1;
	private TextView featured_title;
	private LinearLayout about_featured_holder;
	private LinearLayout add_to_watch;
	private LinearLayout play_featured;
	private LinearLayout video_info;
	private ImageView imageview3;
	private TextView textview3;
	private ImageView imageview2;
	private TextView textview2;
	private ImageView imageview4;
	private TextView textview4;
	private LinearLayout topselection;
	private HorizontalListView hscroll1;
	private ListView listview1;
	private LinearLayout linear23;
	private LinearLayout linear27;
	private TextView textview30;
	private SimpleListView listview3;
	private GridView gridview1;
	private LinearLayout linear19;
	private HorizontalListView hscroll2;
	private ListView top_select_listview;
	private LinearLayout linear21;
	private TextView textview13;
	private ImageView imageview16;
	private TextView textview5;
	private ImageView imageview18;
	private LinearLayout linear24_hidden;
	private GridView gridview2;
	private LinearLayout linear25;
	private HorizontalListView hscroll3;
	private ListView listview2;
	private LinearLayout linear26;
	private HorizontalListView hscroll4;
	private TextView textview28;
	private ImageView imageview19;
	private TextView textview29;
	private ImageView imageview20;
	private MaterialButton materialbutton2;
	private MaterialButton materialbutton1;
	private LinearLayout search_box;
	private ListView popular_search_list;
	private LinearLayout loading_search;
	private LinearLayout search_result_view;
	private ImageView imageview9;
	private EditText edittext1;
	private ImageView imageview10;
	private LottieAnimationView lottie1;
	private TextView textview14;
	private ListView search_result_listview;
	private TextView textview12;
	private LinearLayout search_result_gridview;
	private LinearLayout linear18;
	private TextView textview27;
	private RecyclerView recyclerview1;
	private ImageView imageview12;
	private TextView textview15;
	private TextView textview16;
	private ScrollView vscroll2;
	private LinearLayout linear17;
	private LinearLayout linear12;
	private LinearLayout linear14;
	private TextView textview24;
	private TextView textview25;
	private TextView textview26;
	private ImageView imageview14;
	private LinearLayout linear13;
	private TextView textview18;
	private TextView textview19;
	private LinearLayout linear15;
	private TextView textview21;
	private LinearLayout linear16;
	private ImageView imageview15;
	private TextView textview20;
	private TextView textview22;
	private TextView textview23;
	private ImageView imageview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private ImageView imageview6;
	private TextView textview9;
	private ImageView imageview7;
	private TextView textview10;
	private ImageView imageview8;
	private TextView textview11;
	private ImageView imageview13;
	private TextView textview17;
	
	private TimerTask timer;
	private RequestNetwork request;
	private RequestNetwork.RequestListener _request_request_listener;
	private SpeechRecognizer speechtext;
	private Intent toinfo = new Intent();
	private RequestNetwork requestSearch;
	private RequestNetwork.RequestListener _requestSearch_request_listener;
	private Intent towatch = new Intent();
	private Intent toauth = new Intent();
	private RequestNetwork series;
	private RequestNetwork.RequestListener _series_request_listener;
	private RequestNetwork dl;
	private RequestNetwork.RequestListener _dl_request_listener;
	private Intent more = new Intent();
	private SharedPreferences ff;
	private TimerTask t;
	private ProgressDialog p;
	private DatabaseReference users = _firebase.getReference("users/userInformation");
	private ChildEventListener _users_child_listener;
	private FirebaseAuth auth;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private Intent vlx = new Intent();
	private RequestNetwork r;
	private RequestNetwork.RequestListener _r_request_listener;
	private RequestNetwork music;
	private RequestNetwork.RequestListener _music_request_listener;
	private RequestNetwork fz;
	private RequestNetwork.RequestListener _fz_request_listener;
	private TimerTask time;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
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
		
		background = (LinearLayout) findViewById(R.id.background);
		bottom_nav = (LinearLayout) findViewById(R.id.bottom_nav);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		viewpager_back = (LinearLayout) findViewById(R.id.viewpager_back);
		action_bar = (LinearLayout) findViewById(R.id.action_bar);
		base = (LinearLayout) findViewById(R.id.base);
		trash = (LinearLayout) findViewById(R.id.trash);
		layout1 = (LinearLayout) findViewById(R.id.layout1);
		layout2 = (LinearLayout) findViewById(R.id.layout2);
		layout3 = (LinearLayout) findViewById(R.id.layout3);
		layout4 = (LinearLayout) findViewById(R.id.layout4);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		nested = (LinearLayout) findViewById(R.id.nested);
		featured = (LinearLayout) findViewById(R.id.featured);
		new_view = (LinearLayout) findViewById(R.id.new_view);
		featured_image = (ImageView) findViewById(R.id.featured_image);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		featured_title = (TextView) findViewById(R.id.featured_title);
		about_featured_holder = (LinearLayout) findViewById(R.id.about_featured_holder);
		add_to_watch = (LinearLayout) findViewById(R.id.add_to_watch);
		play_featured = (LinearLayout) findViewById(R.id.play_featured);
		video_info = (LinearLayout) findViewById(R.id.video_info);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview4 = (TextView) findViewById(R.id.textview4);
		topselection = (LinearLayout) findViewById(R.id.topselection);
		hscroll1 = (HorizontalListView) findViewById(R.id.hscroll1);
		listview1 = (ListView) findViewById(R.id.listview1);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		textview30 = (TextView) findViewById(R.id.textview30);
		listview3 = (SimpleListView) findViewById(R.id.listview3);
		gridview1 = (GridView) findViewById(R.id.gridview1);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		hscroll2 = (HorizontalListView) findViewById(R.id.hscroll2);
		top_select_listview = (ListView) findViewById(R.id.top_select_listview);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		textview13 = (TextView) findViewById(R.id.textview13);
		imageview16 = (ImageView) findViewById(R.id.imageview16);
		textview5 = (TextView) findViewById(R.id.textview5);
		imageview18 = (ImageView) findViewById(R.id.imageview18);
		linear24_hidden = (LinearLayout) findViewById(R.id.linear24_hidden);
		gridview2 = (GridView) findViewById(R.id.gridview2);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		hscroll3 = (HorizontalListView) findViewById(R.id.hscroll3);
		listview2 = (ListView) findViewById(R.id.listview2);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		hscroll4 = (HorizontalListView) findViewById(R.id.hscroll4);
		textview28 = (TextView) findViewById(R.id.textview28);
		imageview19 = (ImageView) findViewById(R.id.imageview19);
		textview29 = (TextView) findViewById(R.id.textview29);
		imageview20 = (ImageView) findViewById(R.id.imageview20);
		materialbutton2 = (MaterialButton) findViewById(R.id.materialbutton2);
		materialbutton1 = (MaterialButton) findViewById(R.id.materialbutton1);
		search_box = (LinearLayout) findViewById(R.id.search_box);
		popular_search_list = (ListView) findViewById(R.id.popular_search_list);
		loading_search = (LinearLayout) findViewById(R.id.loading_search);
		search_result_view = (LinearLayout) findViewById(R.id.search_result_view);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		lottie1 = (LottieAnimationView) findViewById(R.id.lottie1);
		textview14 = (TextView) findViewById(R.id.textview14);
		search_result_listview = (ListView) findViewById(R.id.search_result_listview);
		textview12 = (TextView) findViewById(R.id.textview12);
		search_result_gridview = (LinearLayout) findViewById(R.id.search_result_gridview);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		textview27 = (TextView) findViewById(R.id.textview27);
		recyclerview1 = (RecyclerView) findViewById(R.id.recyclerview1);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		textview15 = (TextView) findViewById(R.id.textview15);
		textview16 = (TextView) findViewById(R.id.textview16);
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		textview24 = (TextView) findViewById(R.id.textview24);
		textview25 = (TextView) findViewById(R.id.textview25);
		textview26 = (TextView) findViewById(R.id.textview26);
		imageview14 = (ImageView) findViewById(R.id.imageview14);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		textview18 = (TextView) findViewById(R.id.textview18);
		textview19 = (TextView) findViewById(R.id.textview19);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		textview21 = (TextView) findViewById(R.id.textview21);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		textview20 = (TextView) findViewById(R.id.textview20);
		textview22 = (TextView) findViewById(R.id.textview22);
		textview23 = (TextView) findViewById(R.id.textview23);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview9 = (TextView) findViewById(R.id.textview9);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview10 = (TextView) findViewById(R.id.textview10);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview11 = (TextView) findViewById(R.id.textview11);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		textview17 = (TextView) findViewById(R.id.textview17);
		request = new RequestNetwork(this);
		speechtext = SpeechRecognizer.createSpeechRecognizer(this);
		requestSearch = new RequestNetwork(this);
		series = new RequestNetwork(this);
		dl = new RequestNetwork(this);
		ff = getSharedPreferences("ff", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		r = new RequestNetwork(this);
		music = new RequestNetwork(this);
		fz = new RequestNetwork(this);
		
		add_to_watch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								//code
								time.cancel();
							}
						});
					}
				};
				_timer.schedule(time, (int)(300));
			}
		});
		
		play_featured.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (true) {
					return ;
				}
				if (temp_map.containsKey("link")) {
					if (temp_map.containsKey("watch")) {
						towatch = new Intent();
						towatch.setClass(getApplicationContext(), WatchActivity.class);
						towatch.putExtra("link", temp_map.get("watch").toString());
						towatch.putExtra("image", temp_map.get("image").toString());
						startActivity(towatch);
						
					}
					else {
						p = new ProgressDialog(HomeActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
						p.setMessage("Please wait...");
						p.setCancelable(false);
						p.show();
						map = new HashMap<>();
						map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
						dl.setHeaders(map);
						dl.startRequestNetwork(RequestNetworkController.GET, temp_map.get("link").toString().concat("/download"), "new", _dl_request_listener);
					}
				}
			}
		});
		
		video_info.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!temp_map.isEmpty()) {
					toinfo.setClass(getApplicationContext(), InfoActivity.class);
					toinfo.putExtra("image", temp_map.get("image").toString());
					toinfo.putExtra("link", temp_map.get("link").toString());
					toinfo.putExtra("name", temp_map.get("name").toString());
					_transitionManager(featured_image, "movie_img", toinfo);
				}
			}
		});
		
		imageview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!seriesList.isEmpty()) {
					more.setClass(getApplicationContext(), MoreActivity.class);
					more.putExtra("type", "movie");
					more.putExtra("json", new Gson().toJson(videosList));
					more.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(more);
				}
			}
		});
		
		imageview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!seriesList.isEmpty()) {
					more.setClass(getApplicationContext(), MoreActivity.class);
					more.putExtra("type", "series");
					more.putExtra("json", new Gson().toJson(seriesList));
					more.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(more);
				}
			}
		});
		
		imageview19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_showCustomSnackBar("Coming soon!");
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vlx.setAction(Intent.ACTION_VIEW);
				vlx.setData(Uri.parse("https://dashboard.flutterwave.com/donate/8rsnmwlls6hy"));
				startActivity(vlx);
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent().setClass(getApplicationContext(), AdvancedSearchActivity.class));
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_performSearch(edittext1.getText().toString());
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.trim().equals("")) {
					popular_search_list.setVisibility(View.VISIBLE);
					search_result_view.setVisibility(View.GONE);
				}
				else {
					
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent _intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				_intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
				_intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
				_intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
				speechtext.startListening(_intent);
				SketchwareUtil.showMessage(getApplicationContext(), "Please speak now");
			}
		});
		
		textview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewPager.setCurrentItem(0);
			}
		});
		
		textview24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		textview25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		textview26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FirebaseAuth.getInstance().signOut();
				toauth.setClass(getApplicationContext(), AuthActivity.class);
				startActivity(toauth);
				finish();
			}
		});
		
		textview23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview22.getText().toString()));
				_showCustomSnackBar("URL copied!");
			}
		});
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_transitionViewTime(action_bar, 200);
				textview6.setVisibility(View.VISIBLE);
				textview7.setVisibility(View.GONE);
				textview8.setVisibility(View.GONE);
			}
		});
		
		textview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_transitionViewTime(action_bar, 200);
				textview6.setVisibility(View.GONE);
				textview7.setVisibility(View.VISIBLE);
				textview8.setVisibility(View.GONE);
			}
		});
		
		textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_transitionViewTime(action_bar, 200);
				textview6.setVisibility(View.GONE);
				textview7.setVisibility(View.GONE);
				textview8.setVisibility(View.VISIBLE);
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewPager.setCurrentItem(0);
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewPager.setCurrentItem(1);
			}
		});
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewPager.setCurrentItem(2);
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewPager.setCurrentItem(3);
			}
		});
		
		_request_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				videosList.clear();
									final Document d = Jsoup.parse(_response);
											
										for(Element n : d.selectFirst("div.video-files").select("article")){
								System.out.println(n);
											mp = new HashMap<>();
											mp.put("image", n.selectFirst("img").attr("src").toString());
											mp.put("name", n.selectFirst("img").attr("title"));
											mp.put("link", n.getElementsByAttribute("href").first().attr("href").toString());
											mp.put("date", "2021");
											if (mp.containsKey("image") && !mp.get("image").toString().equals("")) {
												videosList.add(mp);
												}
											
									}
				temp_map = videosList.get((int)SketchwareUtil.getRandom((int)(0), (int)(videosList.size() - 1)));
				_setImageFromURL(featured_image, temp_map.get("image").toString());
				featured_title.setText(temp_map.get("name").toString());
				hscroll2.setAdapter(new Gridview1Adapter(videosList));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		speechtext.setRecognitionListener(new RecognitionListener() {
			@Override
			public void onReadyForSpeech(Bundle _param1) {
			}
			@Override
			public void onBeginningOfSpeech() {
			}
			@Override
			public void onRmsChanged(float _param1) {
			}
			@Override
			public void onBufferReceived(byte[] _param1) {
			}
			@Override
			public void onEndOfSpeech() {
			}
			@Override
			public void onPartialResults(Bundle _param1) {
			}
			@Override
			public void onEvent(int _param1, Bundle _param2) {
			}
			@Override
			public void onResults(Bundle _param1) {
				final ArrayList<String> _results = _param1.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
				final String _result = _results.get(0);
				edittext1.setText(_result);
				speechtext.stopListening();
			}
			
			@Override
			public void onError(int _param1) {
				final String _errorMessage;
				switch (_param1) {
					case SpeechRecognizer.ERROR_AUDIO:
					_errorMessage = "audio error";
					break;
					case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
					_errorMessage = "speech timeout";
					break;
					case SpeechRecognizer.ERROR_NO_MATCH:
					_errorMessage = "speech no match";
					break;
					case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
					_errorMessage = "recognizer busy";
					break;
					case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
					_errorMessage = "recognizer insufficient permissions";
					break;
					default:
					_errorMessage = "recognizer other error";
					break;
				}
				
			}
		});
		
		_requestSearch_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				search.clear();
				try {
					
final Document d = Jsoup.parse(_response);
											for(Element e : d.selectFirst("div.search-results").select("article")){
									
									String link = e.getElementsByAttribute("href").first().attr("href");
									if(link.contains("movie") && !link.contains("season") || link.contains("series") && !link.contains("season")){
										//	System.out.println(link);
											String title = e.getElementsByAttribute("href").first().text().split(":", 2)[1].trim();
											String imageLink = e.getElementsByAttribute("src").first().attr("src");
							
							if (!link.contains("nollywood")) {
								if (!link.contains("episode")) {
									mp = new HashMap<>();
									mp.put("link", link);
									mp.put("name", title);
									mp.put("image", imageLink);
									mp.put("movie", _getType(mp));
									if (_isValidElement(mp.get("link").toString())) {
										search.add(mp);
									}
								}
							}
						}
						
						
					}
				} catch(Exception e) {
					
 
				}
				popular_search_list.setAdapter(new Popular_search_listAdapter(search));
				search_result_view.setVisibility(View.GONE);
				popular_search_list.setVisibility(View.VISIBLE);
				loading_search.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_series_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				seriesList.clear();
									final Document d = Jsoup.parse(_response);
											
										for(Element n : d.selectFirst("div.video-files").select("article")){
								System.out.println(n);
											mp = new HashMap<>();
											mp.put("image", n.selectFirst("img").attr("src").toString());
											mp.put("name", n.selectFirst("img").attr("title"));
											mp.put("link", n.getElementsByAttribute("href").first().attr("href").toString());
											mp.put("date", "2021");
											if (mp.containsKey("image") && !mp.get("image").toString().equals("")) {
												seriesList.add(mp);
												}
											
									}
				hscroll1.setAdapter(new Gridview1Adapter(seriesList));
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
				towatch = new Intent();
				p.dismiss();
				towatch.setClass(getApplicationContext(), WatchActivity.class);
				towatch.putExtra("link", Jsoup.parse(_response).select("div.file-share").last().child(0).child(0).child(0).child(1).child(0).child(0).child(1).select("input").attr("value") + "?d=1");
				towatch.putExtra("image", temp_map.get("image").toString());
				temp_map.put("watch", Jsoup.parse(_response).select("div.file-share").last().child(0).child(0).child(0).child(1).child(0).child(0).child(1).select("input").attr("value") + "?d=1");
				try {
					
startActivity(towatch);
				} catch(Exception e) {
					

					more.putExtra("error", e.toString());
					startActivity(more);
				}
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					if (_childValue.get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
						textview18.setText(_childValue.get("name").toString());
						textview19.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		users.addChildEventListener(_users_child_listener);
		
		_r_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				animeList.clear();
				try {
					
final Document d = Jsoup.parse(_response);
					for(Element _e : d.getElementsByAttributeValue("class", "movie-preview-content")){
						map = new HashMap<>();
						map.put("anime_id", _e.child(0).child(1).select("a").attr("href"));
						map.put("anime_cover_image_url", _e.child(0).child(1).select("a").select("img").attr("src"));
						map.put("anime_name", _e.child(1).getElementsByAttributeValue("class","movie-title").text());
						map.put("anime_story", _e.child(1).getElementsByAttributeValue("class","story").text());
						animeList.add(map);
					}
				} catch(Exception e) {
					
return;
				}
				
				hscroll3.setAdapter(new Search_result_listviewAdapter(animeList));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_music_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				mList.clear();
				final Document d = Jsoup.parse(_response);
				for(Element e : d.getElementsByAttributeValue("class","a-file")){
					if (!e.select("div.image").select("img").attr("src").toString().equals("")) {
						m = new HashMap<>();
						m.put("image", e.select("div.image").select("img").attr("src").toString());
						m.put("name", e.select("div.info").select("h3.file-name").text());
						m.put("link", e.select("div.info").select("h3.file-name").select("a").attr("href").toString());
						m.put("prod", e.select("aside.other-info").text());
						try{
							m.put("artist", e.select("div.info").select("h3.file-name").text().split("-")[0].trim());
						}catch(Exception _e){
							m.put("artist", e.select("div.info").select("h3.file-name").text());
						}
						if (m.get("name").toString().contains("Album:")) {
							m.put("name", m.get("name").toString().replace("Album: ", ""));
							m.put("prod", m.get("prod").toString().replace("Album: ", ""));
							m.put("artist", m.get("artist").toString().replace("Album: ", ""));
							m.put("album", true);
						}
						mList.add(m);
					}
				}
				hscroll4.setAdapter(new Gridview1Adapter(mList));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_fz_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _response));
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		map = new HashMap<>();
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
		request.setHeaders(map);
		request.startRequestNetwork(RequestNetworkController.GET, "https://www.thenetnaija.com/videos/movies", "new", _request_request_listener);
		series.setHeaders(map);
		series.startRequestNetwork(RequestNetworkController.GET, "https://www.thenetnaija.com/videos/series", "new", _series_request_listener);
		
		_viewPagerStuff();
		_LOGIC_UI();
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			textview19.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
		}
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		recyclerview1.setHasFixedSize(true);
		((View)imageview9.getParent()).setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)8, 0xFF212121));
		
		
		recyclerview1.setItemAnimator(null);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		/*
((SimpleItemAnimator)recyclerview1.getItemAnimator()).setSupportsChangeAnimations(false);
		
*/
		
		
		
		
	}
	
	private double SPACE_KB = 1024;
	private double SPACE_MB = 1024 * SPACE_KB;
		private double SPACE_GB = 1024 * SPACE_MB;
		private double SPACE_TB = 1024 * SPACE_GB;
	
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
	public void onBackPressed() {
		if ((textview6.getVisibility() == View.GONE)) {
			_transitionViewTime(action_bar, 400);
			textview6.setVisibility(View.VISIBLE);
			textview7.setVisibility(View.VISIBLE);
			textview8.setVisibility(View.VISIBLE);
		}
		else {
			if ((textview7.getVisibility() == View.GONE)) {
				_transitionViewTime(action_bar, 400);
				textview6.setVisibility(View.VISIBLE);
				textview7.setVisibility(View.VISIBLE);
				textview8.setVisibility(View.VISIBLE);
			}
			else {
				if ((textview8.getVisibility() == View.GONE)) {
					_transitionViewTime(action_bar, 400);
					textview6.setVisibility(View.VISIBLE);
					textview7.setVisibility(View.VISIBLE);
					textview8.setVisibility(View.VISIBLE);
				}
				else {
					finishAffinity();
				}
			}
		}
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		_scrollListener();
		downloadList = _getDownloadsToArray();
		d = new DownloadObserver(new Handler(Looper.getMainLooper()));
		
		Uri myDownloads = Uri.parse( "content://downloads/my_downloads" );
		getContentResolver().registerContentObserver(myDownloads, true, d);
		recyclerview1.setAdapter(new Recyclerview1Adapter(downloadList));
		if (downloadList.isEmpty()) {
			linear18.setVisibility(View.VISIBLE);
			recyclerview1.setVisibility(View.GONE);
		}
		else {
			recyclerview1.setVisibility(View.VISIBLE);
			linear18.setVisibility(View.GONE);
			recyclerview1.getAdapter().notifyDataSetChanged();
		}
		if (seriesList.isEmpty()) {
			for(int _repeat10 = 0; _repeat10 < (int)(10); _repeat10++) {
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("h", "h");
					videosList.add(_item);
				}
				
			}
			hscroll2.setAdapter(new Gridview1Adapter(videosList));
			hscroll1.setAdapter(new Gridview1Adapter(videosList));
			hscroll3.setAdapter(new Search_result_listviewAdapter(videosList));
			hscroll4.setAdapter(new Gridview1Adapter(videosList));
		}
		hscroll2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
								final int _position = _param3;
								

				if (videosList.get((int)_position).containsKey("link")) {
					toinfo.setClass(getApplicationContext(), InfoActivity.class);
					toinfo.putExtra("image", videosList.get((int)_position).get("image").toString());
					toinfo.putExtra("link", videosList.get((int)_position).get("link").toString());
					toinfo.putExtra("name", videosList.get((int)_position).get("name").toString());
					try {
						
_transitionManager(hscroll2.getChildAt(_position).findViewById(R.id.imageview1), "movie_img", toinfo);
					} catch(Exception e) {
						
startActivity(toinfo);
					}
				}
			}
		});
		hscroll1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
								final int _position = _param3;
								
toinfo = new Intent();
				if (!seriesList.isEmpty()) {
					if (seriesList.get((int)_position).containsKey("link")) {
						toinfo.setClass(getApplicationContext(), SodeActivity.class);
						toinfo.putExtra("image", seriesList.get((int)_position).get("image").toString());
						toinfo.putExtra("link", seriesList.get((int)_position).get("link").toString());
						toinfo.putExtra("name", seriesList.get((int)_position).get("name").toString());
						try {
							
_transitionManager(hscroll1.getChildAt(_position).findViewById(R.id.imageview1), "movie_img", toinfo);
						} catch(Exception e) {
							
startActivity(toinfo);
						}
					}
				}
			}
		});
	}
	
	@Override
	public void onPause() {
		super.onPause();
		try {
			
			getContentResolver().unregisterContentObserver(d);
		} catch(Exception e) {
			
 
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		try {
			
Uri myDownloads = Uri.parse( "content://downloads/my_downloads" );
			getContentResolver().registerContentObserver(myDownloads, true, d);
		} catch(Exception e) {
			
 
		}
	}
	
	@Override
	protected void onPostCreate(Bundle _savedInstanceState) {
		super.onPostCreate(_savedInstanceState);
		
		
		hscroll3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
								final int _position = _param3;
								

				if (!animeList.isEmpty()) {
					if (animeList.get((int)_position).containsKey("anime_id")) {
						more.setClass(getApplicationContext(), AnimeTvActivity.class);
						more.putExtra("json", new Gson().toJson(animeList.get((int)(_position))));
						more.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(more);
					}
				}
			}
		});
		
		hscroll4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
								final int _position = _param3;
								

				_show();
				
			}
		});
	}
	public void _LOGIC_UI () {
		vscroll1.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
		_transparentStatusBar();
		_changeActivityFont("product");
		_appFont();
		_removeScollBar(vscroll1);
		_removeScollBar(hscroll1);
		_removeScollBar(hscroll2);
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						action_bar.setTranslationY((float)(40 - background.getMeasuredHeight()));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(0), (int)(500));
		_RippleEffects("#FFFFFF", add_to_watch);
		_RippleEffects("#FFFFFF", video_info);
		_removeScollBar(popular_search_list);
		_set_imeGo_Click(edittext1, imageview9);
		_removeListViewSelect(popular_search_list);
		_setClippedView(imageview14, "#000000", 15, 1);
		_rippleRoundStroke(play_featured, "#FFFFFF", "#BDBDBD", 15, 0, "#0078FF");
		_rippleRoundStroke(linear7, "#121212", "#000000", 0, 0, "#0078FF");
		_rippleRoundStroke(linear8, "#121212", "#000000", 0, 0, "#0078FF");
		_rippleRoundStroke(linear9, "#121212", "#000000", 0, 0, "#0078FF");
		_rippleRoundStroke(linear10, "#121212", "#000000", 0, 0, "#0078FF");
		_rippleRoundStroke(textview16, "#FFFFFF", "#EEEEEE", 15, 0, "#0078FF");
		_rippleRoundStroke(textview24, "#000000", "#BDBDBD", 0, 0, "#0078FF");
		_rippleRoundStroke(textview25, "#000000", "#BDBDBD", 0, 0, "#0078FF");
		_rippleRoundStroke(textview26, "#000000", "#BDBDBD", 0, 0, "#0078FF");
		_rippleRoundStroke(imageview12, "#333333", "#000000", 800, 0, "#0078FF");
		_rippleRoundStroke(imageview16, "#333333", "#000000", 800, 0, "#0078FF");
		_rippleRoundStroke(imageview18, "#333333", "#000000", 800, 0, "#0078FF");
		_rippleRoundStroke(imageview19, "#333333", "#000000", 800, 0, "#0078FF");
		_rippleRoundStroke(imageview20, "#333333", "#000000", 800, 0, "#0078FF");
		textview27.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), Typeface.NORMAL);
	}
	
	
	public void _transparentStatusBar () {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.setNavigationBarColor(Color.parseColor("#121212"));
			w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
	}
	
	
	public void _setViewRadius (final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor("#" + _color.replace("#", "")));
		
		gd.setCornerRadius((int)_radius);
		
		_view.setBackground(gd);
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
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#FF757575")}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _RippleEffects (final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _appFont () {
		featured_title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), Typeface.NORMAL);
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), Typeface.NORMAL);
	}
	
	
	public void _transitionViewTime (final View _view, final double _duration) {
		LinearLayout viewgroup = (LinearLayout)_view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((short)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _setClippedView (final View _view, final String _color1, final double _radius, final double _elevation) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color1));
		
		gd.setCornerRadius((int)_radius);
		
		_view.setBackground(gd);
		_view.setElevation((int)_elevation);
		_view.setClipToOutline(true);
	}
	
	
	public void _rootViewPager () {
	}
	CustomViewPager viewPager;
	
	private class MyPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
		public int getCount() {
			return 4;
		}
		
		@Override public Object instantiateItem(ViewGroup collection, int position) {
			
			LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = inflater.inflate(R.layout.empty, null);
			
			LinearLayout container = (LinearLayout) v.findViewById(R.id.linear1);
			
			if (position == 0) {
				ViewGroup parent = (ViewGroup) layout1.getParent();
				if (parent != null) {
					parent.removeView(layout1);
				}container.addView(layout1);
				
			} else if (position == 1) {
				ViewGroup parent = (ViewGroup) layout2.getParent();
				if (parent != null) {
					parent.removeView(layout2);
				}
				container.addView(layout2);
				
				
			} else if (position == 2) {
				ViewGroup parent = (ViewGroup) layout3.getParent();
				if (parent != null) {
					parent.removeView(layout3);
				}
				container.addView(layout3);
				
				
			} else if (position == 3) {
				ViewGroup parent = (ViewGroup) layout4.getParent();
				if (parent != null) {
					parent.removeView(layout4);
				}
				container.addView(layout4);
			}
			
			collection.addView(v, 0);
			return v;
		}
		@Override public void destroyItem(ViewGroup collection, int position, Object view) {
			collection.removeView((View) view);
			trash.addView((View) view);
		}
		@Override public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == ((View) arg1);}
		@Override public Parcelable saveState() {
			return null;
		}
	}
	private void doNothingVp() {
	}
	
	
	public void _viewPagerStuff () {
		viewPager = new CustomViewPager(this);
		
		viewPager.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		MyPagerAdapter adapter = new MyPagerAdapter();
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);
		base.addView(viewPager);
		viewPager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.OnPageChangeListener() {
			public void onPageSelected(int position) {
				if (viewPager.getCurrentItem() == 2) {
					_startTimer();
				}
				else {
					_stopTimer();
				}
				if (viewPager.getCurrentItem() == 0) {
					downloadListActive = false;
					action_bar.setVisibility(View.VISIBLE);
					action_bar.setEnabled(true);
					textview9.setTextColor(0xFFFFFFFF);
					textview10.setTextColor(0xFF9E9E9E);
					textview11.setTextColor(0xFF9E9E9E);
					textview17.setTextColor(0xFF9E9E9E);
					_ICC(imageview6, "#D81F26", "#D81F26");
					_ICC(imageview7, "#757575", "#757575");
					_ICC(imageview8, "#757575", "#757575");
					_ICC(imageview13, "#757575", "#757575");
				}
				else {
					if (viewPager.getCurrentItem() == 1) {
						downloadListActive = false;
						action_bar.setVisibility(View.INVISIBLE);
						action_bar.setEnabled(false);
						textview9.setTextColor(0xFF9E9E9E);
						textview10.setTextColor(0xFFFFFFFF);
						textview11.setTextColor(0xFF9E9E9E);
						textview17.setTextColor(0xFF9E9E9E);
						_ICC(imageview6, "#757575", "#757575");
						_ICC(imageview7, "#D81F26", "#D81F26");
						_ICC(imageview8, "#757575", "#757575");
						_ICC(imageview13, "#757575", "#757575");
					}
					else {
						if (viewPager.getCurrentItem() == 2) {
							downloadListActive = true;
							action_bar.setVisibility(View.INVISIBLE);
							action_bar.setEnabled(false);
							textview9.setTextColor(0xFF9E9E9E);
							textview10.setTextColor(0xFF9E9E9E);
							textview11.setTextColor(0xFFFFFFFF);
							textview17.setTextColor(0xFF9E9E9E);
							_ICC(imageview6, "#757575", "#757575");
							_ICC(imageview7, "#757575", "#757575");
							_ICC(imageview8, "#D81F26", "#D81F26");
							_ICC(imageview13, "#757575", "#757575");
						}
						else {
							if (viewPager.getCurrentItem() == 3) {
								downloadListActive = false;
								action_bar.setVisibility(View.INVISIBLE);
								action_bar.setEnabled(false);
								textview9.setTextColor(0xFF9E9E9E);
								textview10.setTextColor(0xFF9E9E9E);
								textview11.setTextColor(0xFF9E9E9E);
								textview17.setTextColor(0xFFFFFFFF);
								_ICC(imageview6, "#757575", "#757575");
								_ICC(imageview7, "#757575", "#757575");
								_ICC(imageview8, "#757575", "#757575");
								_ICC(imageview13, "#D81F26", "#D81F26");
							}
						}
					}
				}
			}
			@Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}
			@Override public void onPageScrollStateChanged(int state) {
				
			}
		});
	}
	
	
	public void _NavStatusBarColor (final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public void _set_imeGo_Click (final TextView _edit, final View _view) {
		_edit.setOnEditorActionListener(new EditText.OnEditorActionListener() {
			
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_DONE || actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
					_view.performClick();
					return true;
				}
				return false;
			}});
	}
	
	
	public void _searchResultGridview () {
		GridView gridview3 = new GridView(HomeActivity.this); gridview3.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT));
		float scalefactor = getResources().getDisplayMetrics().density * 120;
		
		int number = getWindowManager().getDefaultDisplay().getWidth();
		
		int columns = (int) ((float) number / (float) scalefactor);
		
		gridview3.setNumColumns(columns);
		gridview3.setColumnWidth(GridView.AUTO_FIT);
		gridview3.setVerticalSpacing(5); gridview3.setHorizontalSpacing(5); gridview3.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
		gridview3.setSelector(android.R.color.transparent);
		gridview3.setVerticalScrollBarEnabled(false);
		gridview3.setAdapter(new Search_result_listviewAdapter(videosList));
		search_result_gridview.addView(gridview3);
		search_result_gridview.removeAllViews();
		search_result_gridview.addView(gridview3);
	}
	
	
	public void _setInputLimit (final TextView _edittext, final double _limit) {
		_edittext.setFilters(new InputFilter[] {new InputFilter.LengthFilter((int)_limit)});
	}
	
	
	public void _removeListViewSelect (final ListView _listview) {
		_listview.setSelector(android.R.color.transparent);
	}
	
	
	public void _performSearch (final String _value) {
		if (_value.trim().equals("")) {
			search_result_view.setVisibility(View.GONE);
			popular_search_list.setVisibility(View.VISIBLE);
			loading_search.setVisibility(View.GONE);
		}
		else {
			map = new HashMap<>();
			map.put("User-Agent", "Mozilla/5.0 (Linux; Android 9; Nokia 2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36");
			requestSearch.setHeaders(map);
			requestSearch.startRequestNetwork(RequestNetworkController.GET, "https://www.thenetnaija.com/search?t=".concat(_value.replaceAll("\\s","+").substring(0, _value.length() - 1).concat("&folder=videos")), "new", _requestSearch_request_listener);
			search_result_view.setVisibility(View.GONE);
			popular_search_list.setVisibility(View.GONE);
			loading_search.setVisibility(View.VISIBLE);
		}
		try {
			
SketchwareUtil.hideKeyboard(getApplicationContext());
		} catch(Exception e) {
			
 
		}
	}
	
	
	public void _transitionManager (final View _view, final String _transitionName, final Intent _intent) {
		_view.setTransitionName(_transitionName);
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(this, _view, _transitionName); startActivity(_intent, optionsCompat.toBundle());
	}
	
	
	public void _transitionComplete (final View _view, final String _transitionName) {
		_view.setTransitionName(_transitionName);
	}
	
	
	public void _setImageFromURL (final ImageView _image, final String _url) {
		Glide.with(this)
		
		.load(_url)
		.apply(new RequestOptions().override(1000, 1000))
		.into(_image);
		
	}
	

	@RequiresApi(api = Build.VERSION_CODES.O)
	public void _setToolTip (final View _view, final String _msg) {
		// add this to import androidx.appcompat.widget.TooltipCompat
		try {
			if (Double.parseDouble(android.os.Build.VERSION.SDK) >= 28) {
				_view.setTooltipText(_msg);
			}
			else {
				if (Double.parseDouble(android.os.Build.VERSION.SDK) < 28) {
					TooltipCompat.setTooltipText(_view, _msg);
				}
			}
		} catch(Exception e) {
		}
	}
	
	private static int pauseDownload(Context context, long downloadId) {
		        if (downloadId >= 0) {
			            try {
				                ContentResolver mResolver = context.getContentResolver();
				                Uri mBaseUri = Uri.parse("content://downloads/my_downloads");
				                ContentValues values = new ContentValues();
				                //values.put(Downloads.Impl.COLUMN_CONTROL, Downloads.Impl.CONTROL_PAUSED);
				                //values.put(Downloads.Impl.COLUMN_STATUS, Downloads.Impl.STATUS_PAUSED_BY_APP);
				                values.put("control", 1);
				                values.put("status", 193);
				                return mResolver.update(ContentUris
				                                .withAppendedId(mBaseUri, downloadId), values,
				                        null, null);
				            } catch (Exception e) {
				//                Log.print("Pausing encountered an error");
				            }
			        } else {
			    //        Log.print("Download id not found");
			        }
		        return -1;
		    }
	{
	}
	
	
	public void _getMovieType (final Element _e) {
		
	}
	
	
	public ArrayList<HashMap<String, Object>> _getDownloadsToArray () {
		
		
						i = 0;
		a = new HashMap<>();
						ArrayList<HashMap<String,Object>> l = new ArrayList<>();
						DownloadManager.Query query = new DownloadManager.Query();
						query.setFilterByStatus(DownloadManager.STATUS_RUNNING);
						Cursor c = ((DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE)).query(query);
						while(c.moveToNext()){
									HashMap<String,Object> h = new HashMap<>();
									h.put("name", c.getString(c.getColumnIndex(DownloadManager.COLUMN_TITLE)));
									h.put("link", c.getString(c.getColumnIndex(DownloadManager.COLUMN_URI)));
									h.put("downloadedBytes", c.getString(c.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)));
									h.put("totalBytes", c.getString(c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES)));
									h.put("state", c.getString(c.getColumnIndex(DownloadManager.COLUMN_STATUS)));
			h.put("id", (long)new Double(c.getInt(c.getColumnIndex(DownloadManager.COLUMN_ID))).longValue());
			
									if(
									    c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI) > 0
									){
									if(_checkIfNull(c)){
					
											l.add(h);
					try{
												a.put(i,new Double(c.getInt(c.getColumnIndex(DownloadManager.COLUMN_ID))).longValue());
												i++;
					}catch(Exception e){}
									}
								}
							}
						return l;
				
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public boolean _isValidElement (final String _s) {
		return (_s.contains("/movies/") || _s.contains("/series/"));
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
	
	
	public void _startTimer () {
		downloadList = _getDownloadsToArray();
		if (downloadList.isEmpty()) {
			linear18.setVisibility(View.VISIBLE);
			recyclerview1.setVisibility(View.GONE);
		}
		else {
			recyclerview1.setVisibility(View.VISIBLE);
			linear18.setVisibility(View.GONE);
			recyclerview1.setAdapter(new Recyclerview1Adapter(downloadList));
		}
		//_startTrackingDownloads();
		
	}
	
	
	private void _deleteItem (final double _n) {
				
				
				
		}
		
	private long getDownloadId(Uri uri){
					long id = 0;
					DownloadManager downloadManager = (DownloadManager) this.getSystemService(Context.DOWNLOAD_SERVICE);
					DownloadManager.Query myDownloadQuery = new DownloadManager.Query();
					myDownloadQuery.setFilterByStatus(DownloadManager.STATUS_RUNNING | DownloadManager.STATUS_PAUSED | DownloadManager.STATUS_PENDING);
					Cursor cursor = downloadManager.query(myDownloadQuery);
					while (cursor.moveToNext()) {
								// Parse each download
								if(cursor.getString(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_URI)).equals(uri)){
											return cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_ID));
											
								}
									
					}
					
					cursor.close();
					return id;
		}
	private void _startTrackingDownloads () {
		    /*********
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
					    
					    
					    Timer timer = new Timer();
t = new TimerTask() {
    @Override
    public void run() {
        // whatever you need to do every 2 seconds
						for(int _repeat11 = 0; _repeat11 < (int)(downloadList.size()); _repeat11++) {

if(!a.containsKey(_repeat11)){
return;
}
							long id = a.get(_repeat11);
							DownloadManager.Query query = new DownloadManager.Query();
							
							query.setFilterById(id);
							
							Cursor c = ((DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE)).query(query);
							
							
							if (c.moveToFirst()) {
								  int sizeIndex = c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES);
								  int downloadedIndex = c.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR);
								  long size = c.getInt(sizeIndex);
								  long downloaded = c.getInt(downloadedIndex);
								  double progress = 0.0;
						//		  if (size != -1) progress = downloaded*100.0/size;  
								  
								
								downloadList.get((int)_repeat11).put("totalBytes", c.getString(c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES)));
								downloadList.get((int)_repeat11).put("downloadedBytes", c.getString(c.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)));
								downloadList.get((int)_repeat11).put("state", c.getString(c.getColumnIndex(DownloadManager.COLUMN_STATUS)));
								if ((size == downloaded) || c.getString(c.getColumnIndex(DownloadManager.COLUMN_STATUS)).equals(DownloadManager.STATUS_FAILED)) {
									downloadList.remove((int)(_repeat11));
									recyclerview1.getAdapter().notifyItemRemoved(_repeat11);
									return;
								//	_snackBarLayout("Download failed!");
								}
								
									recyclerview1.getAdapter().notifyItemChanged(_repeat11);
								
							}
						}
					
		
		  }
};

timer.schedule(t, 4000, 4000);
	//	_timer.scheduleAtFixedRate(t, (int)(0), (int)(4000));
**********/
	}
	
	
	private String _byteToString (final double _d) {
				Double sizeInBytes = _d;
				
				    NumberFormat nf = new DecimalFormat();
				    nf.setMaximumFractionDigits(2);
				
				    try {
						        if ( sizeInBytes < SPACE_KB ) {
								            return nf.format(sizeInBytes) + " Byte(s)";
								        } else if ( sizeInBytes < SPACE_MB ) {
								            return nf.format(sizeInBytes/SPACE_KB) + " KB";
								        } else if ( sizeInBytes < SPACE_GB ) {
								            return nf.format(sizeInBytes/SPACE_MB) + " MB";
								        } else if ( sizeInBytes < SPACE_TB ) {
								            return nf.format(sizeInBytes/SPACE_GB) + " GB";
								        } else {
								            return nf.format(sizeInBytes/SPACE_TB) + " TB";
								        }
						    } catch (Exception e) {
						        return sizeInBytes + " Byte(s)";
						    }
				
				
	}
	
	
	public void _stopTimer () {
		try {
			
t.cancel();
		} catch(Exception e) {
			
 
		}
	}
	
	
	public void _showCustomSnackBar (final String _text) {
		ViewGroup parentLayout = (ViewGroup) ((ViewGroup) this .findViewById(android.R.id.content)).getChildAt(0);
		
		_snackBarView = com.google.android.material.snackbar.Snackbar.make(background, "", com.google.android.material.snackbar.Snackbar.LENGTH_LONG);
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
		text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.NORMAL);
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
	
	
	public boolean _checkIfNull (final Cursor _c) {
		boolean movie = false;
		try {
			
movie = _c.getString(_c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI)). endsWith(".mp4");
		} catch(Exception e) {
			
 
		}
		return (movie);
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
	
	
	public void _editMap (final String _uri) {
		if (viewPager.getCurrentItem() == 2) {
			pp = Double.parseDouble(_uri.replace("content://downloads/my_downloads/", ""));
			long id = new Double(pp).longValue();
			for(int i= 0; i < (int)(downloadList.size()); i++) {
				if ((long)downloadList.get((int)(i)).get("id") == id) {
					DownloadManager.Query query = new DownloadManager.Query();
												
												query.setFilterById(id);
												
												Cursor c = ((DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE)).query(query);
												
												
					while(c.moveToFirst()) {
						
downloadList.set((int)(i), _getMap(id));
						recyclerview1.getAdapter().notifyItemChanged(i);
						if (downloadList.get((int)i).get("state").toString().equals(DownloadManager.STATUS_FAILED)) {
							try {
								
downloadList.remove((int)(i));
								recyclerview1.getAdapter().notifyItemRemoved(i);
							} catch(Exception e) {
								
 
							}
						}
						
						break;
					}
				}
			}
		}
	}
	public class DownloadObserver extends ContentObserver {
		
		public DownloadObserver(Handler d){
						super(d);
				}
		   @Override
		   public void onChange( boolean selfChange, Uri ur) {
			       if(ur.toString().equals(uri)){
				return;
			}
			       _editMap(ur.toString());
			   //   Log.d( "DownloadObserver", "Download " + uri + " updated" );
			   }
		
	}
	
	
	public HashMap<String, Object> _getMap (final long _n) {
		o = new HashMap<>();
		DownloadManager.Query query = new DownloadManager.Query();
									
									query.setFilterById(_n);
									
									Cursor c = ((DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE)).query(query);
									
									
		while(c.moveToFirst()) {
			
o.put("name", c.getString(c.getColumnIndex(DownloadManager.COLUMN_TITLE)));
									o.put("link", c.getString(c.getColumnIndex(DownloadManager.COLUMN_URI)));
									o.put("downloadedBytes", c.getString(c.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)));
									o.put("totalBytes", c.getString(c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES)));
									o.put("state", c.getString(c.getColumnIndex(DownloadManager.COLUMN_STATUS)));
			o.put("id", (long)new Double(c.getInt(c.getColumnIndex(DownloadManager.COLUMN_ID))).longValue());
			
			break;
		}
		return o;
	}
	
	
	public void _show () {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(this);
		
		
		View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_p1,null );
		bottomSheetDialog.setContentView(bottomSheetView);
		bottomSheetDialog.setCancelable(false);
		bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
		TextView t1 = (TextView) bottomSheetView.findViewById(R.id.t1);
		
		TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
		
		TextView b1 = (TextView) bottomSheetView.findViewById(R.id.b1);
		
		TextView b2 = (TextView) bottomSheetView.findViewById(R.id.b2);
		
		ImageView i1 = (ImageView) bottomSheetView.findViewById(R.id.i1);
		
		LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.BOLD);
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.NORMAL);
		b1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.BOLD);
		b2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.BOLD);
		i1.setImageResource(R.drawable.craft);
		t1.setText("Hey, we're busy!");
		t2.setText("The Music downloader is recently new and still in development!");
		b1.setText("Dismiss");
		b2.setVisibility(View.GONE);
		b2.setText("");
		_rippleRoundStroke(bg, "#111111", "#000000", 15, 0, "#000000");
		_rippleRoundStroke(b1, "#222222", "#EEEEEE", 15, 2.5d, "#EEEEEE");
		_rippleRoundStroke(b2, "#F44336", "#40FFFFFF", 15, 0, "#000000");
		b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				bottomSheetDialog.dismiss();
			}
		});
		b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
			}
		});
		bottomSheetDialog.show();
	}
	
	
	public void _scrollListener () {
		HorizontalListView.OnScrollStateChangedListener scroller = new HorizontalListView.OnScrollStateChangedListener(){
									@Override 
									public void onScrollStateChanged(final HorizontalListView.OnScrollStateChangedListener.ScrollState s){
				if(s == HorizontalListView.OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE){
					vscroll1.requestDisallowInterceptTouchEvent(false);
				}else{
					vscroll1.requestDisallowInterceptTouchEvent(true);
				}
			}
		};
		hscroll2.setOnScrollStateChangedListener(scroller);
		
		hscroll1.setOnScrollStateChangedListener(scroller);
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
				_view = _inflater.inflate(R.layout.videos, null);
			}
			
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			
			_setImageFromURL(imageview1, videosList.get((int)_position).get("download_url").toString());
			_setClippedView(linear2, "#000000", 10, 0);
			linear2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					toinfo.setClass(getApplicationContext(), InfoActivity.class);
					toinfo.putExtra("image", videosList.get((int)_position).get("download_url").toString());
					toinfo.putExtra("name", videosList.get((int)_position).get("author").toString());
					_transitionManager(imageview1, "movie_img", toinfo);
				}
			});
			_setToolTip(linear2, videosList.get((int)_position).get("author").toString());
			
			return _view;
		}
	}
	
	public class Listview3Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.recommended_item, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.cardview1);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			
			overrideFonts(_v.getContext(), _v);
			textview1.setText(_data.get((int)_position).get("title").toString());
			textview3.setText(_data.get((int)_position).get("synopsis").toString());
			textview2.setText(_data.get((int)_position).get("year").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("image").toString())).into(imageview1);
			
			return _view;
		}
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
			lp.height =  (int)(((float)getApplicationContext().getResources().getDisplayMetrics().widthPixels) / 1.5f);
			
			linear1.requestLayout();
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/medium.ttf"), Typeface.NORMAL);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/medium.ttf"), Typeface.NORMAL);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.BOLD);
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
			
			return _view;
		}
	}
	
	public class Top_select_listviewAdapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Top_select_listviewAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.topselection, null);
			}
			
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			
			_setImageFromURL(imageview1, videosList.get((int)_position).get("download_url").toString());
			_setClippedView(linear2, "#000000", 10, 0);
			linear2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					toinfo.setClass(getApplicationContext(), InfoActivity.class);
					toinfo.putExtra("image", videosList.get((int)_position).get("download_url").toString());
					toinfo.putExtra("name", videosList.get((int)_position).get("author").toString());
					_transitionManager(imageview1, "movie_img", toinfo);
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
				_view = _inflater.inflate(R.layout.card, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView linear2 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.linear2);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final RelativeLayout linear4 = (RelativeLayout) _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = (LinearLayout) _view.findViewById(R.id.linear5);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			
			
			
			return _view;
		}
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
				_view = _inflater.inflate(R.layout.topselection, null);
			}
			
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			
			
			
			return _view;
		}
	}
	
	public class Popular_search_listAdapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Popular_search_listAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
			
			if (_data.get((int)_position).get("name").toString().contains("Movie:")) {
				_data.get((int)_position).put("name", _data.get((int)_position).get("name").toString().replace("Movie:", "").trim());
			}
			_setImageFromURL(imageview1, _data.get((int)_position).get("image").toString());
			textview1.setText(_data.get((int)_position).get("name").toString());
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.NORMAL);
			textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), Typeface.NORMAL);
			_ICC(imageview2, "#FFFFFF", "#FFFFFF");
			if (_position == 0) {
				textview12.setVisibility(View.VISIBLE);
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
			_setToolTip(imageview2, "Play");
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
						toinfo.setClass(getApplicationContext(), SodeActivity.class);
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
	
	public class Search_result_listviewAdapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Search_result_listviewAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
			
			lp.height = (int)(((float)getApplicationContext().getResources().getDisplayMetrics().widthPixels) / 2.5f);
			linear1.requestLayout();
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/medium.ttf"), Typeface.NORMAL);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/medium.ttf"), Typeface.NORMAL);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.BOLD);
			textview2.setVisibility(View.GONE);
			if (_data.get((int)_position).containsKey("anime_id")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("anime_cover_image_url").toString())).into(imageview1);
				textview1.setText(_data.get((int)_position).get("anime_name").toString());
				textview1.setBackgroundColor(Color.TRANSPARENT);
				linear4.setVisibility(View.VISIBLE);
			}
			else {
				textview1.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)7, 0xFF323232));
				linear4.setVisibility(View.GONE);
			}
			
			return _view;
		}
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		ArrayList<HashMap<String, Object>> _data;
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _inflater.inflate(R.layout.download_item, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final androidx.cardview.widget.CardView linear1 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.linear1);
			final LinearLayout linear7 = (LinearLayout) _view.findViewById(R.id.linear7);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			final ImageView imageview3 = (ImageView) _view.findViewById(R.id.imageview3);
			final Button button1 = (Button) _view.findViewById(R.id.button1);
			final LinearLayout linear5 = (LinearLayout) _view.findViewById(R.id.linear5);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final LinearLayout linear6 = (LinearLayout) _view.findViewById(R.id.linear6);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			linear5.setClipToOutline(true);
			if (ff.getString(_data.get((int)_position).get("name").toString(), "").equals("")) {
				imageview1.setImageResource(R.drawable.avatar);
			}
			else {
				Glide.with(getApplicationContext()).load(Uri.parse(ff.getString(_data.get((int)_position).get("name").toString(), ""))).into(imageview1);
			}
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gilroy_bold.ttf"), Typeface.NORMAL);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.NORMAL);
			button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product.ttf"), Typeface.BOLD);
			textview1.setText(_data.get((int)_position).get("name").toString().concat(" - ").concat(_byteToString(Double.parseDouble(_data.get((int)_position).get("downloadedBytes").toString())).concat("/".concat(_byteToString(Double.parseDouble(_data.get((int)_position).get("totalBytes").toString()))))));
			_RippleEffects("#55ffffff", imageview3);
			_RippleEffects("#55ffffff", imageview2);
			if (_data.get((int)_position).get("state").toString().equals(DownloadManager.STATUS_SUCCESSFUL)) {
				linear6.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
				button1.setVisibility(View.VISIBLE);
				linear5.setVisibility(View.GONE);
				textview2.setVisibility(View.GONE);
				imageview2.setVisibility(View.GONE);
			}
			else {
				button1.setVisibility(View.GONE);
				linear5.setVisibility(View.VISIBLE);
				textview2.setVisibility(View.VISIBLE);
				imageview2.setVisibility(View.VISIBLE);
			}
			if (_data.get((int)_position).get("state").toString().equals(DownloadManager.STATUS_PAUSED)) {
				imageview3.setImageResource(R.drawable.ic_control_1);
			}
			else {
				if (_data.get((int)_position).get("state").toString().equals(DownloadManager.STATUS_RUNNING)) {
					imageview3.setImageResource(R.drawable.ic_control_2);
				}
			}
			pb = Double.parseDouble(_data.get((int)_position).get("downloadedBytes").toString()) / Double.parseDouble(_data.get((int)_position).get("totalBytes").toString());
						try {
								w = pb * linear5.getWidth();
								h = SketchwareUtil.getDip(getApplicationContext(), (int)(20));
								linear6.setLayoutParams(new LinearLayout.LayoutParams((int)w, (int)h));
								linear6.requestLayout();
						} catch(Exception e) {
								 
						}
			textview2.setText(String.valueOf((long)(pb * 100)).concat("%"));
			
			button1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_data.get((int)_position).get("state").toString().equals(DownloadManager.STATUS_SUCCESSFUL)) {
						towatch.setClass(getApplicationContext(), WatchActivity.class);
						fileName = _data.get((int)_position).get("name").toString();
						towatch.putExtra("link", new java.io.File(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS) + ("/Flixr/") + fileName + "." + "mp4").getAbsolutePath());
						startActivity(towatch);
					}
				}
			});
			imageview2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					
					getContentResolver().unregisterContentObserver(d);
					uri = "content://downloads/my_downloads".concat("/".concat(String.valueOf((long)((long)_data.get(_position).get("id")))));
					try {
						
((DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE)).remove((long)_data.get(_position).get("id"));
						_data.remove((int)(_position));
						notifyDataSetChanged();
						_showCustomSnackBar("Download cancelled!");
					} catch(Exception e) {
						
_showCustomSnackBar("Unable to cancel");
					}
					Uri myDownloads = Uri.parse( "content://downloads/my_downloads" );
					getContentResolver().registerContentObserver(myDownloads, true, d);
				}
			});
			imageview3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_data.get((int)_position).get("state").toString().equals(DownloadManager.STATUS_RUNNING)) {
						//new Downloader(getApplicationContext()).pauseDownload(getApplicationContext(), a.get(_position));
					}
					else {
						if (_data.get((int)_position).get("state").toString().equals(DownloadManager.STATUS_PAUSED)) {
							//new Downloader(getApplicationContext()).resumeDownload(getApplicationContext(), a.get(_position));
						}
					}
				}
			});
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder{
			public ViewHolder(View v){
				super(v);
			}
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
