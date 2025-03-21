package com.example.mobile_mastermind.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_mastermind.R

@Composable
fun TextFieldInput(
    value: MutableState<String>,
    label: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = { value.value = it },
    isPassword: Boolean = false
) {
    OutlinedTextField(
        value = value.value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(
                text = label,
                fontSize = 14.sp,
                color = colorResource(id = R.color.gray175)
            )
        },
        shape = RoundedCornerShape(8.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldInputPreview() {
    val textState =
        androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("") }
    TextFieldInput(value = textState, label = stringResource(id = R.string.user_name_playholder))
}