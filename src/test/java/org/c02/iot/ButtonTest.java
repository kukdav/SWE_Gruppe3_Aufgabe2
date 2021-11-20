package org.c02.iot;

import org.c02.iot.effect.test.WhiteLedRunningTest;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.IEffect;
import org.c02.swe.iot.effect.WhiteLedRunning;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;

public class ButtonTest {
    @Test
    public void testWrapper() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.allLedsOff();

        Mockito.verify(api).callMethod("ledsOff", null);

    }
    @Test
    public void testWrapperLed() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(1, Color.white);

        Mockito.verify(api).callMethod("led", "01255255255");

    }

    @Test
    public void testWrapperLedStatus() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(new LedStatus(1,Color.white));
        Mockito.verify(api).callMethod("led", "01255255255");

    }

    @Test
    public void testWrapperLedStatuses() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);
        LedStatus[] statuses = {
            new LedStatus(1, Color.white),
            new LedStatus(3, Color.red)
        };


        for (LedStatus status : statuses) {
            testButton.setLed(status);

            if(status.getColor() == Color.white) {
                Mockito.verify(api).callMethod("led", "01255255255"); //white
            }
            else if(status.getColor() == Color.red) {
                Mockito.verify(api).callMethod("led", "03255000000"); //red
            }

        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrapperLedInvalid() throws ParticleException {

        IParticleApi api = Mockito.mock(IParticleApi.class);

        Button testButton = new Button(api);

        testButton.setLed(-1, Color.white);

    }

}
