package com.nitishkasturia.scramblechat.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.nitishkasturia.scramblechat.ScrambleChat;

import java.util.HashMap;

/**
 * Created by Nitish on 2016-01-22.
 */
public class ScrambledImageView extends View {

    //UNITS ARE DP
    private final int BORDER_SIZE = 3;

    private Context mContext;
    private Bitmap mCroppedImage;
    private Bitmap mImage;
    private HashMap<Integer, Bitmap> mScrambledImage;
    private Paint mPaint;

    //Attributes
    private int mGridSize = -1;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mBorderSizeDp = 0;
    private int mDividerSizeDp = 0;

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
        mBorderSizeDp = ScrambleChat.Utils.dpToPx(BORDER_SIZE, getResources());
        mDividerSizeDp = ScrambleChat.Utils.dpToPx(2, getResources());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mGridSize = (w - (mBorderSizeDp * 2)) / 3;
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
        this.mImage = Bitmap.createScaledBitmap(image, mGridSize * 3, mGridSize * 3, false);
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
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {

        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        canvas.drawPaint(mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mBorderSizeDp);
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
        if (mImage == null) {
            return;
        }

        if (mScrambledImage != null) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (mScrambledImage.get((i * 3) + j) != null) {
                        canvas.drawBitmap(mScrambledImage.get((i * 3) + j), (i * mGridSize) + mBorderSizeDp, (j * mGridSize) + mBorderSizeDp, mPaint);
                    }
                }
            }
        }

        mPaint.setStrokeWidth(mDividerSizeDp);

        canvas.drawLine(mGridSize, 0, mGridSize, mHeight, mPaint);
        canvas.drawLine((mGridSize * 2) + mDividerSizeDp, 0, (mGridSize * 2) + mDividerSizeDp, mHeight, mPaint);
        canvas.drawLine(0, mGridSize, mWidth, mGridSize, mPaint);
        canvas.drawLine(0, (mGridSize * 2) + mDividerSizeDp, mWidth, (mGridSize * 2) + mDividerSizeDp, mPaint);
    }
}
