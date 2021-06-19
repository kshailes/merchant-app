package com.example.merchant.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.merchant.BR

class CommonAdapter<T : ItemViewModel?>(
    var items: List<T>,
    itemClickListener: ItemClickListener<T>? = null
) :
    RecyclerView.Adapter<CommonAdapter.ViewHolder<T>>() {
    private var itemClickListener: ItemClickListener<T>? = null
    private var mLayoutInflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.context)
        }
        return ViewHolder(mLayoutInflater!!.inflate(viewType, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(items[position], itemClickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position]?.viewType ?: 0
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder<T> internal constructor(itemView: View?) : RecyclerView.ViewHolder(
        itemView!!
    ) {
        private val binding: ViewDataBinding?
        fun bind(value: T, clickListener: ItemClickListener<T>?) {
            binding!!.setVariable(BR.item, value)
            binding.root.setOnClickListener { v: View? ->
                clickListener?.onItemClick(
                    value
                )
            }
        }

        init {
            binding = DataBindingUtil.bind(itemView!!)
        }
    }

    init {
        this.itemClickListener = itemClickListener

    }
}