package attendeelist;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

import attendeelist.domain.Attendee;
import attendeelist.domain.Attendees;
import attendeelist.domain.Event;
import attendeelist.service.AttendeeService;
import attendeelist.utils.SystemUtils;

public class Application {
	private static final String RESULT_JSON = "attendees.json";
	private static final String FIELD_TITLE_1 = "Nome";
	private static final String FIELD_TITLE_2 = "Email";

	public static void main(String[] args) throws IOException {
		String fileName = args[0];
		String eventCode = args[1];
		
		//Properties props = SystemUtils.readSystemProperties();
		
		BufferedReader br = SystemUtils.readCsvFile(fileName);

		//String propertiesTitle1 = props.getProperty("FIELD_TITLE_1");
		//String propertiesTitle2 = props.getProperty("FIELD_TITLE_2");
		List<Attendee> participantes = AttendeeService.readAttendeesFromCsv(FIELD_TITLE_1, FIELD_TITLE_2, br);
		
		Event event = AttendeeService. setAttendessFromEvent(eventCode, participantes);

		Attendees attendees = new Attendees();
		attendees.setEvent(event);

		String result =  AttendeeService.createJsonFile(attendees);

		File file = new File(RESULT_JSON);
		SystemUtils.writeResultFile(file, result);
	}
	
}
