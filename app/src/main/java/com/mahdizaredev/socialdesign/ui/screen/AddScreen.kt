package com.mahdizaredev.socialdesign.ui.screen

import android.content.ContentUris
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.rememberPermissionState
import java.io.File

@Composable
fun AddScreen(navController: NavHostController) {
    val context = LocalContext.current

    val cameraPermission = android.Manifest.permission.CAMERA
    val storagePermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        android.Manifest.permission.READ_MEDIA_IMAGES
    else
        android.Manifest.permission.READ_EXTERNAL_STORAGE

    var cameraGranted by remember { mutableStateOf(false) }
    var storageGranted by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        cameraGranted = permissions[cameraPermission] ?: false
        storageGranted = permissions[storagePermission] ?: false
    }

    LaunchedEffect(Unit) {
        launcher.launch(arrayOf(cameraPermission, storagePermission))
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(0.5f).fillMaxWidth()) {
            if (cameraGranted) CameraPreview()
            else Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Camera permission required")
            }
        }

        Box(modifier = Modifier.weight(0.5f).fillMaxWidth()) {
            if (storageGranted) GalleryGrid(navController)
            else Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Storage permission required")
            }
        }
    }
}



@Composable
fun CameraPreview() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    val previewView = remember { PreviewView(context) }

    AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())

    val imageCapture = remember { ImageCapture.Builder().build() }

    LaunchedEffect(cameraProviderFuture) {
        val cameraProvider = cameraProviderFuture.get()
        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(previewView.surfaceProvider)
        }
        val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                imageCapture
            )
        } catch (exc: Exception) {
            Log.e("CameraPreview", "Use case binding failed", exc)
        }
    }
}

@Composable
fun GalleryGrid(navController: NavHostController) {
    val context = LocalContext.current
    val images = remember { mutableStateListOf<Uri>() }

    LaunchedEffect(Unit) {
        val uriExternal: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.Images.Media._ID)
        context.contentResolver.query(
            uriExternal,
            projection,
            null,
            null,
            "${MediaStore.Images.Media.DATE_ADDED} DESC"
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val contentUri = ContentUris.withAppendedId(uriExternal, id)
                images.add(contentUri)
            }
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(2.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(images) { uri ->
            AsyncImage(
                model = uri,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clickable {
                        // کلیک روی عکس برای انتخاب یا پیش‌نمایش
                    },
                contentScale = ContentScale.Crop
            )
        }
    }
}


