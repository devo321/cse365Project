import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.*;

public class PersonTest {

    @Test
    public void testPersonConstructor(){
        Person test = new Person("test","test","test","test","test","test");

        assertNotNull(test.getId());
        assertNotNull(test.getFirstName());
        assertNotNull(test.getLastName());
        assertNotNull(test.getProgramAndPlan());
        assertNotNull(test.getAcademicLevel());
        assertNotNull(test.getAsuRite());
    }

    @Test
    public void testAddTime(){
        Person test = new Person("test","test","test","test","test","test");
        test.addTime("Jan 1", 50);

        assertEquals(test.getTime("Jan 1"), 50);
    }

    @Test
    public void testGetTime(){
        Person test = new Person("ID","FirstName","LastName","Program","AcademicLevel","ASURITE");
        test.addTime("Jan 1", 50);

        assertEquals(50, test.getTime("Jan 1"));        
    }

    @Test
    public void testSetAndGetId(){
        Person test = new Person("ID","FirstName","LastName","Program","AcademicLevel","ASURITE");
        test.setId("1191");
        String id = test.getId();

        assertEquals("1191", id);
    }

    @Test
    public void testSetAndGetFirstName(){
        Person test = new Person("ID","FirstName","LastName","Program","AcademicLevel","ASURITE");
        test.setFirstName("Jane");
        String name = test.getFirstName();

        assertEquals("Jane", name);
    }

    @Test
    public void testSetAndGetLastName(){
        Person test = new Person("ID","FirstName","LastName","Program","AcademicLevel","ASURITE");
        test.setLastName("Doe");
        String name = test.getLastName();

        assertEquals("Doe", name);
    }

    @Test
    public void testSetAndGetProgramAndPlan(){
        Person test = new Person("ID","FirstName","LastName","Program","AcademicLevel","ASURITE");
        test.setProgramAndPlan("Computer Science");
        String prog = test.getProgramAndPlan();

        assertEquals("Computer Science", prog);
    }

    @Test
    public void testSetAndGetAcademicLevel(){
        Person test = new Person("ID","FirstName","LastName","Program","AcademicLevel","ASURITE");
        test.setAcademicLevel("Undergrad");
        String level = test.getAcademicLevel();

        assertEquals("Undergrad", level);
    }

    @Test
    public void testSetAndGetASURite(){
        Person test = new Person("ID","FirstName","LastName","Program","AcademicLevel","ASURITE");
        test.setAsuRite("jDoe11");
        String asuRite = test.getAsuRite();

        assertEquals("jDoe11", asuRite);
    }
    
}
