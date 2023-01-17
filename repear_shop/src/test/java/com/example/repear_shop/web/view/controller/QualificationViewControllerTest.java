package com.example.repear_shop.web.view.controller;

import com.example.repear_shop.dto.QualificationDTO;
import com.example.repear_shop.service.QualificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(QualificationViewController.class)
class QualificationViewControllerTest {
    @MockBean
    private QualificationService service;

    @SpyBean
    private ModelMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    private QualificationDTO qualificationOne;
    private QualificationDTO qualificationTwo;

    @BeforeEach
    public void setUp() {
        this.qualificationOne = new QualificationDTO();
        this.qualificationOne.setQualificationId(Long.valueOf("1"));
        this.qualificationOne.setQualification("qualificationOne");

        this.qualificationTwo = new QualificationDTO();
        this.qualificationTwo.setQualificationId(Long.valueOf("2"));
        this.qualificationTwo.setQualification("qualificationTwo");
    }

    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    @Test
    public void testGetQualificationsAdminAccess() throws Exception {
        this.setUpQualificationsForPage();
        this.mockMvc.perform(MockMvcRequestBuilders.get("/qualifications"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetQualificationsRolesNoAccess() throws Exception {
        this.setUpQualificationsForPage();
        this.mockMvc.perform(MockMvcRequestBuilders.get("/qualifications"))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }

    private void setUpQualificationsForPage() {
        List<QualificationDTO> qualificationList = new ArrayList<>();
        qualificationList.add(this.qualificationOne);
        qualificationList.add(this.qualificationTwo);

        Mockito.when(this.service.getQualifications()).thenReturn(qualificationList);
    }
}