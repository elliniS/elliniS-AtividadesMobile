package com.example.paint;

import android.graphics.Paint;
import android.graphics.Path;

public class Traco {
    Paint mPaint;
    Path mPath;

    public Traco(){
        mPaint = new Paint();
        mPath = new Path();
    }
    public Traco(Paint paint, Path path){
        mPaint = paint;
        mPath = path;
    }
}
