/**
 * Author: chenjin
 * Date: 2019-11-26 17:09
 * Description:
 */
package io.j99.app.template.ext.rx

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

inline fun <reified T> Observable<T>.async(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}