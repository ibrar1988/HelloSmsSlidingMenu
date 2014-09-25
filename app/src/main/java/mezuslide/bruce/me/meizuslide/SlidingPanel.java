package mezuslide.bruce.me.meizuslide;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by bruce on 14-9-22.
 */
public class SlidingPanel extends SlidingPaneLayout implements SlidingPaneLayout.PanelSlideListener
{
    private Integer menuWidthClosed;
    private Integer menuWidthExpand;
    private Boolean isOpened = false;
    private float actiondown = 0;

    public SlidingPanel(Context context)
    {
        super(context);
        init();
        setPanelSlideListener(this);
    }

    public SlidingPanel(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
        setPanelSlideListener(this);
    }

    public SlidingPanel(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init();
        setPanelSlideListener(this);
    }

    private void init()
    {
        menuWidthClosed = getResources().getDimensionPixelOffset(R.dimen.menu_width_closed);
        menuWidthExpand = getResources().getDimensionPixelOffset(R.dimen.menu_width_expand);
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset)
    {
        Log.d("Menu offset", "" + slideOffset);
    }

    @Override
    public void onPanelOpened(View panel)
    {
        Log.d("Is menu opened ?", "Yeah !");
        isOpened = true;
    }

    @Override
    public void onPanelClosed(View panel)
    {
        Log.d("Is menu opened ?", "Nooo !");
        isOpened = false;
    }

    //    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev)
//    {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN)
//        {
//            actiondown = ev.getX();
//            return super.onInterceptTouchEvent(ev);
//        }
//
//        return (ev.getAction() == MotionEvent.ACTION_MOVE &&
//            ((isOpened && actiondown > ev.getX() && actiondown > menuWidthExpand) ||
//                (!isOpened && actiondown < ev.getX() && actiondown < menuWidthClosed)));
//    }
}