package techkids.mad3.animation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by TrungNT on 6/14/2016.
 */
public class CustomButton extends Button {
    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void setXValue(float x)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(displayMetrics);
        int mWidth = displayMetrics.widthPixels - this.getWidth();

        setX(mWidth > 0 ? x * mWidth : 0);
    }

    private float getXValue()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(displayMetrics);
        int mWidth = displayMetrics.widthPixels - this.getWidth();

        return  (mWidth == 0) ? 0 : getX() / (float) mWidth;
    }

    private void setYValue(float y)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(displayMetrics);
        int mHeight = displayMetrics.heightPixels - this.getWidth();

        setY(mHeight > 0 ? y * mHeight : 0);
    }

    private float getYValue()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(displayMetrics);
        int mHeight = displayMetrics.heightPixels - this.getWidth();

        return (mHeight == 0) ? 0 : getY() / (float) mHeight;
    }

//    //du lieu dau vao la toa do x voi don vi la pixel
//    public void convertPixeToDP(float xPixel)
//    {
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
//
//        float xDP = xPixel * (displayMetrics.densityDpi /160f);
//    }
}
