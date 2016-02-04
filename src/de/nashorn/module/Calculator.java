/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.nashorn.module;

import jdk.nashorn.api.scripting.JSObject;

/**
 *
 * @author christian
 */
public interface Calculator {

    JSObject add(int a, int b);
    JSObject sub(double a, double b);
    
    void handle(JSObject result);
    
}
