package com.rahul.jott.android.networking.di

import android.content.Context
import com.rahul.jott.android.networking.NetworkConnectivity
import com.rahul.jott.android.networking.internal.NetworkConnectivityImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * DI Module supplying network state dependencies
 *
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class Module {
    companion object {
        /**
         * @return A [NetworkConnectivityImpl]
         */
        @Provides
        @Singleton
        fun bindNetworkHandler(
            @ApplicationContext context: Context
        ): NetworkConnectivity = NetworkConnectivityImpl(context)
    }
}
