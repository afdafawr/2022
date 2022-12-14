package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamExample {
	
	public static void main(String[] args) {
		try {
			WriteBuf();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileCopy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//byte단위로 읽고 쓰고 작업
	public static void fileCopy() throws IOException {
		FileInputStream fis = new FileInputStream("C:/Temp/origin.jpg");
		FileOutputStream fos = new FileOutputStream("C:/Temp/copy.jpg");
		byte[] buf = new byte[1000];
		
		long start = System.currentTimeMillis();
		
		while(true) {
			int bytes = fis.read(buf); // 한 바이트씩 읽음.
			
			if(bytes == -1) {
				break;
			}
			fos.write(buf); // 배열의 크기만큼 버퍼에 저장하고 한번에 저장
		}
		
		fis.close();
		fos.close();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println("complete");
	}
	
	public static void readBuf() throws IOException {
		InputStream is = new FileInputStream("C:/Temp/Data2.dat");
		byte[] buf = new byte[2]; // 2바이트씩 읽겟다
		
		while(true) {
			int bytes = is.read(buf); //배열에 선언된 크기만큼 읽어들임
			if(bytes == -1) {
				break;
			}
			for(int i=0; i<bytes; i++) {
				System.out.print(buf[i] + " ");
			}
			System.out.println("");
			
		}
		System.out.println("Complete");
		is.close();
	}
	
	public static void WriteBuf() throws IOException {
		byte[] arr = new byte[] {10,20,30};
		OutputStream os = new FileOutputStream("C:/Temp/Data2.dat");
		os.write(arr);
		os.close();
		
		System.out.println("Complete.");
	}
	
	public static void read() {
		try {
			InputStream is = new FileInputStream("C:/Temp/Data1.dat");
			
			while(true) {
				int bytes = is.read(); // byte 읽고 더 이상 읽을 바이트가 없으면 -1 반환.
				if(bytes == -1) {
					break;
				}
				System.out.println(bytes);
			}
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Complete");
	}
	public static void write() {
		//출력스트림(바이트)
				try {
				OutputStream os = new FileOutputStream("C:/Temp/Data1.dat");
				//write(byte b);
				byte a = 10;
				byte b = 20;

				os.write(a);
				os.write(b);
				
				//resource 반환
				
				os.close();		
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
