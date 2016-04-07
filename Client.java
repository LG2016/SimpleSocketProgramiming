package SimpleSocketProgramiming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
public static void main(String[] args) {
	try {
	
		//����Socket,�������Ͷ˿�
		Socket socket=new Socket("localhost", 8888);
		//��ȡ�������������Ϣ
		OutputStream os=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(os);
		Scanner sca=new Scanner(System.in);
		String str=sca.next();
		//String str="���ҵ�ǰʱ��";
		pw.write("�ͻ��ˣ�"+str);
		pw.flush();
		socket.shutdownOutput();
		//��ȡ������
		InputStream  is=socket.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		String inf=null;
		while((inf=br.readLine())!=null)
		{
			System.out.println(inf);
		}
	
		//�ر���Դ
		br.close();
		isr.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
	

	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
