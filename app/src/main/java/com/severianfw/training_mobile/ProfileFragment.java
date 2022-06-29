package com.severianfw.training_mobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.severianfw.training_mobile.view.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    TextView textView1, username, email;;
    EditText editText1;
    Button submitBtn, toUploaded;
    AlertDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        textView1 = v.findViewById(R.id.tv1);
        editText1 = v.findViewById(R.id.et1);
        submitBtn = v.findViewById(R.id.submit_btn);
        toUploaded = v.findViewById(R.id.uploaded_btn);
        username = v.findViewById(R.id.tv_username);
        email = v.findViewById(R.id.tv_email);

        Intent intent = getActivity().getIntent();
        String tempUsername = intent.getStringExtra("account username");

        username.setText(tempUsername);

        String tempEmail = intent.getStringExtra("account email");

        email.setText(tempEmail);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Konfirmasi").setMessage("Apakah anda ingin mengubah teks?").setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textView1.setText(editText1.getText().toString());
            }
        }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
                Toast.makeText(getActivity(), "Perubahan tidak jadi", Toast.LENGTH_SHORT).show();
            }
        });
        dialog = builder.create();

        submitBtn.setOnClickListener(view -> {
            dialog.show();
        });

        toUploaded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toUploadedIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(toUploadedIntent);
            }
        });

        return v;
    }
}