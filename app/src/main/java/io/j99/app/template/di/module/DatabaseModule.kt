/**
 * Author: chenjin
 * Date: 2019-11-26 17:04
 * Description:
 */
package io.j99.app.template.di.module

import android.app.Application
import androidx.room.Room
import com.chaoran.winemarket.di.DatabaseInfo
import dagger.Module
import dagger.Provides
import io.j99.app.template.db.AppDatabase
import io.j99.app.template.db.dao.UserInfoDao
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application, @DatabaseInfo db_name: String): AppDatabase {
        val db = Room.databaseBuilder(
            application,
            AppDatabase::class.java, db_name
        ).build()
        return db
    }

    @Provides
    @Singleton
    fun provideUserInfoDao(db: AppDatabase): UserInfoDao {
        return db.userDao()
    }
}