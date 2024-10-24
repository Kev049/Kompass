package com.example.kompass

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.ui.theme.BgBlack
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.KompassTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kompass.ui.BasicInfoScreen
import com.example.kompass.ui.DocumentsScreen
import com.example.kompass.ui.LogisticsScreen
import com.example.kompass.ui.ScrollableProdCategoryScreen
import com.example.kompass.ui.SustainabilityScreen

enum class KompassScreen {
    Home,
    Basic,
    Logistics,
    Sustainability,
    Documents,
    ProdCategory
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KompassTheme {
                KompassApp()
            }
        }
    }
}

@Composable
private fun KompassApp(
    navController: NavHostController = rememberNavController(),
) {
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val screenHeight = config.screenHeightDp
    Scaffold(
        containerColor = BgBlack,
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black,
                modifier = Modifier
                    .height(100.dp)
                    .topBorder(Color.White, 0.5f),
            ) {
                NavBarButtons(
                    onNavigate = {
                        screen ->
                        if(navController.currentDestination?.route !== screen.name){
                            navController.navigate(screen.name)
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = KompassScreen.Home.name,
            enterTransition = { fadeIn(initialAlpha = 0.4f) },
            exitTransition = { fadeOut(animationSpec = tween(durationMillis = 250)) }
        ) {
            composable(KompassScreen.Home.name) {
                HomeScreen(
                    innerPadding = innerPadding,
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
            composable(KompassScreen.Basic.name) {
                BasicInfoScreen(
                    innerPadding = innerPadding,
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
            composable(KompassScreen.Logistics.name) {
                LogisticsScreen(
                    innerPadding = innerPadding,
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
            composable(KompassScreen.Sustainability.name) {
                SustainabilityScreen(
                    innerPadding = innerPadding,
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
            composable(KompassScreen.Documents.name) {
                DocumentsScreen(
                    innerPadding = innerPadding,
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
            composable(KompassScreen.ProdCategory.name){
                ScrollableProdCategoryScreen(innerPadding = innerPadding,
                    navController, screenWidth, screenHeight)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MobileAppPreview() {
    KompassApp()
}

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    onNavigate: (KompassScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding), // Avoid overlap with BottomAppBar
        contentAlignment = Alignment.Center
    ) {
        PlaceMainButtons(
            onNavigate = onNavigate
        )
    }
}

@Composable
fun NavBarButtons(
    onNavigate: (KompassScreen) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavBarButton(NavBarItem.Home) { onNavigate(KompassScreen.Home) }
        NavBarButton(NavBarItem.QR) { onNavigate(KompassScreen.Home) }
        NavBarButton(NavBarItem.Search) { onNavigate(KompassScreen.Home) }
        NavBarButton(NavBarItem.User) { onNavigate(KompassScreen.Home) }
    }
}

@Composable
private fun NavBarButton(
    navBarItem: NavBarItem,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(64.dp)
            .height(52.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = navBarItem.icon),
            contentDescription = "${navBarItem.description} icon",
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
private fun PlaceMainButtons(
    onNavigate: (KompassScreen) -> Unit
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
            MainButton(CategoryItem.Basic, onNavigate = onNavigate)
            MainButton(CategoryItem.Logistics, onNavigate = onNavigate)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MainButton(CategoryItem.Sustainability, onNavigate = onNavigate)
            MainButton(CategoryItem.Documents, onNavigate = onNavigate)
        }
    }
}

@Composable
fun MainButton(
    categoryItem: CategoryItem,
    onNavigate: (KompassScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(300.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(12.dp))
            .clickable { onNavigate(categoryItem.route) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center-align items horizontally
            verticalArrangement = Arrangement.Center // Center-align items vertically
        ) {
            Image(
                painter = painterResource(id = categoryItem.icon),
                contentDescription = "${categoryItem.description} icon",
                modifier = Modifier.size(90.dp)
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
                    .width(140.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }
    }
}

sealed class NavBarItem(val icon: Int, val description: String) {
    data object Home : NavBarItem(R.drawable.navbar_home, "home")
    data object QR : NavBarItem(R.drawable.navbar_qr, "qr")
    data object User : NavBarItem(R.drawable.navbar_user, "user")
    data object Search : NavBarItem(R.drawable.navbar_search, "search")
}

// fin kod endast
sealed class CategoryItem(val icon: Int, val description: String, val route: KompassScreen) {

    data object Basic : CategoryItem(R.drawable.menu_main_info, "Basic Information", KompassScreen.Basic)
    data object Logistics : CategoryItem(R.drawable.menu_main_logistics, "Logistics", KompassScreen.Logistics)
    data object Sustainability : CategoryItem(R.drawable.menu_main_sustainability, "Sustainability & Design", KompassScreen.Sustainability)
    data object Documents : CategoryItem(R.drawable.menu_main_documents, "Documents & Policy", KompassScreen.Documents)
}

sealed class SubButtonItem(val icon: Int, val description: String) {
    data object Specific : SubButtonItem(R.drawable.menu_basic_spec, "Product Specifics")
    data object Contents : SubButtonItem(R.drawable.menu_basic_contents, "Contents")
    data object Dimensions : SubButtonItem(R.drawable.menu_basic_dimensions, "Dimensions")
    data object Materials : SubButtonItem(R.drawable.menu_basic_materials, "Materials & Care")

    data object Availability : SubButtonItem(R.drawable.menu_logistics_availability, "Availability")
    data object Location : SubButtonItem(R.drawable.menu_logistics_location, "In-Store Location")
    data object Delivery : SubButtonItem(R.drawable.menu_logistics_delivery, "Delivery Options")
    data object History : SubButtonItem(R.drawable.menu_logistics_history, "Product History")

    data object Sustainability : SubButtonItem(R.drawable.menu_main_sustainability, "Sustainability")
    data object Description : SubButtonItem(R.drawable.menu_sustainability_description, "Description")

    data object Manual : SubButtonItem(R.drawable.menu_documents_manual, "Manual")
    data object Installation : SubButtonItem(R.drawable.menu_documents_installation, "Installation")
    data object Safety : SubButtonItem(R.drawable.menu_documents_safety, "Safety")
    data object Policy : SubButtonItem(R.drawable.menu_documents_policy, "Policies")
}

private fun Modifier.topBorder(
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

//@Composable
//fun KompassApp(
//    navController: NavHostController = rememberNavController()
//) {
//    Scaffold(
//        bottomBar = {
//            BottomAppBar(
//                containerColor = Color.Blue,
//                contentColor = Color.Yellow,) {
//                NavBarButtons()
//            }
//        }
//    ) { innerPadding ->
//        NavHost(
//            navController = navController,
//            startDestination = KompassScreen.Start.name,
//            modifier = Modifier.padding(innerPadding)
//        ) {
//            composable(route = KompassScreen.Start.name) {
//                //MainScreen(
//                //    modifier = Modifier.fillMaxSize()
//                //)
//            }
//        }
//    }
//}

//@Composable
//fun MainScreen(
//    modifier: Modifier
//) {
//    Box(
//        modifier = modifier, // Avoid overlap with BottomAppBar
//        contentAlignment = Alignment.Center
//    ) {
//        NavButtons()
//    }
//}



