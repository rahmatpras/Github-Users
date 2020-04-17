package com.rahmatprastyo.githubusers.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahmatprastyo.githubusers.R
import com.rahmatprastyo.githubusers.model.Result
import com.squareup.picasso.Picasso

class MainAdapter(private val results: List<Result>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: Result) {
            with(itemView) {
                val name = findViewById<TextView>(R.id.tv_author_name)
                name.text = result.login

                val imageAuthor = findViewById<ImageView>(R.id.iv_author_image)
                Picasso.get().load(result.avatarUrl).into(imageAuthor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_github_user, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return results.count()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(results[holder.adapterPosition])
    }

}