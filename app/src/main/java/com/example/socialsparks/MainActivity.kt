package com.example.socialsparks

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.socialsparks.ui.theme.SocialSparksTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SocialSparksTheme {

                var timeOfDay by remember { mutableStateOf("") }
                var suggestion by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Social Sparks",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Stay connected, one spark at a time.",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    OutlinedTextField(
                        value = timeOfDay,
                        onValueChange = { timeOfDay = it },
                        label = {
                            Text("Time of day")
                        },
                        placeholder = {
                            Text("e.g. Morning")
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {

                            val input = timeOfDay.trim()

                            // Determine the social spark using if statements.
                            if (input.equals("Morning", ignoreCase = true)) {

                                suggestion =
                                    "Send a \"Good morning\" text to a family member."

                                Log.d(
                                    "SocialSparks",
                                    "Morning spark selected."
                                )

                            } else if (input.equals(
                                    "Mid-morning",
                                    ignoreCase = true
                                )
                            ) {

                                suggestion =
                                    "Reach out to a colleague with a quick \"Thank you.\""

                                Log.d(
                                    "SocialSparks",
                                    "Mid-morning spark selected."
                                )

                            } else if (input.equals(
                                    "Afternoon",
                                    ignoreCase = true
                                )
                            ) {

                                suggestion =
                                    "Share a funny meme or interesting link with a friend."

                                Log.d(
                                    "SocialSparks",
                                    "Afternoon spark selected."
                                )

                            } else if (input.equals(
                                    "Afternoon Snack Time",
                                    ignoreCase = true
                                )
                            ) {

                                suggestion =
                                    "Send a quick \"thinking of you\" message."

                                Log.d(
                                    "SocialSparks",
                                    "Afternoon Snack Time spark selected."
                                )

                            } else if (input.equals(
                                    "Dinner",
                                    ignoreCase = true
                                )
                            ) {

                                suggestion =
                                    "Call a friend or relative for a 5-minute catch-up."

                                Log.d(
                                    "SocialSparks",
                                    "Dinner spark selected."
                                )

                            } else if (input.equals(
                                    "After Dinner / Night",
                                    ignoreCase = true
                                )
                            ) {

                                suggestion =
                                    "Leave a thoughtful comment on a friend's post."

                                Log.d(
                                    "SocialSparks",
                                    "After Dinner / Night spark selected."
                                )

                            } else {

                                // Show helpful feedback when the user enters an invalid option.
                                suggestion =
                                    "Invalid time of day. Please enter one of the available options."

                                Log.d(
                                    "SocialSparks",
                                    "Invalid input: $input"
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Get Spark")
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Your Social Spark",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = suggestion.ifEmpty {
                                    "Your suggestion will appear here."
                                },
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            // Clear the user's input and the displayed suggestion.
                            timeOfDay = ""
                            suggestion = ""

                            Log.d(
                                "SocialSparks",
                                "Input and suggestion reset."
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Reset")
                    }
                }
            }
        }
    }
}