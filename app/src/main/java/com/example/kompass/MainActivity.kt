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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.kompass.ui.theme.BgBlack
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.KompassTheme
import java.util.Locale.Category

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
        val categories = listOf(
            CategoryItem.Basic, CategoryItem.Logistics,
            CategoryItem.Sustainability, CategoryItem.Documents
        )

        KompassTheme {
            Scaffold(
                containerColor = BgBlack,
                bottomBar = {
                    BottomAppBar(
                        containerColor = Color.Black,
                        contentColor = Color.Yellow,
                        modifier = Modifier
                            .height(82.dp)
                            .topBorder(Color.White, 0.5f)
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
                    NavButtons(categories)
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
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavBarButton(NavBarItem.Home)
        NavBarButton(NavBarItem.QR)
        NavBarButton(NavBarItem.User)
        NavBarButton(NavBarItem.Search)
    }
}

@Composable
private fun NavBarButton(navBarItem: NavBarItem) {
    Box(
        modifier = Modifier
            .width(64.dp)
            .height(52.dp)
            .clickable { println("${navBarItem.description} button Clicked") },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = navBarItem.icon),
            contentDescription = "${navBarItem.description} icon",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun NavButtons(categories : List<CategoryItem>) {
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
            CategoryButton(categories[0])
            CategoryButton(categories[1])
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryButton(categories[2])
            CategoryButton(categories[3])
        }
    }
}

@Composable
fun CategoryButton(
    categoryItem: CategoryItem, )
{
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(320.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(8.dp))
            .clickable { println("${categoryItem.description} button Clicked") },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center-align items horizontally
            verticalArrangement = Arrangement.Center // Center-align items vertically
        ) {
            Image(

                painter = painterResource(id = categoryItem.icon),
                contentDescription = "${categoryItem.description} icon",
                modifier = Modifier.size(110.dp)
                    .padding(bottom = 8.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = categoryItem.description,
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


sealed class NavBarItem(val icon: Int, val description: String) {
    data object Home : NavBarItem(R.drawable.home, "home")
    data object QR : NavBarItem(R.drawable.qr, "qr")
    data object User : NavBarItem(R.drawable.user, "user")
    data object Search : NavBarItem(R.drawable.search, "search")
}

sealed class CategoryItem(val icon: Int, val description: String) {
    data object Basic : CategoryItem(R.drawable.info, "Basic Information")
    data object Logistics : CategoryItem(R.drawable.logistics, "Logistics")
    data object Sustainability : CategoryItem(R.drawable.sustainability, "Sustainability & Design")
    data object Documents : CategoryItem(R.drawable.documents, "Documents & Policy")
    data object Specific : CategoryItem(R.drawable.spec, "Product Specifics")
    data object Contents : CategoryItem(R.drawable.contents, "Contents")
    data object Dimensions : CategoryItem(R.drawable.dimensions, "Dimensions")
    data object Materials : CategoryItem(R.drawable.materials, "Materials & Care")
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


