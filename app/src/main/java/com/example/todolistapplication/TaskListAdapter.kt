package com.example.todolistapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*
import java.util.*
import kotlin.collections.ArrayList

class TaskListAdapter(
    val list: ArrayList<Task>,
    val context: Context,
    var listener: ItemClickListener
) :
    RecyclerView.Adapter<TaskListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = list.get(position)
        holder.bind(task)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(private val view: View, context: Context) : RecyclerView.ViewHolder(view) {
        private val mRandom = Random()

        fun bind(task: Task){
            val title: TextView = view.findViewById(R.id.title)
            val status: TextView = view.findViewById(R.id.status)
            val image: ImageView = view.findViewById(R.id.image)
            title.text = task.title
            status.text = task.status
            Glide.with(context).load(task.image).into(image)
            view.image.layoutParams.height = getRandomIntInRange(250, 150)

            view.setOnClickListener {
                listener.itemClicked(task)
            }
        }

        private fun getRandomIntInRange(max: Int, min: Int): Int {
            return mRandom.nextInt(max - min + min) + min
        }

    }

    interface ItemClickListener{
        fun itemClicked(item: Task)
    }
}