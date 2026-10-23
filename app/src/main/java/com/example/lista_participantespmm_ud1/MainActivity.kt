package com.example.lista_participantespmm_ud1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lista_participantespmm_ud1.ui.theme.Lista_participantesPMM_UD1Theme
import androidx.compose.foundation.lazy.items

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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaInscripcion(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaInscripcion(modifier: Modifier = Modifier){
    var nombre by rememberSaveable { mutableStateOf("") }
    var alias by rememberSaveable { mutableStateOf("") }
    var profesion by rememberSaveable { mutableStateOf("") }
    val participantes = remember { mutableStateListOf<Participante>() }
    val formularioValido = nombre.isNotBlank() && alias.isNotBlank() && profesion.isNotBlank()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Inscripción al torneo",
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = alias,
            onValueChange = { alias = it },
            label = { Text("Alias") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = profesion,
            onValueChange = { profesion = it },
            label = { Text("Profesión") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            enabled = formularioValido,
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (formularioValido) {
                    val nuevo = Participante(
                        nombre = nombre.trim(),
                        alias = alias.trim(),
                        profesion = profesion.trim()
                    )
                    participantes.add(nuevo)
                    nombre = ""
                    alias = ""
                    profesion = ""
                }
            }
        ) {
            Text("Añadir participante")
        }

        Text("Participantes inscritos: ${participantes.size}")

        if (participantes.isEmpty()) {
            Text("Todavía no hay participantes")
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(participantes) { participante ->
                    TarjetaParticipante(participante)
                }
            }
        }
    }
}

@Composable
fun TarjetaParticipante(participante: Participante) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = participante.nombre)
            Text(text = "Alias: ${participante.alias}")
            Text(text = "Profesión: ${participante.profesion}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInscripcionPreview() {
    MaterialTheme {
        PantallaInscripcion()
    }
}