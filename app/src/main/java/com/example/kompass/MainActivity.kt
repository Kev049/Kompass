package com.example.kompass

import android.os.Bundle
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
import com.example.kompass.ui.SustainabilityScreen

enum class KompassScreen {
    Home,
    Basic,
    Logistics,
    MainSustainability,
    Documents,
    Specific,
    Dimensions,
    Contents,
    Material,
    Availability,
    Location,
    Delivery,
    History,
    SubSustainability,
    Description,
    Manual,
    Installation,
    Safety,
    Policy
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
    categories: List<CategoryItem> = listOf(
        CategoryItem.Basic, CategoryItem.Logistics,
        CategoryItem.MainSustainability, CategoryItem.Documents
    )
) {
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
                    categories = categories,
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
            composable(KompassScreen.Basic.name) {
                BasicInfoScreen(innerPadding = innerPadding)
            }
            composable(KompassScreen.Logistics.name) {
                LogisticsScreen(innerPadding = innerPadding)
            }
            composable(KompassScreen.MainSustainability.name) {
                SustainabilityScreen(innerPadding = innerPadding)
            }
            composable(KompassScreen.Documents.name) {
                DocumentsScreen(innerPadding = innerPadding)
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
    categories: List<CategoryItem>,
    onNavigate: (KompassScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding), // Avoid overlap with BottomAppBar
        contentAlignment = Alignment.Center
    ) {
        NavButtons(
            categories = categories,
            onNavigate = onNavigate
        )
    }
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
fun NavButtons(
    categories: List<CategoryItem>,
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
            CategoryButton(categories[0]) { onNavigate(categories[0].screenName) }
            CategoryButton(categories[1]) { onNavigate(categories[1].screenName) }
        }

        //Show either 1 or 2 buttons depending on the number of categories
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (categories.size == 3) Arrangement.Center else Arrangement.SpaceEvenly
        ) {
            CategoryButton(categories[2]) { onNavigate(categories[2].screenName) }
            if (categories.size > 3) CategoryButton(categories[3]) { onNavigate(categories[3].screenName) }
        }
    }
}

@Composable
fun CategoryButton(
    categoryItem: CategoryItem,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(300.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(12.dp))
            .clickable { onClick() },
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
sealed class CategoryItem(val icon: Int, val description: String, val screenName: KompassScreen) {

    data object Basic : CategoryItem(R.drawable.menu_main_info, "Basic Information", KompassScreen.Basic)
    data object Logistics : CategoryItem(R.drawable.menu_main_logistics, "Logistics", KompassScreen.Logistics)
    data object MainSustainability : CategoryItem(R.drawable.menu_main_sustainability, "Sustainability & Design", KompassScreen.MainSustainability)
    data object Documents : CategoryItem(R.drawable.menu_main_documents, "Documents & Policy", KompassScreen.Documents)

    data object Specific : CategoryItem(R.drawable.menu_basic_spec, "Product Specifics", KompassScreen.Specific)
    data object Contents : CategoryItem(R.drawable.menu_basic_contents, "Contents", KompassScreen.Contents)
    data object Dimensions : CategoryItem(R.drawable.menu_basic_dimensions, "Dimensions", KompassScreen.Dimensions)
    data object Materials : CategoryItem(R.drawable.menu_basic_materials, "Materials & Care", KompassScreen.Material)

    data object Availability : CategoryItem(R.drawable.menu_logistics_availability, "Availability", KompassScreen.Availability)
    data object Location : CategoryItem(R.drawable.menu_logistics_location, "In-Store Location", KompassScreen.Location)
    data object Delivery : CategoryItem(R.drawable.menu_logistics_delivery, "Delivery Options", KompassScreen.Delivery)
    data object History : CategoryItem(R.drawable.menu_logistics_history, "Product History", KompassScreen.History)

    data object SubSustainability : CategoryItem(R.drawable.menu_main_sustainability, "Sustainability", KompassScreen.SubSustainability)
    data object Description : CategoryItem(R.drawable.menu_sustainability_description, "Description", KompassScreen.Description)

    data object Manual : CategoryItem(R.drawable.menu_documents_manual, "Manual", KompassScreen.Manual)
    data object Installation : CategoryItem(R.drawable.menu_documents_installation, "Installation", KompassScreen.Installation)
    data object Safety : CategoryItem(R.drawable.menu_documents_safety, "Safety", KompassScreen.Safety)
    data object Policy : CategoryItem(R.drawable.menu_documents_policy, "Policies", KompassScreen.Policy)

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


