package text_to_speech;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class SythesizeTest {

	public static void main(String[] args) {
		TextToSpeech service = new TextToSpeech("31699049-e71f-465c-8f2e-0ad2cfc27a9d","y78zU5bOBWlN");
		
		try {
			  String text = "Se necesita una poca de gracia Una poca de gracia pa mi pa ti";
			  InputStream stream = service.synthesize(text, Voice.ES_ENRIQUE,
			    AudioFormat.WAV).execute();
			  InputStream in = WaveUtils.reWriteWaveHeader(stream);
			  OutputStream out = new FileOutputStream("para bailar la bamba.wav");
			  byte[] buffer = new byte[1024];
			  int length;
			  while ((length = in.read(buffer)) > 0) {
			    out.write(buffer, 0, length);
			  }
			  out.close();
			  in.close();
			  stream.close();
			}
			catch (Exception e) {
			  e.printStackTrace();
			}
	}
}

