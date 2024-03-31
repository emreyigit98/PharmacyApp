package com.emreyigit98.pharmacyapp.presentation.component.drawer_menu


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emreyigit98.pharmacyapp.R
import com.emreyigit98.pharmacyapp.util.DrawerMenuItem
import com.emreyigit98.pharmacyapp.util.ScreenListItem

@Composable
fun PharmacyDrawerMenu(
    screenList: List<DrawerMenuItem>,
    modifier: Modifier = Modifier,
    selectNextScreen: (String) -> Unit
) {

    ModalDrawerSheet(
        modifier = modifier.fillMaxWidth(0.79f),
        drawerContainerColor = colorResource(id = R.color.special_black_olive),
        drawerShape = RoundedCornerShape(0.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.07f),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = stringResource(id = R.string.drawer_menu_name),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.white)
                ),
                modifier = modifier.padding(start = 15.dp)
            )
        }
        Divider(
            color = colorResource(id = R.color.white)
        )
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 15.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(screenList) {index, item ->
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = modifier.size(26.dp),
                            tint = colorResource(id = R.color.white)
                        )
                    },
                    label = {
                        Text(
                            text = item.screenName,
                            color = colorResource(id = R.color.white)
                        )
                    },
                    selected = false,
                    onClick = {
                        selectNextScreen(item.route)
                    },
                    modifier = modifier.padding(horizontal = 15.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        unselectedContainerColor = colorResource(id = R.color.special_black_one)
                    )
                )
            }
        }
    }
}
