package io.j99.app.template.ui.common.view

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingViewHolder<ITEM, T : ViewDataBinding>(val binding: T) :
    RecyclerView.ViewHolder(binding.root) {
}