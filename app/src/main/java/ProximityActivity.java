import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.alishaaaa.R;

public class ProximityActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private TextView tvproximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_on_off);
        setTitle("Proximity sensor");

        tvproximity = findViewById(R.id.tvProximity);
        proximity();
    }

    private void proximity() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
     Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

     SensorEventListener proxilistener = new SensorEventListener() {
            @Override
                public void onSensorChanged (SensorEvent event) {
                if (event.values[0] <= 4) {
                    tvproximity.setText("Object is near");
                } else {
                    tvproximity.setText("object is far");
                }
            }
                    @Override
                    public void onAccuracyChanged (Sensor sensor,int accuracy){

                    }
                };
                sensorManager.registerListener(proxilistener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
