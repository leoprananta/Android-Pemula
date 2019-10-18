package com.example.pemula

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pemula.R.layout.item_list
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.startActivity

class RecyclerViewAdapter (private val context: Context, private val items: List<Item>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(item_list, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
            LayoutContainer{

        private var name : TextView = itemView.findViewById(R.id.item_list_name)
        private var logo : ImageView = itemView.findViewById(R.id.item_list_logo)
        private var btn  : Button = itemView.findViewById(R.id.button_details)

        fun bindItem(items: Item){
            name.text = items.name
            Glide.with(itemView.context).load(items.logo).into(logo)
            btn.setOnClickListener {
                containerView.context.startActivity<DescActivity>("data" to items )
            }
        }
    }
}