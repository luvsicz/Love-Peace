package com.rechar.campusassistant.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.rechar.campusassistant.ui.LoginActivity;

/**
 * @author Bamboo
 * @package:com.rechar.campusassistant.model
 * @fileName:LoginViewModel
 * @date on:2019/11/13 14:21
 */
public class LoginViewModel extends ViewModel {
  private MutableLiveData<LoginActivity> loginCheck = new MutableLiveData<>();

}
