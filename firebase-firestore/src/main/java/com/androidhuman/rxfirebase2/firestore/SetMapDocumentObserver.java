package com.androidhuman.rxfirebase2.firestore;

import androidx.annotation.NonNull;

import com.androidhuman.rxfirebase2.firestore.core.OnCompleteDisposable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import java.util.Map;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;

final class SetMapDocumentObserver extends Completable {

    private final DocumentReference instance;

    private final Map<String, Object> value;

    SetMapDocumentObserver(DocumentReference instance, Map<String, Object> value) {
        this.instance = instance;
        this.value = value;
    }

    @Override
    protected void subscribeActual(CompletableObserver observer) {
        Listener listener = new Listener(observer);
        observer.onSubscribe(listener);

        instance.set(value)
                .addOnCompleteListener(listener);
    }

    private static final class Listener extends OnCompleteDisposable<Void> {

        private final CompletableObserver observer;

        Listener(@NonNull CompletableObserver observer) {
            this.observer = observer;
        }

        @Override
        public void onComplete(@NonNull Task task) {
            if (!isDisposed()) {
                if (!task.isSuccessful()) {
                    observer.onError(task.getException());
                } else {
                    observer.onComplete();
                }
            }
        }
    }
}
