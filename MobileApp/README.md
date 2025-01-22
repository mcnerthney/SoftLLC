Fetch Rewards Coding Exercise - Software Engineering - Mobile

Kotlin Multiplatform App that retrieves the data from https://fetch-hiring.s3.amazonaws.com/hiring.json.

Display this list of items to the user based on the following requirements:
Display all the items grouped by "listId"
Sort the results first by "listId" then by "name" when displaying.
Filter out any items where "name" is blank or null.

For Android run composeApp 

For iOS run iosApp

Android App Screenshot

<img src="https://github.com/mcnerthney/fetch-take-home/blob/main/images/Screenshot.png" width="200" height="400" />

### Technologies

The app uses the following multiplatform dependencies in its implementation:

- [Compose Multiplatform](https://jb.gg/compose) for UI
- [Compose Navigation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html)
- [Ktor](https://ktor.io/) for networking
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) for JSON handling
- [Koin](https://github.com/InsertKoinIO/koin) for dependency injection

