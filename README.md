# Immortalviewpager
无限轮循ViewPager

因为项目里到处需要无限轮播的效果，网上也有很多Demo！找了很多，多多少少都有BUG或者不如意的地方

（比如在最后一页和第一页切换的时候速率太快，显得太唐突 

  要么就是到最后一页之后直接从右向左回到第一页，视觉效果更差）
  
所以最后在一个无限轮滑的项目上进行了修改
由于这个项目找到的时间太久了，我也不清楚原作者是谁...所以没法贴出来他的链接！


支持手动，自动。实现无限轮滑效果

Immortalviewpager的使用

1 ： Module依赖 

2 ： XML中使用自定义ViewPager

3 ： 数据填充 

		填充Adapter直接继承自Module中的ImmortalvpAdapter

4 ： 设置轮滑开启

-----------------------------------------------
部分Demo代码

1： XML中使用
<com.immortalviewpager.AutoScrollViewPager
        android:id="@+id/vp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
        

2:  初始化代码

   ① 初始化数据 （设置Adapter）
   
    public HomePagerVpAdapter(Context context) {
        super(context);
    }
   
   第一个参数为：要显示的条目个数
   
   第二个参数为：要显示的布局文件
   
   第三个参数为：回调方法，ImmortalvpAdapter会在创建view之后使用回调方法进行view的数据填充
   
    mAdapter.initViewList(3,R.layout.img,new FillingViewsListener(){
            @Override
            public void fillingView(View view, int position) {
                TextView tvfinal = (TextView) view.findViewById(R.id.tv);
                tvfinal.setText(""+position);
                Log.e("PO","   "+position);
            }
        });
	
	②vp设置
	 mVp = (AutoScrollViewPager) findViewById(R.id.vp);
        mVp.setAdapter(mAdapter);
        mVp.setInterval(3000);
        mVp.startAutoScroll();
  
	
