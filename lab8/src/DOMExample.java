import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class DOMExample {
    private static ArrayList<Bank> banks = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new File("src\\file.xml"));
        NodeList bankElements = doc.getDocumentElement().getElementsByTagName("branch");
        try {
            for (int i = 0; i < bankElements.getLength(); i++) {
                Node bank = bankElements.item(i);
                NamedNodeMap attributes = bank.getAttributes();
                System.out.println(attributes.getNamedItem("name").getNodeValue());
                NodeList bankElementsNew = doc.getDocumentElement().getElementsByTagName("rate");
                for(int j = 0; j< bankElementsNew.getLength(); j++){
                    Node bankRate = bankElementsNew.item(j);
                    NamedNodeMap attributesRate = bankRate.getAttributes();
                    System.out.println(attributesRate.getNamedItem("currency").getNodeValue());
                }
                /*banks.add(new Bank(attributes.getNamedItem("name").getNodeValue(),
                        new Currency(attributes.getNamedItem("currency").getNodeValue(),
                                Integer.parseInt(attributes.getNamedItem("Units").getNodeValue()),
                                new Range(Integer.parseInt(attributes.getNamedItem("min-amount").getNodeValue()),
                                        BigInteger.valueOf(Long.parseLong(attributes.getNamedItem("max-amount").getNodeValue())),
                                        Float.parseFloat(attributes.getNamedItem("buy").getNodeValue()),
                                        Float.parseFloat(attributes.getNamedItem("sell").getNodeValue())))));*/
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        for (var s : banks) {
            System.out.println(s.toString());
        }
    }
}
