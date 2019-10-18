package models.services.base;

import models.services.HashingService;

public class HashingServiceImpl implements HashingService {
    @Override
    public String hash(String str) {
        String result = ("@"+ str +"!");
        return result;
    }
}
