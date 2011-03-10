package org.sprite2d.apps.pp;

import java.io.Serializable;

import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Color;

/**
 * Brush settings driver
 * 
 * @author Artut Bikmullin (devolonter)
 * @version 1.0 
 *
 */
class BrushPreset implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public float size = 2;
	public int color = Color.BLACK;
	public Blur blurStyle = null;
	public int blurRadius = 0;
	public int type = BrushPreset.CUSTOM;
	
	public static final int PENCIL = 1;
	public static final int BRUSH = 2;
	public static final int MARKER = 3;
	public static final int PEN = 4;
	public static final int CUSTOM = 5;
	
	public BrushPreset() {}
	
	public BrushPreset(int type, int color){
		switch(type) {
			case BrushPreset.PENCIL:
				this.set(2, color, Blur.INNER, 10);
				break;
			case BrushPreset.BRUSH: 
				this.set(15, color, Blur.NORMAL, 18);
				break;
			case BrushPreset.MARKER: 
				this.set(20, color);
				break;
			case BrushPreset.PEN: 
				this.set(2, color);
				break;
		}
		
		this.setType(type);
	}
	
	public BrushPreset(float size){
		this.set(size);
	}
	
	public BrushPreset(float size, int color){
		this.set(size, color);
	}
	
	public BrushPreset(float size, Blur blurStyle, int blurRadius){
		this.set(size, blurStyle, blurRadius);
	}
	
	public BrushPreset(float size, int color, Blur blurStyle, int blurRadius){
		this.set(size, color, blurStyle, blurRadius);
	}
	
	public void set(float size){
		this.setSize(size);
	}
	
	public void set(float size, int color){
		this.setSize(size);
		this.setColor(color);
	}
	
	public void set(float size, Blur blurStyle, int blurRadius){
		this.setSize(size);
		this.setBlur(blurStyle, blurRadius);
	}
	
	public void set(float size, int color, Blur blurStyle, int blurRadius){
		this.setSize(size);
		this.setBlur(blurStyle, blurRadius);
		this.setColor(color);
	}
	
	public void setColor(int color) {
		if(this.color != color){
			this.setType(BrushPreset.CUSTOM);
		}
		this.color = color;	
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setSize(float size) {
		if(this.size != size){
			this.setType(BrushPreset.CUSTOM);
		}
		this.size = (size > 0) ? size : 1;
	}
	
	public void setBlur(Blur blurStyle, int blurRadius) {
		if(this.blurStyle != blurStyle || this.blurRadius != blurRadius){
			this.setType(BrushPreset.CUSTOM);
		}
		this.blurStyle = blurStyle;
		this.blurRadius = blurRadius;
	}
}