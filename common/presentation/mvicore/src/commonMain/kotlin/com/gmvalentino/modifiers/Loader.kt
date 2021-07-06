package com.gmvalentino.modifiers

import com.gmvalentino.Action
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.merge

class ActionLoader<ACTION : Action>(
    vararg val actions: ACTION
) : ActionModifier<ACTION> {
    override fun apply(input: Flow<ACTION>): Flow<ACTION> = merge(actions.asFlow(), input)
}