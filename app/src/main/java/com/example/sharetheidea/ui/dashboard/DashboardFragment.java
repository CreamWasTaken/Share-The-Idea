package com.example.sharetheidea.ui.dashboard;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sharetheidea.R;

public class DashboardFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        final TextView profileName = (TextView)root.findViewById(R.id.txt_profilename);
        Button btn_edit = (Button)root.findViewById(R.id.btn_profilepic);
        RatingBar ratingBar =(RatingBar)root.findViewById(R.id.ratingBar);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder AlertBuild = new AlertDialog.Builder(root.getContext());
                AlertBuild.setCancelable(true);
                AlertBuild.setTitle("Edit Profile");
                AlertBuild.setMessage("What do you want to change?");

                AlertBuild.setNegativeButton("Name", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //nest
                        AlertDialog.Builder bob = new AlertDialog.Builder(root.getContext());
                        bob.setCancelable(true);
                        bob.setTitle("Change Name");
                        final EditText edt_upName = new EditText(root.getContext());
                        edt_upName.setInputType(InputType.TYPE_CLASS_TEXT);
                        bob.setView(edt_upName);
                        //nested AlertDialog
                        bob.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                profileName.setText(edt_upName.getText().toString());
                                Toast.makeText(root.getContext(),"Updated",Toast.LENGTH_LONG).show();
                            }
                        });
                        bob.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(root.getContext(),"Canceled",Toast.LENGTH_LONG).show();

                            }
                        });



                      bob.show();
                    }
                });
               AlertBuild.setPositiveButton("Picture", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               });




                AlertBuild.show();
            }
        });



        return root;
    }

}
