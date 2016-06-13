package techkids.mad3.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnClick;
    private int mWidth, mHeight;

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
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(btnClick, "x", btnClick.getX(), mWidth - btnClick.getWidth());
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(btnClick, "y", btnClick.getX(), mHeight - btnClick.getHeight());
        objectAnimatorX.setDuration(5000);
        objectAnimatorY.setDuration(5000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorX, objectAnimatorY);
        animatorSet.start();
    }

}
