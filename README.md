# Android Dagger ButterKnife MVP

This project is part of a 
[3-part series](https://proandroiddev.com/how-to-android-dagger-2-10-2-11-butterknife-mvp-part-1-eb0f6b970fd) 
about how to build Android applications using 
[Dagger 2](https://github.com/google/dagger) (2.11-2.17) with the 
[Dagger Android extension](https://github.com/google/dagger/tree/master/java/dagger/android), 
[Dagger Android support extension](https://github.com/google/dagger/tree/master/java/dagger/android/support), 
[Butterknife](https://github.com/JakeWharton/butterknife) (8.7-8.8), and Model-View-Presenter (MVP) pattern 
with support for `@Singleton`, `@PerActivity`, `@PerFragment`, and `@PerChildFragment` scopes.

**A Larger Project**

> This project is a smaller, derivative of a larger project. One of the main purpose of this project 
is to showcase / walkthrough a specific portion of the larger project's architecture. Take a look at
the following larger project for a more real-world example on how to apply Dagger Android (2.11-2.17), 
Butterknife (8.7-8.8), Clean Architecture, MVP, MVVM, Kotlin, Java Swing, RxJava, RxAndroid, Retrofit 2, 
Jackson, AutoValue, Yelp Fusion (v3) REST API, Google Maps API, monolithic repo project management 
with Gradle, JUNit 4, AssertJ, Mockito 2, Robolectric 3, Espresso 2, and Java best practices and
design patterns.
>
> https://github.com/vestrel00/business-search-app-java

## Supported Versions

This project now uses [Android Studio 3.2.0-rc02](https://developer.android.com/studio/archive.html).
Previous versions of Android Studio (2.4/2.3.3 and below) will no longer be able to build this project.

The following major Dagger 2 and Butterknife versions works with this project;

- Dagger 2: *2.11, 2.12, 2.13, 2.14, 2.15, 2.16, 2.17*
- Butterknife: *8.7, 8.8*

## Branches

There are 4 main branches:

1. [**master**](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master) 
   [![Build Status](https://travis-ci.org/vestrel00/android-dagger-butterknife-mvp.svg?branch=master)](https://travis-ci.org/vestrel00/android-dagger-butterknife-mvp)

  - Uses regular `Activity` and `Fragment` classes with a `minSdkVersion` of 17.

2. [**master-support**](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master-support)
   [![Build Status](https://travis-ci.org/vestrel00/android-dagger-butterknife-mvp.svg?branch=master-support)](https://travis-ci.org/vestrel00/android-dagger-butterknife-mvp)

  - Uses `AppCompatActivity` and support `Fragment` classes with a `minSdkVersion` of 14.
  - This branch is an extension of the **master** branch, containing all changes from **master**.
  - Take a look at [PR #49](https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/49) for
    the main diff from the **master** branch.

3. [**master-kotlin**](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master-kotlin) 
   [![Build Status](https://travis-ci.org/vestrel00/android-dagger-butterknife-mvp.svg?branch=master-kotlin)](https://travis-ci.org/vestrel00/android-dagger-butterknife-mvp)

  - Same as **master** except written in Kotlin.
  - This branch is an extension of the **master** branch, containing all changes from **master**,
    which is then translated to Kotlin.
  - Take a look at [PR #67](https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/67) for
    the main *Java -> Kotlin* translation of the **master** branch.
  

4. [**master-support-kotlin**](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master-support-kotlin) 
   [![Build Status](https://travis-ci.org/vestrel00/android-dagger-butterknife-mvp.svg?branch=master-support-kotlin)](https://travis-ci.org/vestrel00/android-dagger-butterknife-mvp)

  - Same as **master-support** except written in Kotlin.
  - This branch is an extension of the **master-support** branch, containing all changes from 
    **master-support**, which is then translated to Kotlin.
  - Take a look at [PR #68](https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/68) for
    the main *Java -> Kotlin* translation of the **master-support** branch.

**Why is the `minSdkVersion` of the non-support setup in master 17? Can it be lower?**

There are 2 main reasons why the `minSdkVersion` of the non-support setup can only be as low as 17.

1. https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/20/files#r133777223
2. https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/29/files#r133777242

Thus, the lowest `minSdkVersion` supported for the non-support setup in **master** is 17. 
It cannot be lower.

**What about the `minSdkVersion` of the support setup in master-support? Can it be lower than 14?**

No. The *dagger.android.support* API only supports `minSdkVersion` 
[as low as 14](https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/49/files#r133043880).

## Notice

1. As of API 28, fragments and all related fragment code have been deprecated in favor of the support
 fragments in the support lib. Therefore, it is recommended that the 
 [master-support](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master-support) and 
 [master-support-kotlin](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master-support-kotlin) 
 be used as reference instead of the [master](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master) and 
 [master-kotlin](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master-kotlin) branches. _See
 [issue #86](https://github.com/vestrel00/android-dagger-butterknife-mvp/issues/86)._

## Examples

This demonstrates dagger.android, Butterknife, and MVP setup using 5 examples:

1. Activity with 1 Fragment.
2. Activity with 2 Fragments.
3. Activity with 1 Fragment with 1 child Fragment.
4. The Fragment in example 1 as a floating dialog.
5. The Fragments in example 3 as a floating dialog.

## A Quick Gist

For a quick overview of *dagger-android* 2.11 usage with support for `@Singleton`, `@PerActivity`, 
`@PerFragment`, and `@PerChildFragment` scopes, take a look at 
[this gist](https://gist.github.com/vestrel00/64be913f954989fe52c674247e093218). 

Read the **walkthrough** for the complete guide with proper step-by-step setup and explanations.

## Walkthrough

Read the blogs for a complete walkthrough of this app:

1. Creating a project, from scratch, using the new Dagger.Android (2.11-2.17) dependency injection 
   framework with support for `@Singleton`, `@PerActivity` , `@PerFragment`, and `@PerChildFragment` scopes. 
   [ARTICLE](https://proandroiddev.com/how-to-android-dagger-2-10-2-11-butterknife-mvp-part-1-eb0f6b970fd)
2. Using Butterknife (8.7-8.8) to replace a lot of handwritten boilerplate view binding code. 
   [ARTICLE](https://proandroiddev.com/how-to-android-dagger-2-10-2-11-butterknife-mvp-part-2-6eaf60965df7)
3. Restructuring the code to Model-View-Presenter (MVP) to increase testability, maintainability, 
   and scalability.
   [ARTICLE](https://proandroiddev.com/how-to-android-dagger-2-10-2-11-butterknife-mvp-part-3-ed5acf40eb19)

If you don't like reading blogs or are just too "pro" and would like to just explore the repository,
you may want to look at the issues instead;

- [Dagger-android](https://github.com/vestrel00/android-dagger-butterknife-mvp/issues?q=label%3A%22A%3A+dagger.android%22+is%3Aclosed+sort%3Acreated-asc)
- [Butterknife](https://github.com/vestrel00/android-dagger-butterknife-mvp/issues?q=label%3A%22B%3A+butterknife%22+is%3Aclosed+sort%3Acreated-asc)
- [MVP](https://github.com/vestrel00/android-dagger-butterknife-mvp/issues?q=is%3Aclosed+sort%3Acreated-asc+label%3A%22C%3A+mvp%22)
- [Kotlin](https://github.com/vestrel00/android-dagger-butterknife-mvp/issues?q=sort%3Acreated-asc+label%3AKotlin+is%3Aclosed)

## License

    Copyright 2018 Vandolf Estrellado
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
