package com.laioffer.tinnews.common;

import android.os.Bundle;

public interface TinFragmentManager {
    void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle);

    void showSnackBar(String message);

    void doFragmentTransaction(TinBasicFragment basicFragment);

//    void doFragmentTransaction();
}
