package com.mahdizaredev.socialdesign.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mahdizaredev.socialdesign.ui.component.UserCircleProfile

@Composable
fun ProfileScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    UserCircleProfile(
                        "https://avatars.githubusercontent.com/u/190405738?v=4",
                        "Iliya",
                        80.dp,
                        BorderStroke(2.dp, Color.Gray)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        ProfileStat("Posts", "30")
                        ProfileStat("Followers", "100K")
                        ProfileStat("Following", "195")
                    }
                }
                Spacer(Modifier.width(8.dp))
                NameAndBio()
                Spacer(Modifier.width(8.dp))
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text("Edit Profile")
                }
                Spacer(Modifier.width(8.dp))

            }
            ExploreScreen(navController)

        }
    }
}

@Composable
fun NameAndBio() {
    Column {
        Text("Mahdi Zare", fontWeight = FontWeight.Bold)
        Text("Full Stack Mobile Developer🧑‍💻")
    }
}

@Composable
fun ProfileStat(label: String, count: String) {
    Column {
        Text(count, fontWeight = FontWeight.Bold)
        Text(label)
    }
}