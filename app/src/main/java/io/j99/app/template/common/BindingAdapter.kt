package io.j99.app.template.common

import android.graphics.drawable.Drawable
import android.widget.ImageView

object BindingAdapter {
    @JvmStatic
    fun setImage(
        iv: ImageView,
        url: String?,
        drawable: Drawable? = null,
        error: Drawable? = null
    ) {
        GlideApp.with(iv)
            .load(url)
            .placeholder(drawable)
            .error(error)
            .into(iv)
    }
}