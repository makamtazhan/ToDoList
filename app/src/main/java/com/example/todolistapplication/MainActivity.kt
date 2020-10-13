package com.example.todolistapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), TaskListAdapter.ItemClickListener,
    DetailFragment.BackBottomListener {
    private lateinit var mainFragment: MainFragment
    private lateinit var detailFragment: DetailFragment
    private lateinit var fragmentManager: FragmentManager
    private var list = ArrayList<Task>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 1..20) {
            list.add(Task(i, "Title$i", "incomplete", R.drawable.image))
        }
        mainFragment = MainFragment(list, this)
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragment, mainFragment).commit()
    }

    override fun itemClicked(item: Task) {
        detailFragment = DetailFragment(item, this)
        fragmentManager.beginTransaction().replace(R.id.fragment, detailFragment).commit()
    }

    override fun returnBack() {
        fragmentManager.beginTransaction().replace(R.id.fragment, mainFragment).commit()
    }

}