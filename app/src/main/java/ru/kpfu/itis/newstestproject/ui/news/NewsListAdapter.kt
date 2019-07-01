package ru.kpfu.itis.newstestproject.ui.news

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.newstestproject.R
import ru.kpfu.itis.newstestproject.data.model.Article
import ru.kpfu.itis.newstestproject.databinding.ItemNewsBinding

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {

    private lateinit var articleList: List<Article>


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsListViewHolder {
        val binding: ItemNewsBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_news, parent, false)
        return NewsListViewHolder(binding)
    }

    override fun getItemCount(): Int = if (::articleList.isInitialized) articleList.size else 0

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    fun update(articleList: List<Article>) {
        this.articleList = articleList
        notifyDataSetChanged()
    }

    class NewsListViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        private val viewModel = NewsViewModel()

        fun bind(article: Article) {
            viewModel.bind(article)
            binding.viewModel = viewModel
        }

    }
}