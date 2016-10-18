package circlrnum.yuanfei.com.recycleviewdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import circlrnum.yuanfei.com.recycleviewdemo.widget.CustomRecycleView;

/**
 * Created by admin on 2016/10/12.
 */

public class MainActivity extends AppCompatActivity implements CustomRecycleView.OnMutilRecyclerViewListener {
    CustomRecycleView recycleView;
    RecyclerAdapter adapter;
    List<String> list = new ArrayList<>();
    private int flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        recycleView = (CustomRecycleView) findViewById(R.id.recycleView);
        recycleView.setOnMutilRecyclerViewListener(this);
        setRecycle();
        setDate(0);
    }

    @Override
    public void onRefresh() {
        flag = 0;
        list.clear();
        new UpdateTextTask().execute();
    }

    @Override
    public void onLoadMore() {
        flag = flag +10;
        new UpdateTextTask().execute();
    }

    public void setRecycle() {
        adapter = new RecyclerAdapter(this, list);
        recycleView.setAdapter(adapter);
    }

    public void setTime() {
        setDate(flag);
        recycleView.stopLoadingMore();
        recycleView.stopRefresh();
    }

    public void setDate(int index) {
        for (int i = index; i < 10 + index; i++) {
            list.add("ni" + i);
        }
        adapter.notifyDataSetChanged();
    }
    class UpdateTextTask extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            setTime();
        }

        @Override
        protected void onProgressUpdate(String... values) {

        }
    }
}
