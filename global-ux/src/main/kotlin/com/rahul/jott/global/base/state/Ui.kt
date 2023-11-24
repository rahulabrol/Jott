package com.rahul.jott.global.base.state

/**
 * Interface for any Ui related DTO
 */
interface Ui {
    /**
     * Event Ui event which comes from @Compose functions to the [StateHolder2]
     */
    interface Event : Ui
}
