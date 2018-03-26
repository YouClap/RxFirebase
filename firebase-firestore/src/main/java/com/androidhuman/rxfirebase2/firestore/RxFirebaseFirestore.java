package com.androidhuman.rxfirebase2.firestore;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.SetOptions;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public final class RxFirebaseFirestore {

    private RxFirebaseFirestore() {
        throw new AssertionError("No instances");
    }

    @NonNull
    @CheckResult
    public static Single<DocumentSnapshot> getDocument(@NonNull DocumentReference ref) {
        return new DocumentObserver(ref);
    }

    @NonNull
    @CheckResult
    public static Observable<DocumentSnapshot> getDocumentChanges(@NonNull DocumentReference ref) {
        return new DocumentChangesObserver(ref);
    }

    @NonNull
    @CheckResult
    public static <T> Completable setDocument(@NonNull DocumentReference ref, @NonNull T value) {
        return new SetDocumentObserver<>(ref, value);
    }

    @NonNull
    @CheckResult
    public static <T> Completable setDocument(@NonNull DocumentReference ref, @NonNull T value, @NonNull SetOptions setOptions) {
        return new SetDocumentWithSetOptionsObserver<>(ref, value, setOptions);
    }

    @NonNull
    @CheckResult
    public static <T> Single<DocumentReference> addDocument(@NonNull CollectionReference ref, @NonNull T value) {
        return new AddDocumentObserver<>(ref, value);
    }

    @NonNull
    @CheckResult
    public static Completable removeDocument(@NonNull DocumentReference ref) {
        return new DeleteDocumentObserver(ref);
    }
}
