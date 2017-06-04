package nz.ac.aut.ense701.gameModel;

import java.applet.AudioClip;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BGM extends Thread {
	File file;
	AudioInputStream audio;
	AudioFormat format;
	SourceDataLine auline = null;
	DataLine.Info info;
	String path = "BackgroundMusic.wav";
	boolean stop = false;

	public BGM() {
	}

	public void run() {
		while (!stop) {
			try {
				file = new File(path);
				audio = AudioSystem.getAudioInputStream(file);
				format = audio.getFormat();
				info = new DataLine.Info(SourceDataLine.class, format);
				auline = (SourceDataLine) AudioSystem.getLine(info);
				auline.open(format);
				auline.start();
				int nBytesRead = 0;
				byte[] abData = new byte[524288];
				while (nBytesRead != -1) {
					nBytesRead = audio.read(abData, 0, abData.length);
					if (nBytesRead >= 0) {
						auline.write(abData, 0, nBytesRead);
					}
				}
			} catch (IOException e) {
				// System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				auline.drain();
				auline.close();
			}
		}
	}

}
