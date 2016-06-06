package com.immortalviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class ImmortalvpAdapter extends PagerAdapter {

    private Context mContext;
    List<View> mList =new ArrayList<View>();

    public ImmortalvpAdapter(Context context){
        mContext = context ;
    }

    @Deprecated
    public void setViewList( List views ){
        mList = views ;
    }

    public void initViewList(int size,int res,FillingViewsListener listener){
        for ( int i = 0 ; i<size ; i++){
            if ( size>1 && i == 0 ){
                View viewFirst = View.inflate(mContext,res,null);
                listener.fillingView(viewFirst,size-1);
                mList.add(viewFirst);
            }
            View viewNormal = View.inflate(mContext,res,null);
            listener.fillingView(viewNormal,i);
            mList.add(viewNormal);
            if ( size>1 && i == (size-1) ){
                View viewfinal = View.inflate(mContext,res,null);
                listener.fillingView(viewfinal,0);
                mList.add(viewfinal);
            }
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1 ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(mList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        container.addView(mList.get(position));
        return mList.get(position);
    }

}
