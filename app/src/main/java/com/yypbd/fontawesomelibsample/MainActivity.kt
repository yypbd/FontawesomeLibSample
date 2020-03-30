package com.yypbd.fontawesomelibsample

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yypbd.fontawesomelib.FontawesomeLib
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FontawesomeLib.getInstance().init(
            assets,
            "fonts/fa-solid-900.ttf",
            "fonts/fa-regular-400.ttf",
            "fonts/fa-brands-400.ttf"
        )

        initUI()
        initListener()
    }

    private fun initListener() {
        buttonShowSolid.setOnClickListener(View.OnClickListener {
            val intent = Intent(baseContext, IconListActivity::class.java)
            intent.putExtra("font_type", 0)
            startActivity(intent)
        })
        buttonShowRegular.setOnClickListener(View.OnClickListener {
            val intent = Intent(baseContext, IconListActivity::class.java)
            intent.putExtra("font_type", 1)
            startActivity(intent)
        })
        buttonShowBrand.setOnClickListener(View.OnClickListener {
            val intent = Intent(baseContext, IconListActivity::class.java)
            intent.putExtra("font_type", 2)
            startActivity(intent)
        })
        buttonTest.setOnClickListener(View.OnClickListener {
            val text = FontawesomeLib.getInstance()
                .getText(FontawesomeLib.FontType.TYPE_SOLID, "adjust")
            Log.d("tag", text)
            FontawesomeLib.getInstance()
                .setIcon(FontawesomeLib.FontType.TYPE_SOLID, "adjust", buttonTest)
            FontawesomeLib.getInstance()
                .setIcon(FontawesomeLib.FontType.TYPE_SOLID, "atlas", textViewTest)

            // https://github.com/devunwired/textdrawable
            val textDrawable = TextDrawable(baseContext)
            textDrawable.textSize = 50f
            val tf =
                FontawesomeLib.getInstance().getTypeface(FontawesomeLib.FontType.TYPE_SOLID)
            textDrawable.typeface = tf
            textDrawable.text = FontawesomeLib.getInstance()
                .getText(FontawesomeLib.FontType.TYPE_SOLID, "asterisk")
            textDrawable.setTextColor(Color.RED)
            imageViewTest.background = textDrawable
        })
    }

    private fun initUI() {
    }
}
