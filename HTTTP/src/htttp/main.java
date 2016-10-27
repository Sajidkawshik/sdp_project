
package htttp;


import com.sun.net.httpserver.Headers;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;

public class main {

  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
    server.createContext("/info", new InfoHandler());
    server.createContext("/get", new GetHandler());
    server.createContext("/me", new meHandler());
    server.createContext("/music", new musicHandler());
    server.createContext("/video", new videoHandler());

    server.setExecutor(null); // creates a default executor
    server.start();
  }

  static class InfoHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
      
      //String image="back.jpg";
      //String response = "<html>\n" +"<head></head>\n" +"<body background="+image+">"+"\n"+"<h1><a href=\"http://192.168.0.104:8000/get\">picture</a>\n<br><a href=\"http://192.168.0.102:8000/me\">text</a><br><a href=\"http://192.168.0.102:8000/music\">music</a>\n<br><a href=\"http://192.168.0.102:8000/video\">video</a>\n\n" +"</body>\n" +"</html>";
      BufferedReader br= new BufferedReader(new FileReader(new File("html.txt")));
      String response ="";
      while(true)
      {
          String temp=br.readLine();
          if(temp==null)break;
          response+="\n"+temp;
      }
      t.sendResponseHeaders(1000, response.length());
      
      OutputStream os = t.getResponseBody();
      
      os.write(response.getBytes());
      os.close();
    }
  }

  static class GetHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {

      // add the required response header for a PDF file
      Headers h = t.getResponseHeaders();
      //h.add("Content-Type", "application/pdf");

      // a PDF (you provide your own!)
      File file = new File ("got.jpg");
      byte [] bytearray  = new byte [(int)file.length()];
      FileInputStream fis = new FileInputStream(file);
      BufferedInputStream bis = new BufferedInputStream(fis);
      bis.read(bytearray, 0, bytearray.length);

      // ok, we are ready to send the response.
      t.sendResponseHeaders(200, file.length());
      OutputStream os = t.getResponseBody();
      os.write(bytearray,0,bytearray.length);
      os.close();
    }
  }
  static class meHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {

      // add the required response header for a PDF file
      Headers h = t.getResponseHeaders();
     // h.add("Content-Type", "application/pdf");

      // a PDF (you provide your own!)
      File file = new File ("text.txt");
      byte [] bytearray  = new byte [(int)file.length()];
      FileInputStream fis = new FileInputStream(file);
      BufferedInputStream bis = new BufferedInputStream(fis);
      bis.read(bytearray, 0, bytearray.length);

      // ok, we are ready to send the response.
      t.sendResponseHeaders(200, file.length());
      OutputStream os = t.getResponseBody();
      os.write(bytearray,0,bytearray.length);
      os.close();
    }
  }
  static class musicHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {

      // add the required response header for a PDF file
      Headers h = t.getResponseHeaders();
     // h.add("Content-Type", "application/pdf");

      // a PDF (you provide your own!)
      File file = new File ("Sum 41 - Pieces.mp3");
      byte [] bytearray  = new byte [(int)file.length()];
      FileInputStream fis = new FileInputStream(file);
      BufferedInputStream bis = new BufferedInputStream(fis);
      bis.read(bytearray, 0, bytearray.length);

      // ok, we are ready to send the response.
      t.sendResponseHeaders(200, file.length());
      OutputStream os = t.getResponseBody();
      os.write(bytearray,0,bytearray.length);
      os.close();
    }
  }

    private static class videoHandler implements HttpHandler {

 @Override
    public void handle(HttpExchange t) throws IOException {

      // add the required response header for a PDF file
      Headers h = t.getResponseHeaders();
     // h.add("Content-Type", "application/pdf");

      // a PDF (you provide your own!)
      File file = new File ("video.mp4");
      byte [] bytearray  = new byte [(int)file.length()];
      FileInputStream fis = new FileInputStream(file);
      BufferedInputStream bis = new BufferedInputStream(fis);
      bis.read(bytearray, 0, bytearray.length);

      // ok, we are ready to send the response.
      t.sendResponseHeaders(200, file.length());
      OutputStream os = t.getResponseBody();
      os.write(bytearray,0,bytearray.length);
      os.close();
    }
    }

   
}
