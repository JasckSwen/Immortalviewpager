package program.immortalviewpagerdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.immortalviewpager.AutoScrollViewPager;
import com.immortalviewpager.FillingViewsListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AutoScrollViewPager mVp ;
    private  HomePagerVpAdapter mAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new HomePagerVpAdapter(this);
        initData(mAdapter);
        mVp = (AutoScrollViewPager) findViewById(R.id.vp);
        mVp.setAdapter(mAdapter);
        mVp.setInterval(3000);
        mVp.startAutoScroll();
    }

    private void initData(HomePagerVpAdapter mAdapter) {
//        List<View> list = new ArrayList<>();
//        int size = 5 ;
//        for ( int i = 0 ; i<size ; i++){
//            if ( size>1 && i == 0 ){
//                View view = View.inflate(this,R.layout.img,null);
//                TextView tv = (TextView) view.findViewById(R.id.tv);
//                tv.setText(""+(size-1));
//                list.add(view);
//            }
//            View view = View.inflate(this,R.layout.img,null);
//            TextView tv = (TextView) view.findViewById(R.id.tv);
//            tv.setText(""+i);
//            list.add(view);
//            if ( size>1 && i == (size-1) ){
//                View viewfinal = View.inflate(this,R.layout.img,null);
//                TextView tvfinal = (TextView) viewfinal.findViewById(R.id.tv);
//                tvfinal.setText(""+0);
//                list.add(viewfinal);
//            }
//        }
//        mAdapter.setViewList(list);
        mAdapter.initViewList(3,R.layout.img,new FillingViewsListener(){
            @Override
            public void fillingView(View view, int position) {
                TextView tvfinal = (TextView) view.findViewById(R.id.tv);
                tvfinal.setText(""+position);
                Log.e("PO","   "+position);
            }
        });
    }

}
