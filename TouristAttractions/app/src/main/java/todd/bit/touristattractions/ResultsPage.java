/**
 * This class displays the results for the quiz and displays and image and feedback on how the
 * user did.
 */
package todd.bit.touristattractions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsPage extends AppCompatActivity implements View.OnClickListener{
    private ImageView image;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);
        image = (ImageView) findViewById(R.id.imageResult);

        Intent howIgotHere = getIntent();
        score = howIgotHere.getIntExtra("Results", -1);
        TextView tv = (TextView) findViewById(R.id.textResult);
        tv.setText("You scored " + score + " out of 10");

        Button btnRes = (Button) findViewById(R.id.resbtn);
        btnRes.setOnClickListener(this);

        setImage();
    }

    /**
     * This method displays a picture and plays an audio file based on how many points the user
     * got at the end of the quiz.
     */
    public void setImage() {
        if (score == 10) {
            image.setImageResource(R.drawable.victory);
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fortnite);
            mediaPlayer.start();
        }
        else if (score == 0) {
            image.setImageResource(R.drawable.thinking);
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.yoda);
            mediaPlayer.start();
        }
        else {
            image.setImageResource(R.drawable.obama);
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.noice);
            mediaPlayer.start();
        }
    }

    /**
     * This method restarts the app ;)
     * @param v
     */
    @Override
    public void onClick(View v) {
        System.exit(0);
    }
}