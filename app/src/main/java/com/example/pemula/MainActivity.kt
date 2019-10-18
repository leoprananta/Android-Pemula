package com.example.pemula

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.pemula.R.array.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()
    private var menuItem: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        main_recycler_view.layoutManager = LinearLayoutManager(this)
        main_recycler_view.adapter = RecyclerViewAdapter(this, items)
    }

    private fun initData(){
        val name = resources.getStringArray(item_name)
        val logo = resources.getStringArray(item_logo)
        val basecamp = resources.getStringArray(item_basecamp)
        val coach = resources.getStringArray(item_coach)
        val captain = resources.getStringArray(item_captain)
        val sponsor = resources.getStringArray(item_sponsor)
        val desc = resources.getStringArray(item_desc)

        items.clear()

        for(i in name.indices){
            items.add(Item(name[i],
                logo[i],
                basecamp[i],
                coach[i],
                captain[i],
                sponsor[i],
                desc[i]))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option, menu)

        menuItem = menu

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            R.id.about -> {
                startActivity<AboutActivity>()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
