package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test(){

        //preparing part
        //Given step

        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project()); //Stubbing : creating behaviour
        //                                      like"P1000"

        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        //When-step
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());

        //Then step
        //checking- parts
        InOrder inOrder = inOrder(projectRepository,projectMapper); // I want to check the order of these 2 Mocks

        inOrder.verify(projectRepository).findByProjectCode(anyString());//1.we are providing in which order these 2 Mocks should b
        inOrder.verify(projectMapper).convertToDto(any(Project.class));//2.

        assertNotNull(projectDTO);

    }


    @Test
    void getByProjectCode_ExceptionTest(){

        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));

        Throwable throwable = assertThrows(NoSuchElementException.class,() -> projectService.getByProjectCode(""));

        //we are checking correct place or not
        verify(projectRepository).findByProjectCode("");

        verify(projectMapper,never()).convertToDto(any(Project.class));

        //we are checking correct info or not
        assertEquals("Project Not Found",throwable.getMessage());


    }



}