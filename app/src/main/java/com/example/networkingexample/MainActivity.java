package com.example.networkingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private TextView mdislayTextView;
    private Button mgetDataButton;
    private EditText meditText;
    String finalUrl="https://api.github.com/search/users?q=bhavya";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mgetDataButton=(Button)findViewById(R.id.getDataButton);
        mgetDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView();
            }
        });
    }
    private void updateTextView(){
        DownloadTask downloadText=new DownloadTask();
        downloadText.execute();
    }

    class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            String urlString=finalUrl;
            try {

                /*
                        setting up the API
                 */
                URL url= new URL(urlString);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                Scanner scanner=new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                if(scanner.hasNext()){
                    String str = scanner.next();
                    return str;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return "Failed to fetch data";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayList<UsersClass> users=parseJson(s);
            Log.e("my tag","count = " + users.size());
            mdislayTextView=(TextView)findViewById(R.id.displayText);
            mdislayTextView.setText(s);
        }
    }

    ArrayList<UsersClass> parseJson(String str){

        ArrayList<UsersClass> usersList=new ArrayList<>();

        //parsing json
        try {
                JSONObject root= new JSONObject(str);
                JSONArray items=root.getJSONArray("items");

                for(int i=0;i<items.length();i++){
                    JSONObject jsonObject=items.getJSONObject(i);
                    String login=jsonObject.getString("login");
                    Integer id=jsonObject.getInt("id");
                    String nodeId=jsonObject.getString("node_id");
                    String avatar=jsonObject.getString("avatar_url");
                    String html=jsonObject.getString("html_url");
                    UsersClass obj=new UsersClass(login,id,nodeId,avatar,html);
                    usersList.add(obj);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return  usersList;
    }

}
