package tranduythanh.com;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnstart;
	MyAsyncTask task;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnstart=(Button) findViewById(R.id.btnstart);
		
		btnstart.setOnClickListener(new 
				View.OnClickListener() {
			public void onClick(View arg0) {
				doStart();
			}
		});
	}
	public void doStart()
	{
		task=new MyAsyncTask(this);
		task.execute();
	}
}
