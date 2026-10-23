package com.example.lista_participantespmm_ud1

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lista_participantespmm_ud1.ui.theme.Lista_participantesPMM_UD1Theme

data class Participante(
    val nombre: String,
    val alias: String,
    val profesion: String
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lista_participantesPMM_UD1Theme {

            }
        }
    }
}

@Composable
fun PantallaInscripcion(modifier: Modifier = Modifier){
    var nombre by rememberSaveable { mutableStateOf("") }
    var alias by rememberSaveable { mutableStateOf("") }
    var profesion by rememberSaveable { mutableStateOf("") }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lista_participantesPMM_UD1Theme {

    }
}