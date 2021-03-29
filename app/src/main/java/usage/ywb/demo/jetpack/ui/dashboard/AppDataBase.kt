package usage.ywb.demo.jetpack.ui.dashboard

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 *
 * @author  yuwenbo
 * @version [ V.3.0.0  2021/3/12 ]
 */
@Database(version = 1, entities = [DashboardData::class])
abstract class AppDataBase : RoomDatabase() {

    abstract fun getDashboardDao(): DashboardDao

    companion object {

        private const val databaseName: String = "MyJetpackDemo_database"

        @Volatile
        private var instance: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context): AppDataBase {
            return instance ?: buildDataBase(context)
        }

        private fun buildDataBase(context: Context): AppDataBase {
            return Room
                .databaseBuilder(context, AppDataBase::class.java, databaseName)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                })
                .allowMainThreadQueries()//允许在主线程中执行
                .build()
        }

    }

}