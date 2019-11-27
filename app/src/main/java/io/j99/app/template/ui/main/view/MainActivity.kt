package io.j99.app.template.ui.main.view

import android.os.Bundle
import com.google.gson.Gson
import io.j99.app.template.R
import io.j99.app.template.db.AppDatabase
import io.j99.app.template.db.dao.UserInfoDao
import io.j99.app.template.ext.rx.async
import io.j99.app.template.ui.common.view.AbstractTitleActivity
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AbstractTitleActivity() {

    @Inject
    lateinit var gson: Gson
    @Inject
    lateinit var retrofit: Retrofit
    @Inject
    lateinit var httpClient: OkHttpClient
    @Inject
    lateinit var database: AppDatabase
    @Inject
    lateinit var userInfoDao: UserInfoDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addDisposable(
            userInfoDao.getAll().async().subscribe()
        )
    }
}
