package com.sharedelementsfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToB(view: View) {
            supportFragmentManager.beginTransaction()
                .addSharedElement(view, "view_transition")
                .replace(findViewById<ViewGroup>(R.id.preorder_content).id, FragmentB())
                .addToBackStack("")
                .commit()
    }

    fun goToC(view: View) {
        supportFragmentManager.beginTransaction()
            .addSharedElement(view, "view_transition")
            .replace(findViewById<ViewGroup>(R.id.preorder_content).id, FragmentC())
            .addToBackStack("")
            .commit()
    }

}