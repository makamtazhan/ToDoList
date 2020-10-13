package com.example.todolistapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class DetailFragment(val task: Task, val listener: BackBottomListener) : Fragment() {
    private lateinit var image: ImageView
    private lateinit var back: ImageView
    private lateinit var title: TextView
    private lateinit var status: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false) as ViewGroup
        image = rootView.findViewById(R.id.image)
        back = rootView.findViewById(R.id.back)
        title = rootView.findViewById(R.id.title)
        status = rootView.findViewById(R.id.status)
        back.setOnClickListener {
            listener.returnBack()
        }

        Glide.with(context!!).load(task.image).into(image)
        title.text = task.title
        status.text = task.status
        return rootView
    }

    interface BackBottomListener{
        fun returnBack()
    }
}