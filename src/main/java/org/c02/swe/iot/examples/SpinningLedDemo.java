package org.c02.swe.iot.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.IEffect;
import org.c02.swe.iot.effect.SpinningLED;
import org.c02.swe.iot.effect.SpinningWheel;

import java.awt.*;

public class SpinningLedDemo {

    static IParticleApi api = new ParticleApi(new ButtonConnection());

    public static void main(String[] args) throws ParticleException {

        Button button = new Button(api);

        Color color = Color.RED;
        int cycle = 3;

        IEffect running = new SpinningLED(button,color,cycle);

        running.next();

    }

}
