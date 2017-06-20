package com.github.ericguo.servlet.disruptor;

import com.lmax.disruptor.EventHandler;

public class ClearingEventHandler implements EventHandler<AsyncCallEvent>
{
    public void onEvent(AsyncCallEvent  event, long sequence, boolean endOfBatch)
    {
        // Failing to call clear here will result in the 
        // object associated with the event to live until
        // it is overwritten once the ring buffer has wrapped
        // around to the beginning.
        event.clear(); 
    }
}