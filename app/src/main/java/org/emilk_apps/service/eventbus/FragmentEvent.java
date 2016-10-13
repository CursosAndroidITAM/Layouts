package org.emilk_apps.service.eventbus;

/**
 * Created by Emilio on 10/10/2016.
 */
public class FragmentEvent {
    String hola;
    Integer something;


    public FragmentEvent(String hola) {
        this.hola = hola;
    }

    public String getString() {
        return hola;
    }
}
