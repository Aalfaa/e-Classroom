package com.uap.eclassroom.Testing;

import com.uap.eclassroom.Data.Classwork;
import com.uap.eclassroom.Data.DataManage;
import com.uap.eclassroom.Data.Mahasiswa;
import com.uap.eclassroom.componentPanel.GradingTeacher;
import com.uap.eclassroom.dosen.CheckClassworkAttachment;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradingTest {

    private CheckClassworkAttachment checkClassworkAttachment;

    public void setUp() {
        DataManage.classwork = new ArrayList<>();
        DataManage.mahasiswa = new ArrayList<>();

        DataManage.classwork.add(new Classwork("Classwork 1", "Instructions", "15 August 2024"));

        Mahasiswa student1 = new Mahasiswa("Muhammad Shaumi Rayyanullah", "202310370311399", new ArrayList<>(), null, null, new ArrayList<Double>());
        student1.getGrade().add(80.0);
        student1.getAttached().add(new File("dummy.pdf")); // Mock file attachment
        DataManage.mahasiswa.add(student1);

        Mahasiswa student2 = new Mahasiswa("Evan Alfredio", "202310370311400", new ArrayList<>(), null, null, new ArrayList<Double>());
        student2.getGrade().add(90.0);
        student2.getAttached().add(null);
        DataManage.mahasiswa.add(student2);

        checkClassworkAttachment = new CheckClassworkAttachment(0);
    }

    @Test
    public void testDownloadPDF() {
        Mahasiswa student = DataManage.mahasiswa.get(0);
        File attachment = student.getAttached().get(0);
        assertNotNull("Attachment should not be null for student 1");

        Mahasiswa studentWithoutAttachment = DataManage.mahasiswa.get(1);
        File noAttachment = studentWithoutAttachment.getAttached().get(0);
        assertNull("Attachment should be null for student 2");
    }

    @Test
    public void testGradingValidation() {
        GradingTeacher gradingPanel = new GradingTeacher();

        gradingPanel.getGradeInput().setText("");
        String gradeInput = gradingPanel.getGradeInput().getText();
        assertTrue(gradeInput.isEmpty(), "Grade input should be empty");

        gradingPanel.getGradeInput().setText("InvalidNumber");
        gradeInput = gradingPanel.getGradeInput().getText();
        assertFalse(gradeInput.matches("^[-+]?[0-9]*\\.?[0-9]+$"), "Grade input should not be numeric");

        gradingPanel.getGradeInput().setText("85");
        gradeInput = gradingPanel.getGradeInput().getText();
        assertTrue(gradeInput.matches("^[-+]?[0-9]*\\.?[0-9]+$"), "Grade input should be numeric");

        double gradeValue = Double.parseDouble(gradingPanel.getGradeInput().getText());
        assertTrue(gradeValue >= 0 && gradeValue <= 100, "Grade should be between 0 and 100");
    }

    @Test
    public void testUpdateGrade() {
        Mahasiswa student = DataManage.mahasiswa.get(0);
        ArrayList<Double> grades = student.getGrade();

        assertEquals("Initial grade should be 80", 80.0);

        grades.set(0, 95.0);
        student.setGrade(grades);

        assertEquals("Grade should be updated to 95", 95.0);
    }
}
