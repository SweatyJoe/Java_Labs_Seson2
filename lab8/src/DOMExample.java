import org.w3c.dom.*;
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
        NodeList bankElements = doc.getDocumentElement().getElementsByTagName("branch"); //берём все branch
        try {
            for (int i = 0; i < bankElements.getLength(); i++) {  //перебираем
                Node bankBranch = bankElements.item(i);
                String branchName = bankBranch.getAttributes().getNamedItem("name").getNodeValue(); //branch
                System.out.println("\nName:" + branchName);
                NodeList bankElementsNew = bankBranch.getChildNodes();
                for (int j = 0; j < bankElementsNew.getLength(); j++) {
                    Node nodeRate = bankElementsNew.item(j);
                    try {
                        String rateCurrency = nodeRate.getAttributes().getNamedItem("currency").getNodeValue();
                        int rateUnits = Integer.parseInt(nodeRate.getAttributes().getNamedItem("Units").getNodeValue());
                        System.out.println("Currency: " + rateCurrency + " Units: " + rateUnits);
                        NodeList nodeRange = nodeRate.getChildNodes();
                        try {
                            for (int k = 0; k < nodeRange.getLength(); k++) {
                                if (nodeRange.item(k) instanceof Element) {
                                    Node node = nodeRange.item(k);
                                    int rangeMin = Integer.parseInt(node.getAttributes().getNamedItem("min-amount").getNodeValue());
                                    BigInteger rangeMax = BigInteger.valueOf(Long.parseLong(node.getAttributes().getNamedItem("max-amount").getNodeValue()));
                                    System.out.println("\tmin: " + rangeMin +
                                            " max: " + rangeMax);
                                    NodeList nextNodeList = node.getChildNodes();
                                    if (nextNodeList.item(1) instanceof Element || nextNodeList.item(3) instanceof Element) {
                                        banks.add(new Bank(branchName, new Currency(rateCurrency, rateUnits, new Range(rangeMin, rangeMax, Float.parseFloat(nextNodeList.item(1).getTextContent()), Float.parseFloat(nextNodeList.item(1).getTextContent())))));
                                        System.out.println("\t\tbuy " + nextNodeList.item(1).getNodeName() + " " +
                                                " sell " + nextNodeList.item(1).getNodeName());
                                    }

                                }
                            }
                        } catch (NullPointerException e) {
                            try {
                                for (int k = 0; k < nodeRange.getLength(); k++) {
                                    if (nodeRange.item(k) instanceof Element) {
                                        Node node = nodeRange.item(k);
                                        System.out.println("\t\t" + node.getNodeName() + " " + node.getTextContent());
                                    }
                                }
                            } catch (Exception e1) {
                                System.out.println("no");
                            }
                        }
                    } catch (NullPointerException e) {
                        if (bankElementsNew.item(j) instanceof Element) {
                            String name = nodeRate.getAttributes().getNamedItem("currency").getNodeValue();
                            banks.add(new Bank(branchName, new Currency(name, new Range(Float.parseFloat(nodeRate.getTextContent())))));
                            System.out.println("Currency " + name + "\n\t" + nodeRate.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (var s : banks) {
            System.out.println(s.toString());
        }
    }
}
