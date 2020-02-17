package com.example.mobiletopup.ui.account.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobiletopup.BR;
import com.example.mobiletopup.R;
import com.example.mobiletopup.databinding.ReportDetailBinding;
import com.example.mobiletopup.ui.account.dto.FinancialReport;
import com.example.mobiletopup.utils.IOnItemClick;

import java.util.List;

public class FinancialReportAdapter extends RecyclerView.Adapter<FinancialReportAdapter.ViewHolder> {
    private List<FinancialReport> userList;
    private ReportDetailBinding mUserItem;
    private IOnItemClick iOnItemClick;

    public FinancialReportAdapter(/*List<User> notificationsList*/) {
//            userList = notificationsList;
    }

    public void setInterface(IOnItemClick itemClick) {
        iOnItemClick = itemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mUserItem= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.report_detail, null, false);
        return new ViewHolder(mUserItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FinancialReport user = userList.get(position);
        holder.bind(user);
        mUserItem.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnItemClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (userList != null) {
            return userList.size();
        } else {
            return 0;
        }
    }

    public void setDataset(List<FinancialReport> listUsers) {
        userList = listUsers;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(ReportDetailBinding userItemBinding) {

            super(userItemBinding.getRoot());
            mUserItem = userItemBinding;
        }
        public void bind(FinancialReport obj) {
            mUserItem.setVariable(BR.user, obj);
            mUserItem.executePendingBindings();
        }
    }

}

