package com.rumosoft.modulatedlayers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.rumosoft.presentation.TestFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigate()
    }

    private fun navigate() {
        val fragment = TestFragment.newInstance()
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, fragment)
        }
    }
}
