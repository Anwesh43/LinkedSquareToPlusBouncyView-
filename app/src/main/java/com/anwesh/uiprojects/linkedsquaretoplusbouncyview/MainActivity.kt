package com.anwesh.uiprojects.linkedsquaretoplusbouncyview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.squaretoplusbouncyview.SquareToPlusBouncyView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SquareToPlusBouncyView.create(this)
    }
}
