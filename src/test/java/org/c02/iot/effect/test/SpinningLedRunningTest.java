package org.c02.iot.effect.test;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningLED;
import org.c02.swe.iot.examples.SpinningLedDemo;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

public class SpinningLedRunningTest {


    @Test
    public void testReset() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        Color color = Color.RED;
        int cycle = 2;

        SpinningLED poc = new SpinningLED(buttonInstance,color,cycle);
        poc.reset();

        Mockito.verify(buttonInstance).allLedsOff();
        Mockito.verifyNoMoreInteractions(buttonInstance);
    }

    /*@Test
    public void testOneTick() throws ParticleException{
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        Color color = Color.RED;
        int cycle = 2;

        SpinningLED poc = new SpinningLED(buttonInstance,color,cycle);

        Assert.assertTrue(poc.next());

        Mockito.verify(buttonInstance).setLed(1, Color.red);
        Mockito.verifyNoMoreInteractions(buttonInstance);
    }


    @Test
    public void testSequenceTwoTicks() throws ParticleException{
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        Color color = Color.RED;
        int cycle = 2;

        SpinningLED poc = new SpinningLED(buttonInstance,color,cycle);

        Assert.assertTrue(poc.next());
        Assert.assertTrue(poc.next());

        InOrder inOrder = Mockito.inOrder(buttonInstance);

        inOrder.verify(buttonInstance).setLed(1, Color.blue);
        inOrder.verify(buttonInstance).setLed(2, Color.green);

        inOrder.verifyNoMoreInteractions();
    } */

    @Test
    public void testSequence() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        Color color = Color.RED;
        int cycle = 1;

        SpinningLED poc = new SpinningLED(buttonInstance,color,cycle);

        poc.next();

        InOrder inOrder = Mockito.inOrder(buttonInstance);
        for (int count = 1; count <= 11; count++) {
            inOrder.verify(buttonInstance).setLed(count, color);
        }
        inOrder.verify(buttonInstance).allLedsOff();
        inOrder.verifyNoMoreInteractions();
    }

}
