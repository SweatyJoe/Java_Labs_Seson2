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
import java.util.ArrayList;

public class DOMExample {
    private static ArrayList<Bank> banks = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new File("src\\file.xml"));
        NodeList bankElements = doc.getDocumentElement().getElementsByTagName("branch"); //берём все branch
        try {
            for (int i = 0; i < bankElements.getLength(); i++) {  //перебираем
                Node bankBranch = bankElements.item(i);
                //NamedNodeMap attributesBranch = bankBranch.getAttributes();
                System.out.println("\nName:" + bankBranch.getAttributes().getNamedItem("name").getNodeValue());
                NodeList bankElementsNew = bankBranch.getChildNodes();
                for (int j = 0; j < bankElementsNew.getLength(); j++) {
                    Node nodeRate = bankElementsNew.item(j);
                    try {
                        System.out.println("Currency: " + nodeRate.getAttributes().getNamedItem("currency").getNodeValue() +
                                " Units: " + nodeRate.getAttributes().getNamedItem("Units").getNodeValue());

                        NodeList nodeRange = nodeRate.getChildNodes();
                        try {
                            for (int k = 0; k < nodeRange.getLength(); k++) {
                                Node node = nodeRange.item(k);
                                System.out.println("\tmin: " + node.getAttributes().getNamedItem("min-amount").getNodeValue() +
                                        " max: " + node.getAttributes().getNamedItem("max-amount").getNodeValue());
                            }

                        } catch (NullPointerException e) {
                            continue;
                        }
                    } catch (NullPointerException e) {
                        continue;
                    }


                }

                //Node bb = bankElementsNew;
                //System.out.println(bb.getLocalName().toString());
                /*if (bb != null) {
                    //NodeList bankElementsRange = doc.getDocumentElement().getElementsByTagName("range");
                    NodeList bankElementsRange = bb.item(i).getChildNodes();
                    if (bankElementsRange != null) {
                        for (int j = 0; j < bankElementsRange.getLength(); j++) {
                            Node bRange = bankElementsRange.item(j);
                            NamedNodeMap mapRange = bRange.getAttributes();
                            NodeList nodeList = bRange.getChildNodes();
                            System.out.println("\tmin\\max[" + nodeList.item(0).getTextContent() + nodeList.item(1).getTextContent() + "]\n" +
                                    "\tMin\\max: [" + mapRange.getNamedItem("min-amount").getNodeValue() + "][" + mapRange.getNamedItem("max-amount").getNodeValue() + "]");
                        }
                    }
                }*/

               /* for (int j = 0; j < bankElementsNew.getLength(); j++) {
                    Node bankRate = bankElementsNew.item(j);
                    NamedNodeMap attributesRate = bankRate.getAttributes();
                    try {
                        if (attributesRate.getNamedItem("currency").getTextContent().length() < 4) {
                            System.out.print("\tCur: " + attributesRate.getNamedItem("currency").getNodeValue() + "Un: " + attributesRate.getNamedItem("Units").getNodeValue());
                            NodeList bankElementsRange = doc.getDocumentElement().getElementsByTagName("range");

                            for (int k = 0; k < bankElementsRange.getLength(); k++) {
                                Node bankRange = bankElementsRange.item(k);
                                NamedNodeMap attributesRange = bankRange.getAttributes();
                                System.out.println("\tMin\\max: [" + attributesRange.getNamedItem("min-amount").getNodeValue() + "][" + attributesRange.getNamedItem("max-amount").getNodeValue() + "]");
                                NodeList buy = doc.getDocumentElement().getElementsByTagName("buy");
                                NodeList sell = doc.getDocumentElement().getElementsByTagName("sell");
                                System.out.println("\t\tbuy\\sell :[" + buy.item(k).getTextContent() + "][" + sell.item(k).getTextContent() + "]");
                            }
                        } else {
                            System.out.println(attributesRate.getNamedItem("currency").getTextContent());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }*/
                /*banks.add(new Bank(attributes.getNamedItem("name").getNodeValue(),
                        new Currency(attributes.getNamedItem("currency").getNodeValue(),
                                Integer.parseInt(attributes.getNamedItem("Units").getNodeValue()),
                                new Range(Integer.parseInt(attributes.getNamedItem("min-amount").getNodeValue()),
                                        BigInteger.valueOf(Long.parseLong(attributes.getNamedItem("max-amount").getNodeValue())),
                                        Float.parseFloat(attributes.getNamedItem("buy").getNodeValue()),
                                        Float.parseFloat(attributes.getNamedItem("sell").getNodeValue())))));*/

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (var s : banks) {
            System.out.println(s.toString());
        }
    }
}
