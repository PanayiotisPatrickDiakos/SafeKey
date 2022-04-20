package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ModuleQuizActivity extends AppCompatActivity {
    private static final String TAG = "ModuleQuizActivity";
    private TextView mQuizName, mTimer;
    private TextView mQuestion, mQuestions;
    private AppCompatButton mOptionA, mOptionB, mOptionC, mOptionD;
    private AppCompatButton mNext;
    private Timer quizTimer;
    private int totalTimeInMins = 0;
    private int seconds = 10;
    private List<QuestionsList> questionsList;
    private int currentQuestionPosition = 0;
    private String selectedOptionByUser = "";


    public static final String INTENT_MESSAGE = "intent_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_quiz);


        mQuizName = findViewById(R.id.quiz_Name);
        mTimer = findViewById(R.id.timer);

        mQuestion = findViewById(R.id.quiz_question);
        mQuestions = findViewById(R.id.questions_counter);

        mOptionA = findViewById(R.id.optionA);
        mOptionB = findViewById(R.id.optionB);
        mOptionC = findViewById(R.id.optionC);
        mOptionD = findViewById(R.id.optionD);

        mNext = findViewById(R.id.quiz_next);

        Intent intent = getIntent();
        if (intent.hasExtra(INTENT_MESSAGE)) {
            String moduleSymbol = getIntent().getStringExtra(INTENT_MESSAGE);
            Log.d(TAG, "INTENT_MESSAGE = " + moduleSymbol);
            Module module = Module.getModule(moduleSymbol);

            if (module != null) {
                mQuizName.setText(module.getName());
                Log.d(TAG, "Set mQuizName text:" + module.getName());
            }
        }

        questionsList = QuestionsBank.getQuestions(String.valueOf(mQuizName.getText()));
        Log.d(TAG, "Got quiz name");
        for (QuestionsList temp : questionsList) {
            Log.d(TAG, String.valueOf(temp));
        }
        mQuestions.setText((currentQuestionPosition + 1) + "/" + questionsList.size());
        mQuestion.setText(questionsList.get(0).getQuestion());
        mOptionA.setText(questionsList.get(0).getOptionA());
        mOptionB.setText(questionsList.get(0).getOptionB());
        mOptionC.setText(questionsList.get(0).getOptionC());
        mOptionD.setText(questionsList.get(0).getOptionD());

        mOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = String.valueOf(mOptionA.getText());
                    Log.d(TAG, selectedOptionByUser);
                    mOptionA.setBackgroundResource(R.drawable.round_back_red10);
                    mOptionA.setTextColor(getResources().getColor(R.color.grey_white));

                    revealAnswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        mOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = String.valueOf(mOptionB.getText());
                    mOptionB.setBackgroundResource(R.drawable.round_back_red10);
                    mOptionB.setTextColor(getResources().getColor(R.color.grey_white));

                    revealAnswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        mOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = String.valueOf(mOptionC.getText());
                    mOptionC.setBackgroundResource(R.drawable.round_back_red10);
                    mOptionC.setTextColor(getResources().getColor(R.color.grey_white));

                    revealAnswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        mOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = String.valueOf(mOptionD.getText());
                    mOptionD.setBackgroundResource(R.drawable.round_back_red10);
                    mOptionD.setTextColor(getResources().getColor(R.color.grey_white));

                    revealAnswer();
                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    mNext.setEnabled(false);
                } else {
                    mNext.setEnabled(true);
                    changeNextQuestion();
                }
            }
        });
        startTimer(mTimer);
    }

    private void changeNextQuestion() {
        currentQuestionPosition++;
        if((currentQuestionPosition + 1) == questionsList.size()) {
            mNext.setText("Finish Quiz");
        }

        if(currentQuestionPosition < questionsList.size()) {
            selectedOptionByUser = "";

            mOptionA.setBackgroundResource(R.drawable.round_back_white10);
            mOptionA.setTextColor(getResources().getColor(R.color.black_overlay));

            mOptionB.setBackgroundResource(R.drawable.round_back_white10);
            mOptionB.setTextColor(getResources().getColor(R.color.black_overlay));

            mOptionC.setBackgroundResource(R.drawable.round_back_white10);
            mOptionC.setTextColor(getResources().getColor(R.color.black_overlay));

            mOptionD.setBackgroundResource(R.drawable.round_back_white10);
            mOptionD.setTextColor(getResources().getColor(R.color.black_overlay));

            mQuestions.setText((currentQuestionPosition + 1) + "/" + questionsList.size());
            mQuestion.setText(questionsList.get(currentQuestionPosition).getQuestion());
            mOptionA.setText(questionsList.get(currentQuestionPosition).getOptionA());
            mOptionB.setText(questionsList.get(currentQuestionPosition).getOptionB());
            mOptionC.setText(questionsList.get(currentQuestionPosition).getOptionC());
            mOptionD.setText(questionsList.get(currentQuestionPosition).getOptionD());
        } else {
            Intent intent = new Intent(ModuleQuizActivity.this, ModuleQuizResultsActivity.class);
            String correctAnswers = String.valueOf(getCorrectAnswers());
            intent.putExtra("correct", correctAnswers);
            intent.putExtra("incorrect", getIncorrectAnswers());
            startActivity(intent);
            finish();
        }
    }

    private void startTimer(TextView timerTextView) {
        long duration = TimeUnit.MINUTES.toMillis(1);
        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(totalTimeInMins == 0 && seconds == 0) {

                    quizTimer.purge();
                    quizTimer.cancel();
                    Intent intent = new Intent(ModuleQuizActivity.this, ModuleQuizResultsActivity.class);
                    String correctAnswers = String.valueOf(getCorrectAnswers());
                    intent.putExtra("correct", correctAnswers);
                    intent.putExtra("incorrect", getIncorrectAnswers());
                    startActivity(intent);

                    finish();
                } else if(seconds == 0) {
                    totalTimeInMins--;
                    seconds = 59;
                } else {
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1) {
                            finalMinutes = "0" + finalMinutes;
                        }

                        if(finalSeconds.length() == 1) {
                            finalSeconds = "0" + finalSeconds;
                        }

                        timerTextView.setText(finalMinutes + ":" + finalSeconds);
                    }
                });
            }
        }, 1000, 1000);
    }



    private int getCorrectAnswers() {
        int correctAnswers = 0;
        for(int i = 0; i < questionsList.size(); i++) {
            String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            String getCorrectAnswer = questionsList.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getCorrectAnswer)){
                correctAnswers++;
            }
        }
        Log.d(TAG, "RESULTS" + String.valueOf(correctAnswers));
        return correctAnswers;
    }

    private int getIncorrectAnswers() {
        int correctAnswers = 0;
        for(int i = 0; i < questionsList.size(); i++) {
            String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            String getCorrectAnswer = questionsList.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getCorrectAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed () {
        quizTimer.purge();
        quizTimer.cancel();
        startActivity(new Intent(ModuleQuizActivity.this, MainActivity.class));
        finish();
    }

    private void revealAnswer() {
        String getAnswer = questionsList.get(currentQuestionPosition).getAnswer();
        Log.d(TAG, getAnswer);
        if(mOptionA.getText().toString().equals(getAnswer)) {
            mOptionA.setBackgroundResource(R.drawable.round_back_green10);
            mOptionA.setTextColor(getResources().getColor(R.color.grey_white));
        } else if(mOptionB.getText().toString().equals(getAnswer)) {
            mOptionB.setBackgroundResource(R.drawable.round_back_green10);
            mOptionB.setTextColor(getResources().getColor(R.color.grey_white));
        } else if(mOptionC.getText().toString().equals(getAnswer)) {
            mOptionC.setBackgroundResource(R.drawable.round_back_green10);
            mOptionC.setTextColor(getResources().getColor(R.color.grey_white));
        } else if(mOptionD.getText().toString().equals(getAnswer)) {
            mOptionD.setBackgroundResource(R.drawable.round_back_green10);
            mOptionD.setTextColor(getResources().getColor(R.color.grey_white));
        }
    }

}