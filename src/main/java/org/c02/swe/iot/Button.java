package org.c02.swe.iot;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;
import java.util.List;

public class Button implements IButton {

    static IParticleApi api;
    private Object ParticleException;
    private Object IllegalArgumentException;

    public Button(IParticleApi wrapperInstance) {
        this.api = wrapperInstance;
    }


    public void setLed(int position, Color color) throws ParticleException {
        // nn = Position 01-12
        // rrr = rot
        // ggg = grün
        // bbb = blau
        // nnrrrgggbbb

        //String convcolor = ;

        String pos;

        if (position <= 0 || position >= 12) throw new IllegalArgumentException();



        if (position <= 9) {
            pos = "0"+ String.valueOf(position);
        } else {
            pos = String.valueOf(position);
        }

        int red = color.getRed();
        int blue = color.getBlue();
        int green = color.getGreen();

        if (red < 10) { pos += "00" + String.valueOf(red); }
        else if (red < 100){ pos += "0" + String.valueOf(red); }
        else { pos += String.valueOf(red); }

        if (blue < 10) { pos += "00" + String.valueOf(blue); }
        else if (blue < 100){ pos += "0" + String.valueOf(blue); }
        else { pos += String.valueOf(blue); }

        if (green < 10) { pos += "00" + String.valueOf(green); }
        else if (green < 100){ pos += "0" + String.valueOf(green); }
        else { pos += String.valueOf(green); }

        api.callMethod("led", pos);

    }

    public void allLedsOff() throws ParticleException {
        api.callMethod("ledsOff", null);
    }


    // ignore unitl setup 3
    public void setLed(LedStatus status) throws ParticleException {

        int position = status.getPosition();
        Color color = status.getColor();

        setLed(position,color);

    }

    public void setLeds(List<LedStatus> statuses) throws ParticleException {
        for (LedStatus status : statuses) {

            int position = status.getPosition();
            Color color = status.getColor();

            setLed(position,color);

        }

    }


}