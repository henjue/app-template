/**
 * Author: chenjin
 * Date: 2019-11-26 18:19
 * Description:
 */
package io.j99.app.template.ext

import android.widget.ImageView
import io.j99.app.template.common.BindingAdapter

fun ImageView.setUrl(url: String?) {
    BindingAdapter.setImage(this, url)
}