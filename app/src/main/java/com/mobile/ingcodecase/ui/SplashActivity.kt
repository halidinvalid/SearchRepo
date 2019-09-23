package com.mobile.ingcodecase.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobile.ingcodecase.show.accounts.presentation.SearchRepoActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, SearchRepoActivity::class.java))
        finish()
    }
}