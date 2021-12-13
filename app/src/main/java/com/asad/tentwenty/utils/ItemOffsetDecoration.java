package com.asad.tentwenty.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

    private final int leftMargin;
    private final int topMargin;
    private final int rightMargin;
    private final int bottomMargin;

    public ItemOffsetDecoration(int leftMargin, int topMargin,
                                int rightMargin, int bottomMargin) {
        this.leftMargin = leftMargin;
        this.topMargin = topMargin;
        this.rightMargin = rightMargin;
        this.bottomMargin = bottomMargin;
    }

    public ItemOffsetDecoration(@NonNull Context context, @DimenRes int leftMargin
            , @DimenRes int rightMargin
            , @DimenRes int bottomMargin
            , @DimenRes int topMargin) {
        this(context.getResources().getDimensionPixelSize(leftMargin)
                , context.getResources().getDimensionPixelSize(topMargin),
                context.getResources().getDimensionPixelSize(rightMargin),
                context.getResources().getDimensionPixelSize(bottomMargin));
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(leftMargin, topMargin, rightMargin, bottomMargin);
    }

}