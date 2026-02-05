package com.firestrokes.firestrokes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firestrokes.firestrokes.data.model.CommonWordsDictionary
import com.firestrokes.firestrokes.data.model.Suggestion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SuggestionViewModel : ViewModel() {
    
    private val dictionary = CommonWordsDictionary.get()
    
    private val _currentSuggestions = MutableStateFlow<List<Suggestion>>(emptyList())
    val currentSuggestions: StateFlow<List<Suggestion>> = _currentSuggestions.asStateFlow()
    
    private val _currentWord = MutableStateFlow("")
    val currentWord: StateFlow<String> = _currentWord.asStateFlow()
    
    private val _suggestionIndex = MutableStateFlow(-1)
    val suggestionIndex: StateFlow<Int> = _suggestionIndex.asStateFlow()
    
    fun updateCurrentWord(text: String) {
        _currentWord.value = text
        _suggestionIndex.value = -1
        
        if (text.isNotEmpty() && text.last() != ' ') {
            val words = text.split(" ")
            val currentWordPrefix = words.lastOrNull() ?: ""
            
            if (currentWordPrefix.length >= MIN_WORD_LENGTH) {
                updateSuggestions(currentWordPrefix)
            } else {
                clearSuggestions()
            }
        } else {
            clearSuggestions()
        }
    }
    
    private fun updateSuggestions(prefix: String) {
        viewModelScope.launch {
            val suggestions = dictionary.search(prefix)
            _currentSuggestions.value = suggestions
        }
    }
    
    fun selectSuggestion(index: Int): Suggestion? {
        val suggestions = _currentSuggestions.value
        if (index in suggestions.indices) {
            return suggestions[index]
        }
        return null
    }
    
    fun cycleSuggestions(): String? {
        val suggestions = _currentSuggestions.value
        if (suggestions.isNotEmpty()) {
            _suggestionIndex.value = (_suggestionIndex.value + 1) % suggestions.size
            return suggestions[_suggestionIndex.value].word
        }
        return null
    }
    
    fun clearSuggestions() {
        _currentSuggestions.value = emptyList()
        _suggestionIndex.value = -1
    }
    
    fun getSelectedSuggestion(): Suggestion? {
        val index = _suggestionIndex.value
        return if (index >= 0 && index < _currentSuggestions.value.size) {
            _currentSuggestions.value[index]
        } else {
            null
        }
    }
    
    companion object {
        private const val MIN_WORD_LENGTH = 2
    }
}
