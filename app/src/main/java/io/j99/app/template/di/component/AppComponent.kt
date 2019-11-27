package io.j99.app.template.di.component


import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import io.j99.app.template.App
import io.j99.app.template.di.builder.ActivityBuilder
import io.j99.app.template.di.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        HttpModule::class,
        HttpServiceModule::class,
        CommonModule::class,
        StringModule::class,
        DatabaseModule::class,
        ActivityBuilder::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)

}