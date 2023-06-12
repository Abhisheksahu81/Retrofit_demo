package com.example.ashutosh

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ashutosh.API.APIUtility
import com.example.ashutosh.API.RetrofitInstance
import com.example.ashutosh.Model.Post
import com.example.ashutosh.ui.theme.AshutoshTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    private lateinit var tv : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        tv = findViewById(R.id.textView)

        val apiUtility = RetrofitInstance.getInstance().create(APIUtility::class.java)


        CoroutineScope(Dispatchers.IO).launch {
            val posts = apiUtility.getAllPhotos()
            Log.d("Hello" , posts.toString())
            val post : Post = posts.get(0)
            tv.setText(post.body)

        }



    }
}
