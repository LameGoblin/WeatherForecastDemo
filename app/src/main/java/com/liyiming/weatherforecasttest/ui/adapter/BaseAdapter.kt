package com.liyiming.weatherforecasttest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.liyiming.weatherforecasttest.base.BaseViewHolder

abstract class BaseAdapter<T>(var data: List<T> = listOf()): RecyclerView.Adapter<BaseViewHolder>() {
    lateinit var context: AppCompatActivity
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context as AppCompatActivity
        return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun refreshData(newData: List<T>) {
        this.data = newData
        this.notifyDataSetChanged()
    }
}