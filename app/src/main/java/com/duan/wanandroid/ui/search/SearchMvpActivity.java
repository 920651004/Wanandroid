package com.duan.wanandroid.ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.SearchAdapter;
import com.duan.wanandroid.base.BaseMvpActivity;
import com.duan.wanandroid.bean.HotText;
import com.duan.wanandroid.utlis.CommonUtils;
import com.duan.wanandroid.utlis.JumpUtlis;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class SearchMvpActivity extends BaseMvpActivity<SearchPresenter> implements SearchMvpView {


    @BindView(R.id.search_back_img)
    AppCompatImageView searchBackImg;
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.search_text)
    AppCompatTextView searchText;
    @BindView(R.id.search_rl)
    RelativeLayout searchRl;
    @BindView(R.id.search_hot)
    AppCompatTextView searchHot;
    @BindView(R.id.hot_rv)
    RecyclerView hotRv;
    @BindView(R.id.search_clear)
    AppCompatTextView searchClear;
    @BindView(R.id.serach_history_rv)
    RecyclerView serachHistoryRv;
    @BindView(R.id.hot_flow)
    TagFlowLayout hotFlow;
    private List<HotText.DataBean> dataBeanList;
    SearchAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @NonNull
    @Override
    protected SearchPresenter initPresenter() {
        return new SearchImpl(this, this, this);
    }


    @Override
    public void setHotInfo(List<HotText.DataBean> hotList) {
        dataBeanList = hotList;
        hotFlow.setAdapter(new TagAdapter<HotText.DataBean>(hotList) {
            @Override
            public View getView(FlowLayout parent, int position, HotText.DataBean dataBean) {
                TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.flow_layout_tv,
                        hotFlow, false);
                String name = dataBean.getName();
                tv.setPadding(30, 30,
                        30, 30);
                tv.setText(name);
                tv.setTextColor(CommonUtils.randomTagColor());
                return tv;
            }
        });
    }


    @Override
    public void initView() {
        presenter.getHotText();
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("搜索更多干货");

        adapter = new SearchAdapter(R.layout.item_search, presenter.LoadHistory());
        serachHistoryRv.setLayoutManager(new LinearLayoutManager(this));
        serachHistoryRv.setAdapter(adapter);
        adapter.setOnItemChildClickListener((adapter, view, position) -> {

        });

        searchView.setOnQueryTextFocusChangeListener((view, b) -> {

        });
        hotFlow.setOnTagClickListener((view, position, parent) -> {

            presenter.addHistory(dataBeanList.get(position).getName());
            adapter.setNewData(presenter.LoadHistory());
            JumpUtlis.GoSearchDetial(mContext, dataBeanList.get(position).getName());
            return true;
        });
    }


    @OnClick({R.id.search_back_img, R.id.search_text, R.id.search_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_back_img:
                finish();
                break;
            case R.id.search_text:
                if (StringUtils.isEmpty(searchView.getQuery())) return;
                presenter.addHistory(searchView.getQuery().toString());
                adapter.setNewData(presenter.LoadHistory());
                JumpUtlis.GoSearchDetial(mContext, searchView.getQuery().toString());
                break;
            case R.id.search_clear:
                presenter.clearHistory();
                adapter.setNewData(new ArrayList<>());
                break;
        }
    }
}
