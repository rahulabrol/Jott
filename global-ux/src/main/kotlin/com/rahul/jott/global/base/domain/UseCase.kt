package com.rahul.jott.global.base.domain

/**
 * An Base contract for use cases that return a single result
 *
 * Can initiate suspend function calls, but can invoke without suspending
 *
 * This was inspired by the ResultInteractor class in Tivi project
 *
 * @param P Parameters: encapsulates the data necessary to run the use case, can be Unit
 * @param R Result: A result type the use case will return
 */
abstract class UseCase<P, R> {
    /**
     * @param params A class that holds the necessary data to execute the use case
     * @return A result that emits type of [R]
     */
    operator fun invoke(params: P): R = doWork(params)

    /**
     * UseCase specific work should be implemented here
     *
     * @param params A class that holds the necessary data to execute the use case
     * @return result type of [R]
     */
    protected abstract fun doWork(params: P): R
}
