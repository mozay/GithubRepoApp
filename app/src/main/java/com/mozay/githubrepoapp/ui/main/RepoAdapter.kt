package com.mozay.githubrepoapp.ui.main

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mozay.githubrepoapp.R
import com.mozay.githubrepoapp.models.Repo
import com.mozay.githubrepoapp.models.RepoOwner

class RepoAdapter(private val context: Context,
                  private val list: MutableList<Repo>,
                  activity: Activity
): RecyclerView.Adapter<RepoAdapter.ListViewHolder>() {

    private val listener: RepoAdapter.onItemClickListener

    init {
        this.listener = activity as RepoAdapter.onItemClickListener
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var post = list[position]

        //binding
        holder!!.name!!.setText(post.name)
        holder!!.description!!.setText(post.description)
        holder!!.language!!.setText(post.language)

        holder.layout!!.setOnClickListener {
            listener.itemDetail(post.owner!!, post)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_repo_item, parent, false)
        return RepoAdapter.ListViewHolder(itemView)
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val layout = itemView.findViewById<CardView>(R.id.itemRepo)
        val name = itemView.findViewById<TextView>(R.id.txtRepoName)
        val description = itemView.findViewById<TextView>(R.id.txtRepoDesc)
        val language = itemView.findViewById<TextView>(R.id.txtItemLanguage)
    }

    interface onItemClickListener {
        fun itemDetail(ownerInfo : RepoOwner, repo: Repo)
    }
}