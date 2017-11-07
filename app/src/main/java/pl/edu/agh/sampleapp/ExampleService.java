package pl.edu.agh.sampleapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ExampleService {

   @GET(Config.getURL)
   Call<List<Book>> getBooks();

   @POST(Config.postURL)
   Call<Void> postBook(@Body Book book);

}