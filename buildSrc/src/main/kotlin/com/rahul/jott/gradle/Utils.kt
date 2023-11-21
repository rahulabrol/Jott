package com.rahul.jott.gradle

import org.gradle.api.Project

/**
 * Prop or def
 *
 * @param project
 * @param propertyName
 * @param defaultValue
 * @return Any
 */
fun propOrDef(
    project: Project,
    propertyName: String,
    defaultValue: Any
): Any {
    val propertyValue = project.properties[propertyName]

    return propertyValue ?: defaultValue
}