package io.j99.app.template.ui.common.view

/**
 * Abstract Activity with title
 */
abstract class AbstractTitleActivity : AbstractActivity() {
    override val showTitle: Boolean
        get() = true
}