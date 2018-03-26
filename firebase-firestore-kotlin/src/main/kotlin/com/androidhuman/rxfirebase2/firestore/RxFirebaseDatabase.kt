@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package com.androidhuman.rxfirebase2.firestore

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.SetOptions
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

inline fun <reified T : Any> CollectionReference.rxAdd(value: T)
        : Single<DocumentReference> = RxFirebaseFirestore.addDocument(this, value)

inline fun <reified T : Any> DocumentReference.rxSet(value: T)
        : Completable = RxFirebaseFirestore.setDocument(this, value)

inline fun <reified T : Any> DocumentReference.rxSet(value: T, setOptions: SetOptions)
        : Completable = RxFirebaseFirestore.setDocument(this, value, setOptions)

inline fun DocumentReference.rxRemove()
        : Completable = RxFirebaseFirestore.removeDocument(this)

inline fun DocumentReference.rxGet()
        : Single<DocumentSnapshot> = RxFirebaseFirestore.getDocument(this)

inline fun DocumentReference.rxGetChanges()
        : Observable<DocumentSnapshot> = RxFirebaseFirestore.getDocumentChanges(this)

