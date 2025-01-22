package org.yakushev.weblaba1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TextCaption(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
fun TextHyperLink(
    text: String,
    url: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.tertiary,
    textAlign: TextAlign = TextAlign.Center,
) {
    val uriHandler = LocalUriHandler.current

//    val annotatedString = buildAnnotatedString {
//        pushStringAnnotation(tag = "URL", annotation = url)
//        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
//            append(text)
//        }
//        pop()
//    }

    Text(
        modifier = modifier
            .clickable { uriHandler.openUri(url) },
        text = text,
        color = color,
        textAlign = textAlign,
        textDecoration = TextDecoration.Underline,
    )
}

@Composable
fun TextRow(
    name: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(size = 16.dp),
            )
            .clickable {
                onClick()
            },
    ) {
        TextCaption(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically)
                .weight(.5f),
            text = name,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            textAlign = TextAlign.Start,
        )
    }
}