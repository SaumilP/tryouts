import javax.script.*;
import java.io.*;

public class Program {
	public static void main(String... args) throws ScriptException, NoSuchMethodException {
		  ScriptEngineManager factory = new ScriptEngineManager();
		  ScriptEngine nashornEngine = factory.getEngineByName("nashorn");
		  nashornEngine.eval(new InputStreamReader(Program.class.getResourceAsStream("script1.js")));
		  
		  System.out.println(nashornEngine.get("version"));
		  
		  Invocable invocable = (Invocable) nashornEngine;
		  Object result = invocable.invokeFunction("greetings", "Saumil");
		  System.out.println(result);
	}
}