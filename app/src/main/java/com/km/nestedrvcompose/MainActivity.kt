package com.km.nestedrvcompose

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.km.nestedrvcompose.adapter.ChildAdapter
import com.km.nestedrvcompose.adapter.ItemView
import com.km.nestedrvcompose.adapter.ParentAdapter
import com.km.nestedrvcompose.adapter.TitleList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.padding(16.dp)) {
                    Button(onClick = { startActivity(ComposeActivity::class.java) }) {
                        Text("Composable")
                    }

                    Button(
                        onClick = { startActivity(HorizontalScrollActivity::class.java) },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Horizontal Scroller")
                    }

                    Button(
                        onClick = { startActivity(VerticalScrollActivity::class.java) },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Vertical Scroller")
                    }

                    Button(
                        onClick = { startActivity(NestedScrollActivity::class.java) },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Nested Scroller")
                    }

                    Button(
                        onClick = { startActivity(VerticalScrollViewActivity::class.java) },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Vertical Scroll view")
                    }

                    Button(
                        onClick = { startActivity(HorizontalScrollActivity::class.java) },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Horizontal Scroll view")
                    }
                }
            }
        }
    }

    private fun startActivity(klass: Class<out AppCompatActivity>) {
        startActivity(Intent(this, klass))
    }
}

class ComposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenContent("Simple composable")
        }

    }
}

class VerticalScrollActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ChildAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}

class HorizontalScrollActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ChildAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }
}

class NestedScrollActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ParentAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}

class VerticalScrollViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_scroll_view)

        val listContainer= findViewById<LinearLayout>(R.id.list_container)
        for (title in TitleList) {
            val itemView = ItemView(this)
            itemView.title = title
            listContainer.addView(itemView)
        }
    }
}

class HorizontalScrollViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_scroll_view)

        val listContainer= findViewById<LinearLayout>(R.id.list_container)
        for (title in TitleList) {
            val itemView = ItemView(this)
            itemView.title = title
            listContainer.addView(itemView)
        }
    }
}

