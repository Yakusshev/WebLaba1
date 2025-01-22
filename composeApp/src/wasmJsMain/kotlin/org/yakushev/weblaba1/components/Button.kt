package org.yakushev.weblaba1.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@Composable
fun TertiaryButton(
    modifier: Modifier = Modifier,
    textRes: String,
    contentColor: Color,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
        )
    ) {
        Text(
            text = textRes,
            style = TextStyle(
                fontSize = TextUnit(value = 16f, type = TextUnitType.Sp),
                fontWeight = FontWeight.Bold,
            )
        )
    }
}
