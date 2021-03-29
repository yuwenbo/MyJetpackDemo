package usage.ywb.demo.jetpack.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 *
 * @author  yuwenbo
 * @version [ V.3.0.0  2021/3/12 ]
 */
@Dao
interface DashboardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: DashboardData): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(data: DashboardData): Int

    @Delete
    fun delete(data: DashboardData): Int

    @Query("SELECT * FROM DashboardData")
    fun selectAll(): LiveData<List<DashboardData>>

    @Query("SELECT * FROM DashboardData WHERE id = :id")
    fun selectById(id: Long): DashboardData

}