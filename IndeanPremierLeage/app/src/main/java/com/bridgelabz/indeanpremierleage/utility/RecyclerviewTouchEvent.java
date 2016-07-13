package com.bridgelabz.indeanpremierleage.utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by bridgelabz1 on 6/7/16.
 */

public class RecyclerviewTouchEvent implements RecyclerView.OnItemTouchListener {
    GestureDetector gestureDetector;
    Context mcontext;
    private ClickListener clickListener;
    RecyclerView recyclerview;


   // public RecyclerviewTouchEvent(Context mcontext, final RecyclerView recyclerview, final ClickListener clickListener) {

      /*  this.mcontext = mcontext;
        this.clickListener = clickListener;
        this.recyclerview = recyclerview;
        gestureDetector = new GestureDetector(mcontext, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return super.onSingleTapUp(e);
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerview.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerview.getChildPosition(child));
                }

                super.onLongPress(e);
            }
        });*/
        public RecyclerviewTouchEvent(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
}
