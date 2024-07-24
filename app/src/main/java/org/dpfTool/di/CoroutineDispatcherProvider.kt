package org.dpfTool.di

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    fun provideMainDispatcher(): CoroutineDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher
}