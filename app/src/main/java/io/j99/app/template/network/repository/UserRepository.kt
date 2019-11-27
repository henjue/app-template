/**
 * Author: chenjin
 * Date: 2019-11-26 15:21
 * Description:
 */
package io.j99.app.template.network.repository

import io.j99.app.template.network.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(service: UserService) : UserService {
    override fun login(username: String, password: String): Observable<String> {
        return Observable.empty()
    }

}