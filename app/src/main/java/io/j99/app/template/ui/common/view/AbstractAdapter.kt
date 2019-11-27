package io.j99.app.template.ui.common.view


import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.MainThread
import androidx.recyclerview.widget.RecyclerView

/**
 *  RecyclerView  Abstract Adapter
 */
abstract class AbstractAdapter<T, V : RecyclerView.ViewHolder>(
    val onItemActionListener: OnItemActionListener? = null
) : RecyclerView.Adapter<V>() {
    val items: MutableList<T> = mutableListOf()

    @MainThread
    open fun update(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()

    }

    @MainThread
    fun refresh(items: List<T>, refresh: Boolean = true) {
        this.items.clear()
        this.items.addAll(items)
        if (refresh) notifyDataSetChanged()
    }

    @MainThread
    fun append(items: List<T>, refresh: Boolean = true) {
        this.items.addAll(items)
        if (refresh) notifyItemRangeInserted(this.items.size - items.size, items.size)
    }

    @MainThread
    fun replace(position: Int, item: T, refresh: Boolean = true) {
        this.items.set(position, item)
        if (refresh) notifyItemChanged(position)
    }

    @MainThread
    fun append(position: Int, items: List<T>, refresh: Boolean = true) {
        this.items.addAll(position, items)
        if (refresh) notifyItemRangeInserted(position, items.size)
    }

    @MainThread
    fun remove(position: Int, refresh: Boolean = true) {
        this.items.removeAt(position)
        if (refresh) notifyItemRemoved(position)
    }

    @MainThread
    fun remove(item: T, refresh: Boolean = true) {
        val index = items.indexOf(item)
        if (index != -1) {
            this.items.removeAt(index)
            if (refresh) notifyItemRemoved(index)
        }
    }

    @CallSuper
    override fun onBindViewHolder(holder: V, position: Int) {
        if (onItemActionListener != null) {
            holder.itemView.setOnClickListener {
                onItemActionListener.onItemClick(it, holder)
            }
        }
    }

    @CallSuper
    override fun getItemCount(): Int = items.size


    interface OnItemActionListener {
        fun onItemClick(view: View, viewHolder: RecyclerView.ViewHolder)
    }
}