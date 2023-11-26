package com.rahul.jott.android.networking

/**
 * Network interface
 */
sealed interface Network {
    /**
     * Network state class
     */
    sealed interface State {
        /**
         * Connected state
         */
        object Connected : State

        /**
         * Disconnected state
         */
        object Disconnected : State
    }
}
