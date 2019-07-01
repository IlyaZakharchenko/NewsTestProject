package ru.kpfu.itis.newstestproject.ui.source

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.newstestproject.R
import ru.kpfu.itis.newstestproject.data.model.Source
import ru.kpfu.itis.newstestproject.databinding.ItemSourceBinding

class SourceListAdapter : RecyclerView.Adapter<SourceListAdapter.SourceViewHolder>() {

    private lateinit var sourceList: List<Source>

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SourceViewHolder {
        val binding: ItemSourceBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_source, parent, false)
        return SourceViewHolder(binding)
    }

    override fun getItemCount() = if (::sourceList.isInitialized) sourceList.size else 0

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        holder.bind(sourceList[position])
    }

    fun update(sourceList: List<Source>) {
        this.sourceList = sourceList
        notifyDataSetChanged()
    }

    class SourceViewHolder(private val binding: ItemSourceBinding) : RecyclerView.ViewHolder(binding.root) {

        private val viewModel = SourceViewModel()

        fun bind(source: Source) {
            viewModel.bind(source)
            binding.viewModel = viewModel
        }
    }
}