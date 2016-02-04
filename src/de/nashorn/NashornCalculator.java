package de.nashorn;

import de.nashorn.module.CalcResult;
import de.nashorn.module.Calculator;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author christian
 */
public class NashornCalculator {

    private final Calculator calculator;
    
    public NashornCalculator() throws Exception {
        // load script...
        InputStream scriptAsStream = NashornCalculator.class.getResourceAsStream("/js/script.js");
        InputStreamReader inputStreamReader = new InputStreamReader(scriptAsStream);
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        
        scriptEngine.eval(inputStreamReader);
        
        Invocable invocable = (Invocable) scriptEngine;
        
        calculator = invocable.getInterface(Calculator.class);        
    }

    
    
    CalcResult add(int a, int b) {
        return new CalcResult(calculator.add(a, b));
    }
    
    CalcResult sub(double a, double b) {
        return new CalcResult(calculator.sub(a, b));
    }
        
    void handle(CalcResult result) {
        calculator.handle(result.getJsResult());        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        System.out.println("N A S H O R N Y - S A N D B O X");
        
        NashornCalculator calculator = new NashornCalculator();

        
        CalcResult addResult = calculator.add(5, 10);        
        CalcResult subResult = calculator.sub(7.8d, 0.9d);
        
        System.out.println("addResult " + addResult.getNotice());
        System.out.println("addResult " + addResult.getResult());
        System.out.println("subResult " + subResult.getNotice());
        System.out.println("subResult " + subResult.getResult());
        
        calculator.handle(addResult);
        calculator.handle(subResult);
        
    }
    
}
