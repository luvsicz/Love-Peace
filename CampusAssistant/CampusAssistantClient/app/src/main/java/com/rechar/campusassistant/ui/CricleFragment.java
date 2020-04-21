package com.rechar.campusassistant.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.adapter.CircleAdapter;
import com.rechar.campusassistant.model.CircleFriends;
import com.rechar.campusassistant.util.DBHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
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
      private String deleteUrl="https://" + ip + "/CommentsDelete" ;
      private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
      private final OkHttpClient mOkHttpClient = new OkHttpClient();
   @Nullable
   @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    Log.e(TAG, "onCreateView: ");
    View view = inflater.inflate(R.layout.circle_fragment, container, false);
    listView = view.findViewById(R.id.list);
    FloatingActionButton fab = view.findViewById(R.id.fab_add);

       Cursor cursor2=new DBHelper(getActivity(),"user.db",null,1).query("Select username from users",null);
       if (cursor2.moveToFirst()) {
           fab.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), AddNoticeActivity.class)));
       }
       else
       {
           Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
       }

    listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
          @Override
          public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
              String username=null;
              Cursor cursor1=new DBHelper(getActivity(),"user.db",null,1).query("Select username from users",null);
              if (cursor1.moveToFirst()) {
                  username=cursor1.getString(0);
              }
              Log.e(TAG, "onItemLongClick: "+username );
              if (username.equals(friendsList.get(position).getUserName())) {
                  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                  CircleAdapter  circleAdapter = new CircleAdapter(getActivity(), friendsList);
                  builder.setMessage("确认删除吗");
                  builder.setTitle("提示");
                  builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface arg0, int arg1) {
                      // TODO Auto-generated method stub
                      arg0.dismiss();
                  }
              });
              builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface arg0, int arg1) {
                      // TODO Auto-generated method stub
                     new Thread(new Runnable() {
                         @Override
                         public void run() {
                             String dContent= friendsList.get(position).getContent();
                             String dUsername=friendsList.get(position).getUserName();
                             HashMap<String, String> params = new HashMap<>();
                             params.put("content",dContent);
                             params.put("username",dUsername);
                             Gson gson = new Gson();
                             //使用Gson将对象转换为json字符串
                             String json = gson.toJson(params);
                             RequestBody body = RequestBody.create(json, JSON);
                             Request request = new Request.Builder()
                                     .url(deleteUrl)
                                     .post(body)
                                     .build();
                             Response response = null;
                             try {
                                 response = mOkHttpClient.newCall(request).execute();
                                 String str = null;
                                 if (response.isSuccessful()) {
                                     if (response.body() != null) {
                                         str = response.body().string();
                                         Log.e(TAG, "str: " + str);
                                     }
                                     if (str.equals("200")) {
                                         Log.e(TAG, "run: 发布成功");
                                        getActivity(). runOnUiThread(new Runnable() {
                                             @Override
                                             public void run() {
                                                 Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
                                             }
                                         });
                                         circleAdapter.notifyDataSetChanged();friendsList.remove(position);
                                     } else {
                                         getActivity().runOnUiThread(new Runnable() {
                                             @Override
                                             public void run() {
                                                 Toast.makeText(getActivity(), "删除失败", Toast.LENGTH_SHORT).show();
                                             }
                                         });

                                     }
                                     Log.e(TAG, "sendData: " + gson.toJson(str));
                                 }
                             } catch (IOException e) {
                                 e.printStackTrace();
                             }
                         }
                     }).start();

                  }
              });
              builder.create().show();
              }
              return true;
          }
      });
    return view;
  }

  @Override
  public void onStart() {
    super.onStart();
    new Thread(() -> {
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
        getActivity().runOnUiThread(() -> Toast.makeText(getActivity(),"请求超时",Toast.LENGTH_SHORT).show());
      }
      getActivity().runOnUiThread(() -> {
        //json获取list
        CircleAdapter  circleAdapter = new CircleAdapter(getActivity(), friendsList);
        listView.setAdapter(circleAdapter);
      });
    }).start();
  }
}
