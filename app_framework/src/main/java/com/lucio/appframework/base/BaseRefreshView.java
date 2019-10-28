package com.lucio.appframework.base;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public abstract class BaseRefreshView<T> {

    private List<T> mData;

    private int pageSize = 10;

    private int pageNum = 1;

    private void initRefresh(Activity mActivity) {

        getRecyclerView().setAdapter(getAdapter());

        getRefreshLayout().setRefreshHeader(new ClassicsHeader(mActivity));
        if (isLoad()) {
            getRefreshLayout().setRefreshFooter(new ClassicsFooter(mActivity));

        }

        getRefreshLayout().setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pageNum++;

                getRefreshRequest().request(pageSize, pageNum);

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageNum = 0;
                getRefreshRequest().request(pageSize, pageNum);
            }
        });
    }

    public abstract SmartRefreshLayout getRefreshLayout();

    public abstract RecyclerView getRecyclerView();

    public abstract RecyclerView.Adapter getAdapter();

    public boolean isLoad() {
        return true;
    }

    public abstract RefreshRequest getRefreshRequest();

    public interface RefreshRequest {
        void request(int pageSize, int pageNum);
    }
}
