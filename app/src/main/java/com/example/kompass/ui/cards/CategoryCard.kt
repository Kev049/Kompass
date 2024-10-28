import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kompass.KompassScreen
import com.example.kompass.types.Category
import com.example.kompass.types.CategoryData
import com.example.kompass.ui.getStringAfterDelimiter
import com.example.kompass.ui.theme.IkeaBlue
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CategoryCard(
    categoryData: CategoryData,
    modifier: Modifier = Modifier,
    screenWidth: Int,
    screenHeight: Int,
    onNavigate: (KompassScreen, Category) -> Unit,
    screen: KompassScreen,
    openProductList: Boolean = false,
    isHighlighted: Boolean
) {
    //val paddingBetweenCards = 8
    val cardWidth = (screenWidth / 2 - 10)
    val cardHeight = (screenHeight * 0.14)

    Box(
        modifier = modifier
            .width(cardWidth.dp)
            .height(cardHeight.dp)
            .background(
                if (isHighlighted) Color.Yellow else IkeaBlue,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                if (!openProductList) {
                    onNavigate(screen, categoryData.category)
                } else {
                    onNavigate(KompassScreen.ProductList, categoryData.category)
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image
            Image(
                painter = painterResource(id = categoryData.imageResId),
                contentDescription = categoryData.description,
                modifier = Modifier
                    .padding(4.dp)
                    .width((cardWidth * 0.3).dp)
                    .height((cardHeight * 0.6).dp),
                contentScale = ContentScale.Fit
            )
            // Text
            var cardText = categoryData.category.toDisplayName()

            // Change name if its a subcategory
            cardText = getStringAfterDelimiter(cardText)
            val formattedText = cardText.replace(" & ", "_&\n")
            val moreFormattedText = formattedText.replace(" ", "\n")
            val eMoreFormattedText = moreFormattedText.replace("_", " ")

            Text(
                text = eMoreFormattedText,
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                //maxLines = 2,  // Restrict to one line
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(2.dp)
                    .width((cardWidth - 4).dp)
                    .height(cardHeight.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }
    }
}
