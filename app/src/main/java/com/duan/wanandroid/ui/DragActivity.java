package com.duan.wanandroid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.duan.wanandroid.R;
import com.duan.wanandroid.bean.DragBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DragActivity extends AppCompatActivity {

    @BindView(R.id.drag_rv)
    RecyclerView dragRv;
    DragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        List<DragBean> list=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            DragBean bean=new DragBean();
            bean.setName("我的频道"+i);
            list.add(bean);
        }
        List<String>mlist=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            mlist.add("频道"+i);
        }
        for (DragBean bean : list) {
            bean.setList(mlist);
        }
        dragRv.setLayoutManager(new LinearLayoutManager(this));
        adapter=new DragAdapter(R.layout.item_drag,list);

        dragRv.setAdapter(adapter);
    }
}
class DragAdapter extends BaseItemDraggableAdapter<DragBean,BaseViewHolder> {
    RecyclerView view;
    DragAchilddapter achilddapter;
    public DragAdapter(int layoutResId, @Nullable List<DragBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DragBean item) {
        helper.setText(R.id.ad_text,item.getName());
        view=helper.getView(R.id.ad_child_rv);
        view.setLayoutManager(new GridLayoutManager(mContext,3));
        achilddapter=new DragAchilddapter(R.layout.item_nav_child,item.getList());
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(achilddapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(view);
        OnItemDragListener onItemDragListener = new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos){}
            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {}
            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {}
        };
// 开启拖拽
        achilddapter.enableDragItem(itemTouchHelper, R.id.nav_text, true);
        achilddapter.setOnItemDragListener(onItemDragListener);
        view.setAdapter(achilddapter);
    }
}
class DragAchilddapter extends BaseItemDraggableAdapter<String,BaseViewHolder> {
    public DragAchilddapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.nav_text,item);
    }
}