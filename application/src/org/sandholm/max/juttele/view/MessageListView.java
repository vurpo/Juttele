/*
Yaaic - Yet Another Android IRC Client

Copyright 2009-2013 Sebastian Kaspari

This file is part of Yaaic.

Yaaic is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Yaaic is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Yaaic.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sandholm.max.juttele.view;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import org.sandholm.max.juttele.listener.MessageClickListener;

/**
 * A customized ListView for Messages
 *
 * @author Sebastian Kaspari <sebastian@yaaic.org>
 */
public class MessageListView extends ListView
{
    /**
     * Create a new MessageListView
     *
     * @param context
     */
    public MessageListView(Context context)
    {
        super(context);

        setOnItemClickListener(MessageClickListener.getInstance());

        // Scale padding by screen density
        float density = context.getResources().getDisplayMetrics().density;
        int padding = (int) (8 * density);
        setPadding(padding, 0, padding, 0);

        setDivider(getResources().getDrawable(android.R.color.transparent));
        setDividerHeight(padding);

        View paddingView = new View(context);
        paddingView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 0));
        setOverScrollMode(OVER_SCROLL_NEVER);
        setStackFromBottom(true);
        addFooterView(paddingView);
        //addHeaderView(paddingView);


        setTranscriptMode(TRANSCRIPT_MODE_NORMAL);
    }
}
