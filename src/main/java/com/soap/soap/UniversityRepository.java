package com.soap.soap;


import localhost.university.University;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UniversityRepository {

    private Map<String, University> universities = new HashMap<>();

    @PostConstruct // run method when class is injected
    private void LoadData(){
        University strath = new University();
        strath.setLocation("Ole Sangale");
        strath.setName("Strathmore");
        strath.setYearFounded("1968");
        universities.put(strath.getName(), strath);
        universities.put(strath.getLocation(), strath);
        universities.put(strath.getYearFounded(), strath);

        University jkuat = new University();
        jkuat.setLocation("Juja");
        jkuat.setName("Jkuat");
        jkuat.setYearFounded("1956");
        universities.put(jkuat.getName(), jkuat);
        universities.put(jkuat.getLocation(), jkuat);
        universities.put(jkuat.getYearFounded(), jkuat);

        University ku = new University();
        ku.setLocation("Kiambu");
        ku.setName("Kenyatta University");
        ku.setYearFounded("1946");
        universities.put(ku.getName(),ku);
        universities.put(ku.getLocation(),ku);
        universities.put(ku.getYearFounded(),ku);
    }

    public University getUniversityByName(String name){
        Assert.notNull(name,"University must not be null!");
        return universities.get(name);
    }

    public List<University> getAll(){
        return new ArrayList<>(universities.values());
    }

    public University getAllAtLocation(String location) {
        return universities.get(location);
    }
    public University getAllYearFounded(String YearFounded){
        return universities.get(YearFounded);
    }


}
