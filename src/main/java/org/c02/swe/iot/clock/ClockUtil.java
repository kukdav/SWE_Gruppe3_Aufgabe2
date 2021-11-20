package org.c02.swe.iot.clock;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ClockUtil {


    IButton btn;

    public ClockUtil(IButton button) {
        this.btn = button;

    }

    public void show(Date date) throws ParticleException {
        int hour = date.getHours();
        int min = date.getMinutes();
        int sec = date.getSeconds();

        if (hour>=12){hour-=12;}
        int minpos = min / 5;
        int secpos = sec / 5;


        List<LedStatus> statuses = new ArrayList<LedStatus>();
        statuses.add(new LedStatus(hour, Color.red));
        statuses.add(new LedStatus(minpos, Color.green));
        statuses.add(new LedStatus(secpos, Color.blue));

        this.btn.setLeds(statuses);


    }




}
