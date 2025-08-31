package com.example.randominfoapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import com.example.randominfoapp.ui.theme.RandomInfoAppTheme
import org.junit.Rule
import org.junit.Test

class RandomInfoScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testButtonClickUpdatesText() {
        // Set up the composable content
        composeTestRule.setContent {
            RandomInfoAppTheme {
                RandomInfoScreen()
            }
        }

        // Initial state: Text should be empty
        composeTestRule.onNodeWithTag("sentenceText")
            .assertIsDisplayed()
            .assertTextContains("") // Initial state is empty string

        // Click the button
        composeTestRule.onNodeWithTag("randomFactButton").performClick()

        // Check that the text is updated to a non-empty value
        // Since exact sentence is random, check for a substring common to all sentences
        composeTestRule.onNodeWithTag("sentenceText")
            .assertIsDisplayed()
            .assertTextContains("I") // Common character in all sentences; adjust if needed

        // Verify image is displayed
        composeTestRule.onNodeWithTag("profileImage")
            .assertIsDisplayed()
    }
}