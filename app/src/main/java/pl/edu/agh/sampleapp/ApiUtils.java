package pl.edu.agh.sampleapp;

public class ApiUtils {
 
    public static ExampleService getService() {
        return RetrofitClient.getClient("https://api.myjson.com").create(ExampleService.class);
    }

    public static ExampleService getServiceBin() {
        return RetrofitClient.getClient("https://requestb.in").create(ExampleService.class);
    }
}