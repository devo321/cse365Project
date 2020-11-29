import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class SourceTest {
    
    @Test
    public void testSourceUpdateRoster(){
        String[] data = new String[]{"test"};
        Source source = new Source();
        Person person1 = new Person(data[0],data[0],data[0],data[0],data[0],data[0]);

        source.updateRoster(person1);
        assertNotNull(source.getRoster().get(0).getId());
        assertNotNull(source.getRoster().get(0).getFirstName());
        assertNotNull(source.getRoster().get(0).getLastName());
        assertNotNull(source.getRoster().get(0).getProgramAndPlan());
        assertNotNull(source.getRoster().get(0).getAcademicLevel());
        assertNotNull(source.getRoster().get(0).getAsuRite());
    }

    @Test
    public void testUpdateAttendance(){
        String[] data = new String[]{"test"};
        Source source = new Source();
        Person person1 = new Person(data[0],data[0],data[0],data[0],data[0],data[0]);
        Attendance a = new Attendance("test", 10);

        source.updateRoster(person1);
        source.updateAttendance(a, "Jan 1");

        assertNotNull(source.getRoster().get(0).getTime("Jan 1"));

    }

    @Test
    public void testClearRoster(){
        String[] data = new String[]{"test"};
        Source source = new Source();
        Person person1 = new Person(data[0],data[0],data[0],data[0],data[0],data[0]);
        Attendance a = new Attendance("test", 10);

        source.updateRoster(person1);
        source.updateAttendance(a, "Jan 1");
        source.clearRoster();

        assertTrue(source.getRoster().isEmpty());



    }

}
