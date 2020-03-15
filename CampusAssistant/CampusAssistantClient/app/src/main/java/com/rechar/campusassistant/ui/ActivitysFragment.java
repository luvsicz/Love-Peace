package com.rechar.campusassistant.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
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
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.adapter.PaintingsAdapter;
import com.rechar.campusassistant.bean.Painting;
import com.rechar.campusassistant.util.GlideHelper;

/**
 * @author Bamboo
 * @package:com.rechar.campusassistant.ui
 * @fileName:ActivitysFragment
 * @date on:2020/1/21 16:46
 */
public class ActivitysFragment extends Fragment {
    private static View listTouchInterceptor;
    private static View detailsLayout;
    private static UnfoldableView unfoldableView;
    private static Activity aActivity;
    private static PaintingsAdapter paintingsAdapter;
public static  final String TAG="ActivitysFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activitys_fragment,container,false);
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.e(TAG, "onCreateView: " );
        ListView listView =view.findViewById( R.id.list_view);
        paintingsAdapter= new PaintingsAdapter(aActivity);
        listView.setAdapter(paintingsAdapter);

        listTouchInterceptor =view.findViewById( R.id.touch_interceptor_view);
        listTouchInterceptor.setClickable(false);

        detailsLayout =view.findViewById( R.id.details_layout);
        detailsLayout.setVisibility(View.INVISIBLE);
        Log.e(TAG, "onCreateView: "+detailsLayout );
        unfoldableView =view.findViewById(R.id.unfoldable_view);

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
        Log.e(TAG, "openDetails:detailsLayout: "+detailsLayout +" details_image: "+R.id.details_image);
        final ImageView image =  Views.find(detailsLayout, R.id.details_image);
        Log.e(TAG, "openDetails: -----" );
       final TextView title =Views.find(detailsLayout, R.id.details_title);

     final TextView description = Views.find(detailsLayout, R.id.details_text);
        Log.e(TAG, "openDetails: 2" );
        GlideHelper.loadPaintingImage(image, painting);
      title.setText(painting.getTitle());
      SpannableBuilder builder = new SpannableBuilder(aActivity);
        builder
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append(R.string.year).append(": ")
                .clearStyle()
                .append(painting.getYear()).append("\n")
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append(R.string.location).append(": ")
                .clearStyle()
                .append(painting.getLocation());
      description.setText(builder.build());

        unfoldableView.unfold(coverView, detailsLayout);
        Log.e(TAG, "openDetails: 3" );
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.aActivity= (Activity) context;
    }
}