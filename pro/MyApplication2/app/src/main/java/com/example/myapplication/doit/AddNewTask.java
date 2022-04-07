package com.example.myapplication.doit;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.security.AppUriAuthenticationPolicy;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.app.DialogCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.R;
import com.example.myapplication.ToDoMoudel;
import com.example.myapplication.Utils.DatabaseHandler;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.CharArrayWriter;

public class AddNewTask extends BottomSheetDialogFragment {
    public static final String TAG = "ActionBottomDialog";
    private EditText newTaskText;
    private Button newTaskSaveButton;
    private DatabaseHandler db;
    public static AddNewTask newInstance(){
    return new AddNewTask();

    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL , R.style.DialogStyle);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container , Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.new_task , container , false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }
    @Override
    public void onViewCreated(View view , Bundle avedInstanceState){
        super.onViewCreated(view ,avedInstanceState);
        newTaskText = getView().findViewById(R.id.newtask);
        newTaskSaveButton = getView().findViewById(R.id.button);

        db = new DatabaseHandler(getActivity());
        db.openDatabase();
        boolean isUpdate = false;
        final Bundle bundle = getArguments();
        if(bundle != null) {
            isUpdate = true;
            String task = bundle.getString("task");
            newTaskText.setText(task);
            if (task.length() > 0)
                newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(),R.color.BLUE));
        }

        newTaskText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")){
              newTaskSaveButton.setEnabled(false);
              newTaskText.setTextColor(Color.GRAY);
                }
                else {
                    newTaskSaveButton.setEnabled(true);
                    newTaskText.setTextColor(ContextCompat.getColor(getContext(),R.color.BLUE));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        boolean finalIsUpdate = isUpdate;
        newTaskSaveButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String text = newTaskText.getText().toString();
               if (finalIsUpdate){
                   db.updateTask (bundle.getInt("id"), text);
               }
               else{
                   ToDoMoudel task = new ToDoMoudel();
                   task.setTask(text);
                   task.setStatus(0);
               }
           dismiss();
           }
       });

    }
    @Override
    public void onDismiss(DialogInterface dialog){
        Activity activity = getActivity();
        if (activity instanceof DialogInterface){
            ( (DialogCloseListene)activity).handleDialogClose(dialog);
        }
    }
    }
