package com.example.randominfoapp

import org.junit.Test
import org.junit.Assert.*

class SentenceRandomizerTest {

    @Test
    fun testRandomSentenceReturnsValidValue() {
        // Use the internal sentences list directly
        val randomSentence = sentences.random()
        assertNotNull(randomSentence)
        assertTrue(sentences.contains(randomSentence))
    }

    @Test
    fun testRandomSentenceHasCorrectLength() {
        // Verify that the random sentence is not empty
        val randomSentence = sentences.random()
        assertTrue(randomSentence.isNotEmpty())
    }

    @Test
    fun testSentenceListSize() {
        // Ensure the list has at least 10 sentences as per requirement
        assertTrue(sentences.size >= 10)
    }
}