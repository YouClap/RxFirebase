package com.androidhuman.rxfirebase2.database;

import com.google.auto.value.AutoValue;
import com.google.firebase.database.DataSnapshot;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@AutoValue
public abstract class ChildAddEvent extends ChildEvent {

    @CheckResult
    @NonNull
    public static ChildAddEvent create(DataSnapshot dataSnapshot, String previousChildName) {
        return new AutoValue_ChildAddEvent(dataSnapshot, previousChildName);
    }

    @Nullable
    public abstract String previousChildName();
}
