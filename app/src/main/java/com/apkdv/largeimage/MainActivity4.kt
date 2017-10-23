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
//        val imageUriProvider = ImageUriProvider.getInstance(this)
//        val uriSuccess = imageUriProvider.createSampleUri(
//                ImageUriProvider.ImageSize.XL,
//                ImageUriProvider.UriModification.CACHE_BREAKER)
//        val uriFailure = imageUriProvider.createNonExistingUri()
//
//        val draweeView = view.findViewById(R.id.drawee)
//        val retrySwitch = view.findViewById(R.id.retry_enabled)
//
//        //noinspection deprecation
//        val failureDrawable = resources.getDrawable(R.drawable.ic_error_black_96dp)
//        DrawableCompat.setTint(failureDrawable, Color.RED)
//
//        val progressBarDrawable = ProgressBarDrawable()
//        progressBarDrawable.color = resources.getColor(R.color.accent)
//        progressBarDrawable.backgroundColor = resources.getColor(R.color.primary)
//        progressBarDrawable.radius = resources.getDimensionPixelSize(R.dimen.drawee_hierarchy_progress_radius)

//        draweeView.getHierarchy().setProgressBarImage(progressBarDrawable)
//        draweeView.getHierarchy().setFailureImage(failureDrawable, ImageView.ScaleType.CENTER_INSIDE)

    }
}
