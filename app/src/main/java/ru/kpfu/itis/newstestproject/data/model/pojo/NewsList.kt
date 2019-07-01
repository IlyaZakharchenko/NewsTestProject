package ru.kpfu.itis.newstestproject.data.model.pojo

import ru.kpfu.itis.newstestproject.data.model.Article

data class NewsList(var status: String, var totalResults: Int, var articles: List<Article>)