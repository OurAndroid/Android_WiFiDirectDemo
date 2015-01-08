package com.example.filebrowser;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class FileResultsTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
        		Intent intent = new Intent(FileResultsTest.this,
        				MainActivity.class);
        		startActivityForResult(intent,100);
			}
        });
        
    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode,Intent data){
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode == 100 && resultCode == Activity.RESULT_OK ){
    		String val = data.getExtras().getString("EXTRAS_FILE_PATH");
    		TextView textView = (TextView) findViewById(R.id.textView1);
    		textView.setText("来自文件管理器的值"+val);
    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}