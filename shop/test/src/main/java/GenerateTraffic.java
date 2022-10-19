import java.io.FileOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;



public class GenerateTraffic {

	
	public static void main(String[] args) {
	
	// arg 1 = URL 
	/*
		if (args.length <1 ) {
			System.out.println("You must supply the URL of the Javasahop to be called.");
			return;
		}
	*/	// args[0];
		
		String url = "http://10.0.0.192:32247//";
		
		System.out.println("Utah Location");
		for (int j=0; j<50; j++) {
			
		
			try {
		
				HttpClient client = HttpClient.newHttpClient();
				String theURL = url + "?name=Guest&location=Utah";
			
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(theURL)).build();
				
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
				String sResult = response.body().toString();
			 
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("California Location");
		long startTime = System.nanoTime();
	
		
		for (int k=0; k<100; k++) {
			
			
			try {
			
				HttpClient client = HttpClient.newHttpClient();
				String theURL =  url + "?name=Guest&location=California";
			
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(theURL)).build();
				
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
				String sResult = response.body().toString();
			 
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		
		System.out.println("CALIFORNIA DURATION IS: " + duration /  1000000000);
		
		startTime = System.nanoTime();
		
		System.out.println("Colorado Location");
		
		for (int l=0; l<100; l++) {
			
			
			try {
		
				HttpClient client = HttpClient.newHttpClient();
				String theURL =  url + "?name=Guest&location=Colorado";
			
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(theURL)).build();
				
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
				String sResult = response.body().toString();
			 
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		 endTime = System.nanoTime();

		 duration = (endTime - startTime);
		
		System.out.println("COLORADO DURATION IS: " + duration/ 1000000000);
	}
	/*
	// Create a neat value object to hold the URL
	URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

	// Open a connection(?) on the URL(??) and cast the response(???)
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	// Now it's "open", we can set the request method, headers etc.
	connection.setRequestProperty("accept", "application/json");

	// This line makes the request
	InputStream responseStream = connection.getInputStream();

	// Manually converting the response body InputStream to APOD using Jackson
	ObjectMapper mapper = new ObjectMapper();
	APOD apod = mapper.readValue(responseStream, APOD.class);

	// Finally we have the response
	System.out.println(apod.title);
	*/
}
