package com.profesional.samplemvvmrazi.ui.itemPage

import javax.inject.Inject

data class ItemModel @Inject constructor(
    var albumId: Int,
    var id: Int,
    var thumbnailUrl: String,
    var title: String,
    var url: String
)