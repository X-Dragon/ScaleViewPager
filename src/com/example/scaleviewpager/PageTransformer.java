package com.example.scaleviewpager;


import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by HanHailong on 15/9/27.
 */
public class PageTransformer implements ViewPager.PageTransformer {

    public static final float MAX_SIZE = 1.0f;
    public static final float MIN_SIZE = 0.8f;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
    public void transformPage(View page, float position) {
        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }
        float offset =0;
        if(position<0){
        	offset=1 + position;
        }else{
        	offset=1 - position;
        }
        float scaleSize = MIN_SIZE + offset * (MAX_SIZE - MIN_SIZE);
        page.setScaleY(scaleSize);
        page.setScaleX(scaleSize);

    }
}
