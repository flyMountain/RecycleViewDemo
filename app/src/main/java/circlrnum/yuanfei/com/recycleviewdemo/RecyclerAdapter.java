package circlrnum.yuanfei.com.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import circlrnum.yuanfei.com.recycleviewdemo.widget.BaseRecyclerViewHolder;

/**
 * 作者 yuanfei on 2016/10/17.
 * 邮箱 yuanfei221@126.com
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecycleHoldView> {

    List<String> list = new ArrayList<>();
    Context context;
    public RecyclerAdapter(Context context,List<String> list){
        this.list = list;
        this.context = context;

    }
    @Override
    public RecyclerAdapter.RecycleHoldView onCreateViewHolder(ViewGroup parent, int viewType) {
        RecycleHoldView holder = new RecycleHoldView(LayoutInflater.from(
                context).inflate(R.layout.item_home, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecycleHoldView holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class RecycleHoldView extends BaseRecyclerViewHolder{

        TextView tv;

        public RecycleHoldView(View itemView) {
            super(itemView);
            tv = (TextView) findView(R.id.tv);
        }

    }
}
