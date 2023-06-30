package com.example.rallyapp.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.rallyapp.ui.theme.RallyDialogThemeOverlay

@Composable
fun RallyAlertDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    bodyText: String,
) {
    RallyDialogThemeOverlay {
        AlertDialog(
            onDismissRequest = onDismiss,
            text = {
                Text(bodyText)
            },
            confirmButton = {
                TextButton(
                    onClick = onConfirm
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismiss,
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}
