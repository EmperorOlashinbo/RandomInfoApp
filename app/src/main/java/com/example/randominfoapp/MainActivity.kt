package com.example.randominfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randominfoapp.ui.theme.RandomInfoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomInfoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RandomInfoScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Data: Hard-coded list of at least 10 sentences about me.
// Make this 'internal' to be accessible from the test in the same module
internal val sentences = listOf(
    "I am passionate about AI and machine learning.",
    "My favorite hobbies are boxing and cardio.",
    "I love reading philosophy novels.",
    "I have traveled to over 10 countries.",
    "My dream job is to work in tech innovation.",
    "I enjoy cooking and eating Nigerian food.",
    "I am a boxing coach at HKR.",
    "I am a non-smoker and I don't drink coffee, energy drink, soda, and alcohol.",
    "I love learning new things.",
    "I speak three languages fluently, such as Yoruba, English, and Swedish.",
    "I love watching documentaries about space.",
    "I have a daughter and her name is Sonia.",
    "I enjoy listening to music on my free time.",
    "I love coding.",
    "My favorite color is blue."
)

// Main Composable: Structured into a reusable function
@Composable
fun RandomInfoScreen(modifier: Modifier = Modifier) {
    var currentSentence by remember { mutableStateOf("") }  // State for the displayed sentence

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag("randomInfoScreenColumn"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile picture", // We can use this for finding
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 16.dp)
                .testTag("profileImage") // Test tag for the image
        )
        // Display the random sentence
        Text(
            text = currentSentence,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .testTag("sentenceText") // Test tag for the text
        )
        // Button to randomize and show a new sentence
        Button(
            onClick = {
                currentSentence = sentences.random()  // Random selection
            },
            modifier = Modifier.testTag("randomFactButton") // Test tag for the button
        ) {
            Text("Show Random Fact") // We can also find the button by its text
        }
    }

}

// Preview for development (no device needed)
@Preview(showBackground = true)
@Composable
fun RandomInfoScreenPreview() {
    RandomInfoAppTheme {
        RandomInfoScreen()
    }
}
