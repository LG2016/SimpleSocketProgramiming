package SimpleSocketProgramiming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
  public static void main(String[] args) {
	try {
		//1.����ServerSocket���󣬰󶨶˿�
		ServerSocket severSocket=new ServerSocket(8888);
		//2.ͨ��accept()���������˿�
		int count=0;
		JOptionPane.showMessageDialog(null, "���������ڵȴ��ͻ�������");
		while (true) {
			Socket socket=severSocket.accept();
			SeverThread severThread=new SeverThread(socket);
		    severThread.start();
		    count++;
		    JOptionPane.showMessageDialog(null, "��ǰ�Ŀͻ��ˣ�"+count);
		}

	 
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
