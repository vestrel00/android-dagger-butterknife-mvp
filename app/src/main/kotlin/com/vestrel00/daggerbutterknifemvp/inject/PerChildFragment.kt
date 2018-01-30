/*
 * Copyright 2018 Vandolf Estrellado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vestrel00.daggerbutterknifemvp.inject

import javax.inject.Scope

/**
 * A custom scoping annotation that specifies that the lifespan of a dependency be the same as that
 * of a child Fragment (a fragment inside a fragment that is added using
 * Fragment.getChildFragmentManager().
 *
 * This is used to annotate dependencies that behave like a singleton within the lifespan of a child
 * Fragment instead of the entire Application, Activity, or parent Fragment.
 *
 * Note that this does not support a child fragment within a child fragment as conflicting scopes
 * will occur. Child fragments within child fragments should usually be avoided. However, if another
 * level of child fragment is required, then another scope would need to be created (perhaps
 * PerGrandChild custom scope annotation).
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerChildFragment