/**
 * Author: chenjin
 * Date: 2019-11-26 17:00
 * Description:
 */
package io.j99.app.template.db.dao

import androidx.room.Dao
import androidx.room.Query
import io.j99.app.template.db.entity.UserInfo
import io.reactivex.Observable

@Dao
interface UserInfoDao {
    @Query("SELECT * FROM user_info")
    fun getAll(): Observable<UserInfo>

}