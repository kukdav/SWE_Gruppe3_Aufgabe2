package org.c02.iot.effect.test;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.c02.swe.iot.effect.SpinningWheel;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.awt.*;

public class SpinningLedRedBlueRunningTest {


    @Test
    public void testReset() throws ParticleException {
        //setup
        IButton buttonInstance = Mockito.mock(IButton.class);
        Color color = Color.RED;
        int cycle = 2;

        SpinningWheel poc = new SpinningWheel(buttonInstance,cycle);
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
        int cycle = 1;

        SpinningWheel poc = new SpinningWheel(buttonInstance,cycle);

        poc.next();

        InOrder inOrder = Mockito.inOrder(buttonInstance);
        int hilfe = cycle * 11;

        for (int count = 1; count <= hilfe; count++) {

            if (count % 2 == 0) {inOrder.verify(buttonInstance).setLed(count, Color.red);}
            else {inOrder.verify(buttonInstance).setLed(count, Color.blue);}

        }

        inOrder.verify(buttonInstance).allLedsOff();
        inOrder.verifyNoMoreInteractions();
    }

}
