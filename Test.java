import java.io.*;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
// import groovy.lang.GroovyShell;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Test {
    public static void main(String[] args) throws Exception {
	Test t = new Test();
	t.testBean();
    }

    private void testBean() throws Exception {

    	// ProcessBuilder
    	// File processbuilderxml = new File("processbuilder.xml");
    	// ProcessBuilder pb = new java.lang.ProcessBuilder("/Users/alvaro/bin/pwnAlert");
    	// encodeObject(pb, processbuilderxml);

    	// GroovyShell
    	// GroovyShell shell = new GroovyShell();
    	// Object value = shell.evaluate("println 'Hello World!';");
    	// File groovyxml = new File("groovy.xml");
    	// encodeObject(shell, groovyxml);

    	// ScriptingEngine
    	// ScriptEngineManager mgr = new ScriptEngineManager();
		// ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
		// try {
		// 	jsEngine.eval("runCommand('/Users/alvaro/bin/pwnAlert')");
		// } catch (ScriptException ex) {
		//	ex.printStackTrace();
		//} 

		// Simple Bean
		// System.out.println("Testing bean");
		// File simpleBeanXml = new File("bean.xml");
		// Bean b = new Bean();
		// b.setName("Java");
		// encodeObject(b, simpleBeanXml);
		// Bean b2 = (Bean) decodeObject(simpleBeanXml);
		// System.out.println("Retrieved: " + b2);
		// System.out.println();

		// XXE
		// File beanXXEXml = new File("bean-xxe.xml");
		// Bean b3 = (Bean) decodeObject(beanXXEXml);
		// System.out.println("Retrieved: " + b3);
		// System.out.println();

		try {
			File beanRCEXml = new File("bean-rce.xml");
			//decodeObject(beanRCEXml);
			Bean test = (Bean) decodeObject(beanRCEXml);
		} catch (Exception e) {
			e.printStackTrace();	
		}
    
    }


    void encodeObject(Object o, File xmlFile) throws IOException {
	XMLEncoder encoder = new XMLEncoder(
				new FileOutputStream(xmlFile)
			     );
	encoder.writeObject(o);
	encoder.close();
    }

    Object decodeObject(File xmlFile) throws IOException {
	XMLDecoder decoder = new XMLDecoder(
				new FileInputStream(xmlFile)
			     );
	Object o = decoder.readObject();
	decoder.close();
	return o;
    }
}