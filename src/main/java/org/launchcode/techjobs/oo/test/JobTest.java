package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    private void assertNotEquals(boolean equals) {
    }
    @Test
    public void testSettingJobId(){
        Job job1 = new Job("Web Developer", new Employer("SomeTechEmployer"), new Location("Philadelphia"), new PositionType("Junior"), new CoreCompetency("JavaScript"));
        Job job2 = new Job("Backend Developer", new Employer("SomeOtherEmployer"), new Location("Philadelphia"), new PositionType("Junior"), new CoreCompetency("Java"));
        assertNotEquals(job1.equals(job2));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job3 instanceof Job);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(),"Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");


    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert Island"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert Island"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test_job = new Job("Full stack developer", new Employer("International Co."), new Location("Remote"), new PositionType("Entry level"), new CoreCompetency("Problem solving"));
        char firstChar = test_job.toString().charAt(0);
        char lastChar = test_job.toString().charAt(test_job.toString().length() - 1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test_job = new Job("Full stack developer", new Employer("International Co."), new Location("Remote"), new PositionType("Entry level"), new CoreCompetency("Problem solving"));
        String stringToTest = "\n" +
                "ID: " + test_job.getId() + "\n" +
                "Name: " + test_job.getName() + "\n" +
                "Employer: " + test_job.getEmployer() + "\n" +
                "Location: " + test_job.getLocation() + "\n" +
                "Position Type: " + test_job.getPositionType() + "\n" +
                "Core Competency: " + test_job.getCoreCompetency() + "\n";

        assertEquals(stringToTest, test_job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job test_job = new Job("Full stack developer", new Employer("International Co."), new Location("Remote"), new PositionType(""), new CoreCompetency("Problem solving"));
        assertEquals(test_job.toString(), "\n"+ "ID: 1\n" +
                "Name: Full stack developer\n" +
                "Employer: International Co.\n" +
                "Location: Remote\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Problem solving"+ "\n");
    }



}
