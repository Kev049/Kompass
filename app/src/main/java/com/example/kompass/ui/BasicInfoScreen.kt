package com.example.kompass.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.R
import com.example.kompass.ui.theme.KompassTheme
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.BgBlack

@Composable
fun BasicInfoScreen(
) {
        Scaffold(
            containerColor = BgBlack,
            bottomBar = {
                BottomAppBar(
                    containerColor = Color.Black,
                    contentColor = Color.Yellow,
                    modifier = Modifier
                        .height(72.dp)
                        .topBorder(Color.White, 0.5f)
                ) {
                    NavBarButtons2()
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding), // Avoid overlap with BottomAppBar
                contentAlignment = Alignment.Center
            ) {
                InfoButtons()
            }
        }
}

@Composable
private fun InfoButtons(
) {
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
            CategoryBtn2("Product Specifics", IkeaBlue)
            CategoryBtn2("Installation", IkeaBlue)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryBtn2("Dimensions", IkeaBlue)
            CategoryBtn2("Materials & Care", IkeaBlue)
        }
    }
}

@Composable
fun CategoryBtn2(
    text: String,
    color: Color)
{

    val drawableMap = mapOf(
        "Product Specifics" to R.drawable.spec,
        "Installation" to R.drawable.contents,
        "Dimensions" to R.drawable.dimensions,
        "Materials & Care" to R.drawable.materials
    )

    val drawableId = drawableMap[text]

    Box(
        modifier = Modifier
            .width(160.dp)
            .height(320.dp)
            .background(color, shape = RoundedCornerShape(8.dp))
            .clickable { println("$text button Clicked") },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center-align items horizontally
            verticalArrangement = Arrangement.Center // Center-align items vertically
        ) {
            if (drawableId != null) {  // Check if drawableId is valid
                Image(
                    painter = painterResource(id = drawableId),
                    contentDescription = "$text icon",
                    modifier = Modifier.size(110.dp)
                        .padding(bottom = 8.dp),
                    contentScale = ContentScale.Fit
                )
            } else {
                // Fallback in case drawable is not found
                Text(
                    text = text,
                    modifier = Modifier.size(50.dp),
                    textAlign = TextAlign.Center
                )
            }
            Text(
                text = text,
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                        .height(60.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }
    }
}


@Composable
private fun NavBarButtons2() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavBarBtn2("home")
        NavBarBtn2("qr")
        NavBarBtn2("user")
        NavBarBtn2("search")
    }
}

@Composable
private fun NavBarBtn2(text: String) {

    val navbarDrawableMap = mapOf(
        "home" to R.drawable.home,
        "qr" to R.drawable.qr,
        "user" to R.drawable.user,
        "search" to R.drawable.search
    )

    val navbarDrawableId = navbarDrawableMap[text]
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(52.dp)
            .clickable { println("$text button Clicked") },
        contentAlignment = Alignment.Center
    ) {
        if (navbarDrawableId != null) {  // Check if drawableId is valid
            Image(
                painter = painterResource(id = navbarDrawableId),
                contentDescription = "$text icon",
                modifier = Modifier.size(38.dp)
            )
        } else {
            // Fallback in case drawable is not found
            Text(
                text = text,
                modifier = Modifier.size(50.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}


fun Modifier.topBorder(
    color: Color,
    height: Float,
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        start = Offset(0f, 0f),
        end = Offset(size.width, 0f),
        strokeWidth = height,
    )
}

@Preview(showBackground = true)
@Composable
private fun InfoScreenPreview(
) {
    KompassTheme {
        BasicInfoScreen(
        )
    }
}

