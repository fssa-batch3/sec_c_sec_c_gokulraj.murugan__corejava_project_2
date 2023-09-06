package com.fssa.bitwallet.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

public class CurrencyValues {
	public static void main(String[] args) throws IOException, InterruptedException {
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://coinlib.io/api/v1/coin?key=0f699c336c04344a&pref=INR&symbol=btc"))
//				.header("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
//				.header("X-RapidAPI-Host", "coingecko.p.rapidapi.com")
//				.method("GET", HttpRequest.BodyPublishers.noBody())
//				.build();
//		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println(response.body());
		
		AsyncHttpClient client = new DefaultAsyncHttpClient();
		client.prepare("GET", "https://coingecko.p.rapidapi.com/simple/price?ids=%3CREQUIRED%3E&vs_currencies=%3CREQUIRED%3E")
			.setHeader("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
			.setHeader("X-RapidAPI-Host", "coingecko.p.rapidapi.com")
			.execute()
			.toCompletableFuture()
			.thenAccept(System.out::println)
			.join();

		client.close();
	}

}
