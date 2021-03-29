package usage.ywb.demo.jetpack.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import usage.ywb.demo.jetpack.BR
import usage.ywb.demo.jetpack.R
import usage.ywb.demo.jetpack.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentDashboardBinding
    private var adapter: DashboardAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        recyclerView = binding.dashboardList
        dashboardViewModel.getDashboardList(requireContext(), this, {
            setAdapter(it)
        })
        binding.setVariable(BR.fragment, this)
        return binding.root
    }

    private fun setAdapter(data: List<DashboardData>) {
        if (adapter == null) {
            adapter = DashboardAdapter(requireContext(), data)
            recyclerView.adapter = adapter
        } else {
            adapter?.setDataList(data)
            adapter?.notifyDataSetChanged()
        }
    }

    var index: Int = 0;

    fun onClickAdd() {
        index++
        val data = DashboardData("数据$index")
        val result = dashboardViewModel.addDashboard(requireContext(), data)
        if (result > 0) {
            Toast.makeText(requireContext(), "${data.dashName}插入成功！", Toast.LENGTH_SHORT).show()
        }
    }

}