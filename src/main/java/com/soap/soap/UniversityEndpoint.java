package com.soap.soap;




import localhost.university.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UniversityEndpoint {
    private static final String NAMESPACE_URI = "http://localhost/university";

    private final UniversityRepository universityRepository;

    public UniversityEndpoint(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityRequest")
    @ResponsePayload
    public GetUniversityResponse getUniversity(@RequestPayload GetUniversityRequest request) {
        GetUniversityResponse response = new GetUniversityResponse();
        response.setUniversity(universityRepository.getUniversityByName(request.getName()));
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUniversitiesAtLocationRequest")
    @ResponsePayload
    public GetAllUniversitiesAtLocationResponse getAllUniversitiesAtLocationResponse(@RequestPayload GetAllUniversitiesAtLocationRequest request) {
        GetAllUniversitiesAtLocationResponse response = new GetAllUniversitiesAtLocationResponse();
        response.setUniversity(universityRepository.getAllAtLocation(request.getLocation()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUniversitiesRequest")
    @ResponsePayload
    public GetAllUniversitiesResponse getAllUniversities(@RequestPayload GetAllUniversitiesRequest request) {
        GetAllUniversitiesResponse response = new GetAllUniversitiesResponse();
        for (University university : universityRepository.getAll()) {
            response.getUniversity().add(university);
        }

        return response;
    }






//    @Autowired
//    public CountryEndpoint(CountryRepository countryRepository) {
//        this.countryRepository = countryRepository;
//    }

//    public CountryEndpoint() {
//        this.countryRepository = new CountryRepository();
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
//    @ResponsePayload
//    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
//        GetCountryResponse response = new GetCountryResponse();
//        response.setCountry(countryRepository.findCountry(request.getName()));
//
//
//        return response;
//    }

}



