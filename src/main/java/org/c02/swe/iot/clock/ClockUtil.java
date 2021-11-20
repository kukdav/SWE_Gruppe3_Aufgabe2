package org.c02.swe.iot.clock;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.util.Date;


public class ClockUtil {




    public ClockUtil(IButton button) {
        IButton btn = button;

    }

    public void show(Date date) throws ParticleException {
        int hour = date.getHours();
        int min = date.getMinutes();
        int sec = date.getSeconds();

        int hourpos;

        int minpos = min / 5;
        int secpos = sec / 5;

        if (minpos == 12) {  }


    }



}
