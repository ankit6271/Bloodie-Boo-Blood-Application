package Project1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.net.URL;
import java.net.Socket;

public class Net {
	String s=" ";
	DataOutputStream dos;
	DataInputStream di;
	Socket so ;
    public Net(String si) throws Exception, IOException {
        so=new Socket(si,9995);
        di=new DataInputStream(so.getInputStream());
        dos=new DataOutputStream(so.getOutputStream()); 
    }
	public String toSend(String texttodonor) throws IOException{
        dos.writeUTF(texttodonor);
        s=di.readUTF();
        if (s=="Stop"){
        	return s;
        }
        else{
        	 System.out.println("Server Says:"+s);//add this string to textbox
        	 return s;
        }
	}
	public void connectionClose() throws IOException {
		so.close();
	}
}

