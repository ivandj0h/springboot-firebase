package com.java.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CRUDService {

    // Get all users
    public CRUD getCRUD(String docId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("crud_users").document(docId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        CRUD crud;

        if(document.exists()) {
            crud = document.toObject(CRUD.class);
            return crud;
        }
        return null;
    }

    // Create CRUD Service
    public String createCRUD(CRUD crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("crud_users").document(crud.getName()).set(crud);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    // Update CRUD Service
    public String updateCRUD(CRUD crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("crud_users").document(crud.getName()).set(crud);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    // Delete CRUD Service
    public String deleteCRUD(String docId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("crud_users").document(docId).delete();
        return "Successfully Delete!" + docId;
    }
}
