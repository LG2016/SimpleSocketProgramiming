package SimpleSocketProgramiming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class SeverThread extends Thread {
             Socket socket;
	
             public SeverThread(Socket socket) {
				this.socket=socket;
			}
             @Override
            public void run() {
     
                InputStream is = null;
         		InputStream in=null;
				InputStreamReader isr=null;
				BufferedReader br=null;
				OutputStream os=null;
				PrintWriter pw=null;
				try {
					is = socket.getInputStream();
					isr = new InputStreamReader(is);
					br = new BufferedReader(isr);
					String inf=null;
					while((inf=br.readLine())!=null)
					{
						System.out.println(inf);
					}
					socket.shutdownInput();
					os = socket.getOutputStream();
					pw = new PrintWriter(os);
					pw.write("服务器：欢迎你访问服务端\n");
					Date date=new Date();
					String str=date.toString();
					char[] strc=str.toCharArray();
					pw.write("服务器当前的时间：");
					pw.write(strc);
					pw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}finally
				{
					//关闭资源
					try {
						if(pw!=null) pw.close();
						if(os!=null) os.close();
						if(socket!=null) socket.close();
						if(br!=null) br.close();
						if(isr!=null) isr.close();
						if(is!=null) is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
         		
         	
            }
}
