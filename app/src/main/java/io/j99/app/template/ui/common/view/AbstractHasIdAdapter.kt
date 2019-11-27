package io.j99.app.template.ui.common.view

import androidx.annotation.CallSuper
import androidx.annotation.MainThread
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.j99.app.template.ui.common.model.IdObject


abstract class AbstractHasIdAdapter<T : IdObject, V : RecyclerView.ViewHolder>(
    val _hasStableIds: Boolean?, onItemActionListener: OnItemActionListener?
) : AbstractAdapter<T, V>(onItemActionListener) {

    init {
        super.setHasStableIds(_hasStableIds ?: false)
    }

    //todo 次方法内部以后改成异步
    @MainThread
    open fun update(items: List<T>, diff: Boolean = true) {
        if (diff) {
            val result =
                DiffUtil.calculateDiff(SimpleDiffCallback(ArrayList(this.items), ArrayList(items)))
            this.items.clear()
            this.items.addAll(items)
            result.dispatchUpdatesTo(this)
        } else {
            super.update(items)
        }
    }

    @CallSuper
    override fun getItemId(position: Int): Long {
        return items[position].getItemId()
    }

    private class SimpleDiffCallback<T : IdObject>(val olds: List<T>, val news: List<T>) :
        DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            olds[oldItemPosition].getItemId() == news[newItemPosition].getItemId()

        override fun getOldListSize(): Int = olds.size

        override fun getNewListSize(): Int = news.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            olds[oldItemPosition] == news[newItemPosition]
    }
}