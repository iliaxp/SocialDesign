# SocialDesign — Instagram UI for Developers & Employers

Modern Instagram-style Android app (UI only) built with Kotlin and Jetpack Compose. Designed to showcase clean UI/UX patterns relevant to developers and employers evaluating Android skills.

— UI only (no backend). Supports feed, stories, post details, likes, save, pull-to-refresh, infinite scroll, and basic navigation.

## Preview

<p align="center">
  <img src="app/src/main/appicon-playstore.png" alt="App Icon" width="96" />
</p>

> Screens: Home (Stories + Feed), Explore, Add, Activities, Profile, Story Viewer, Post Detail.

## Features

- Home feed with mock posts and captions
- Stories row with circular avatars and full-screen story viewer
- Double-tap like with heart burst animation
- Save/Like/Comment/Send actions on posts
- Pull to refresh using Accompanist SwipeRefresh
- Infinite scroll with on-demand mock loading
- Bottom navigation with five destinations
- Top app bar that hides for full-screen story
- Post detail screen with start index parameter
- CameraX dependencies prepared for future capture flow

## Tech Stack

- Language: Kotlin (JVM 11)
- UI: Jetpack Compose + Material 3
- Navigation: Navigation Compose
- Image Loading: Coil 3
- Utilities: Google Accompanist (SwipeRefresh, Permissions)
- Async/State: Compose state + ViewModel
- Min SDK 24, Target/Compile SDK 36

## Module Structure

```
app/
 └── src/main/java/com/mahdizaredev/socialdesign/
     ├── data/
     │   ├── MockDataRepository.kt
     │   ├── MockNameRepository.kt
     │   ├── MockStringRepository.kt
     │   └── model/
     │       ├── ActivityItem.kt
     │       ├── Post.kt
     │       └── Story.kt
     ├── ui/
     │   ├── component/ (StoriesRow, PostsView, TopNavBar, BottomNavigationBar, etc.)
     │   ├── screen/ (Home, Explore, Add, Activities, Profile, SingleStoryView, PostDetail)
     │   ├── theme/ (Color, Theme, Type)
     │   └── utils/ (MenuItem)
     ├── vm/
     │   └── PostsViewModel.kt
     └── MainActivity.kt
```

## Architecture

- Single-Activity app with Compose navigation
- `SocialDesignApp` hosts `NavHost` and conditionally shows top/bottom bars
- Screens delegate to small, focused composables in `ui/component`
- Mock repositories provide deterministic sample data for UI showcasing

Key navigation setup (start destination `home`, dynamic routes for story and post detail):

```20:53:app/src/main/java/com/mahdizaredev/socialdesign/ui/screen/SocialDesignApp.kt
@Composable
fun SocialDesignApp() {
    val navController = rememberNavController()
    var isFullScreen = checkForFullScreen(navController)
    Scaffold(
        topBar = { if(!isFullScreen) TopNavBar() },
        modifier = Modifier.fillMaxSize(),
        bottomBar = { if(!isFullScreen) BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(navController, startDestination = "home") {
                composable(MenuItem.Home.route) { HomeScreen(navController) }
                composable(MenuItem.Explore.route) { ExploreScreen(navController) }
                composable(MenuItem.Add.route) { AddScreen(navController) }
                composable(MenuItem.Activities.route) { ActivitiesScreen(navController) }
                composable(MenuItem.Profile.route) { ProfileScreen(navController) }
                composable(
                    "story/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) {
                    val id = it.arguments?.getInt("id") ?: 0
                    SingleStoryView(id, navController)
                }
                composable("postDetail/{startIndex}") { backStackEntry ->
                    val startIndex = backStackEntry.arguments?.getString("startIndex")?.toInt() ?: 0
                    PostDetailScreen(navController, startIndex)
                }
            }
        }
    }
}
```

Post interactions include double-tap like animation, action row, and caption:

```93:103:app/src/main/java/com/mahdizaredev/socialdesign/ui/component/PostsView.kt
@Composable
fun PostItem(post: Post, navController: NavController) {
    var liked by rememberSaveable { mutableStateOf(false) }
    Column {
        PostAuthor(post)
        PostImage(post, liked) { liked = !liked }
        PostActions(post, liked) { liked = !liked }
        PostCaption(post)
        Spacer(Modifier.height(16.dp))
    }
}
```

## Requirements

- Android Studio Ladybug or newer
- JDK 11
- Android SDK 24+

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Build and run on device/emulator (no backend required)

## App ID and SDK

- Application ID: `com.mahdizaredev.socialdesign`
- Min SDK: 24
- Target/Compile SDK: 36

## Permissions

- Internet (image loading)
- Camera (future features; not fully wired)
- Read External Storage / Read Media Images (gallery support groundwork)

## Notes

- This is a UI showcase; data is mocked via repositories in `data/`
- Replace mock data and add repositories/services to integrate a real backend
- CameraX libraries are included for future capture and story/post creation flows

## License

This project is open-source under the MIT License.


