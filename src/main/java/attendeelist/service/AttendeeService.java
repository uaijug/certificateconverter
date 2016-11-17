package attendeelist.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import attendeelist.domain.Attendee;
import attendeelist.domain.Attendees;
import attendeelist.domain.Event;
import attendeelist.utils.CryptoUtils;

public class AttendeeService {
	public static String createJsonFile(Attendees attendees) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String result = gson.toJson(attendees);
		System.out.println(result);
		return result;
	}

	public static Event setAttendessFromEvent(String eventCode, List<Attendee> participantes) {
		List<Event> events = new ArrayList<Event>();
		Event event = new Event();
		event.setId(eventCode);
		event.setAttendee(participantes);
		events.add(event);
		return event;
	}

	public static List<Attendee> readAttendeesFromCsv(String propertiesTitle1, String propertiesTitle2,
			BufferedReader br) throws IOException {
		List<Attendee> participantes = new ArrayList<Attendee>();

		String line = "";
		String[] row = null;
		int i = 0;
		while ((line = br.readLine()) != null) {
			if (!line.isEmpty()) {
				i++;
				// "," ou ";" de acordo com o arquivo
				row = line.split(";");
				if (row.length > 0) {

					// System.out.println(row[0] + " - " + row[1]);
					if (!row[0].equals(propertiesTitle1) && !row[0].equals(propertiesTitle2)) {

						Attendee participante = new Attendee();
						participante.setId(new Long(i) + 10000);
						participante.setName(row[0]);
						participante.setEmail(CryptoUtils.md5(row[1]));

						participantes.add(participante);
					}
				}
			}
		}
		return participantes;
	}

}
