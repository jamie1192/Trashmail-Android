package com.jamie1192.TrashmailAndroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.divider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        createDrawer()

    }

    private fun createDrawer() {

        drawer{

            primaryItem("Home") {}
            divider {}
            primaryItem("Users") {}
            secondaryItem("Settings") {}

        }
    }
}
