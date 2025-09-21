package com.example.randominfoapp

import org.junit.Assert
import org.junit.Test

class SentenceRandomizerTest {

    @Test
    fun testRandomSentenceReturnsValidValue() {
        // Use the internal sentences list directly
        val randomSentence = sentences.random()
        Assert.assertNotNull(randomSentence)
        Assert.assertTrue(sentences.contains(randomSentence))
    }

    @Test
    fun testRandomSentenceHasCorrectLength() {
        // Verify that the random sentence is not empty
        val randomSentence = sentences.random()
        Assert.assertTrue(randomSentence.isNotEmpty())
    }

    @Test
    fun testSentenceListSize() {
        // Ensure the list has at least 10 sentences as per requirement
        Assert.assertTrue(sentences.size >= 10)
    }
}