/**
 * Author: chenjin
 * Date: 2019-11-26 17:14
 * Description:
 */
package io.j99.app.template.ui.common.view

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.j99.app.template.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import permissions.dispatcher.PermissionRequest
import javax.inject.Inject

/**
 * Abstract Activity
 */
abstract class AbstractActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
    fun showRationaleDialog(@StringRes messageResId: Int, request: PermissionRequest) {
        AlertDialog.Builder(this)
            .setPositiveButton(R.string.button_allow) { dialog, which -> request.proceed() }
            .setNegativeButton(R.string.button_deny) { dialog, which -> request.cancel() }
            .setCancelable(false)
            .setMessage(messageResId)
            .show()
    }

    protected val compositeDisposable = CompositeDisposable()
    @CallSuper
    fun addDisposable(d: Disposable) {
        compositeDisposable.add(d)
    }


    fun showLoading(message: String? = "请稍等") {
        LoadingDialog.newInstence(message).show(supportFragmentManager, "loading")
    }

    fun hideLoading() {
        val dialog = supportFragmentManager.findFragmentByTag("loading") as? LoadingDialog
        dialog?.dismissAllowingStateLoss()
    }

    open val showTitle = false
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onTitleChanged(title: CharSequence?, color: Int) {
        super.onTitleChanged(title, color)
        mTitle?.text = title
    }

    private var mTitle: TextView? = null
    private var mContent: FrameLayout? = null
    private var mToolbar: Toolbar? = null
    @CallSuper
    override fun setContentView(view: View?) {
        if (showTitle) {
            super.setContentView(R.layout.activity_abstract)
            mContent = findViewById(R.id.abstract_content)
            mTitle = findViewById(R.id.base_title)
            mToolbar = findViewById(R.id.toolbar)
            mToolbar?.title = ""
            mContent?.addView(view)
            setSupportActionBar(mToolbar)
            val actionBar = supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setDisplayShowHomeEnabled(true)
            initToolBar(mToolbar)
        } else {
            super.setContentView(view)
        }

    }

    @CallSuper
    override fun setContentView(layoutResID: Int) {
        val view = layoutInflater.inflate(layoutResID, null, false)
        this.setContentView(view)
    }

    fun <T : ViewDataBinding> binding(@LayoutRes layoutResID: Int): T {
        val binding = DataBindingUtil.inflate<T>(layoutInflater, layoutResID, null, false)
        setContentView(binding.root)
        return binding
    }

    /**
     * toolbar初始化完成时调用
     *
     * @param toolbar
     */
    open protected fun initToolBar(toolbar: Toolbar?) {

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    override fun onSupportNavigateUp(): Boolean {
        val b = if (navControllerId > 0) {
            findNavController(navControllerId).navigateUp() || super.onSupportNavigateUp()
        } else {
            super.onSupportNavigateUp()
        }
        if (!b) {
            finish()
        }
        return b
    }

    @IdRes
    open val navControllerId: Int = 0
}