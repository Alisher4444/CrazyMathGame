package creatingnew.kz.crazymathematician;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class HistoryActivity extends AppCompatActivity {
    private Realm realm;
    private static final String SHARED_PREFS_NAME = "creatingnew.kz.crazymathematician.sharedprefs";
    private static final String SHARED_PREFS_SCORE_KEY = "score";
    private static final int REQUEST_CODE_PLAY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


    }
/*
    private boolean saveArray(String[] array, String arrayName, Context mContext){
        SharedPreferences prefs = mContext.getSharedPreferences(SHARED_PREFS_NAME,0);
        SharedPreferences.Editor mEditor = prefs.edit();
        mEditor.putInt(arrayName,score);
        for(int i=0; i<array.length; i++){
            mEditor.putString(arrayName + "_" + i, array[i]);
        }
        return mEditor.commit();
    }

    private String[] loadArray(String arrayName, Context mContext){
        SharedPreferences prefs = mContext.getSharedPreferences(SHARED_PREFS_NAME,0);
        int size = prefs.getInt(arrayName + "_size",0);
        String array[] = new String[size];
        for(int i=0; i<size;i++){
            array[i] = prefs.getString(arrayName + "_" + i,null);

        }
        return array;
    }*/



}
