import javax.script.*;
import java.io.*;

public class Program {
	public static void main(String... args) throws ScriptException, NoSuchMethodException {
		  ScriptEngineManager factory = new ScriptEngineManager();
		  ScriptEngine nashornEngine = factory.getEngineByName("nashorn");
		  nashornEngine.eval(new InputStreamReader(Program.class.getResourceAsStream("greeting.js")));
		  
		  System.out.println("version: " + nashornEngine.get("version"));
		  
		  Invocable invocable = (Invocable) nashornEngine;
		  Object result = invocable.invokeFunction("greetings", "Saumil");
		  System.out.println(result);
	}
}