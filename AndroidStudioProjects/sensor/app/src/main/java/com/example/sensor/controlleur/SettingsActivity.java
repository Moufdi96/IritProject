package com.example.sensor.controlleur;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;
import com.example.sensor.R;
import static android.R.layout.simple_list_item_1;


public class SettingsActivity extends AppCompatActivity {
    private WindowManager.LayoutParams mLayoutParams;
    private ListView mListView;
    private ImageView mCloseButton;
    private String[] mSettings;
    private Context mContext;
    private Drawable icon;
    private Intent mDataActivity;
    private int mCheckedItemAcquisitionRate;
    private int mChoosenResultAccuracy;
    private AlertDialog.Builder builder;
    private AlertDialog.Builder builder1;
    private NumberPicker mResultAccuracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutParams = getWindow().getAttributes();
        mLayoutParams.x = 0;
        mLayoutParams.y = 50;
        mLayoutParams.height = 650;
        mLayoutParams.width = 1000;

        this.getWindow().setAttributes(mLayoutParams);
        setContentView(R.layout.activity_settings);
        mListView = (ListView)findViewById(R.id.Settings_activity_listView);
        mDataActivity=new Intent();
        final Intent intent = getIntent();
        int[] updatedSettings=intent.getIntArrayExtra("settings");
        mCheckedItemAcquisitionRate = updatedSettings[0];
        mChoosenResultAccuracy = updatedSettings[1];
        mResultAccuracy=new NumberPicker(this);
        mResultAccuracy.setMaxValue(15);
        mResultAccuracy.setMinValue(0);
        mResultAccuracy.setValue(mChoosenResultAccuracy);
        mResultAccuracy.setWrapSelectorWheel(false);
        builder=new AlertDialog.Builder(this);
        builder1=new AlertDialog.Builder(this);
        mSettings=new String[]{"Acquisition frequency","Accuracy","Todo","Todo","Todo"};
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(this,simple_list_item_1,mSettings);
        mListView.setAdapter(mArrayAdapter);
        icon= getDrawable(R.drawable.ic_check_circle_black_24dp);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=(String)mListView.getItemAtPosition(position);
                switch (selectedItem) {
                    case "Acquisition frequency":
                        builder1.setTitle("Set the acquisition frequency");
                        builder1.setSingleChoiceItems(new String[]{"100Hz", "50Hz", "25Hz", "7Hz"}, mCheckedItemAcquisitionRate, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mDataActivity.putExtra("setting",new int[]{0,which});
                                if(which==0){

                                    Toast.makeText(SettingsActivity.this,"High Acquisition rate may drane your battery",Toast.LENGTH_LONG).show();
                                }
                                mCheckedItemAcquisitionRate=which;
                            }
                        });


                        builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setResult(RESULT_OK,mDataActivity);
                                dialog.dismiss();
                            }
                        });

                        builder1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setResult(RESULT_CANCELED,mDataActivity);
                                dialog.dismiss();
                            }
                        });

                        builder1.create();
                        builder1.show();
                        break;
                    case "Accuracy":
                        builder.setTitle("Set the acquisition accuracy (number of decimals)");
                        builder.setView(mResultAccuracy);
                        mResultAccuracy.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                            @Override
                            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                                mResultAccuracy.setValue(newVal);

                                if(newVal!=oldVal){
                                    mChoosenResultAccuracy=newVal;
                                    mDataActivity.putExtra("setting",new int[]{1,mChoosenResultAccuracy});
                                    setResult(RESULT_OK,mDataActivity);

                                }
                            }
                        });
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setResult(RESULT_OK,mDataActivity);
                                dialog.dismiss();
                                ((ViewGroup)mResultAccuracy.getParent()).removeView(mResultAccuracy);
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setResult(RESULT_CANCELED,mDataActivity);
                                dialog.dismiss();
                                ((ViewGroup)mResultAccuracy.getParent()).removeView(mResultAccuracy);
                            }
                        });
                        builder.create();
                        builder.show();
                        break;

                }
            }
        });


    }
}