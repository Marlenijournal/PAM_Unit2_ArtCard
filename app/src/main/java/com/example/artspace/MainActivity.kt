package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtCardDisplay()
            }
        }
    }
}

@Composable
fun ArtCardDisplay() {
    // Daftar gambar, judul, dan nama artis
    val imageList = listOf(R.drawable.zeus, R.drawable.hera, R.drawable.aphrodite, R.drawable.posaiden,R.drawable.apollo,R.drawable.athena,R.drawable.hedes, R.drawable.demeter,R.drawable.hephaestus,R.drawable.ares,R.drawable.hermes,R.drawable.arthemis,R.drawable.hestia)
    val titleList = listOf("Zeus", "Hera", "Aphrodite","Posaiden","Apollo", "Athena", "Hades", "Demeter", "Hephaestus", "Ares", "Hermes", "Arthemis", "Hestia")
    val artistList = listOf("Raja dewa, penguasa langit dan petir.",
                            "Dewi pernikahan dan keluarga, istri Zeus.",
                            "Dewi cinta dan kecantikan.",
                            "Dewa laut dan gempa bumi.",
                            "Dewa musik, puisi, dan ramalan",
                            "Dewi kebijaksanaan dan perang.",
                            "Dewa dunia bawah dan kematian.",
                            " Dewi pertanian dan kesuburan.",
                            "Dewa api dan pengrajin.",
                            "Dewa perang dan kekerasan.",
                            "Dewa perdagangan dan utusan dewa.",
                            "Dewi berburu dan alam liar.",
                            "Dewi perapian dan rumah.")

    // Index gambar aktif
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        // Tampilan Card untuk gambar
        Surface(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(0.8f),
            shadowElevation = 8.dp
        ) {
            Image(
                painter = painterResource(id = imageList[currentIndex]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .padding(10.dp)
            )
        }

        // Box untuk menampilkan teks judul dan nama artis
        Box(
            modifier = Modifier
                .padding(10.dp)
                .background(Color(0xAAd5e1f5))
                .padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = titleList[currentIndex],
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = artistList[currentIndex],
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }

        // Baris untuk tombol navigasi
        Row(
            modifier = Modifier
                .fillMaxWidth() // Pastikan tombol mengambil lebar penuh
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) currentIndex--
                },
                modifier = Modifier
                    .padding(end = 8.dp)
                    .height(40.dp)
            ) {
                Text("Previous")
            }
            Button(
                onClick = {
                    if (currentIndex < imageList.size - 1) currentIndex++
                },
                modifier = Modifier.height(40.dp)
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArtCardDisplay() {
    ArtSpaceTheme {
        ArtCardDisplay()
    }
}
