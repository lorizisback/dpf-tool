package org.dpfTool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.dpfTool.presentation.MainActivityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import org.dpfTool.presentation.ObdCodeRetrievalUiState
import org.dpfTool.ui.theme.DpfToolTheme
import kotlin.coroutines.coroutineContext

@AndroidEntryPoint
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
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel = viewModel()
) {
    Button(onClick = {
        viewModel.connectToCar()
    }) {
        Text("Filled")
    }
}

@Composable
fun ObdCodeInfos(mainActivityViewModel: MainActivityViewModel) {
    when (val state = mainActivityViewModel.obdUiState.value) {
        ObdCodeRetrievalUiState.Initialised,
        ObdCodeRetrievalUiState.InProgress -> Unit //Do nothing?
        ObdCodeRetrievalUiState.Failure -> {
            Text(
                text = "ERRORE"
            )
        }

        is ObdCodeRetrievalUiState.Success -> {
            Text(
                text = state.obdCodeUiModel.codeName
            )
            Text(
                text = state.obdCodeUiModel.codeValue
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DpfToolTheme {
        Greeting("Android")
    }
}

@Composable
fun PairedBluetoothDevices(viewModel: MainActivityViewModel) {
    LazyColumn {

    }
}