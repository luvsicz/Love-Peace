package com.rechar.campusassistant.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.alexvasilkov.android.commons.texts.SpannableBuilder;
import com.alexvasilkov.android.commons.ui.Views;
import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.alexvasilkov.foldablelayout.shading.GlanceFoldShading;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.adapter.PaintingsAdapter;
import com.rechar.campusassistant.model.Painting;
import com.rechar.campusassistant.util.GlideHelper;
import com.rechar.campusassistant.util.HttpImageGetter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Bamboo
 * @package:com.rechar.campusassistant.ui
 * @fileName:ActivitysFragment
 * @date on:2020/1/21 16:46
 */
public class ActivitysFragment extends Fragment {

  public static final String TAG = "ActivitysFragment";
  private static View listTouchInterceptor;
  private static View detailsLayout;
  private static UnfoldableView unfoldableView;
  private static Activity aActivity;
  private static PaintingsAdapter paintingsAdapter;
  private ListView listView;
  private Bitmap glance;
  public String CREATE_ACCOUNT_URL = "https://" + ip + "/WantedServlet";
  private static String ip = "liurechar.utools.club";
  private static ObjectMapper mapper = new ObjectMapper();
  ImageView imageView;
  private  List<Painting> paintingList;
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activitys_fragment, container, false);
    Log.e(TAG, "onCreateView: ");
    listView = view.findViewById(R.id.list_view);
    paintingsAdapter = new PaintingsAdapter(aActivity,paintingList);
    listView.setAdapter(paintingsAdapter);
    imageView=view.findViewById(R.id.details_image);
    listTouchInterceptor = view.findViewById(R.id.touch_interceptor_view);
    listTouchInterceptor.setClickable(false);
    detailsLayout = view.findViewById(R.id.details_layout);
    detailsLayout.setVisibility(View.INVISIBLE);

    Log.e(TAG, "onCreateView: " + detailsLayout);
    unfoldableView = view.findViewById(R.id.unfoldable_view);

    glance = BitmapFactory.decodeResource(getResources(), R.drawable.unfold_glance);
    unfoldableView.setFoldShading(new GlanceFoldShading(glance));
    unfoldableView.setOnFoldingListener(new UnfoldableView.SimpleFoldingListener() {
      @Override
      public void onUnfolding(UnfoldableView unfoldableView) {
        listTouchInterceptor.setClickable(true);
        detailsLayout.setVisibility(View.VISIBLE);
      }

      @Override
      public void onUnfolded(UnfoldableView unfoldableView) {
        listTouchInterceptor.setClickable(false);
      }

      @Override
      public void onFoldingBack(UnfoldableView unfoldableView) {
        listTouchInterceptor.setClickable(true);
      }

      @Override
      public void onFoldedBack(UnfoldableView unfoldableView) {
        listTouchInterceptor.setClickable(false);
        detailsLayout.setVisibility(View.INVISIBLE);
      }
    });
    return view;
  }

  public void openDetails(View coverView, Painting painting) {
    Log.e(TAG, "openDetails:detailsLayout: " + detailsLayout + " details_image: " + R.id.details_image);
    final ImageView image = Views.find(detailsLayout, R.id.details_image);
    Log.e(TAG, "openDetails: -----");
    final TextView title = Views.find(detailsLayout, R.id.details_title);
    final TextView description = Views.find(detailsLayout, R.id.details_text);

    Log.e(TAG, "openDetails: 2");
    GlideHelper.loadPaintingImage(image, painting);
    title.setText(painting.getTitle());
    SpannableBuilder builder = new SpannableBuilder(aActivity);
    builder.createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
          .clearStyle()
          .append(painting.getContent()).append("\n");
        description.setText(builder.build());
       unfoldableView.unfold(coverView, detailsLayout);
       Log.e(TAG, "openDetails: 3");
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    aActivity = (Activity) context;
  }


  @Override
  public void onStart() {
    super.onStart();
    Log.e(TAG, "onStart: ");
    pint.start();
  }

  private Thread pint = new Thread(new Runnable() {
    @Override
    public void run() {
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(CREATE_ACCOUNT_URL).build();
      Log.e(TAG, "onCreateView: 2");
      try {
        Log.e(TAG, "onCreateView: 1");
        Response response = client.newCall(request).execute();
        Log.e(TAG, "onCreateView: 3");
        if (response.isSuccessful()) {
          Log.e(TAG, "onCreateView: 4");
          String str = null;
          if (response.body() != null) {
            str = response.body().string();
            Log.e(TAG, "onCreateView:----  " + str);
          }
          Gson gson = new Gson();

          List<Painting> paintingLists = gson.fromJson(str, new TypeToken<List<Painting>>() {}.getType());
          Log.e(TAG, "run: -------------" );
          paintingList=paintingLists;


         /* for (Painting painting : paintingList) {
            String url=painting.getUrl();
            Log.e(TAG, "run: " + gson.toJson(painting));
            Drawable img=HttpImageGetter.getDrawable(url);
            showResponse(img);
          }*/
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  });

  private void showResponse(final Drawable response) {
    getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        // 在这里进行UI操作，将结果显示到界面上
        imageView.setImageDrawable(response);
      }
    });
  }


}