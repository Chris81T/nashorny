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
public class CalcResult {

    private final JSObject result;

    public CalcResult(JSObject result) {
        this.result = result;
    }

    public JSObject getJsResult() {
        return result;
    }
    
    public String getNotice() {
        return (String) result.getMember("notice");
    }
    
    public double getResult() {
        return (double) result.getMember("result");
    }

    @Override
    public String toString() {
        return "CalcResult{" + "result=" + result + '}';
    }    
    
}
