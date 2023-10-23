package com.venu.sleeptracker.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter

@Composable
fun ImageCrop(
    modifier: Modifier = Modifier,
    data: Any? = null,
    placeHolderRes: Int? = null,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
) {
    val painter = rememberImagePainter(data = data) {
        //  placeholder(placeHolderRes?: R.drawable.ic_album)
        //  error(placeHolderRes?: R.drawable.ic_album)
    }
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale,
        alignment = alignment
    )
}