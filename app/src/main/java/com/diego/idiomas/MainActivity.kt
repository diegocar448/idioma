package com.diego.idiomas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diego.idiomas.ui.theme.Blue900
import com.diego.idiomas.ui.theme.White


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(){

    var expandedMenu by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Blue900
                ),
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.Menu,
                        contentDescription = "Icon Menu",
                        tint = White,
                        modifier = Modifier.clickable {
                            expandedMenu = true
                        }
                    )
                    //Menu do Drawable
                    Column(
                        modifier = Modifier
                    ){
                        DropdownMenu(
                            expanded = expandedMenu,
                            onDismissRequest = {
                                //propriedade bool para menu aparecer ou não
                                expandedMenu = false
                            },
                            modifier = Modifier.width(200.dp).background(White)
                        )
                        {
                            //Aqui adicionamos todos os nosso items
                            DropdownMenuItem(
                                text = {
                                    Text(text = "Protuguês")
                                },
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(R.drawable.brasil),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                onClick = {

                                }
                            )
                        }
                    }
                }
            )
        }

    ){ paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().background(White)
        ){

        }
    }
}

@Preview
@Composable
private fun HomePreview(){
    Home();
}


