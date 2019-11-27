/**
 * Author: chenjin
 * Date: 2019-11-26 15:21
 * Description:
 */
package io.j99.app.template.network.service

import io.reactivex.Observable

interface UserService {
    fun login(username: String, password: String): Observable<String>
}