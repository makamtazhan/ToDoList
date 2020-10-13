package com.example.todolistapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainFragment(val list: ArrayList<Task>, val listener: TaskListAdapter.ItemClickListener) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskListAdapter: TaskListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        taskListAdapter = TaskListAdapter(list, context!!, listener)
        val rootView = inflater.inflate(R.layout.main_fragment, container, false) as ViewGroup
        recyclerView = rootView.findViewById(R.id.recyclerview)
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = taskListAdapter
        return rootView
    }

}