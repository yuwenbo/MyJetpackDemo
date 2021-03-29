package usage.ywb.demo.jetpack.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import usage.ywb.demo.jetpack.BR;
import usage.ywb.demo.jetpack.R;
import usage.ywb.demo.jetpack.databinding.AdapterDashboardItemBinding;
import usage.ywb.demo.jetpack.databinding.AdapterDashboardItemBindingImpl;

/**
 * @author yuwenbo
 * @version [ V.3.0.0  2021/3/15 ]
 */
public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.Holder> {

    private List<DashboardData> dataList;

    private LayoutInflater inflater;

    public DashboardAdapter(Context context, List<DashboardData> dataList) {
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }

    public void setDataList(List<DashboardData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.adapter_dashboard_item, parent, false);
        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        DataBindingUtil.getBinding(holder.itemView).setVariable(BR.dash, dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
