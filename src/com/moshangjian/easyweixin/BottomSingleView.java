package com.moshangjian.easyweixin;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

public class BottomSingleView extends View {

	public BottomSingleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initAttri(context , attrs, defStyle);
		init(context);
	}
	public BottomSingleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAttri(context , attrs, 0);
		init(context);
	}
	public BottomSingleView(Context context) {
		super(context);
		init(context);
	}
	
	
	private void initAttri(Context context , AttributeSet attrs ,  int defStyle){
		Resources resources = getResources();
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.easyweixin, defStyle, 0);
		textColor = typedArray.getColor(R.styleable.easyweixin_textColor, Color.BLUE ) ;
		textSize = typedArray.getDimensionPixelSize(R.styleable.easyweixin_textSize, resources.getDimensionPixelSize(R.dimen.defult_text_size)) ;
		text = typedArray.getString(R.styleable.easyweixin_text ) ; 
		normalBitmap = ((BitmapDrawable)typedArray.getDrawable(R.styleable.easyweixin_normalBitmp)).getBitmap(); 
		pitchBitmap = ((BitmapDrawable)typedArray.getDrawable(R.styleable.easyweixin_pitchBitmp)).getBitmap(); 
		typedArray.recycle();  
	}
	
	private Bitmap normalBitmap ; 
	private Bitmap pitchBitmap ; 
	private int textColor ; 
	private int textSize  ; 
	private String text ; 
	
	private  void init(Context context){
		if (normalBitmap == null  || pitchBitmap == null ) {
			throw new RuntimeException("please give normalBitmap  and pitchBitmap  values ") ; 
		}
		bitmapPaint = new Paint();
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.save() ;
		bitmapPaint.setAlpha(255 - currentAlpha );
		canvas.drawBitmap(normalBitmap, 0, 0, bitmapPaint);
		bitmapPaint.setAlpha(currentAlpha );
		canvas.drawBitmap(pitchBitmap, 0, 0 , bitmapPaint);
		canvas.restore();  
	}
	
	private Paint bitmapPaint; 
	
	private int currentAlpha = 0 ; 
	
	public void setProgress(int progress){
		if (progress > 100) {
			throw new RuntimeException("progress do not > 100") ; 
		}
		currentAlpha = 255 * progress / 100 ; 
		invalidate(); 
	}
	
	
	
	
	
	
	
	
	

}
