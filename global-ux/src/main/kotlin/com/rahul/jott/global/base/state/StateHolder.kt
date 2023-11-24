package com.rahul.jott.global.base.state

import kotlinx.coroutines.flow.Flow

/**
 * An Interface the every state holder must implement.
 *
 * @param P A class the encapsulates the data necessary to initialize the screen
 * @param T A type of ui state the state holder will expose
 */
abstract class StateHolder<P, T> {
    /**
     * Function to create state holder parameters, utilizing navigation arguments
     *
     * @return params
     */
    protected abstract val params: P

    /**
     * The flow the the state holder emits it's ui state through
     */
    abstract val state: Flow<T>
}
