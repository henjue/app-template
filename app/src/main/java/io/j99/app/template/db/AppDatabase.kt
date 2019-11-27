/**
 * Author: chenjin
 * Date: 2019-11-26 17:01
 * Description:
 */
package io.j99.app.template.db

import androidx.room.Database
import androidx.room.RoomDatabase
import io.j99.app.template.db.dao.UserInfoDao
import io.j99.app.template.db.entity.UserInfo

@Database(entities = arrayOf(UserInfo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserInfoDao
}