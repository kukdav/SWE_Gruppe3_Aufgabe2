package org.c02.swe.iot.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.clock.ClockUtil;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ClockDemo {
    static IParticleApi api = new ParticleApi(new ButtonConnection());
    public static void main(String[] args) throws ParticleException {

        IButton button = new Button(api);
        ClockUtil clockUtil = new ClockUtil(button);
        Date date = new Date();
        clockUtil.show(date);
    }



}
