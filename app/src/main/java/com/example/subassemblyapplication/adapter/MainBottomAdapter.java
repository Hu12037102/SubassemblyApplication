package com.example.subassemblyapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comm.utils.DataUtils;
import com.example.subassemblyapplication.R;
import com.example.subassemblyapplication.bean.HomeBottomBean;

import java.util.List;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/14
 * 更新时间: 2019/12/14
 * 描述: 首页BottomAdapter
 */
public class MainBottomAdapter extends RecyclerView.Adapter<MainBottomAdapter.ViewHolder> {
    private Context mContext;
    private List<HomeBottomBean> mData;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener onItemClickListener;

    public MainBottomAdapter(@NonNull Context context, @NonNull List<HomeBottomBean> data) {
        this.mContext = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mian_bottom_view, parent, false));
    }

    public void selectorTab(int position) {
        if (mData == null || mData.size() == 0) {
            return;
        }
        if (position < 0 || position > mData.size() - 1) {
            position = 0;
        }
         HomeBottomBean selectorBean = mData.get(position);
        for (HomeBottomBean homeBottomBean : mData) {
            homeBottomBean.isCheck= selectorBean .equals(homeBottomBean);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final HomeBottomBean bean = mData.get(position);
        holder.mTvName.setText(bean.name);
        if (bean.isCheck) {
            holder.mTvName.setCompoundDrawablesWithIntrinsicBounds(0, bean.checkResId, 0, 0);
            holder.mTvName.setTextColor(DataUtils.getColor(R.color.color_2));
        } else {
            holder.mTvName.setCompoundDrawablesWithIntrinsicBounds(0, bean.defaultResId, 0, 0);
            holder.mTvName.setTextColor(DataUtils.getColor(R.color.color_3));
        }
        holder.itemView.setOnClickListener(v -> {
            if (!bean.isCheck) {
                for (HomeBottomBean bottomBean : mData) {
                    bottomBean.isCheck = bottomBean.equals(bean);
                }
              /*  for (int i = 0;i < mData.size();i++){
                    if (i == position){
                        bean.isCheck = true;
                    }else {
                        bean.isCheck = false;
                    }
                }*/
                notifyDataSetChanged();
                if (onItemClickListener != null) {
                    onItemClickListener.onClickItem(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_name);
            ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
            layoutParams.width = itemView.getContext().getResources().getDisplayMetrics().widthPixels / 4;
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            itemView.setLayoutParams(layoutParams);
        }
    }

    public interface OnItemClickListener {
        void onClickItem(View view, int position);
    }
}
