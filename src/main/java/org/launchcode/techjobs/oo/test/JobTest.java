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
        assertEquals(job3.getName(), "Product tester" );
        assertTrue(job3 instanceof Job);
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
        assertEquals(test_job.toString().startsWith("\n"), test_job.toString().endsWith("\n"));
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
        assertTrue(test_job.toString().contains("Data not available"));
    }



}
