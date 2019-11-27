package io.j99.app.template.ui.common.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper

/**
 * RecyclerView Databinding Abstract Adapter
 */
abstract class AbstractBindAdapter<T, B : androidx.databinding.ViewDataBinding>(
    onItemActionListener: OnItemActionListener? = null
) : AbstractAdapter<T, BindingViewHolder<T, B>>(onItemActionListener) {
    @CallSuper
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<T, B> {
        return BindingViewHolder(
            createBinding(
                LayoutInflater.from(parent.context),
                parent,
                viewType
            )
        )
    }

    @CallSuper
    override fun onBindViewHolder(holder: BindingViewHolder<T, B>, position: Int) {
        super.onBindViewHolder(holder, position)
        onBind(items[position], holder.binding)
    }

    abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): B
    abstract fun onBind(item: T, binding: B)
}