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

/**
 * Contains the different custom scopes used.
 * <p>
 * Note that the standard {@link javax.inject.Singleton} scope is used as the application scope
 * (there is no PerApplication scope annotation). This is done in order to support singleton
 * scoped classes from other libraries (which do not have access to this project's custom scopes).
 */
package com.vestrel00.daggerbutterknifemvp.inject;
