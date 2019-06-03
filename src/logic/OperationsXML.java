package logic;

import org.w3c.dom.*;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.*;

public class OperationsXML
{
	static Element root, event, eventTitle, eventDescription, eventPlace, eventStartDate, eventEndDate, alarmDate;
	static Attr attribute;

	public static void saveToXML(EventCollection events) throws DatatypeConfigurationException
	{
		try
		{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			
			//root element
			root = document.createElement("events");
			document.appendChild(root);

			
			for (int i=0; i<events.getEvents().size(); i++)
			{
				event = document.createElement("event");
				root.appendChild(event);
				
				eventTitle = document.createElement("eventTitle");
				eventTitle.appendChild(document.createTextNode(events.getEvent(i).getTitle()));
				event.appendChild(eventTitle);
				
				eventDescription = document.createElement("eventDescription");
				eventDescription.appendChild(document.createTextNode(events.getEvent(i).getDescription()));
				event.appendChild(eventDescription);
				
				eventPlace = document.createElement("eventPlace");
				eventPlace.appendChild(document.createTextNode(events.getEvent(i).getPlace()));
				event.appendChild(eventPlace);
				
				// SAVING DATE TO XML
				// Jak nie zadzia³a wczytywanie to date podzieliæ na dzien, miesiac itd.
				{
				eventStartDate = document.createElement("eventStartDate");
				
				GregorianCalendar calendar1 = new GregorianCalendar();
				calendar1.setTime(events.getEvent(i).getStartDate().getTime());
				DatatypeFactory df1 = DatatypeFactory.newInstance();
				XMLGregorianCalendar startEventTime = df1.newXMLGregorianCalendar(calendar1);
				
				eventStartDate.appendChild(document.createTextNode(startEventTime.toString()));
				event.appendChild(eventStartDate);
				
				
				eventEndDate = document.createElement("eventEndDate");
				
				GregorianCalendar calendar2 = new GregorianCalendar();
				calendar2.setTime(events.getEvent(i).getEndDate().getTime());
				DatatypeFactory df2 = DatatypeFactory.newInstance();
				XMLGregorianCalendar endEventTime = df2.newXMLGregorianCalendar(calendar2);
				
				eventEndDate.appendChild(document.createTextNode(endEventTime.toString()));
				event.appendChild(eventEndDate);
				}
				
				attribute = document.createAttribute("alarmSet");
				
				if (events.getEvent(i).isAlarmTrigger() == false)
				{
					attribute.setValue("No");
					event.setAttributeNode(attribute);
				}
				else 
				{
					attribute.setValue("Yes");
					event.setAttributeNode(attribute);
					
					
					alarmDate = document.createElement("alarmDate");
					
					GregorianCalendar calendar3 = new GregorianCalendar();
					calendar3.setTime(events.getEvent(i).getAlarmDate().getTime());
					DatatypeFactory df3 = DatatypeFactory.newInstance();
					XMLGregorianCalendar endAlarmTime = df3.newXMLGregorianCalendar(calendar3);
					
					alarmDate.appendChild(document.createTextNode(endAlarmTime.toString()));
					event.appendChild(alarmDate);
				}

			}
			
			
			//creating the xml file
			//transforming the DOM Object to an XML File
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File("eventsXML.xml"));
			transformer.transform(domSource, streamResult);
			
			System.out.println("XML file created");
		}
		catch (ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		catch (TransformerException te)
		{
			te.printStackTrace();
		}
	}
}
