package com.rahul.jott.global.base.state

import kotlinx.coroutines.flow.Flow

/**
 * State Producer is a shared State by other State Holders
 *
 * @param T A type of ui state the state holder will expose
 * @param P A class the encapsulates the data necessary to initialize the screen
 */
abstract class StateProducer<T, P> {
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
