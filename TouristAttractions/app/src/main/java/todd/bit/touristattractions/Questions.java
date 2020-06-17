/**
 * This Class stores the information on all the questions for the quiz.
 */
package todd.bit.touristattractions;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

public class Questions {
    private String ques;
    public String quesAnswer1;
    public String quesAnswer2;
    public String quesAnswer3;
    public String quesAnswer4;
    public Questions (int i) {
        switch (i) {
            case 0:
                ques = "Which region is Hobbiton located in?";
                quesAnswer1 = "Waikato correct";
                quesAnswer2 = "Auckland";
                quesAnswer3 = "Otago";
                quesAnswer4 = "Canterbury";
                break;

            case 1:
                ques = "Which region is Queenstown located in?";
                quesAnswer1 = "Otago correct";
                quesAnswer2 = "Auckland";
                quesAnswer3 = "Canterbury";
                quesAnswer4 = "Waikato";
                break;

            case 2:
                ques = "Which region is Mount Cook Nation Park located in?";
                quesAnswer1 = "Canterbury correct";
                quesAnswer2 = "Auckland";
                quesAnswer3 = "Otago";
                quesAnswer4 = "Waikato";
                break;

            case 3:
                ques = "Which region is Abel Tasmen National Park located in?";
                quesAnswer1 = "Tasman correct";
                quesAnswer2 = "Canterbury";
                quesAnswer3 = "Otago";
                quesAnswer4 = "Waikato";
                break;

            case 4:
                ques = "Which region is Milford Sound located in?";
                quesAnswer1 = "Southland correct";
                quesAnswer2 = "Auckland";
                quesAnswer3 = "Otago";
                quesAnswer4 = "Waikato";
                break;

            case 5:
                ques = "Which region is Christchurch located in?";
                quesAnswer1 = "Canterbury correct";
                quesAnswer2 = "Auckland";
                quesAnswer3 = "Otago";
                quesAnswer4 = "Waikato";
                break;

            case 6:
                ques = "Which region is White Island located in?";
                quesAnswer1 = "Bay of Plenty correct";
                quesAnswer2 = "Canterbury";
                quesAnswer3 = "Otago";
                quesAnswer4 = "Waikato";
                break;

            case 7:
                ques = "Which region is Waitomo Glowworm Caves located in?";
                quesAnswer1 = "Waikato correct";
                quesAnswer2 = "Auckland";
                quesAnswer3 = "Otago";
                quesAnswer4 = "Canterbury";
                break;

            case 8:
                ques = "Which region is Wanaka located in?";
                quesAnswer1 = "Otago correct";
                quesAnswer2 = "Auckland";
                quesAnswer3 = "Canterbury";
                quesAnswer4 = "Waikato";
                break;

            case 9:
                ques = "Which region is Hanmer Springs located in?";
                quesAnswer1 = "Canterbury correct";
                quesAnswer2 = "Auckland";
                quesAnswer3 = "Otago";
                quesAnswer4 = "Waikato";
                break;
        }
    }

    public String getAnswer() { return quesAnswer1; }

    public String getQues() { return ques; }
}
