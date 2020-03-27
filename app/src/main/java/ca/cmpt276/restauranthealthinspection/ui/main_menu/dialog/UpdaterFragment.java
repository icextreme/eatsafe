package ca.cmpt276.restauranthealthinspection.ui.main_menu.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import androidx.fragment.app.FragmentManager;
import ca.cmpt276.restauranthealthinspection.R;
import ca.cmpt276.restauranthealthinspection.ui.main_menu.MapsActivity;

public class UpdaterFragment extends DialogFragment {

    public static final String TAG = "updating";

    public interface UpdaterDialogListener {
        void onDialogPositiveClick(DialogFragment dialog);
        void onDialogNegativeClick(DialogFragment dialog);
    }

    private UpdaterDialogListener listener;

//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        try {
//            listener = (UpdaterDialogListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(getActivity().toString()
//                    + " must implement NoticeDialogListener");
//        }
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.update_avaiable)
                .setMessage(R.string.update_message)
                .setPositiveButton(R.string.dialog_button_update, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        listener.onDialogPositiveClick(UpdaterDialogFragment.this);
                        FragmentManager fragmentManager = getFragmentManager();
                        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
                        progressDialogFragment.show(fragmentManager, ProgressDialogFragment.TAG);
                    }
                })
                .setNegativeButton(R.string.dialog_button_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        listener.onDialogNegativeClick(UpdaterDialogFragment.this);

                        Intent i = MapsActivity.makeLaunchIntent(getContext());
                        startActivity(i);
                    }
                });


        return builder.create();
    }
}
