/**
 * Author: chenjin
 * Date: 2019-11-26 14:59
 * Description:
 */
package io.j99.app.template

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.j99.app.template.di.AppInjecter
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        AppInjecter.inject(this)
    }
}