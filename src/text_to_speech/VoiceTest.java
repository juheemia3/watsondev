package text_to_speech;

import java.util.List;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

public class VoiceTest {

	public static void main(String[] args) {
// 인증 방법 1)		
		TextToSpeech service = new TextToSpeech("31699049-e71f-465c-8f2e-0ad2cfc27a9d","y78zU5bOBWlN");
		
/* 인증 방법 2)
 * 		TextToSpeech service = new TextToSpeech();
		service.setUsernameAndPassword("31699049-e71f-465c-8f2e-0ad2cfc27a9d","y78zU5bOBWlN");
*/
		ServiceCall call = service.getVoices();
		List<Voice> voices = (List<Voice>)call.execute();
		for(Voice voice : voices) { // voices라는 리스트에서 voice를 계속 꺼내옴!
			System.out.println(voice.getName()+ ":" +voice.getLanguage());

		}
	}
}
