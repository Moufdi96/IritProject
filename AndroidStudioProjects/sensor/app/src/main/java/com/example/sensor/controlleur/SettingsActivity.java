package com.example.sensor.controlleur;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;

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
        //mCloseButton=(ImageView)findViewById(R.id.settings_activity_close_button);
        mSettings=new String[]{"Acquisition frequency","Unit"};
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(this,simple_list_item_1,mSettings);
        mListView.setAdapter(mArrayAdapter);
        icon= getDrawable(R.drawable.ic_check_circle_black_24dp);
        mDataActivity=new Intent();

        final Intent intent = getIntent();
        mCheckedItemAcquisitionRate = intent.getIntExtra("rate",3);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=(String)mListView.getItemAtPosition(position);
                switch (selectedItem) {
                    case "Acquisition frequency":
                        AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                        builder.setTitle("Set the acquisition rate");
                        builder.setSingleChoiceItems(new String[]{"0", "1", "2", "3"}, mCheckedItemAcquisitionRate, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mDataActivity.putExtra("acquisitionRate",which);
                                mCheckedItemAcquisitionRate=which;
                            }
                        });


                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setResult(RESULT_OK,mDataActivity);
                                dialog.dismiss();
                                finish();
                            }
                        });

                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setResult(RESULT_CANCELED,mDataActivity);
                                dialog.dismiss();
                                finish();
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