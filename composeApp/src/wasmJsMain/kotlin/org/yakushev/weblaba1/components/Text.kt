package org.yakushev.weblaba1.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

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

//@Composable
//fun Operation(
//    operationUiModel: OperationUiModel,
//    navController: NavHostController,
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 4.dp, horizontal = 16.dp)
//            .background(
//                color = operationUiModel.type.getBackground(),
//                shape = RoundedCornerShape(size = 16.dp),
//            )
//            .clickable {
//                if (operationUiModel.type == AccountEnum.Income || operationUiModel.type == AccountEnum.Expense) {
//                    navController.navigate(route = "${Routes.AddOperation.destination}/${operationUiModel.id}")
//                }
//            },
//    ) {
//        TextCaption(
//            modifier = Modifier
//                .padding(16.dp)
//                .align(Alignment.CenterVertically)
//                .weight(.5f),
//            text = operationUiModel.name,
//            color = operationUiModel.type.getTextColor(),
//            textAlign = TextAlign.Start,
//        )
//        if (operationUiModel.type == AccountEnum.Income || operationUiModel.type == AccountEnum.Expense) {
//            TextCaption(
//                modifier = Modifier.padding(16.dp).weight(.2f),
//                text = operationUiModel.percent,
//                color = operationUiModel.type.getTextColor(),
//                textAlign = TextAlign.Start,
//            )
//        }
//        if (operationUiModel.amount != 0) {
//            TextCaption(
//                modifier = Modifier.padding(16.dp).weight(.25f),
//                text = operationUiModel.amount.toString(),
//                color = operationUiModel.type.getTextColor(),
//                textAlign = TextAlign.End,
//            )
//        }
//    }
//}