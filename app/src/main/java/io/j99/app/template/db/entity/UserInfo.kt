/**
 * Author: chenjin
 * Date: 2019-11-26 16:49
 * Description:
 */
package io.j99.app.template.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info")
data class UserInfo(
    @PrimaryKey
    var id: Long,
    var username: String?,
    var nickname: String?
)