package com.rechar.campusassistant.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.adapter.PaintingsAdapter;
import com.rechar.campusassistant.model.Painting;
import com.rechar.campusassistant.util.GlideHelper;

/**
 * @author Bamboo
 * @package:com.rechar.campusassistant.ui
 * @fileName:ActivitysFragment
 * @date on:2020/1/21 16:46
 */
public class ActivitysFragment extends Fragment {
  public static final String TAG = "ActivitysFragment";
  @SuppressLint("StaticFieldLeak")
  private static View listTouchInterceptor;
  @SuppressLint("StaticFieldLeak")
  private static View detailsLayout;
  @SuppressLint("StaticFieldLeak")
  private static UnfoldableView unfoldableView;
  @SuppressLint("StaticFieldLeak")
  private static Activity aActivity;
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activitys_fragment, container, false);
    Log.e(TAG, "onCreateView: ");
    ListView listView = view.findViewById(R.id.list_view);
    PaintingsAdapter paintingsAdapter = new PaintingsAdapter(aActivity);

    listView.setAdapter(paintingsAdapter);
    listTouchInterceptor = view.findViewById(R.id.touch_interceptor_view);
    listTouchInterceptor.setClickable(false);
    detailsLayout = view.findViewById(R.id.details_layout);
    detailsLayout.setVisibility(View.INVISIBLE);
    FloatingActionButton fab = view.findViewById(R.id.fab_activity_add);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=41657772")));
      }
    });
    Log.e(TAG, "onCreateView: " + detailsLayout);
    unfoldableView = view.findViewById(R.id.unfoldable_view);
      Bitmap glance = BitmapFactory.decodeResource(getResources(), R.drawable.unfold_glance);
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

  }


}