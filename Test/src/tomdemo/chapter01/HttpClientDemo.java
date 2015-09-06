package tomdemo.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpClientDemo {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("www.baidu.com",80);
			OutputStream os = socket.getOutputStream();
			boolean autoflush = true;
			PrintWriter out = new PrintWriter(socket.getOutputStream(),autoflush);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// send an HTTP request to the web server
			out.println("GET / HTTP/1.1");
			out.println("Host:www.baidu.com");
			out.println("Connection:close");
			out.println();
			// read the response
			boolean loop = true;
			StringBuilder sb = new StringBuilder(8096);
			while(loop) {
				if(in.ready()) {
					int i = 0;
					while(i!=-1) {
						i = in.read();
						sb.append((char)i);
					}
					loop = false;
				}
				Thread.currentThread().sleep(50);
			}
			System.out.println(sb.toString());
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
