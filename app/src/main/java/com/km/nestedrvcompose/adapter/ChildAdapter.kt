package com.km.nestedrvcompose.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.AbstractComposeView
import androidx.recyclerview.widget.RecyclerView
import com.km.nestedrvcompose.ScreenContent

val TitleList = listOf(
    "late", "soul", "execution", "conference", "translate",
    "paint", "adoption", "intervention", "acquisition",
    "economic", "monkey", "variation", "dinner", "flower",
    "guest", "point", "brush", "march", "precede", "scandal",
)

class ChildAdapter : RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return TitleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder.itemView as ItemView).title = TitleList[position]
    }
}


class ItemView(context: Context, attrs: AttributeSet? = null) : AbstractComposeView(context) {

    var title by mutableStateOf("")

    @Composable
    override fun Content() {
        MaterialTheme {
            ScreenContent(title)
        }
    }
}