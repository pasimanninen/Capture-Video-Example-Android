package fi.ptm.capturevideoexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;

/**
 *
 * @author PTM
 */
public class MainActivity extends Activity {
    private final int TAKE_VIDEO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void captureVideo(View view) {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, TAKE_VIDEO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == TAKE_VIDEO) {
            VideoView videoView = (VideoView) findViewById(R.id.videoView);
            videoView.setVideoURI(data.getData());
            videoView.requestFocus();
            videoView.start();
        }
    }

}
