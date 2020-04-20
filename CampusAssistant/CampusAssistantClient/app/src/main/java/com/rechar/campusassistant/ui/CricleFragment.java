package com.rechar.campusassistant.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.adapter.CircleAdapter;
import com.rechar.campusassistant.model.CircleFriends;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * @author Bamboo
 * @package:com.rechar.campusassistant.ui+
 * @fileName:GuideFragment
 * @date on:2020/1/15 18:15
 */
public class CricleFragment extends Fragment {

  private static final String TAG = "CricleFragment";
  private ListView listView;
  private ArrayList<CircleFriends> friendsList = new ArrayList<CircleFriends>();
  private String CREATE_ACCOUNT_URL = "https://" + ip + "/Comments";
  private static String ip = "liurechar.utools.club";
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    Log.e(TAG, "onCreateView: ");
    View view = inflater.inflate(R.layout.circle_fragment, container, false);
    listView = view.findViewById(R.id.list);
    getContentAll.start();
    FloatingActionButton fab = view.findViewById(R.id.fab_add);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(getActivity(), AddNoticeActivity.class));
      }
    });
    return view;
  }

 private Thread getContentAll =new Thread(new Runnable() {
   @Override
   public void run() {

     OkHttpClient client = new OkHttpClient();
     Log.e(TAG, "getContentAll: "+ CREATE_ACCOUNT_URL);
     Request request = new Request.Builder().url(CREATE_ACCOUNT_URL).build();

     Log.e(TAG, "onCreateView: 2");
     try {
       Response response = client.newCall(request).execute();
       if (response.isSuccessful()) {
         String str = null;
         if (response.body() != null) {
           str = response.body().string();
         }
         Gson gson = new Gson();
         friendsList = gson.fromJson(str, new TypeToken<List<CircleFriends>>() {}.getType());
       }
     } catch (IOException e) {
       e.printStackTrace();
       getActivity().runOnUiThread(new Runnable() {
           @Override
           public void run() {
               Toast.makeText(getActivity(),"请求超时",Toast.LENGTH_SHORT).show();
           }
       });

     }
     getActivity().runOnUiThread(new Runnable() {
       @Override
       public void run() {
         //json获取list
         CircleAdapter  circleAdapter = new CircleAdapter(getActivity(), friendsList);
         listView.setAdapter(circleAdapter);
       }
     });

   }
 }) ;
}
