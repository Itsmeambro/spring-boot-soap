package com.ambro.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ambro.soap.entity.Student;
import com.ambro.soap.service.StudentService;
import com.ambro.soap.xml.school.StudentDetailsRequest;
import com.ambro.soap.xml.school.StudentDetailsResponse;

@Endpoint
public class StudentEndpoint
{
  private static final String NAMESPACE_URI = "http://soap.ambro.com/xml/school";
  
  @Autowired
  StudentService studentService;
  
  
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
  @ResponsePayload
  public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
    StudentDetailsResponse response = new StudentDetailsResponse();
    response.setStudent(studentService.getStudent(request.getName()));
    return response;
  }
}