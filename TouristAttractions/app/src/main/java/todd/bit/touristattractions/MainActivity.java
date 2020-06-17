/**
 * This is the main quiz section that displays the questions and moves to the next question
 * as well as setting up the answers in random order and displaying each image for the correct
 * question.
 */

package todd.bit.touristattractions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView image;
    private Questions[] questions = new Questions[10];
    private int score = 0;
    private int questionNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        Button btnCheck = (Button) findViewById(R.id.submitBtn);
        btnCheck.setOnClickListener(this);
        score = 0;
        questionNum = 0;

        setQuestions();
        showQuestion();
        loadQuestion();
    }


    /**
     * This method loops through the question array.
     */
    public void setQuestions() {
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new Questions(i);
        }
    }

    /**
     * This method gets the text for the question and sets the image for the same question.
     */
    public void showQuestion() {
        TextView question = (TextView) findViewById(R.id.question);
        question.setText(questions[questionNum].getQues());
        image = (ImageView) findViewById(R.id.imageView);
        loadQuestion();

        switch(questionNum) {
            case 0:
                image.setImageResource(R.drawable.hobbiton);
                break;
            case 1:
                image.setImageResource(R.drawable.queenstown);
                break;
            case 2:
                image.setImageResource(R.drawable.mountcook);
                break;
            case 3:
                image.setImageResource(R.drawable.abeltasman);
                break;
            case 4:
                image.setImageResource(R.drawable.milford);
                break;
            case 5:
                image.setImageResource(R.drawable.christchurch);
                break;
            case 6:
                image.setImageResource(R.drawable.whiteisland);
                break;
            case 7:
                image.setImageResource(R.drawable.glowworm);
                break;
            case 8:
                image.setImageResource(R.drawable.wanaka);
                break;
            case 9:
                image.setImageResource(R.drawable.hanmer);
                break;
        }
    }

    /**
     * This method loads the question data and randomizes the answer location on the radio buttons.
     */
    public void loadQuestion() {
        RadioButton rb1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.rb3);
        RadioButton rb4 = (RadioButton) findViewById(R.id.rb4);
        Random rand = new Random();

        switch(rand.nextInt(4)) {
            case 0:
                rb1.setText(questions[questionNum].quesAnswer1);
                rb2.setText(questions[questionNum].quesAnswer2);
                rb3.setText(questions[questionNum].quesAnswer3);
                rb4.setText(questions[questionNum].quesAnswer4);
                break;

            case 1:
                rb1.setText(questions[questionNum].quesAnswer4);
                rb2.setText(questions[questionNum].quesAnswer3);
                rb3.setText(questions[questionNum].quesAnswer2);
                rb4.setText(questions[questionNum].quesAnswer1);
                break;

            case 2:
                rb1.setText(questions[questionNum].quesAnswer1);
                rb2.setText(questions[questionNum].quesAnswer4);
                rb3.setText(questions[questionNum].quesAnswer3);
                rb4.setText(questions[questionNum].quesAnswer2);
                break;

            case 3:
                rb1.setText(questions[questionNum].quesAnswer4);
                rb2.setText(questions[questionNum].quesAnswer2);
                rb3.setText(questions[questionNum].quesAnswer1);
                rb4.setText(questions[questionNum].quesAnswer3);
                break;
        }
    }

    /**
     * This method is used to check the answer(string) in the radio button selected by the user and
     * display a toast based on the result of correct or incorrect. This method also moves to the
     * next intent screen(results page) once the user has finished the quiz questions.
     * @param v
     */
    @Override
    public void onClick(View v) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        if (rg.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_LONG).show();
        }
        else if (questionNum < questions.length) {
            int selected = rg.getCheckedRadioButtonId();
            RadioButton chosen = (RadioButton) findViewById(selected);
            if (chosen.getText().equals(questions[questionNum].getAnswer())) {
                Toast.makeText(this, "Correct :)", Toast.LENGTH_LONG).show();
                score++;
            } else {
                Toast.makeText(this, "Wrong :( The correct answer was " + questions[questionNum].getAnswer(), Toast.LENGTH_LONG).show();
            }
            questionNum++;
            rg.clearCheck();
            if (questionNum < questions.length) {
                showQuestion();
            } else {
                //Go to results page
                Intent changeActivity = new Intent(MainActivity.this, ResultsPage.class);
                changeActivity.putExtra("Results", score);
                startActivity(changeActivity);
            }
        }
    }
}