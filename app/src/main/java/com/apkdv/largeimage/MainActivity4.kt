package com.apkdv.largeimage


import android.os.Bundle

import com.chenenyu.router.annotation.Route
import kotlinx.android.synthetic.main.activity_main4.*


@Route("main4")
class MainActivity4 : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main4;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rollpagerview.setAdapter(TestNomalAdapter2())


    }
}
