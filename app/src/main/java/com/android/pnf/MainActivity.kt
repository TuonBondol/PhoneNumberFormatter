package com.android.pnf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phonenumberformatter.formattingPhoneNumberAndRemoveZero

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newPhone = "".formattingPhoneNumberAndRemoveZero("0122342310")

        println("MainActivity Format Number 0$newPhone")
    }
}
