/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.mindorks.framework.mvvm.ui.splash;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mindorks.framework.mvvm.BR;
import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.ViewModelProviderFactory;
import com.mindorks.framework.mvvm.databinding.ActivitySplashBinding;
import com.mindorks.framework.mvvm.ui.base.BaseActivity;
import com.mindorks.framework.mvvm.ui.login.LoginActivity;
import com.mindorks.framework.mvvm.ui.main.MainActivity;
import javax.inject.Inject;

/**
 * Created by amitshekhar on 08/07/17.
 */

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements
    SplashNavigator {

  @Inject
  ViewModelProviderFactory factory;
  private SplashViewModel mSplashViewModel;

  public static Intent newIntent(Context context) {
    return new Intent(context, SplashActivity.class);
  }

  @Override
  public int getBindingVariable() {
    return BR.viewModel;
  }

  @Override
  public int getLayoutId() {
    return R.layout.activity_splash;
  }

  @Override
  public SplashViewModel getViewModel() {
    mSplashViewModel = ViewModelProviders.of(this, factory).get(SplashViewModel.class);
    return mSplashViewModel;
  }

  @Override
  public void openLoginActivity() {
    Intent intent = LoginActivity.newIntent(SplashActivity.this);
    startActivity(intent);
    finish();
  }

  @Override
  public void openMainActivity() {
    Intent intent = MainActivity.newIntent(SplashActivity.this);
    startActivity(intent);
    finish();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mSplashViewModel.setNavigator(this);
    mSplashViewModel.startSeeding();
  }
}
