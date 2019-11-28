package io.j99.app.template.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.google.gson.Gson
import io.j99.app.template.R
import io.j99.app.template.db.AppDatabase
import io.j99.app.template.db.dao.UserInfoDao
import io.j99.app.template.ext.rx.async
import io.j99.app.template.ui.common.view.AbstractTitleActivity
import io.j99.app.template.ui.common.view.AbstractBottomDialog
import io.j99.app.template.ui.common.view.AppDialog
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
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
        addDisposable(
            Observable.timer(1000, TimeUnit.MILLISECONDS).subscribe {
                val dialog = MyBottomDialog()

                dialog.show(supportFragmentManager, "dialog")
            }
        )
        addDisposable(
            Observable.timer(1200, TimeUnit.MILLISECONDS).subscribe {
                AppDialog.show(supportFragmentManager, message = "this is message")

            }
        )

    }

    class MyBottomDialog : AbstractBottomDialog() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return TextView(requireContext()).apply { text = "aadsfadsfafasfdsf" }.apply {
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
            }
        }
    }
}
