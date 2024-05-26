package org.dpfTool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.dpfTool.presentation.ObdCodeViewModel
import org.dpfTool.ui.theme.DpfToolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DpfToolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    // how to use obdCodeInfos composable? where to instance the viewmodel?
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ObdCodeInfos(obdCodeViewModel: ObdCodeViewModel) {
    Text(
        text = obdCodeViewModel.uiState.codeName
    )
    Text(
        text = obdCodeViewModel.uiState.codeValue
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DpfToolTheme {
        Greeting("Android")
    }
}