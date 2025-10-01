<div align="center">

# 📸 SocialDesign — Instagram UI for Developers & Employers

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.0-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Jetpack_Compose-Material_3-3DDC84?logo=android&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Min SDK](https://img.shields.io/badge/Min_SDK-24-FF6F00)](#)
[![Target SDK](https://img.shields.io/badge/Target_SDK-36-FF6F00)](#)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](#license)

<br/>
Modern Instagram-style Android app (UI only) built with Kotlin and Jetpack Compose — tailored for showcasing clean UI/UX patterns to programmers and employers.

<br/>
<img src="app/src/main/appicon-playstore.png" alt="App Icon" width="88" />

</div>

---

## ✨ Highlights

- 🔥 Double-tap like with animated heart burst
- 🧵 Infinite scroll feed with lazy loading
- 🔄 Pull-to-refresh via Accompanist
- 🧭 Bottom navigation (Home/Explore/Add/Activities/Profile)
- 🧑‍🤝‍🧑 Stories row + full-screen story viewer
- 🗂️ Post detail with index deep-link
- 🖼️ Coil 3 image loading with loading state
- 🔒 Permissions scaffolded (Camera, Media)

## 🖼️ Screenshots

> Replace with your real screenshots (GIFs recommended). For now, using bundled assets as placeholders.

<table>
  <tr>
    <td align="center"><strong>Home</strong></td>
    <td align="center"><strong>Top Bar</strong></td>
    <td align="center"><strong>Icon</strong></td>
  </tr>
  <tr>
    <td><img src="app/src/main/mipmap-xxxhdpi/appicon.webp" alt="Home" width="240"/></td>
    <td><img src="app/src/main/res/drawable/topbar.png" alt="Top Bar" width="240"/></td>
    <td><img src="app/src/main/ic_launcher-playstore.png" alt="Icon" width="240"/></td>
  </tr>
</table>

<details>
  <summary><strong>How to capture nice screenshots / recordings</strong> 📹</summary>

1. Run on a Pixel emulator (portrait) with system UI hidden.
2. Use Android Studio Layout Inspector to verify edge-to-edge and paddings.
3. Record GIFs with Android Studio or `adb shell screenrecord` and convert via ffmpeg.

</details>

## 🧩 Tech Stack

- 🟣 Kotlin (JVM 11)
- 🟢 Jetpack Compose + Material 3
- 🧭 Navigation Compose
- 🖼️ Coil 3 (AsyncImage)
- 🧰 Google Accompanist (SwipeRefresh, Permissions)
- 🧪 ViewModel + Compose state

## 🧱 Project Structure

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
     │   ├── component/ (StoriesRow, PostsView, TopNavBar, BottomNavigationBar, ...)
     │   ├── screen/ (Home, Explore, Add, Activities, Profile, SingleStoryView, PostDetail)
     │   ├── theme/ (Color, Theme, Type)
     │   └── utils/ (MenuItem)
     ├── vm/
     │   └── PostsViewModel.kt
     └── MainActivity.kt
```

## 🧭 Navigation Overview

```20:53:app/src/main/java/com/mahdizaredev/socialdesign/ui/screen/SocialDesignApp.kt
@Composable
fun SocialDesignApp() { /* NavHost with Home/Explore/Add/Activities/Profile + story/{id} + postDetail/{startIndex} */ }
```

```93:103:app/src/main/java/com/mahdizaredev/socialdesign/ui/component/PostsView.kt
@Composable
fun PostItem(post: Post, navController: NavController) { /* author, image, actions, caption */ }
```

## 🚀 Quick Start

```bash
git clone https://github.com/your-username/SocialDesign.git
open -a "Android Studio" SocialDesign
```

1. Use Android Studio Ladybug or newer
2. Build and run on device/emulator (no backend required)

## ⚙️ App ID & SDK

- Application ID: `com.mahdizaredev.socialdesign`
- Min SDK: 24 • Target/Compile SDK: 36

## 🔐 Permissions

- `INTERNET` (image loading)
- `CAMERA` (future story/post capture)
- `READ_MEDIA_IMAGES` / `READ_EXTERNAL_STORAGE` (gallery groundwork)

## 🗒️ Notes

- UI showcase only: data is mocked in `data/`
- Swap mock repositories for real data sources when integrating backend
- CameraX libraries included for future capture flows

## 📄 License

MIT — feel free to use, learn, and build upon.


