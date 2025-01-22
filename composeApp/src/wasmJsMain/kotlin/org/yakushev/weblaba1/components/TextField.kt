package org.yakushev.weblaba1.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AddRowTextField(
    placeholder: String,
    value: String,
    supportingText: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors().copy(
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            errorContainerColor = MaterialTheme.colorScheme.errorContainer,
        ),
        maxLines = 1,
        label = { Text(text = placeholder) },
        supportingText = { Text(text = supportingText) },
        isError = supportingText.isNotEmpty(),
        keyboardOptions = keyboardOptions,
        value = value,
        onValueChange = onValueChange,
    )
}