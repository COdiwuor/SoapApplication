package com.soap.soap;

import localhost.university.University;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class UniversityRepository {

    private Map<String, University> universities = new HashMap<>();

    @PostConstruct
    private void LoadData(){
        University strath = new University();
        strath.setLocation("Ole Sangale");
        strath.setName("Strathmore");
        strath.setYearFounded(String.valueOf(1968));
        universities.put(strath.getName(), strath);

        University jkuat = new University();
        jkuat.setLocation("Juja");
        jkuat.setName("Jkuat");
        jkuat.setYearFounded(String.valueOf(1944));
        universities.put(jkuat.getName(), jkuat);

        University ku = new University();
        ku.setLocation("Kiambu");
        ku.setName("Kenyatta University");
        ku.setYearFounded(String.valueOf(1956));
        universities.put(ku.getName(),ku);
    }

    public University getUniversityByName(String name){
        return universities.get(name);
    }
}
