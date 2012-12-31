/* Copyright 2012 ESRI
 *
 * All rights reserved under the copyright laws of the United States
 * and applicable international laws, treaties, and conventions.
 *
 * You may freely redistribute and use this sample code, with or
 * without modification, provided you include the original copyright
 * notice and use restrictions.
 *
 * See the 锟絊ample code usage restrictions锟�document for further information.
 *
 */

package com.esri.arcgis.android.samples.helloworld;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;

import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;

public class HelloWorld extends Activity {
	MapView map = null;
	ArcGISTiledMapServiceLayer tileLayer;


	
	
	
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// Retrieve the map and initial extent from XML layout
		map = (MapView)findViewById(R.id.map);
		// Add tiled layer to MapView
//		tileLayer = new ArcGISTiledMapServiceLayer("http://services.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer");
//		map.addLayer(tileLayer);
		
		CopyData();
	}
	

	void  CopyData()
	{
		File fromFile=new File("/data/data/com.ful/databases/e4p");
		
				File toFile=new File("/mnt/sdcard/e4p.db");
		
		
				copyfile(fromFile,toFile,true);
	}
	public static void copyfile(File fromFile, File toFile, Boolean rewrite) {

		if (!fromFile.exists()) {

			return;

		}

		if (!fromFile.isFile()) {

			return;

		}

//		if (!fromFile.canRead()) {
//
//			return;
//
//		}

		if (!toFile.getParentFile().exists()) {

			toFile.getParentFile().mkdirs();

		}

		if (toFile.exists() && rewrite) {

			toFile.delete();

		}

		try {

			java.io.FileInputStream fosfrom = new java.io.FileInputStream(
					fromFile);

			java.io.FileOutputStream fosto = new FileOutputStream(toFile);

			byte bt[] = new byte[1024];

			int c;

			while ((c = fosfrom.read(bt)) > 0) {

				fosto.write(bt, 0, c); // 将内容写到新文件当中

			}

			fosfrom.close();

			fosto.close();

		} catch (Exception exw) {
			
			System.out.print("");
		}
	}

	
	protected void onPause() {
		super.onPause();
		map.pause();
 }

	protected void onResume() {
		super.onResume(); 
		map.unpause();
	}	
	
}