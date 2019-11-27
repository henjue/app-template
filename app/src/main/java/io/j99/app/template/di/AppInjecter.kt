package io.j99.app.template.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.j99.app.template.App
import io.j99.app.template.common.EmptyActivityLifecycleCallbacks
import io.j99.app.template.di.component.DaggerAppComponent

object AppInjecter {
    @JvmStatic
    fun inject(application: App) {
        DaggerAppComponent.builder()
            .application(application)
            .build()
            .inject(application)
        application.registerActivityLifecycleCallbacks(object :
            EmptyActivityLifecycleCallbacks() {
            override fun onActivityCreated(activity: Activity, p1: Bundle?) {
                super.onActivityCreated(activity, p1)
                if (activity is HasAndroidInjector || activity is Injectable) {
                    AndroidInjection.inject(activity)
                }
                if (activity is FragmentActivity) {
                    activity.supportFragmentManager
                        .registerFragmentLifecycleCallbacks(
                            object : FragmentManager.FragmentLifecycleCallbacks() {
                                override fun onFragmentCreated(
                                    fm: FragmentManager,
                                    f: Fragment,
                                    savedInstanceState: Bundle?
                                ) {
                                    super.onFragmentCreated(fm, f, savedInstanceState)
                                    if (f is Injectable) {
                                        AndroidSupportInjection.inject(f)
                                    }
                                }
                            }, true
                        )
                }
            }
        })
    }
}