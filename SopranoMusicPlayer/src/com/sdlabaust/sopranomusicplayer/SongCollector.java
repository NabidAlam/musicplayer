package com.sdlabaust.sopranomusicplayer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;

public class SongCollector {
	// SD card Path
	final String MEDIA_PATH = new String("/sdcard/");

	private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

	// Read all .mp3 files from sd card
	public ArrayList<HashMap<String, String>> getPlayList() {
		File home = new File(MEDIA_PATH);

		if (home.listFiles(new FileExtensionFilter()).length > 0) {
			for (File file : home.listFiles(new FileExtensionFilter())) {

				// Store all songtitles and songpaths in hashmap and return them
				// to arraylist

				HashMap<String, String> song = new HashMap<String, String>();
				song.put(
						"songTitle",
						file.getName().substring(0,
								(file.getName().length() - 4)));
				song.put("songPath", file.getPath());

				songsList.add(song);
			}
		}

		return songsList;
	}

	// Filter .mp3 files

	class FileExtensionFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".mp3") || name.endsWith(".MP3"));
		}
	}
}
