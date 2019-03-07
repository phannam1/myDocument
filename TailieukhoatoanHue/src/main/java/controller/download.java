package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.net.HttpURLConnection;
import java.net.URL;



public class download implements Runnable {
	String link;
	File out;
	public  download(String link, File out) {
		this.link = link;
		this.out = out;
	}
	@Override
	public void run() {
		try {
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			double fileSize = (double)http.getContentLengthLong();
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new  FileOutputStream(this.out);
			BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
			byte[] buffer = new byte[1024];
			double downloaded =0.00;
			int read =0;
			double percentdownloaded = 0.00;
			while((read = in.read(buffer,0,1024))>=0) {
				bout.write(buffer, 0, read);
				downloaded += read;
				percentdownloaded = (downloaded*100)/fileSize;
				String percent = String.format("%.4f", percentdownloaded);
				System.out.println("download" + percent + "% of a file." );
				
			}
			bout.close();
			in.close();
			System.out.println("download complete" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
