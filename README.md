# Android Dagger ButterKnife MVP

This project is part of a 
[3-part series](https://proandroiddev.com/how-to-android-dagger-2-10-2-11-butterknife-mvp-part-1-eb0f6b970fd) 
about how to build Android applications using 
[Dagger 2](https://github.com/google/dagger) with the 
[Dagger Android extension](https://github.com/google/dagger/tree/dagger-2.11/java/dagger/android), 
[Dagger Android support extension](https://github.com/google/dagger/tree/dagger-2.11/java/dagger/android/support), 
[Butterknife](https://github.com/JakeWharton/butterknife), and Model-View-Presenter (MVP) pattern 
with support for `@Singleton`, `@PerActivity`, `@PerFragment`, and `@PerChildFragment` scopes.

**A Larger Project**

This project is a smaller, derivative of a larger project. One of the main purpose of this project 
is to showcase / walkthrough a specific portion of the larger project's architecture. Take a look at
the following larger project for a more real-world example on how to apply Dagger Android (2.11), 
Butterknife (8.7), Clean Architecture, MVP, MVVM, Kotlin, Java Swing, RxJava, RxAndroid, Retrofit 2, 
Jackson, AutoValue, Yelp Fusion (v3) REST API, Google Maps API, monolithic repo project management 
with Gradle, JUNit 4, AssertJ, Mockito 2, Robolectric 3, Espresso 2, and Java best practices and
design patterns.

https://github.com/vestrel00/business-search-app-java


## Branches

There are 2 main branches:

1. [**master**](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master)

  - Uses regular `Activity` and `Fragment` classes with a `minSdkVersion` of 17.

2. [**master-support**](https://github.com/vestrel00/android-dagger-butterknife-mvp/tree/master-support)

  - Uses `AppCompatActivity` and support `Fragment` classes with a `minSdkVersion` of 14. 
    This branch is an extension of the **master** branch, containing all changes from **master**. 
    Take a look at PR #49 for the main diff from **master**.

**Why is the `minSdkVersion` of the non-support setup in master 17? Can it be lower?**

There are 2 main reasons why the `minSdkVersion` of the non-support setup can only as low as 17.

1. https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/20/files#r133777223
2. https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/29/files#r133777242

Thus, the lowest `minSdkVersion` supported for the non-support setup in **master** is 17. 
It cannot be lower.

**What about the `minSdkVersion` of the support setup in master-support? Can it be lower than 14?**

No. The *dagger.android.support* API only supports `minSdkVersion` 
[as low as 14](https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/49/files#r133043880).

## Examples

This demonstrates dagger.android, Butterknife, and MVP setup using 3 examples:

1. Activity with 1 fragment.
2. Activity with 2 fragments.
3. Activity with 1 fragment with 1 child fragment.

## Walkthrough

Read the blogs for a complete walkthrough of this app:

1. Creating a project, from scratch, using the new Dagger.Android (2.11) dependency injection 
   framework with support for `@Singleton`, `@PerActivity` , `@PerFragment`, and `@PerChildFragment` scopes. 
   [ARTICLE](https://proandroiddev.com/how-to-android-dagger-2-10-2-11-butterknife-mvp-part-1-eb0f6b970fd)
2. Using Butterknife (8.7) to replace a lot of handwritten boilerplate view binding code. 
   [ARTICLE](https://proandroiddev.com/how-to-android-dagger-2-10-2-11-butterknife-mvp-part-2-6eaf60965df7)
3. Restructuring the code to Model-View-Presenter (MVP) to increase testability, maintainability, 
   and scalability. *(coming soon)*

## License

    Copyright 2017 Vandolf Estrellado
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
