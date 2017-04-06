package roemilk.tistory.com.simpleswitchview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CustomSwitch extends RelativeLayout {
	private RelativeLayout mSwitchParentLay = null;
	private ImageView mSwitchImageView = null;
	public boolean mSwitchState = false;
	public CustomSwitch(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		init(context);
	}
	
	public CustomSwitch(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
	
	/**
	 * 
	 * summary : Initializes the view.
	 * @param context
	 */
	public void init(Context context) {
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.custom_view_switch, this);

		mSwitchParentLay = (RelativeLayout)view.findViewById(R.id.custom_view_switch_lay);
		mSwitchImageView = (ImageView)view.findViewById(R.id.custom_view_switch_imageView);
	}
	
	/**
	 * 
	 * summary : Shows animations that match the state of the switch.
	 * @param context
	 */
	public void startSwitchAnimation(Context context) {
		Animation animation = null;
		int res;
		if(mSwitchState != true) {
			animation = AnimationUtils.loadAnimation(context, R.anim.ani_switch_on);
			animation.setFillAfter(true);
			res = R.drawable.switch_on;
			setSwitchOnOff(true);
		}else {
			animation = AnimationUtils.loadAnimation(context, R.anim.ani_switch_off);
			animation.setFillAfter(true);
			res = R.drawable.switch_off;
			setSwitchOnOff(false);
		}
		mSwitchImageView.startAnimation(animation);
		mSwitchParentLay.setBackgroundResource(res);
	}
	
	/**
	 * 
	 * summary : Returns the current state of the switch.
	 * @return current state (ON:true  OFF:false)
	 */
	public boolean getSwitchOnOff() {
		return mSwitchState;
	}
	
	/**
	 * @param state ON:true  OFF:false
	 * summary : Set the state of the switch.
	 */
	public void setSwitchOnOff(boolean state) {
		mSwitchState = state;
	}
}
