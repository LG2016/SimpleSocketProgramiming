package SimpleSocketProgramiming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
  public static void main(String[] args) {
	try {
		//1.创建ServerSocket对象，绑定端口
		ServerSocket severSocket=new ServerSocket(8888);
		//2.通过accept()方法监听端口
		int count=0;
		JOptionPane.showMessageDialog(null, "服务器端在等待客户端连接");
		while (true) {
			Socket socket=severSocket.accept();
			SeverThread severThread=new SeverThread(socket);
		    severThread.start();
		    count++;
		    JOptionPane.showMessageDialog(null, "当前的客户端："+count);
		}

	 
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
