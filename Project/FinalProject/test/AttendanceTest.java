import static org.junit.Assert.assertEquals;

import org.junit.*;

public class AttendanceTest {

    @Test
    public void testAttendance(){
        Attendance a = new Attendance("test", 10);

        assertEquals(a.getAsuRite(), "test");
        assertEquals(a.getTime(), 10);
    }

    @Test
    public void testSetTime(){
        Attendance a = new Attendance("test", 10);
        a.setTime(20);

        assertEquals(a.getTime(), 20);
    }
    
}
