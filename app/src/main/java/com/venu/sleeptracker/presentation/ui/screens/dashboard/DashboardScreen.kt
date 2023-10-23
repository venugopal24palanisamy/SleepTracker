package com.venu.sleeptracker.presentation.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.venu.sleeptracker.R
import com.venu.sleeptracker.domain.model.SleepTrend
import com.venu.sleeptracker.presentation.ui.components.BarGraph
import com.venu.sleeptracker.presentation.ui.components.SleepTrendCard
import com.venu.sleeptracker.utils.BarType

@Composable
fun DashboardScreen(
    paddingValues: PaddingValues = PaddingValues(),
    navController: NavHostController
) {

    val contentHeight = 280.dp
    val scrollState = rememberLazyListState()
    val offsetY = scrollState.offsetY(contentHeight)
    val alpha = 1f - offsetY.value / contentHeight.value

    val imageScale = if (alpha <= 0.5) {
        1f
    } else {
        alpha + 0.5f
    }
    val trends = remember { generateSleepTrendsData() }
    LazyColumn(
        state = scrollState,
        contentPadding = PaddingValues(bottom = paddingValues.calculateBottomPadding())
    ) {
        item {
            Box(
                modifier = Modifier
                    .height(contentHeight)
                    .background(color = Color.Black)
                    .alpha(alpha),
                contentAlignment = Alignment.BottomStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_bg),
                    contentDescription = "", modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .scale(imageScale)
                )

            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 15.dp,
                        start = 15.dp,
                        end = 15.dp
                    )
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Activity",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                // Spacer(modifier = Modifier.height(10.dp))
            }

        }
        items(trends.size) {
            SleepTrendCard(trends[it])
        }
        item {
            Spacer(modifier = Modifier.height(45.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(35.dp),
            ) {

                val dataList = mutableListOf(30, 60, 90, 150, 70, 44, 66)
                val floatValue = mutableListOf<Float>()
                val datesList = mutableListOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

                dataList.forEachIndexed { index, value ->
                    floatValue.add(
                        index = index,
                        element = value.toFloat() / dataList.max().toFloat()
                    )
                }

                BarGraph(
                    graphBarData = floatValue,
                    xAxisScaleData = datesList,
                    barData_ = dataList,
                    height = 200.dp,
                    roundType = BarType.TOP_CURVED,
                    barWidth = 20.dp,
                    barColor = Color.Black,
                    barArrangement = Arrangement.SpaceEvenly
                )
            }
        }
    }


}

fun generateSleepTrendsData(): List<SleepTrend> {
    return listOf(
        SleepTrend("Total Sleep Time", "7 hours 30 minutes", R.drawable.ic_clock),
        SleepTrend("Average Sleep Quality", "85%", R.drawable.ic_star),
        SleepTrend("Average Sleep Quality", "85%", R.drawable.ic_star),
    )
}

@Composable
fun LazyListState.offsetY(contentHeight: Dp): Dp {
    return if (firstVisibleItemIndex != 0) {
        contentHeight
    } else with(LocalDensity.current) { firstVisibleItemScrollOffset.toDp() }
}