package org.c02.swe.iot.effect;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningLED extends AbstractEffect {

    protected int count = 1;
    Color color;
    int cycle;

    public SpinningLED(IButton button, Color color, int cycle) {
        super(button);
        this.color = color;
        this.cycle = cycle;
    }

    @Override
    public boolean next() throws ParticleException {

        for (int i = 0;i<cycle;i++)
        {
            for (int j = 1; j <= 11; j++) {
                count = j;
                button.allLedsOff();
                button.setLed(count, color);
            }
            button.allLedsOff();
        }
        return true;
    }

    @Override
    public void reset() throws ParticleException{
        button.allLedsOff();
    }
}
