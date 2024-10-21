package com.example.signuploginforget;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDataFragment extends Fragment {
    private EditText name ;
    private EditText location ;
    private EditText id ;
    private EditText specialty;
    private Button add1;
    private FirebaseServices fbs;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddDataFragment newInstance(String param1, String param2) {
        AddDataFragment fragment = new AddDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_data, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        connect();
    }
   public void connect()
    {
       name=getView().findViewById(R.id.edName);
       fbs=FirebaseServices.getInstance();
        location=getView().findViewById(R.id.etLocation);
        id=getView().findViewById(R.id.etid);
        specialty=getView().findViewById(R.id.etSpecialty);
        add1=getView().findViewById(R.id.btnAdd);



    }
    public  void adddoctor() {
        String name1, id1, location1, specialty1;
        name1 = name.getText().toString();
        id1 = id.getText().toString();
        location1 = location.getText().toString();
        specialty1 = specialty.getText().toString();
        if (name1.isEmpty() || id1.isEmpty() || location1.isEmpty() || specialty1.isEmpty()) {
            Toast.makeText(getActivity(), "something is wrong", Toast.LENGTH_SHORT).show();
            return;
        }
        Doctor doctor = new Doctor(id1, name1, location1, specialty1);

        fbs.getFire().collection("doctors").add(doctor).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getActivity(), "success to add", Toast.LENGTH_SHORT).show();
                return;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "something is wrong", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }
}





