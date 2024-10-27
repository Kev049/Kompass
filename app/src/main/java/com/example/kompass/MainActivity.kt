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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kompass.types.Category
import com.example.kompass.ui.BasicInfoScreen
import com.example.kompass.ui.CategoryScreen
import com.example.kompass.ui.DetailedDimensionsScreen
import com.example.kompass.ui.DetailedAvailabilityScreen
import com.example.kompass.ui.DetailedContentsScreen
import com.example.kompass.ui.DetailedMaterialsScreen
import com.example.kompass.ui.DetailedProductSpecificsScreen
import com.example.kompass.ui.DocumentsScreen
import com.example.kompass.ui.LogisticsScreen
import com.example.kompass.ui.ProductListScreen
import com.example.kompass.ui.SearchScreen
import com.example.kompass.ui.SubCategoryScreen
import com.example.kompass.ui.SustainabilityScreen
import com.example.kompass.ui.shared.SharedRecentImage
import com.example.kompass.ui.theme.BgBlack
import com.example.kompass.ui.theme.IkeaBlue
import com.example.kompass.ui.theme.KompassTheme
import com.example.kompass.ui.DetailedSustainabilityScreen
import com.example.kompass.ui.shared.SharedRecentProduct
import com.example.kompass.ui.shared.SharedSecondaryButton

