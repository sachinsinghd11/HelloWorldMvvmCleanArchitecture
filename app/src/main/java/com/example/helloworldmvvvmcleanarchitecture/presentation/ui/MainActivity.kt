package com.example.helloworldmvvvmcleanarchitecture.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.helloworldmvvvmcleanarchitecture.di.component.DaggerActivityComponent
import com.example.helloworldmvvvmcleanarchitecture.di.module.ActivityModule
import com.example.helloworldmvvvmcleanarchitecture.domain.model.WelcomeText
import com.example.helloworldmvvvmcleanarchitecture.presentation.HelloWorldApplication
import com.example.helloworldmvvvmcleanarchitecture.presentation.base.UiState
import com.example.helloworldmvvvmcleanarchitecture.presentation.ui.theme.HelloWorldMvvvmCleanArchitectureTheme
import com.example.helloworldmvvvmcleanarchitecture.presentation.viewmodel.HelloWorldViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: HelloWorldViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldMvvvmCleanArchitectureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .helloWorldApplicationComponent((application as HelloWorldApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build().inject(this)
    }
}

@Composable
fun Greeting(viewModel: HelloWorldViewModel, modifier: Modifier = Modifier) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when(uiState){
        is UiState.Success ->{
            val msg = (uiState as UiState.Success<WelcomeText>).data.message
            Text(
                text = "Hello $msg!",
                modifier = modifier
            )
        }
        is UiState.Error -> {
            Text(
                text = "Hello Error!",
                modifier = modifier
            )
        }
        is UiState.Loading -> {
            Text(
                text = "Hello Loading!",
                modifier = modifier
            )
        }

    }

}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldMvvvmCleanArchitectureTheme {
        Greeting(ViewModel(), Modifier)
    }
}*/
