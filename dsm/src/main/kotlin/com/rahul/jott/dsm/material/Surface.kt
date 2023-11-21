package com.rahul.jott.dsm.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.rahul.jott.dsm.material.internal.AppSurfaceDefaults

/**
 * <a href="https://material.io/design/environment/surfaces.html"
 * class="external" target="_blank">An app specific Material Design
 * surface</a>.
 *
 * Material surface is the central metaphor in material design. Each
 * surface exists at a given elevation, which influences how that piece
 * of surface visually relates to other surfaces and how that surface
 * casts shadows.
 *
 * If you want to have a [AppSurface] that handles clicks, consider
 * using another overload.
 *
 * The [AppSurface] is responsible for:
 *
 * 1) Clipping: Surface clips its children to the shape specified by
 * [shape]
 *
 * 2) Elevation: Surface draws a shadow to represent depth, where
 * [elevation] represents the depth of this surface. If the passed
 * [shape] is concave the shadow will not be drawn on Android versions
 * less than 10.
 *
 * 3) Borders: If [shape] has a border, then it will also be drawn.
 *
 * 4) Background: Surface fills the shape specified by [shape] with the
 * [backgroundColor]. If [backgroundColor] is [Colors.surface], the
 * [ElevationOverlay] from [LocalElevationOverlay] will be used to apply
 * an overlay - by default this will only occur in dark theme. The color
 * of the overlay depends on the [elevation] of this Surface, and the
 * [LocalAbsoluteElevation] set by any parent surfaces. This ensures
 * that a Surface never appears to have a lower elevation overlay than
 * its ancestors, by summing the elevation of all previous Surfaces.
 *
 * 5) Content color: Surface uses [contentColor] to specify a preferred
 * color for the content of this surface - this is used by the [Text]
 * and [Icon] components as a default color.
 *
 * 6) Blocking touch propagation behind the surface.
 *
 * If no [contentColor] is set, this surface will try and match
 * its background color to a color defined in the theme [Colors],
 * and return the corresponding content color. For example, if the
 * [backgroundColor] of this surface is [Colors.surface], [contentColor]
 * will be set to [Colors.onSurface]. If [backgroundColor] is not part
 * of the theme palette, [contentColor] will keep the same value set
 * above this Surface.
 *
 * To modify these default style values used by text, use
 * [ProvideTextStyle] or explicitly pass a new [TextStyle] to your text.
 *
 * @param modifier Modifier to be applied to the layout corresponding to
 *     the surface
 * @param shape Defines the surface's shape as well its shadow. A shadow
 *     is only displayed if the [elevation] is greater than zero.
 * @param backgroundColor The background color. Use [Color.Transparent]
 *     to have no color.
 * @param contentColor The preferred content color provided by this
 *     Surface to its children. Defaults to either the
 *     matching content color for [backgroundColor], or if
 *     [backgroundColor] is not a color from the theme, this
 *     will keep the same value set above this Surface.
 * @param border Optional border to draw on top of the surface
 * @param elevation The size of the shadow below the surface. Note that
 *     It will not affect z index of the Surface. If you want to
 *     change the drawing order you can use `Modifier.zIndex`.
 */
@Composable
fun AppSurface(
    modifier: Modifier = Modifier,
    shape: Shape = AppSurfaceDefaults.Shape,
    backgroundColor: Color = AppSurfaceDefaults.BackgroundColor,
    contentColor: Color = AppSurfaceDefaults.ContentColor,
    border: BorderStroke? = null,
    elevation: Dp = AppSurfaceDefaults.Elevation,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
        border = border,
        elevation = elevation,
        content = content
    )
}

/**
 * Material surface is the central metaphor in material design. Each surface exists at a given
 * elevation, which influences how that piece of surface visually relates to other surfaces and
 * how that surface casts shadows.
 *
 * This version of Surface is responsible for a click handling as well al everything else that
 * a regular Surface does:
 *
 * This clickable Surface is responsible for:
 *
 * 1) Clipping: Surface clips its children to the shape specified by [shape]
 *
 * 2) Elevation: Surface draws a shadow to represent depth, where [elevation] represents the
 * depth of this surface. If the passed [shape] is convex the shadow will not be drawn on Android
 * versions less than 10.
 *
 * 3) Borders: If [shape] has a border, then it will also be drawn.
 *
 * 4) Background: Surface fills the shape specified by [shape] with the [color]. If [color] is
 * [Colors.surface], the [ElevationOverlay] from [LocalElevationOverlay] will be used to apply
 * an overlay - by default this will only occur in dark theme. The color of the overlay depends
 * on the [elevation] of this Surface, and the [LocalAbsoluteElevation] set by any parent
 * surfaces. This ensures that a Surface never appears to have a lower elevation overlay than its
 * ancestors, by summing the elevation of all previous Surfaces.
 *
 * 5) Content color: Surface uses [contentColor] to specify a preferred color for the content of
 * this surface - this is used by the [Text] and [Icon] components as a default color. If no
 * [contentColor] is set, this surface will try and match its background color to a color defined
 * in the theme [Colors], and return the corresponding content color. For example, if the [color]
 * of this surface is [Colors.surface], [contentColor] will be set to [Colors.onSurface]. If
 * [color] is not part of the theme palette, [contentColor] will keep the same value set above
 * this Surface.
 *
 * 6) Click handling. This version of surface will react to the clicks, calling [onClick] lambda,
 * updating the [interactionSource] when [PressInteraction] occurs, and showing ripple indication in
 * response to press events. If you don't need click handling, consider using the Surface function
 * that doesn't require [onClick] param.
 *
 * 7) Semantics for clicks. Just like with [Modifier.clickable], clickable version of Surface will
 * produce semantics to indicate that it is clicked. Also, by default, accessibility services will
 * describe the element as [Role.Button]. You may change this by passing a desired [Role] with a
 * [Modifier.semantics].
 *
 * @sample androidx.compose.material.samples.ClickableSurfaceSample
 *
 * To modify these default style values used by text, use [ProvideTextStyle] or explicitly
 * pass a new [TextStyle] to your text.
 *
 * To manually retrieve the content color inside a surface, use [LocalContentColor].
 *
 * @param onClick callback to be called when the surface is clicked
 * @param modifier Modifier to be applied to the layout corresponding to the surface
 * @param enabled Controls the enabled state of the surface. When `false`, this surface will not
 * be clickable
 * @param shape Defines the surface's shape as well its shadow. A shadow is only
 *  displayed if the [elevation] is greater than zero.
 * @param color The background color. Use [Color.Transparent] to have no color.
 * @param contentColor The preferred content color provided by this Surface to its children.
 * Defaults to either the matching content color for [color], or if [color] is not a color from
 * the theme, this will keep the same value set above this Surface.
 * @param border Optional border to draw on top of the surface
 * @param elevation The size of the shadow below the surface. Note that It will not affect z index
 * of the Surface. If you want to change the drawing order you can use `Modifier.zIndex`.
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Surface. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance
 * / behavior of this Surface in different [Interaction]s.
 */
@ExperimentalMaterialApi
@Composable
fun AppSurface(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = AppSurfaceDefaults.Shape,
    color: Color = AppSurfaceDefaults.BackgroundColor,
    contentColor: Color = AppSurfaceDefaults.ContentColor,
    border: BorderStroke? = null,
    elevation: Dp = AppSurfaceDefaults.Elevation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        color = color,
        contentColor = contentColor,
        border = border,
        elevation = elevation,
        interactionSource = interactionSource,
        content = content
    )
}
