package ca.ualberta.cs.comput301.currentlocation;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class CurrentLocationActivity extends Activity {
	private static final String GPS_MOCK_PROVIDER = "GpsMockProvider";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// TODO
		// Obtain LocationManager service and set up location update request.
		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
		
		
	}

	
	// Retrieve location updates through LocationListener interface
	private final LocationListener locationListener = new LocationListener(){
	// TODO: override the four methods.
		public void onLocationChanged (Location location) {
			//TODO
			TextView tv = (TextView) findViewById(R.id.myLocationText);
			if(location != null){
				double lat = location.getLatitude();
				double lng = location.getLongitude();
		
				tv.setText("Latitude: " + lat + "\nLongitude: " + lng);
						
			}else{
				tv.setText("NO LOCATION INFO");
			}
		}
		
		public void onProviderDisabled (String provider) {
			//TODO
		}
		
		public void onProviderEnabled (String provider) {
			//TODO
		}
		
		public void onStatusChanged (String provider, int status, Bundle extras) {
			//TODO
		}
		
	};	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
