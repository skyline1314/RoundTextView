package com.skyline.roundedittext.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

import com.skyline.roundedittext.R;

/**
 * Created by skyline on 2017/9/29.
 */
public class RoundTextView extends TextView {

    private int border_width;
    private int border_color;
    private int radius;
    private int left_top_radiu;
    private int left_bottom_radiu;
    private int right_top_radiu;
    private int right_bottom_radiu;
    private int press_border_color;
    private boolean isPress = false;
    private int press_backgroud;
    private int normal_backgroud;
    private int press_text_color;
    private int normal_text_color;
    private GradientDrawable drawable;

    public RoundTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public RoundTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public RoundTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundTextView);
        border_width = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_border_widht, 0);
        border_color = typedArray.getColor(R.styleable.RoundTextView_normal_border_color, 0);
        press_text_color = typedArray.getColor(R.styleable.RoundTextView_press_text_color, 0);
        press_backgroud = typedArray.getColor(R.styleable.RoundTextView_press_backgroud, 0);
        press_border_color = typedArray.getColor(R.styleable.RoundTextView_press_border_color, 0);
        radius = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_radius, 0);
        left_top_radiu = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_left_top_radiu, 0);
        left_bottom_radiu = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_left_bottom_radiu, 0);
        right_top_radiu = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_right_top_radiu, 0);
        right_bottom_radiu = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_right_bottom_radiu, 0);

        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            normal_backgroud = ((ColorDrawable) background).getColor();
        } else {
            normal_backgroud = 0;
        }
        ColorStateList colors = getTextColors();
        normal_text_color = colors.getColorForState(getDrawableState(), 0);

        drawable = new GradientDrawable();
        setDrawable();
    }

    private void setDrawable() {
        if (left_top_radiu > 0 || left_bottom_radiu > 0 || right_top_radiu > 0 || right_bottom_radiu > 0) {
            float[] radii = new float[]{
                    left_top_radiu, left_top_radiu,
                    left_bottom_radiu, left_bottom_radiu,
                    right_top_radiu, right_top_radiu,
                    right_bottom_radiu, right_bottom_radiu
            };
            drawable.setCornerRadii(radii);
        } else {
            drawable.setCornerRadius(radius);
        }


        if (isPress) {
            if (press_border_color != 0) {
                drawable.setStroke(border_width, press_border_color);
            }

            if (press_backgroud != 0) {
                drawable.setColor(press_backgroud);
            }
            if (press_text_color != 0) {
                setTextColor(press_text_color);
            }

        } else {
            drawable.setStroke(border_width, border_color);
            setTextColor(normal_text_color);
            drawable.setColor(normal_backgroud);
        }
        setBackgroundDrawable(drawable);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //如果没有则不重新设置drawable
        if (!bPressAttr()) {
            return super.onTouchEvent(event);
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            isPress = false;
        } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
            isPress = true;
        }
        setDrawable();
        return true;
    }


    //是否设置有按压属性
    private boolean bPressAttr() {
        if (press_text_color != 0 || press_backgroud != 0 || press_border_color != 0) {
            return true;
        }
        return false;
    }

    public int getLeft_bottom_radiu() {
        return left_bottom_radiu;
    }

    public void setLeft_bottom_radiu(int left_bottom_radiu) {
        this.left_bottom_radiu = left_bottom_radiu;
        setDrawable();
    }

    public int getRight_top_radiu() {
        return right_top_radiu;
    }

    public void setRight_top_radiu(int right_top_radiu) {
        this.right_top_radiu = right_top_radiu;
        setDrawable();
    }

    public int getRight_bottom_radiu() {
        return right_bottom_radiu;
    }

    public void setRight_bottom_radiu(int right_bottom_radiu) {
        this.right_bottom_radiu = right_bottom_radiu;
        setDrawable();
    }

    public int getPress_border_color() {
        return press_border_color;
    }

    public void setPress_border_color(int press_border_color) {
        this.press_border_color = press_border_color;
        setDrawable();
    }

    public int getBorder_width() {
        return border_width;
    }

    public void setBorder_width(int border_width) {
        this.border_width = border_width;
        setDrawable();
    }

    public int getBorder_color() {
        return border_color;
    }

    public void setBorder_color(int border_color) {
        this.border_color = border_color;
        setDrawable();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        setDrawable();
    }

    public int getLeft_top_radiu() {
        return left_top_radiu;
    }

    public void setLeft_top_radiu(int left_top_radiu) {
        this.left_top_radiu = left_top_radiu;
        setDrawable();
    }

    public int getPress_backgroud() {
        return press_backgroud;
    }

    public void setPress_backgroud(int press_backgroud) {
        this.press_backgroud = press_backgroud;
        setDrawable();
    }

    public int getNormal_backgroud() {
        return normal_backgroud;
    }

    public void setNormal_backgroud(int normal_backgroud) {
        this.normal_backgroud = normal_backgroud;
        setDrawable();
    }

    public int getPress_text_color() {
        return press_text_color;
    }

    public void setPress_text_color(int press_text_color) {
        this.press_text_color = press_text_color;
        setDrawable();
    }

    public int getNormal_text_color() {
        return normal_text_color;
    }

    public void setNormal_text_color(int normal_text_color) {
        this.normal_text_color = normal_text_color;
        setDrawable();
    }
}
