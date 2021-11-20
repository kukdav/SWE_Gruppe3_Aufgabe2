package org.c02.swe.iot.effect;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class SpinningWheel extends AbstractEffect {

    protected int count = 1;
    int cycle;

    public SpinningWheel(IButton button, int cycle) {
        super(button);

        this.cycle = cycle;
    }

    @Override
    public boolean next() throws ParticleException {

        for (int i = 0;i<cycle;i++)
        {
            for (int j = 1; j <= 11; j++) {
                count = j;
                button.allLedsOff();
                if (count%2 == 0 ) button.setLed(count, Color.red);
                else button.setLed(count,Color.blue);
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
