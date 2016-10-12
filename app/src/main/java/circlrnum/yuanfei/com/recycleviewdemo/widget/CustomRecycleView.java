package circlrnum.yuanfei.com.recycleviewdemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import circlrnum.yuanfei.com.recycleviewdemo.R;

/**
 * Created by admin on 2016/10/12.
 */

public class CustomRecycleView extends SwipeRefreshLayout implements SwipeRefreshLayout.OnRefreshListener {

    //分割线的高度
    private float mDivideHeigth;

    //分割线的颜色
    private int mDivideColor;

    //判断是不是gridView
    private boolean isGird;

    private Context context;

    private RecyclerView mRecycleView;


    public CustomRecycleView(Context context) {
        this(context,null);
    }

    public CustomRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomRecycleView, 0, 0);
        for (int i = 0, count = a.getIndexCount(); i < count; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.CustomRecycleView_divideColor) {
                mDivideColor = a.getColor(attr, Color.RED);
            } else if (attr == R.styleable.CustomRecycleView_divideHeigth) {
                mDivideHeigth = a.getDimension(attr, 0);
            }  else if (attr == R.styleable.CustomRecycleView_isGird) {
                isGird = a.getBoolean(attr, false);
            }
        }
        a.recycle();
        init();
    }

    private void init(){
        setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_green_dark);//设置下拉加载的颜色
        setOnRefreshListener(this);
        initRecycleView();
    }

    private void initRecycleView(){
        mRecycleView = new RecyclerView(context);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mRecycleView.setLayoutParams(params);
        addView(mRecycleView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        if (isGird){
            mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        }else{

        }
    }


    @Override
    public void onRefresh() {

    }

}
