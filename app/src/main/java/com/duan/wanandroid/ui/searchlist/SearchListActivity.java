package com.duan.wanandroid.ui.searchlist;

import android.app.ActivityOptions;
import android.os.Build;
import android.text.Html;

import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.SearchListAdapter;
import com.duan.wanandroid.base.BaseMvpActivity;
import com.duan.wanandroid.bean.SearchListBean;
import com.duan.wanandroid.utlis.JumpUtlis;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class SearchListActivity extends BaseMvpActivity<SearchListPresent> implements SearchListView {

    @BindView(R.id.sh_back_img)
    AppCompatImageView shBackImg;
    @BindView(R.id.sh_text)
    AppCompatTextView shText;
    @BindView(R.id.sh_list_rv)
    RecyclerView shListRv;
    private int page = 0;
    private String k;//从搜索界面传过来的字段
    SearchListAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search_list;
    }

    @NonNull
    @Override
    protected SearchListPresent initPresenter() {
        return new SearchListImpl(this, this, this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void SetListData(List<SearchListBean.DataBean.DatasBean> list) {
        adapter = new SearchListAdapter(R.layout.item_mianfra, list);
        shListRv.setLayoutManager(new LinearLayoutManager(this));
        shListRv.setAdapter(adapter);
        adapter.setOnItemChildClickListener((adapter, view, position) -> {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, view, getString(R.string.tranname));
            JumpUtlis.ToWebDetial(mContext,
                    list.get(position).getLink(),
                    list.get(position).getTitle(),
                    options);
        });
    }

    @Override
    public void initView() {
        k = getIntent().getStringExtra("search_text");
        shText.setText(Html.fromHtml(k));
        presenter.GetSearchListData(page, k);
    }

    @OnClick(R.id.sh_back_img)
    public void onViewClicked() {
        finish();
    }
}
