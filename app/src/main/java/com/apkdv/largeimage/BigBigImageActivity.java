package com.apkdv.largeimage;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.apkdv.imageloader.IMloader;
import com.apkdv.imageloader.LargePhotoView;
import com.apkdv.largeimage.rollviewpager.DvViewUtil;
import com.chenenyu.router.annotation.Route;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.facebook.drawee.gestures.GestureDetector;


/**
 * 用于演示加载超大图（长图）
 *
 * Created by android_ls on 17/05/15.
 */
@Route("big")
public class BigBigImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_big_big);

        final SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) findViewById(R.id.image);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
        imageView.setMinScale(1.0f);
        imageView.setMaxScale(2.0f);
        // 禁用缩放功能
//        imageView.setZoomEnabled(false);
//
//        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
//            @Override
//            public boolean onSingleTapConfirmed(MotionEvent e) {
//                if (imageView.isReady()) {
//                    PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
//                    MLog.i("单击: " + ((int) sCoord.x) + ", " + ((int) sCoord.y));
//                } else {
//                    MLog.i("onSingleTapConfirmed onError");
//                }
//
//                return false;
//            }
//
//            @Override
//            public void onLongPress(MotionEvent e) {
//                if (imageView.isReady()) {
//                    PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
//                    MLog.i("长按: " + ((int) sCoord.x) + ", " + ((int) sCoord.y));
//                } else {
//                    MLog.i("onLongPress onError");
//                }
//            }
//
//            @Override
//            public boolean onDoubleTap(MotionEvent e) {
//                if (imageView.isReady()) {
//                    PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
//                    MLog.i("双击: " + ((int) sCoord.x) + ", " + ((int) sCoord.y));
//                } else {
//                    MLog.i("onDoubleTap onError");
//                }
//                return false;
//            }
//        });
//
//        imageView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return gestureDetector.onTouchEvent(motionEvent);
//            }
//        });

        // 加载网络的
//        String fileCacheDir = getCacheDir().getAbsolutePath();

//        String url = "http://img5q.duitang.com/uploads/item/201402/24/20140224212510_eQRG5.thumb.700_0.jpeg";
        String testUrl = "https://user-gold-cdn.xitu.io/2017/5/25/74c8d908757f15357d26d1cd627f363e?imageView2/1/w/800/h/600/q/85/format/jpg/interlace/1";
//        String url = "http://img5q.duitang.com/uploads/item/201402/24/20140224212510_eQRG5.thumb.700_0.jpeg";

//        Phoenix.with(imageView)
//                .setDiskCacheDir(fileCacheDir)
//                .load(url);

        // 不指定缓存目录



//        IMloader.with(SubsamplingScaleImageView).setWidth(DvViewUtil.getScreenWidth()).load(testUrl);

        // 加载本地的
//        imageView.setImage(ImageSource.asset("qmsht.jpg"));
//        imageView.setImage(ImageSource.resource(R.drawable.monkey));
//        imageView.setImage(ImageSource.uri("/storage/emulated/0/fresco-helper/Download/Images/20140224212510_eQRG5.thumb.700_0.jpeg"));
//        imageView.setImage(ImageSource.bitmap(bitmap));

    }

}
