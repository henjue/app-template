package io.j99.app.template.di.module

import dagger.Module
import dagger.Provides
import io.j99.app.template.network.repository.UserRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
open class HttpServiceModule {
//    @Singleton
//    @Provides
//    open fun providesUserService2(retrofit: Retrofit): UserService {
//        return object:UserService{
//            override fun login(username: String, password: String):  Observable<String>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   e<Result<String>> {
//                //todo 用其他任何网络框架实现具体的请求
//                return Observable.empty()
//            }
//        }
//    }
    /**
     * 换其他网络框架需要返回一个实现了UserService接口的对象（参考本类中注释的方法）
     */
    @Singleton
    @Provides
    open fun providesUserService(retrofit: Retrofit): UserRepository {
        return retrofit.create(UserRepository::class.java)
    }
}
