package com.example.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SimplePaint extends View{
    Paint currentPaint;
    Path currentPath;
    ColorDrawable currentColor;
    int currentStroke;
    Shape mShape;
    float x0, y0;
    ArrayList<Traco> tracos;

    public enum Shape{LINHA, CIRCULO, QUADRADO}

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        tracos = new ArrayList<Traco>();
        currentColor = new ColorDrawable();
        currentColor.setColor(Color.BLACK);
        currentStroke = 10;
        setupPaint();
    }

    private void setupPaint() {
        currentPaint = new Paint();
        currentPath = new Path();
        currentPaint.setColor(currentColor.getColor());
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeWidth(currentStroke);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x1 = event.getX();
        float y1 = event.getY();

        switch (event.getAction()){
            case (MotionEvent.ACTION_DOWN):
                x0 = x1;
                y0 = y1;
                currentPath.moveTo(x1,y1);
                currentPath.lineTo(x1, y1);
                break;
            case (MotionEvent.ACTION_MOVE):
                switch (mShape){
                    case LINHA:
                        currentPath.lineTo(x1, y1);
                        break;
                    case QUADRADO:
                        float xg, xp, yg, yp;
                        currentPath.reset();
                        if(x0 < x1){
                            xg = x1;
                            xp = x0;
                        }else {
                            xg = x0;
                            xp = x1;
                        }

                        if(y0 < y1){
                            yg = y1;
                            yp = y0;
                        }else {
                            yg = y0;
                            yp = y1;
                        }
                        currentPath.addRect(xp, yp, xg, yg, Path.Direction.CCW);
                        break;
                    case CIRCULO:
                        currentPath.reset();
                        float centerX = (x0 + x1) / 2;
                        float centerY = (y0 + y1) / 2;
                        currentPath.addCircle(centerX ,centerY, pitagorico(x0, y0, x1, y1)/2, Path.Direction.CCW);
                }
                break;
            case (MotionEvent.ACTION_UP):
                tracos.add(new Traco(currentPaint, currentPath));
                setupPaint();
                break;
        }

       invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < tracos.size(); i++){
            canvas.drawPath(tracos.get(i).mPath, tracos.get(i).mPaint);
        }
        canvas.drawPath(currentPath, currentPaint);
    }

    public void setColor(Color color) {
        currentColor.setColor(color.toArgb());
        currentPaint.setColor(color.toArgb());
    }

    public void setForma(Shape shape){
        mShape = shape;
    }

    public void voltaLinha() {
        if (tracos.size() > 0){
            tracos.remove(tracos.size() - 1);
        }
        invalidate();
    }

    public void deleta(){
        tracos = new ArrayList<Traco>();
        invalidate();
    }

    public float pitagorico(float x0, float y0, float x1, float y1){
        return (float)Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0) );
    }
}
