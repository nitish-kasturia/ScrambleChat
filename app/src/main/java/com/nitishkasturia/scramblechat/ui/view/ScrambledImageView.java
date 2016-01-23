package com.nitishkasturia.scramblechat.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashMap;

/**
 * Created by Nitish on 2016-01-22.
 */
public class ScrambledImageView extends View {

    private Context mContext;
    private Bitmap mCroppedImage;
    private Bitmap mImage;
    private HashMap<Integer, Bitmap> mScrambledImage;
    private Paint mPaint;

    //Attributes
    private int mGridSize = -1;
    private int mWidth = 0;
    private int mHeight = 0;

    public ScrambledImageView(Context context) {
        super(context);
        initialize(context);
    }

    public ScrambledImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public ScrambledImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        this.mContext = context;
        this.mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setFilterBitmap(true);
        mPaint.setDither(true);
        mScrambledImage = new HashMap<>();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mGridSize = (w - 10 - 4) / 3;
        mWidth = w;
        mHeight = h;
        if (mImage != null) {
            setImage(mImage);
        }
    }

    public void setImage(Bitmap image) {
        if (mWidth == 0) {
            mImage = image;
            return;
        }
        this.mImage = Bitmap.createScaledBitmap(image, mWidth - 10, mHeight - 10, false);
        Bitmap croppedImage;
        if (mGridSize != -1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    croppedImage = Bitmap.createBitmap(mImage, i * mGridSize, j * mGridSize, mGridSize, mGridSize);
                    mScrambledImage.put((i * 3) + j, croppedImage);
                }
            }
            mScrambledImage.put(8, null);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        canvas.drawPaint(mPaint);
        if (mImage == null) {
            return;
        }
        if (mScrambledImage != null) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (mScrambledImage.get((i * 3) + j) != null) {
                        canvas.drawBitmap(mScrambledImage.get((i * 3) + j), i * mGridSize, j * mGridSize, mPaint);
                    }
                }
            }
        }
    }
}
