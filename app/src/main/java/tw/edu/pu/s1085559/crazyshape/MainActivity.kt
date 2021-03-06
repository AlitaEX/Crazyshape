package tw.edu.pu.s1085559.crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*



@GlideModule
public final class MyAppGlideModule : AppGlideModule()




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgNext.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                var X: Int = (1..4).random()
                when (X){
                    1 -> imgNext.setImageResource(R.drawable.circle)
                    2 -> imgNext.setImageResource(R.drawable.square)
                    3 -> imgNext.setImageResource(R.drawable.star)
                    4 -> imgNext.setImageResource(R.drawable.triangle)
                }
            }
        })

        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
            .load(R.drawable.cover)
            .override(800, 600)
            .into(imgTitle)

        Toast.makeText(baseContext, "作者：黃景明", Toast.LENGTH_LONG).show()

        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)
                return true
            }
        })

    }
}