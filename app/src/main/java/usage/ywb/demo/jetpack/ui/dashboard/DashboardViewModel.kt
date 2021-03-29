package usage.ywb.demo.jetpack.ui.dashboard

import android.content.Context
import androidx.lifecycle.*

class DashboardViewModel : ViewModel() {

    fun getDashboardList(
        context: Context,
        owner: LifecycleOwner,
        observer: Observer<List<DashboardData>>
    ) {
        AppDataBase.getInstance(context).getDashboardDao().selectAll().observe(owner, observer)
    }

    fun addDashboard(context: Context,data: DashboardData):Long {
       return AppDataBase.getInstance(context).getDashboardDao().insert(data)
    }

}