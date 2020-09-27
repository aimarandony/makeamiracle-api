package com.makeamiracle.api.config;

import com.makeamiracle.api.domain.Degree;
import com.makeamiracle.api.domain.School;
import com.makeamiracle.api.domain.SchoolType;
import com.makeamiracle.api.service.SchoolService;
import com.makeamiracle.api.service.SchoolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PopulateConfig {

    @Autowired
    SchoolService schoolService;

    @Autowired
    SchoolTypeService schoolTypeService;

    public void init(){
        SchoolType schoolType1 = new SchoolType(), schoolType2 = new SchoolType();
        schoolType1.setName("UNIVERSIDAD");
        schoolType2.setName("INSTITUTO");
        schoolTypeService.create(schoolType1);
        schoolTypeService.create(schoolType2);

        Degree degree1 = new Degree(), degree2 = new Degree(), degree3 = new Degree();
        degree1.setName("fisica");
        degree2.setName("algebra");
        degree3.setName("geometria");

        List<Degree> degrees = new ArrayList<>();
        degrees.add(degree1);
        degrees.add(degree2);
        degrees.add(degree3);

        School school1 = new School();
        school1.setName("San Francisco");
        school1.setSchoolType(schoolType1);
        school1.setDegrees(degrees);
        schoolService.create(school1);
    }
}
