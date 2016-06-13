package techkids.mad3.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private Button btnClick;
    private int mWidth, mHeight;
    private RelativeLayout relLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initComponent();
    }


    private void initComponent()
    {
        btnClick = (Button) this.findViewById(R.id.btnClick);
        DisplayMetrics displayMatrics = new DisplayMetrics();
        ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMatrics);
        mWidth = displayMatrics.widthPixels;
        mHeight = displayMatrics.heightPixels;
        relLayout = (RelativeLayout) this.findViewById(R.id.relLayout);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        Log.d("ABC", "X: "+ String.valueOf(btnClick.getX()));
        Log.d("ABC", "btn Width: "+ String.valueOf(btnClick.getWidth()));
        Log.d("ABC", "screen Width: "+ String.valueOf(mWidth));
        Log.d("ABC", "btn Height:" + String.valueOf(btnClick.getHeight()));
        Log.d("ABC", "screen Height: " + String.valueOf(mHeight));
        Log.d("ABC", "relaytive layout Width:" + String.valueOf(relLayout.getWidth()));
        Log.d("ABC", "relaytive layout Height:" + String.valueOf(relLayout.getHeight()));
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(btnClick, "x", btnClick.getWidth(), relLayout.getWidth() - btnClick.getWidth());
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(btnClick, "y", btnClick.getHeight(), relLayout.getHeight() - btnClick.getHeight());
        objectAnimatorX.setDuration(5000);
        objectAnimatorY.setDuration(5000);
        objectAnimatorX.setRepeatMode(Animation.REVERSE);
        objectAnimatorX.setRepeatCount(Animation.INFINITE);
        objectAnimatorY.setRepeatMode(Animation.REVERSE);
        objectAnimatorY.setRepeatCount(Animation.INFINITE);

        objectAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int time = (int) animation.getCurrentPlayTime() / 1000;
                switch (time) {
                    case 1:
                        btnClick.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_cricle));
                        break;
                    case 2:
                        btnClick.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_parallelogram));
                        break;
                    case 3:
                        btnClick.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_diamond));
                        break;
                    case 4:
                        btnClick.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_triangle));
                        break;
                    default:
                        btnClick.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_rectangle));
                        break;
                }
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorX, objectAnimatorY);
        animatorSet.start();
    }

}



