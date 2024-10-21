package com.example.kompass

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.PluralsRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.kompass.ui.theme.KompassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldCreation()
        }
    }

    @Composable
    private fun ScaffoldCreation() {
        KompassTheme {
            Scaffold(
                bottomBar = {
                    BottomAppBar(
                        containerColor = Color.Blue,
                        contentColor = Color.Yellow,
                    ) {
                        NavBarButtons()
                    }
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding), // Avoid overlap with BottomAppBar
                    contentAlignment = Alignment.Center
                ) {
                    NavButtons()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MobileAppPreview() {
        ScaffoldCreation();
    }
}

@Composable
fun NavBarButtons() {

//    Text(
//        modifier = Modifier.fillMaxSize(),
//        text = "Navbar",
//        textAlign = TextAlign.Center,
//        fontSize = 10.em,
//    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavBarBtn("home", LocalContext.current)
        NavBarBtn("qr", LocalContext.current)
        NavBarBtn("user", LocalContext.current)
        NavBarBtn("search", LocalContext.current)
    }

}

@Composable
fun NavButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryBtn("Product Info", Color.Black)
            CategoryBtn("Installation", Color.Black)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryBtn("Logistics & Delivery", Color.Black)
            CategoryBtn("Policy", Color.Black)
        }
    }
}

@Composable
fun CategoryBtn(text: String, color: Color) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(320.dp)
            .background(color, shape = RoundedCornerShape(8.dp))
            .clickable { println("$text button Clicked") },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

//@Composable
//fun NavBarBtn(text: String) {
//    Box(
//        modifier = Modifier
//            .width(60.dp)
//            .height(60.dp)
//            .background(color=Color.Black, shape = RoundedCornerShape(8.dp))
//            .clickable { println("$text button Clicked") },
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = text,
//            color = Color.White,
//            fontSize = 12.sp,
//            textAlign = TextAlign.Center
//        )
//    }
//}

@Composable
fun NavBarBtn(text: String, context: Context) {
    // var buttonPath = "R.drawable." + text + "_navbar_logo"

    val drawableId = remember(text) {
        context.resources.getIdentifier("${text}_navbar_logo", "drawable", context.packageName)
    }

    Box(
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .clickable { println("$text button Clicked") }
            .background(color = Color.Black, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        // TODO Change images so that we use larger images, to reduce bluriness by scaling
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = "$text icon",
            modifier = Modifier.size(50.dp),
            // contentScale = ContentScale.Fit
        )
    }
}


