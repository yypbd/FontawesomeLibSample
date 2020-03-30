package com.yypbd.fontawesomelibsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.yypbd.fontawesomelib.FontawesomeLib
import com.yypbd.fontawesomelib.FontawesomeLib.FontType
import kotlinx.android.synthetic.main.activity_icon_list.*

class IconListActivity : AppCompatActivity() {
    private lateinit var mAdapter: IconAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon_list)
        val iconList = ArrayList<IconItem>()
        val intent = intent
        val type = intent.getIntExtra("font_type", 0)
        val fontType: FontType
        fontType = when (type) {
            0 -> {
                FontType.TYPE_SOLID
            }
            1 -> {
                FontType.TYPE_REGULAR
            }
            else -> {
                FontType.TYPE_BRAND
            }
        }
        for (key in FontawesomeLib.getInstance().getCharMap(fontType).keys) {
            iconList.add(IconItem(key!!))
        }
        layoutManager = LinearLayoutManager(this)
        recyclerViewIcon.layoutManager = layoutManager
        mAdapter = IconAdapter(fontType, iconList)
        recyclerViewIcon.setAdapter(mAdapter)
    }
}