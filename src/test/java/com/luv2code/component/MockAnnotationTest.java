package com.luv2code.component;

import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    //@Mock
    @MockBean
    private ApplicationDao applicationDao;

    //@InjectMocks
    @Autowired
    private ApplicationService applicationService;

    @BeforeEach
    public void beforeEach() {
        studentOne.setFirstname("Buu");
        studentOne.setLastname("Vo");
        studentOne.setEmailAddress("buuvo@luv2code.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When & verify")
    @Test
    public void assertEqualsTestAddGrades() {
        when(applicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults())).thenReturn(100.00);

        assertEquals(100, applicationService.addGradeResultsForSingleClass(studentOne.getStudentGrades().getMathGradeResults()));
        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        verify(applicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

    }

    @DisplayName("Not Null")
    @Test
    public void testAssertNotNull() {
        when(applicationDao.checkNull(studentGrades.getMathGradeResults()))
                .thenReturn(true);
        assertNotNull(applicationService.checkNull(studentOne.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Thrown Runtime Error")
    @Test
    public void throwRuntimeError() {
        CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");

        doThrow(new RuntimeException()).when(applicationDao).checkNull(nullStudent);

        assertThrows(RuntimeException.class, () -> {
            applicationService.checkNull(nullStudent);
        });
        verify(applicationDao, times(1)).checkNull(nullStudent);
    }

    @DisplayName("Thrown an Exception")
    @Test
    public void throwAnException() {
        CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");

        when(applicationDao.checkNull(nullStudent))
                .thenThrow(new RuntimeException())
                .thenReturn("Do not throw exception second time");

        assertThrows(RuntimeException.class, () -> {
            applicationService.checkNull(nullStudent);
        });
        assertEquals("Do not throw exception second time", applicationService.checkNull(nullStudent));
    }
}
