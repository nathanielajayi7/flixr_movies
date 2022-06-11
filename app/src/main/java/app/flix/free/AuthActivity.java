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
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.view.View;
import android.graphics.Typeface;
import org.jsoup.*;
import com.eyalbira.loadingdots.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class AuthActivity extends  AppCompatActivity  { 
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String activityFontName = "";
	private boolean isNewUser = false;
	private HashMap<String, Object> map = new HashMap<>();
	
	private LinearLayout linear27;
	private LinearLayout viewpager_back;
	private LinearLayout base;
	private LinearLayout trash;
	private LinearLayout layout1;
	private LinearLayout layout2;
	private LinearLayout linear28;
	private LinearLayout welcome_viewpager;
	private LinearLayout linear36;
	private TextView textview5;
	private ImageView imageview2;
	private LinearLayout linear29;
	private TextView textview4;
	private LinearLayout linear31;
	private LinearLayout linear39;
	private LinearLayout base2;
	private LinearLayout trash2;
	private LinearLayout layout11;
	private LinearLayout layout22;
	private LinearLayout layout33;
	private ImageView imageview4;
	private TextView textview6;
	private TextView textview7;
	private ImageView imageview5;
	private TextView textview9;
	private TextView textview10;
	private ImageView imageview6;
	private TextView textview11;
	private TextView textview12;
	private LinearLayout dot1;
	private LinearLayout dot2;
	private LinearLayout dot3;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private ImageView imageview1;
	private EditText username;
	private EditText email;
	private EditText password;
	private LinearLayout login;
	private TextView textview2;
	private TextView textview3;
	private TextView textview1;
	
	private Intent tohome = new Intent();
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
	private DatabaseReference app = _firebase.getReference("users/userInformation");
	private ChildEventListener _app_child_listener;
	private ProgressDialog pb;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.auth);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		viewpager_back = (LinearLayout) findViewById(R.id.viewpager_back);
		base = (LinearLayout) findViewById(R.id.base);
		trash = (LinearLayout) findViewById(R.id.trash);
		layout1 = (LinearLayout) findViewById(R.id.layout1);
		layout2 = (LinearLayout) findViewById(R.id.layout2);
		linear28 = (LinearLayout) findViewById(R.id.linear28);
		welcome_viewpager = (LinearLayout) findViewById(R.id.welcome_viewpager);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		textview5 = (TextView) findViewById(R.id.textview5);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear29 = (LinearLayout) findViewById(R.id.linear29);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		linear39 = (LinearLayout) findViewById(R.id.linear39);
		base2 = (LinearLayout) findViewById(R.id.base2);
		trash2 = (LinearLayout) findViewById(R.id.trash2);
		layout11 = (LinearLayout) findViewById(R.id.layout11);
		layout22 = (LinearLayout) findViewById(R.id.layout22);
		layout33 = (LinearLayout) findViewById(R.id.layout33);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview9 = (TextView) findViewById(R.id.textview9);
		textview10 = (TextView) findViewById(R.id.textview10);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview12 = (TextView) findViewById(R.id.textview12);
		dot1 = (LinearLayout) findViewById(R.id.dot1);
		dot2 = (LinearLayout) findViewById(R.id.dot2);
		dot3 = (LinearLayout) findViewById(R.id.dot3);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		username = (EditText) findViewById(R.id.username);
		email = (EditText) findViewById(R.id.email);
		password = (EditText) findViewById(R.id.password);
		login = (LinearLayout) findViewById(R.id.login);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview1 = (TextView) findViewById(R.id.textview1);
		auth = FirebaseAuth.getInstance();
		
		textview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewPager.setCurrentItem(1);
				username.setVisibility(View.VISIBLE);
				textview2.setVisibility(View.GONE);
				textview3.setText("Already have an account? Log in.");
				textview1.setText("Sign Up");
				isNewUser = true;
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewPager.setCurrentItem(1);
				username.setVisibility(View.GONE);
				textview2.setVisibility(View.VISIBLE);
				textview3.setText("Already have an account? Log in.");
				textview1.setText("Sign In");
				isNewUser = false;
			}
		});
		
		username.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		email.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		password.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isNewUser) {
					if ((username.getText().toString().trim().length() > 0) && ((email.getText().toString().trim().length() > 0) && (password.getText().toString().trim().length() > 0))) {
						auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(AuthActivity.this, _auth_create_user_listener);
						_alert();
					}
					else {
						_showCustomSnackBar("Fill in the required information!");
					}
				}
				else {
					if ((email.getText().toString().trim().length() > 0) && (password.getText().toString().trim().length() > 0)) {
						auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(AuthActivity.this, _auth_sign_in_listener);
						_alert();
					}
					else {
						_showCustomSnackBar("Fill in the required information!");
					}
				}
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (email.getText().toString().trim().equals("")) {
					_showCustomSnackBar("Type your email first");
				}
				else {
					_alert();
					auth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(_auth_reset_password_listener);
					_showCustomSnackBar("Reset password email is being sent...");
				}
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_transitionViewTime(layout2, 300);
				if (isNewUser) {
					username.setVisibility(View.GONE);
					textview2.setVisibility(View.VISIBLE);
					textview3.setText("Already have an account? Log in.");
					textview1.setText("Sign In");
					isNewUser = false;
				}
				else {
					username.setVisibility(View.VISIBLE);
					textview2.setVisibility(View.GONE);
					textview3.setText("Already have an account? Log in.");
					textview1.setText("Sign Up");
					isNewUser = true;
				}
			}
		});
		
		_app_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		app.addChildEventListener(_app_child_listener);
		
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
				if (_success) {
					map = new HashMap<>();
					map.put("name", username.getText().toString());
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					app.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
					map.clear();
					tohome.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(tohome);
					finish();
				}
				else {
					_showCustomSnackBar(_errorMessage);
				}
				pb.dismiss();
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					tohome.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(tohome);
					finish();
				}
				else {
					_showCustomSnackBar(_errorMessage);
				}
				pb.dismiss();
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				_showCustomSnackBar("Password reset email sent!");
				pb.dismiss();
			}
		};
	}
	
	private void initializeLogic() {
		_LOGIC_UI();
		_viewPagerStuff();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _LOGIC_UI () {
		_setViewRadius(dot1, 90, "#E50913");
		_setViewRadius(dot2, 90, "#333333");
		_setViewRadius(dot3, 90, "#333333");
		_NavStatusBarColor("#000000", "#000000");
		_changeActivityFont("product");
		_rippleRoundStroke(login, "#000000", "#EEEEEE", 20, 6, "#424242");
		_rippleRoundStroke(textview2, "#000000", "#EEEEEE", 20, 0, "#424242");
		_rippleRoundStroke(textview3, "#000000", "#EEEEEE", 20, 0, "#424242");
		_rippleRoundStroke(textview4, "#000000", "#EEEEEE", 20, 0, "#424242");
		_rippleRoundStroke(textview5, "#E50913", "#FFFFFF", 15, 0, "#424242");
		_rippleRoundStroke(username, "#333333", "#EEEEEE", 20, 0, "#424242");
		_rippleRoundStroke(email, "#333333", "#EEEEEE", 20, 0, "#424242");
		_rippleRoundStroke(password, "#333333", "#EEEEEE", 20, 0, "#424242");
		username.setVisibility(View.GONE);
		isNewUser = false;
	}
	
	
	public void _NavStatusBarColor (final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _setMaterialEditText (final TextView _edittext, final View _view, final double _corners, final boolean _counter, final double _countLength) {
		//This moreblock was made by Ilyasse Salama :)
		com.google.android.material.textfield.TextInputLayout textinput = new com.google.android.material.textfield.TextInputLayout(this, null, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox);
		textinput.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		textinput.setCounterEnabled(_counter);
		
		textinput.setBoxStrokeColor(Color.parseColor("#FFFFFF"));
		if (_counter) {
			textinput.setCounterMaxLength((int)_countLength);
		}
		textinput.setBoxBackgroundMode(com.google.android.material.textfield.TextInputLayout.BOX_BACKGROUND_OUTLINE);
		textinput.setBoxCornerRadii((float)_corners, (float)_corners, (float)_corners, (float)_corners);
		((LinearLayout)_view).removeAllViews();
		
		textinput.addView(_edittext);
		
		((LinearLayout)_view).addView(textinput);
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
	
	
	public void _rootViewPager () {
	}
	androidx.viewpager.widget.ViewPager viewPager;
	
	private class MyPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
		public int getCount() {
			return 2;
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
	androidx.viewpager.widget.ViewPager viewPager2;
	
	private class MyPagerAdapter2 extends androidx.viewpager.widget.PagerAdapter {
		public int getCount() {
			return 3;
		}
		
		@Override public Object instantiateItem(ViewGroup collection, int position) {
			
			LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = inflater.inflate(R.layout.empty, null);
			
			LinearLayout container = (LinearLayout) v.findViewById(R.id.linear1);
			
			if (position == 0) {
				ViewGroup parent = (ViewGroup) layout11.getParent();
				if (parent != null) {
					parent.removeView(layout11);
				}container.addView(layout11);
				
			} else if (position == 1) {
				ViewGroup parent = (ViewGroup) layout22.getParent();
				if (parent != null) {
					parent.removeView(layout22);
				}
				container.addView(layout22);
			} else if (position == 2) {
				ViewGroup parent = (ViewGroup) layout33.getParent();
				if (parent != null) {
					parent.removeView(layout33);
				}
				container.addView(layout33);
			}
			collection.addView(v, 0);
			return v;
		}
		@Override public void destroyItem(ViewGroup collection, int position, Object view) {
			collection.removeView((View) view);
			trash2.addView((View) view);
		}
		@Override public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == ((View) arg1);}
		@Override public Parcelable saveState() {
			return null;
		}
	}
	private void doNothing() {
	}
	
	
	public void _viewPagerStuff () {
		viewPager = new androidx.viewpager.widget.ViewPager(this);
		
		viewPager.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		MyPagerAdapter adapter = new MyPagerAdapter();
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);
		base.addView(viewPager);
		viewPager2 = new androidx.viewpager.widget.ViewPager(this);
		
		viewPager2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		MyPagerAdapter2 adapter2 = new MyPagerAdapter2();
		viewPager2.setAdapter(adapter2);
		viewPager2.setCurrentItem(0);
		base2.addView(viewPager2);
		viewPager2.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.OnPageChangeListener() {
			public void onPageSelected(int position) {
				if (viewPager2.getCurrentItem() == 0) {
					_setViewRadius(dot1, 90, "#E50913");
					_setViewRadius(dot2, 90, "#333333");
					_setViewRadius(dot3, 90, "#333333");
					textview5.setVisibility(View.INVISIBLE);
				}
				else {
					if (viewPager2.getCurrentItem() == 1) {
						_setViewRadius(dot1, 90, "#333333");
						_setViewRadius(dot2, 90, "#E50913");
						_setViewRadius(dot3, 90, "#333333");
						textview5.setVisibility(View.INVISIBLE);
					}
					else {
						if (viewPager2.getCurrentItem() == 2) {
							_setViewRadius(dot1, 90, "#333333");
							_setViewRadius(dot2, 90, "#333333");
							_setViewRadius(dot3, 90, "#E50913");
							textview5.setVisibility(View.VISIBLE);
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
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#FF757575")}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _setViewRadius (final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor("#" + _color.replace("#", "")));
		
		gd.setCornerRadius((int)_radius);
		
		_view.setBackground(gd);
	}
	
	
	public void _transitionViewTime (final View _view, final double _duration) {
		LinearLayout viewgroup = (LinearLayout)_view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((short)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
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
	
	
	public void _alert () {
		pb = new ProgressDialog (this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		pb.setMessage("Please wait...");
		pb.setCancelable(true);
		pb.show();
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
