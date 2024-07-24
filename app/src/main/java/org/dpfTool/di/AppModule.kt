package org.dpfTool.di

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcherProvider =
        object : CoroutineDispatcherProvider {
            override fun provideMainDispatcher(): CoroutineDispatcher {
                return Dispatchers.Main
            }

            override fun provideIoDispatcher(): CoroutineDispatcher {
                return Dispatchers.IO
            }
        }

    @Provides
    fun provideBluetoothAdapter(@ApplicationContext appContext: Context): BluetoothAdapter {
        val bluetoothManager = appContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        return bluetoothManager.adapter
    }
}