package ru.kpfu.itis.newstestproject.data.model

data class Article(
    var source: Source,
    var title: String,
    var author: String,
    var description: String,
    var imageUrl: String,
    var publishedAt: String,
    var content: String
)