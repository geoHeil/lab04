package edu.liu.geoheil;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class XMLCounter implements ContentHandler {

    /* here comes var declaration */
    Stack<Integer> deweyNumber;
    // element qualified path (attr key, attr val)
    HashMap<String, HashMap<String, String>> elemAttributes;

    public void startDocument() throws SAXException {

     /* here comes the init code */
        deweyNumber = new Stack<>();
        deweyNumber.push(1);
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        /**
         * Stuff for the elements.
         * Saved to file manually
         */
        System.out.println(printStack(deweyNumber) + " " + qName);
        deweyNumber.push(1);

        /**
         * For the attributes
         * saved manually to file
         */
//        for (int i = 0; i < attributes.getLength(); i++) {
//            System.out.println(printStack(deweyNumber) + " " + attributes.getQName(i) + " " + attributes.getValue(i));
//        }
//        deweyNumber.push(1);
    }

    public String printStack(Stack<Integer> stack) {
        StringBuilder result = new StringBuilder();
        Iterator<Integer> iter = stack.iterator();

        while (iter.hasNext()) {
            result.append(iter.next());

            if (iter.hasNext()) {
                result.append(".");
            }
        }
        return result.toString();
    }

    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        deweyNumber.pop();
        deweyNumber.set(deweyNumber.size() - 1, deweyNumber.peek() + 1);
        /* here comes code after the endElement is met */

    }

    public void characters(char ch[], int start, int length) throws SAXException {

        /**
         * not needed @Valentina
         */
        /* here comes code after the startElement is met */
//        System.out.println("start characters : " +
//                new String(ch, start, length));
    }


    public void endDocument() throws SAXException {

        System.out.println("End of docuement ");

        /**
         * Written to files manually
         */
//        List<String> tags = new ArrayList<>();
//        tags.add("test");
//        writeFile(tags, "result/tags");
    }

//    private void writeFile(List<String> document, String pathName) {
//        try {
//            Files.write(Paths.get(pathName), document);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    // Do-nothing methods we have to implement only to fulfill
    // the interface requirements:

    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
    }

    public void processingInstruction(String target, String data)
            throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
    }

    public void endPrefixMapping(String prefix) throws SAXException {
    }

    public void skippedEntity(String name) throws SAXException {
    }

}
