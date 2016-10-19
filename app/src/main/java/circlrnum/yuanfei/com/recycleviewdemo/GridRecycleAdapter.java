package circlrnum.yuanfei.com.recycleviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import circlrnum.yuanfei.com.recycleviewdemo.widget.BaseRecyclerAdapter;
import circlrnum.yuanfei.com.recycleviewdemo.widget.BaseRecyclerViewHolder;

/**
 * 作者 yuanfei on 2016/10/18.
 * 邮箱 yuanfei221@126.com
 */

public class GridRecycleAdapter extends BaseRecyclerAdapter<String> implements BaseRecyclerAdapter.OnItemClickLitener {
    private Context context;

    public GridRecycleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getLayout() {
        return R.layout.gird_item;
    }

    /**
     * 数据绑定
     *
     * @param holder
     * @param i
     * @param list
     */
    @Override
    public void showData(BaseRecyclerViewHolder holder, int i, List<String> list) {
        final RecycleHoldView holdView = (RecycleHoldView) holder;
        holdView.tv.setText(list.get(i));
    }

    @Override
    public BaseRecyclerViewHolder createViewHolder(View view) {
        setOnItemClickLitener(this);
        return new RecycleHoldView(view);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e("position", position + "");
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Log.e("position_long", position + "");
    }

    class RecycleHoldView extends BaseRecyclerViewHolder {

        TextView tv;

        public RecycleHoldView(View itemView) {
            super(itemView);
            tv = (TextView) findView(R.id.tv);
        }
    }
}