enum class KompassScreen {
    Home,
    Basic,
    Logistics,
    DetailedAvailability,
    DetailedDimensions,
    DetailedMaterials,
    DetailedContents,
    DetailedProductSpecifics,
    DetailedSustainability,
    Sustainability,
    Documents,
    ProductList,
    Category,
    Search,
    SubCategory //
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
    val primaryButtonItemMap = mutableMapOf<Any, PrimaryButtonItem>()
    initializePrimaryButtonItemMap(primaryButtonItemMap)
    val sharedRecentImage: SharedRecentImage = viewModel()
    val sharedRecentProduct: SharedRecentProduct = viewModel()
    val sharedRecentSecondaryButton : SharedSecondaryButton = viewModel()
    val recentImage by sharedRecentImage.recentImage.collectAsState()
    val recentProduct by sharedRecentProduct.recentProduct.collectAsState()
    val recentSecondaryButton by sharedRecentSecondaryButton.recentSecondaryButton.collectAsState()
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val screenHeight = config.screenHeightDp
    var category = Category.NONE

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
                            // reset most recent image to null (is displayed in the categories screen)
                            if(screen.name == KompassScreen.Home.name){
                                sharedRecentImage.setRecentImage(null)
                                sharedRecentProduct.setRecentProduct(null)
                                sharedRecentSecondaryButton.setRecentSecondaryButton(null)
                            }
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
                        val primaryButtonItem = primaryButtonItemMap[screen]
                        primaryButtonItem?.let { sharedRecentImage.setRecentImage(primaryButtonItem.icon) }
                        navController.navigate(screen.name);
                    }
                )
            }
            composable(KompassScreen.Basic.name) {
                BasicInfoScreen(
                    innerPadding = innerPadding,
                    onItemClicked = {itemName ->
                        sharedRecentImage.setRecentImage(itemName.icon)
                        sharedRecentSecondaryButton.setRecentSecondaryButton(itemName)
                    },
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    },
                )
            }
            composable(KompassScreen.Logistics.name) {
                LogisticsScreen(
                    innerPadding = innerPadding,
                    onItemClicked = {itemName ->
                        sharedRecentImage.setRecentImage(itemName.icon)
                        sharedRecentSecondaryButton.setRecentSecondaryButton(itemName)
                    },
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
            composable(KompassScreen.Sustainability.name) {
                SustainabilityScreen(
                    innerPadding = innerPadding,
                    onItemClicked = {itemName ->
                        sharedRecentImage.setRecentImage(itemName.icon)
                        sharedRecentSecondaryButton.setRecentSecondaryButton(itemName)
                    },
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
            composable(KompassScreen.Documents.name) {
                DocumentsScreen(
                    innerPadding = innerPadding,
                    onItemClicked = {itemName ->
                        sharedRecentImage.setRecentImage(itemName.icon)
                        sharedRecentSecondaryButton.setRecentSecondaryButton(itemName)
                    },
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
            composable(KompassScreen.Category.name){
                CategoryScreen(
                    innerPadding = innerPadding,
                    screenWidth,
                    screenHeight,
                    imageResId = recentImage,
                    onNavigate = { screen, _ ->
                        navController.navigate(screen.name)
                    }
                )
            }
            //var subCategory
            composable(KompassScreen.ProductList.name){
                recentSecondaryButton?.let { recentSecondaryButton ->
                    ProductListScreen(
                        innerPadding = innerPadding,
                        imageResId = recentImage,
                        onNavigate = { screen ->
                            navController.navigate(screen.name)
                        },
                        onItemClicked = {itemName ->
                            sharedRecentProduct.setRecentProduct(itemName)
                        },
                        secondaryButton = recentSecondaryButton,
                        category = category
                    )
                }
            }
            composable(KompassScreen.Search.name) {
                SearchScreen(
                    innerPadding = innerPadding,
                    onNavigate = { screen ->
                        navController.navigate(screen.name)
                    },
                    onItemClicked = {itemName ->
                        sharedRecentProduct.setRecentProduct(itemName)
                    },
                )
            }
            composable(KompassScreen.DetailedSustainability.name) {
                recentProduct?.let { recentProduct ->
                    DetailedSustainabilityScreen(
                        fontColor = Color.White,
                        onNavigate = { screen ->
                            if(navController.currentDestination?.route !== screen.name){
                                navController.navigate(screen.name)
                            }
                        },
                        innerPadding = innerPadding,
                        productImage = recentProduct.imageResId,
                        productName = recentProduct.name,
                        productNumber = recentProduct.articleNr,
                        productCategory = recentProduct.productDescription,
                        productPrice = recentProduct.price,
                        emissionAmount = recentProduct.sustainability.emissionAmount
                    )
                }
            }
            composable(KompassScreen.DetailedDimensions.name) {
                recentProduct?.let { recentProduct ->
                    DetailedDimensionsScreen(
                        fontColor = Color.White,
                        onNavigate = { screen ->
                            if(navController.currentDestination?.route !== screen.name){
                                navController.navigate(screen.name)
                            }
                        },
                        innerPadding = innerPadding,
                        productImage = recentProduct.imageResId,
                        productName = recentProduct.name,
                        productNumber = recentProduct.articleNr,
                        productCategory = recentProduct.productDescription,
                        productPrice = recentProduct.price,
                        dimensionInfo = recentProduct.dimension
                    )
                }
            }
            composable(KompassScreen.DetailedContents.name) {
                recentProduct?.let { recentProduct ->
                    DetailedContentsScreen(
                        fontColor = Color.White,
                        onNavigate = { screen ->
                            if(navController.currentDestination?.route !== screen.name){
                                navController.navigate(screen.name)
                            }
                        },
                        innerPadding = innerPadding,
                        productImage = recentProduct.imageResId,
                        productName = recentProduct.name,
                        productNumber = recentProduct.articleNr,
                        productCategory = recentProduct.productDescription,
                        productPrice = recentProduct.price,
                        contentCards = recentProduct.contentsCards
                    )
                }
            }
            composable(KompassScreen.DetailedMaterials.name) {
                recentProduct?.let { recentProduct ->
                    DetailedMaterialsScreen(
                        fontColor = Color.White,
                        onNavigate = { screen ->
                            if(navController.currentDestination?.route !== screen.name){
                                navController.navigate(screen.name)
                            }
                        },
                        innerPadding = innerPadding,
                        productImage = recentProduct.imageResId,
                        productName = recentProduct.name,
                        productNumber = recentProduct.articleNr,
                        productCategory = recentProduct.productDescription,
                        productPrice = recentProduct.price,
                        materialsDescription = recentProduct.materialsDescription
                    )
                }
            }
            composable(KompassScreen.DetailedProductSpecifics.name) {
                recentProduct?.let { recentProduct ->
                    DetailedProductSpecificsScreen(
                        fontColor = Color.White,
                        onNavigate = { screen ->
                            if(navController.currentDestination?.route !== screen.name){
                                navController.navigate(screen.name)
                            }
                        },
                        innerPadding = innerPadding,
                        productImage = recentProduct.imageResId,
                        productName = recentProduct.name,
                        productNumber = recentProduct.articleNr,
                        productCategory = recentProduct.productDescription,
                        productPrice = recentProduct.price,
                        productSpecification = recentProduct.productSpecification
                    )
                }
            }
            composable(KompassScreen.DetailedAvailability.name) {
                recentProduct?.let { recentProduct ->
                    DetailedAvailabilityScreen(
                        fontColor = Color.White,
                        onNavigate = { screen ->
                            if(navController.currentDestination?.route !== screen.name){
                                navController.navigate(screen.name)
                            }
                        },
                        innerPadding = innerPadding,
                        productImage = recentProduct.imageResId,
                        productName = recentProduct.name,
                        productNumber = recentProduct.articleNr,
                        productCategory = recentProduct.productDescription,
                        productPrice = recentProduct.price,
                    )
                }
            }
            composable(KompassScreen.SubCategory.name){
                SubCategoryScreen(
                    innerPadding = innerPadding,
                    screenWidth,
                    screenHeight,
                    imageResId = recentImage,
                    onNavigate = { screen, categoryFromClick ->
                        category = categoryFromClick
                        navController.navigate(screen.name)
                    }
                )
            }
        }
    }

}
fun initializePrimaryButtonItemMap(primaryButtonItemMap: MutableMap<Any, PrimaryButtonItem>){
    PrimaryButtonItem.getAllItems().forEach { item ->
        // Replace `item.description` with any unique key of your choice.
        primaryButtonItemMap[item.route] = item
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
        PlacePrimaryButtons(
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
        NavBarButton(NavBarItem.Search) { onNavigate(KompassScreen.Search) }
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
fun PlacePrimaryButtons(
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
            PrimaryButton(PrimaryButtonItem.Basic, onNavigate = onNavigate)
            PrimaryButton(PrimaryButtonItem.Logistics, onNavigate = onNavigate)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PrimaryButton(PrimaryButtonItem.Sustainability, onNavigate = onNavigate)
            PrimaryButton(PrimaryButtonItem.Documents, onNavigate = onNavigate)
        }
    }
}

@Composable
fun PrimaryButton(
    primaryButtonItem: PrimaryButtonItem,
    onNavigate: (KompassScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(300.dp)
            .background(IkeaBlue, shape = RoundedCornerShape(12.dp))
            .clickable { onNavigate(primaryButtonItem.route) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center-align items horizontally
            verticalArrangement = Arrangement.Center // Center-align items vertically
        ) {
            Image(
                painter = painterResource(id = primaryButtonItem.icon),
                contentDescription = "${primaryButtonItem.description} icon",
                modifier = Modifier
                    .size(90.dp)
                    .padding(bottom = 8.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = primaryButtonItem.description,
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
sealed class PrimaryButtonItem(val icon: Int, val description: String, val route: KompassScreen, val SubButtonList: List<SecondaryButtonItem> ) {

    data object Basic : PrimaryButtonItem(R.drawable.menu_main_info, "Basic Information", KompassScreen.Basic, SecondaryButtonItem.getBasicItems())
    data object Logistics : PrimaryButtonItem(R.drawable.menu_main_logistics, "Logistics", KompassScreen.Logistics, SecondaryButtonItem.getLogisticsItems())
    data object Sustainability : PrimaryButtonItem(R.drawable.menu_main_sustainability, "Sustainability & Design", KompassScreen.Sustainability, SecondaryButtonItem.getSustainabilityItems())
    data object Documents : PrimaryButtonItem(R.drawable.menu_main_documents, "Documents & Policy", KompassScreen.Documents, SecondaryButtonItem.getDocumentItems())

    companion object {
        // Function to retrieve all instances of primaryButtonItem
        fun getAllItems(): List<PrimaryButtonItem> = listOf(Basic, Logistics, Sustainability, Documents)
    }
}

sealed class SecondaryButtonItem(val icon: Int, val description: String) {
    data object Specific : SecondaryButtonItem(R.drawable.menu_basic_spec, "Product Specifics")
    data object Contents : SecondaryButtonItem(R.drawable.menu_basic_contents, "Contents")
    data object Dimensions : SecondaryButtonItem(R.drawable.menu_basic_dimensions, "Dimensions")
    data object MaterialsBasic : SecondaryButtonItem(R.drawable.menu_basic_materials, "Materials & Care")

    data object Availability : SecondaryButtonItem(R.drawable.menu_logistics_availability, "Availability")
    data object Location : SecondaryButtonItem(R.drawable.menu_logistics_location, "In-Store Location")
    data object Delivery : SecondaryButtonItem(R.drawable.menu_logistics_delivery, "Delivery Options")
    data object History : SecondaryButtonItem(R.drawable.menu_logistics_history, "Product History")

    data object Sustainability : SecondaryButtonItem(R.drawable.menu_main_sustainability, "Sustainability")
    data object Description : SecondaryButtonItem(R.drawable.menu_sustainability_description, "Description")
    data object MaterialsSustainability : SecondaryButtonItem(R.drawable.menu_basic_materials, "Materials & Care")

    data object Manual : SecondaryButtonItem(R.drawable.menu_documents_manual, "Manual")
    data object Installation : SecondaryButtonItem(R.drawable.menu_documents_installation, "Installation")
    data object Safety : SecondaryButtonItem(R.drawable.menu_documents_safety, "Safety")
    data object Policy : SecondaryButtonItem(R.drawable.menu_documents_policy, "Policies")

    companion object {
        fun getBasicItems(): List<SecondaryButtonItem> = listOf(Specific, Contents,Dimensions, MaterialsBasic)
        fun getLogisticsItems(): List<SecondaryButtonItem> = listOf(Availability, Location, Delivery, History)
        fun getSustainabilityItems(): List<SecondaryButtonItem> = listOf(Sustainability, Description)
        fun getDocumentItems(): List<SecondaryButtonItem> = listOf(Manual, Installation, Safety, Policy)
    }
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
