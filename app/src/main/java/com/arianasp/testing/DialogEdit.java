package com.arianasp.testing;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ariana on 9/27/2016.
 */

public class DialogEdit extends DialogFragment {

    EditText etTitle;
    EditText etDescription;
    Button btnUpdate;
    DataDao dataDao;
    DialogEditCommunicator communicator;

    public DialogEdit(){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_edit,container,false);
        etTitle = (EditText) v.findViewById(R.id.et_title);
        etDescription = (EditText) v.findViewById(R.id.et_description);
        btnUpdate = (Button) v.findViewById(R.id.btn_update);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (DialogEditCommunicator) context;
    }

    public void sendData(){
        if(isValid()){
            DataDao data = new DataDao(etTitle.getText().toString(),etDescription.getText().toString(),1);
            communicator.sendData(data);
            getDialog().dismiss();
        }
    }

    public boolean isValid(){
        boolean isValid = true;
        if(TextUtils.isEmpty(etTitle.getText().toString())){
            isValid = false;
            etTitle.setError("title tidak boleh kosong");
        }
        if(TextUtils.isEmpty(etDescription.getText().toString())){
            isValid = false;
            etDescription.setError("deskripsi tidak boleh kosong");
        }

        return isValid;
    }