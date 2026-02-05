package com.firestrokes.firestrokes.data.model

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord = false
    var frequency = 0
}

class Dictionary {
    private val root = TrieNode()
    
    fun insert(word: String, frequency: Int = 1) {
        var current = root
        for (char in word.lowercase()) {
            if (char !in current.children) {
                current.children[char] = TrieNode()
            }
            current = current.children[char]!!
        }
        current.isEndOfWord = true
        current.frequency = frequency
    }
    
    fun search(prefix: String): List<Suggestion> {
        var current = root
        for (char in prefix.lowercase()) {
            if (char !in current.children) {
                return emptyList()
            }
            current = current.children[char]!!
        }
        return collectWords(current, prefix, mutableListOf())
    }
    
    private fun collectWords(
        node: TrieNode,
        prefix: String,
        results: MutableList<Suggestion>
    ): List<Suggestion> {
        if (results.size >= MAX_SUGGESTIONS) {
            return results
        }
        
        if (node.isEndOfWord) {
            results.add(Suggestion(prefix, node.frequency))
        }
        
        node.children.entries.sortedByDescending { it.value.frequency }.forEach { (char, child) ->
            collectWords(child, prefix + char, results)
        }
        
        return results.sortedByDescending { it.frequency }.take(MAX_SUGGESTIONS)
    }
    
    fun hasWord(word: String): Boolean {
        var current = root
        for (char in word.lowercase()) {
            if (char !in current.children) {
                return false
            }
            current = current.children[char]!!
        }
        return current.isEndOfWord
    }
    
    companion object {
        private const val MAX_SUGGESTIONS = 3
    }
}

data class Suggestion(
    val word: String,
    val frequency: Int
)

object CommonWordsDictionary {
    private val dictionary = Dictionary()
    private var initialized = false
    
    fun get(): Dictionary {
        if (!initialized) {
            initializeCommonWords()
            initialized = true
        }
        return dictionary
    }
    
    private fun initializeCommonWords() {
        val commonWords = listOf(
            "the", "be", "to", "of", "and", "a", "in", "that", "have", "I",
            "it", "for", "not", "on", "with", "he", "as", "you", "do", "at",
            "this", "but", "his", "by", "from", "they", "we", "say", "her", "she",
            "or", "an", "will", "my", "one", "all", "would", "there", "their", "what",
            "so", "up", "out", "if", "about", "who", "get", "which", "go", "me",
            "when", "make", "can", "like", "time", "no", "just", "him", "know", "take",
            "people", "into", "year", "your", "good", "some", "could", "them", "see", "other",
            "than", "then", "now", "look", "only", "come", "its", "over", "think", "also",
            "back", "after", "use", "two", "how", "our", "work", "first", "well", "way",
            "even", "new", "want", "because", "any", "these", "give", "day", "most", "us",
            "is", "are", "was", "were", "been", "being", "has", "had", "did", "does",
            "hello", "world", "keyboard", "typing", "text", "message", "send", "receive",
            "privacy", "secure", "local", "data", "phone", "mobile", "app", "android"
        )
        
        commonWords.forEachIndexed { index, word ->
            dictionary.insert(word, commonWords.size - index)
        }
    }
}
