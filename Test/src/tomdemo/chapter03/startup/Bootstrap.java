package tomdemo.chapter03.startup;

import tomdemo.chapter03.connector.http.HttpConnector;


public class Bootstrap {
	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector();
		connector.start();
	}
}
