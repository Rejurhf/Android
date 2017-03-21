package com.example.rejurhf.a001_listsandmore;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by Rejurhf on 21.03.2017.
 */

public class DialogWindow extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder myDialog = new AlertDialog.Builder(getActivity());
        myDialog.setTitle("Running away!");
        myDialog.setMessage("Do you want to exit?");
        myDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().finish();
            }
        });
        myDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String message = "That's good for you";
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });
        return myDialog.create();
    }
}
