package parser;

import java.util.*;
import org.xml.sax.*;

public class XMLCounter implements ContentHandler {

	/* here comes var declaration */

	public void startDocument( ) throws SAXException {

     /* here comes the init code */
        
    }

	public void startElement(String uri, String localName,String qName, 
	            Attributes attributes) throws SAXException {

		System.out.println("Start Element :" + qName);

        /* here comes code after the startElement is met */
        /* for attributes too */
        
	}

    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        
        System.out.println("End Element :" + qName);
        
        /* here comes code after the endElement is met */
    }
    
    public void characters(char ch[], int start, int length) throws SAXException {
        
        /* here comes code after the startElement is met */
		
    }
    
    
    public void endDocument( ) throws SAXException {
        System.out.println("End of docuement ");
    }
    
    // Do-nothing methods we have to implement only to fulfill
    // the interface requirements:
    
    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {}
    
    public void processingInstruction(String target, String data) 	   
    throws SAXException {}
    public void setDocumentLocator(Locator locator) {}
    public void startPrefixMapping(String prefix, String uri)
    throws SAXException {}
    public void endPrefixMapping(String prefix) throws SAXException {}
    public void skippedEntity(String name) throws SAXException {}
    
}
