import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {
	public static void main(String[] args){
		ArrayList<Member> lst = new ArrayList<Member>();
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			f.setValidating(false);
			DocumentBuilder builder = f.newDocumentBuilder();
			Document doc = builder.parse(new File("K:\\eclipse_projects\\XMLParser\\src\\test.xml"));
			doc.getDocumentElement().normalize();
			NodeList projects = doc.getElementsByTagName("project");
			System.out.println(projects.getLength());
			for(int i = 0; i < projects.getLength(); ++i) {			
				if(projects.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element project = (Element) projects.item(i);
					String projectName = project.getAttribute("name");
					NodeList members = project.getChildNodes();
					for (int j = 0 ; j < members.getLength(); ++j) {
						if(members.item(j).getNodeType() == Node.ELEMENT_NODE) {
							Element mem = (Element) members.item(j);
							String roleName = mem.getAttribute("role");
							String name = mem.getAttribute("name");
							Member.Role role = new Member.Role(roleName, projectName);
							boolean alreadyExists = false;
							for (Member m : lst ) {
								if (m.getName().equals(name)) {
									m.addRole(role);
									alreadyExists = true;
									break;
								}
							}
							if (!alreadyExists) {
								lst.add(new Member(name, role));
							}
						}
					}
				}
			}		
			
			for( Member mem : lst) {
				System.out.println(mem);
			}
			createNewDoc(lst);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private static void createNewDoc(ArrayList<Member> lst) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement("members");
        document.appendChild(rootElement);
        for(Member m : lst) {
        	Element member = document.createElement("member");
        	 rootElement.appendChild(member);
        	 Attr attr = document.createAttribute("name");
        	 attr.setValue(m.getName());
        	 member.setAttributeNode(attr);
        	 for (Member.Role r: m.getRoles()) {
        		 Element role = document.createElement("role");
        		 role.setAttribute("name", r.getRole());
        		 role.setAttribute("project", r.getProjectName());
        		 member.appendChild(role);
        	 }
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("K:\\eclipse_projects\\XMLParser\\src\\result2.xml"));
        transformer.transform(domSource,  streamResult);
        System.out.println("Файл сохранен!");
	}
}


