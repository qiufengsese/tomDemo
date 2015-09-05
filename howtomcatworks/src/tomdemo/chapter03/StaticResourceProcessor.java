package tomdemo.chapter03;

import java.io.IOException;

import tomdemo.chapter03.connector.http.HttpRequest;
import tomdemo.chapter03.connector.http.HttpResponse;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
