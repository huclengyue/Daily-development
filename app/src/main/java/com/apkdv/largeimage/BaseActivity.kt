package com.apkdv.largeimage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chenenyu.router.Router
import kotlinx.android.synthetic.main.base_activity.*

/**
 * Created by LengYue on 2017/10/20.
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)

        btn_jump.setOnClickListener { Router.build(edit.text.toString()).go(this) }
        if (getLayoutId() != 0){
            val view = layoutInflater.inflate(getLayoutId(), rootView, false)
            rootView.addView(view,0)
        }

    }

    abstract fun getLayoutId():Int
}