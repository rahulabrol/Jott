package com.rahul.jott.global.base

/**
 * Function to filter a list of results into a list containing only elements matching the
 * given [predicate]
 *
 * @param T
 * @param predicate
 * @return Result of filtered items
 */
fun <T> Result<List<T>>.filterResultList(predicate: (T) -> Boolean) = this.map { list ->
    list.filter { predicate(it) }
}

/**
 * Function to map a result of items into a result of items of a different type
 *
 * @param transform function
 * @return Result of items of type S
 */
fun <T, S> Result<List<T>>.mapResultList(transform: (T) -> S) = this.map { list ->
    list.map { transform(it) }
}

/**
 * Function to map a result of items into a result of items of a different type catching any exception.
 *
 * @param transform function
 * @return Result of items of type S
 */
fun <T, S> Result<List<T>>.mapCatchingResultList(transform: (T) -> S) = this.mapCatching { list ->
    list.map { transform(it) }
}
