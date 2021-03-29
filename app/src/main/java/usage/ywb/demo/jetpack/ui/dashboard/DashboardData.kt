package usage.ywb.demo.jetpack.ui.dashboard

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @author  yuwenbo
 * @version [ V.3.0.0  2021/3/12 ]
 */
@Entity(tableName = "DashboardData")
data class DashboardData(
    @ColumnInfo(name = "dash_name") var dashName: String?
) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo(name = "desc")
    var desc: String? = null

    @ColumnInfo(name = "count")
    var count: Int = 0

}