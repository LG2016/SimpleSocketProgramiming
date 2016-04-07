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
	
		//创建Socket,绑定主机和端口
		Socket socket=new Socket("localhost", 8888);
		//获取输出流，发送消息
		OutputStream os=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(os);
		Scanner sca=new Scanner(System.in);
		String str=sca.next();
		//String str="给我当前时间";
		pw.write("客户端："+str);
		pw.flush();
		socket.shutdownOutput();
		//获取输入流
		InputStream  is=socket.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		String inf=null;
		while((inf=br.readLine())!=null)
		{
			System.out.println(inf);
		}
	
		//关闭资源
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
