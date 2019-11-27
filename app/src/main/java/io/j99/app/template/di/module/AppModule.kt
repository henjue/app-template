package io.j99.app.template.di.module

import android.app.Application
import android.content.Context

import dagger.Module
import dagger.Provides
import io.j99.app.template.App
import io.j99.app.template.di.rx.AppSchedulerProvider
import io.j99.app.template.di.rx.SchedulerProvider
import javax.inject.Singleton


@Module(includes = [AppProvider::class])
class AppModule {
    @Provides
    @Singleton
    fun providesContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun providesApplication(application: App): Application {
        return application
    }

    /**
     * 如果不需要接口模式解耦则不需要此方法直接在AppSchedulerProvider构造函数增加@Inject注解即可
     */
    @Singleton
    @Provides
    fun providesSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

}