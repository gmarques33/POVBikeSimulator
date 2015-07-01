package br.com.povbike.povbike.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import br.com.povbike.povbike.R;

/**
 * Created by gmarques on 01/07/15.
 */
public class LedBoard extends View {

    private List<Byte> mBytes;

    private RectF mRecF;
    private Paint mPaint;

    public LedBoard(Context context) {
        super(context);
    }

    public LedBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LedBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LedBoard(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mRecF = new RectF(getPaddingLeft(),
                getPaddingTop(),
                getLayoutParams().width - getPaddingRight(),
                getLayoutParams().height - getPaddingBottom());

        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#D33B27"));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(getResources().getDimension(R.dimen.led_stroke));
        mPaint.setAntiAlias(true);
    }

    public void setBytes(List<Byte> bytes) {
        mBytes = bytes;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mBytes != null) {
            for(int i = 0; i < mBytes.size(); i++) {
                Byte currentByte = mBytes.get(i);
                for (int c = 0; c < 8; c++) {
                    if (checkBit(currentByte, c)) {
                        canvas.drawArc(getRectLed(c), 270 + ((360f / mBytes.size()) * i), 360f / mBytes.size(), false, mPaint);
                    }
                }
            }
        }
    }

    private RectF getRectLed(int index) {
        float spacing = getResources().getDimension(R.dimen.led_spacing)*index;
        return new RectF(getPaddingLeft()+spacing,
                getPaddingTop()+spacing,
                getLayoutParams().width - getPaddingRight() - spacing,
                getLayoutParams().height - getPaddingBottom() - spacing);
    }

    public boolean checkBit(Byte id, int position)
    {
        return ((id >> position) & 1) == 1;
    }

}
