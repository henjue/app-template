package io.j99.app.template.di.module

import android.app.Application
import android.util.Log

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.j99.app.template.BuildConfig
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class HttpModule {
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {

        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .baseUrl(BuildConfig.API_SERVER)
            .build()
    }


    @Provides
    @Singleton
    fun provideHttpClient(application: Application): OkHttpClient {
        val loggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                Log.d("HttpModule", message)
                if (message.startsWith("{") && message.endsWith("}") || message.startsWith("[") && message.endsWith(
                        "]"
                    )
                ) {
                }

            })
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(7, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("timestamp", System.currentTimeMillis().toString())
                    .build()
                chain.proceed(request)
            }
            .addNetworkInterceptor(
                if (BuildConfig.DEBUG)
                    loggingInterceptor
                else
                    Interceptor { chain -> chain.proceed(chain.request()) })

            .build()
    }
}