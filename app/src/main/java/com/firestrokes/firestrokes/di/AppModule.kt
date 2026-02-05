package com.firestrokes.firestrokes.di

import android.content.Context
import com.firestrokes.firestrokes.data.local.ThemeManager
import com.firestrokes.firestrokes.presentation.viewmodel.KeyboardViewModel
import com.firestrokes.firestrokes.presentation.viewmodel.SuggestionViewModel
import com.firestrokes.firestrokes.presentation.viewmodel.ThemeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { KeyboardViewModel() }
    viewModel { SuggestionViewModel() }
    viewModel { ThemeViewModel(get()) }
    single { ThemeManager(androidContext()) }
}
