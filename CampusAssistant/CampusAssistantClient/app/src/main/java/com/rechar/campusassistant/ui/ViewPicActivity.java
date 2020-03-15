package com.rechar.campusassistant.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;

import com.rechar.campusassistant.R;
import com.rechar.campusassistant.app.AppContext;
import com.rechar.campusassistant.app.VolleyManager;
import com.rechar.campusassistant.base.BaseActivity;
import com.rechar.campusassistant.http.BitmapCache;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_view_pic)
public class ViewPicActivity extends BaseActivity {
    @ViewInject(R.id.big_img)
    private ImageView big_img;
    @ViewInject(R.id.btn_save)
    private TextView btn_save;
    @ViewInject(R.id.big_networkimg)
    private NetworkImageView big_networkimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String img = getIntent().getStringExtra("img");
        String picUrl = AppContext.URL_SUPPRESS_PIC+img;
        //使用ImageRequest加载图片
//        requestImage(picUrl);
        //使用ImageLoader加载图片
//        loadImage(picUrl);
        //使用NetworkImageView加载图片
        netLoad(picUrl);
    }


    public void requestImage(String picUrl){
        ImageRequest imageRequest = new ImageRequest(picUrl,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        big_img.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                big_img.setImageResource(R.mipmap.base_list_default_icon);
            }
        });
        VolleyManager.createInstance(this).getRequestQueue().add(imageRequest);
    }

    public void loadImage(String picUr){
        ImageLoader imageLoader = new ImageLoader(VolleyManager.createInstance(this).getRequestQueue(),new BitmapCache());

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(big_img,
                R.mipmap.base_list_default_icon, R.mipmap.base_list_default_icon);

        imageLoader.get(picUr, listener);
    }

    public void netLoad(String picUr){
        ImageLoader imageLoader = new ImageLoader(VolleyManager.createInstance(this).getRequestQueue(),new BitmapCache());
        big_networkimg.setDefaultImageResId(R.mipmap.base_list_default_icon);
        big_networkimg.setErrorImageResId(R.mipmap.base_list_default_icon);
        big_networkimg.setImageUrl(picUr,imageLoader);
    }
}
