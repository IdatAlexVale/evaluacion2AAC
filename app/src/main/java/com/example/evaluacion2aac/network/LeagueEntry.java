package com.example.evaluacion2aac.network;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.evaluacion2aac.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class LeagueEntry {
    private static final String TAG = LeagueEntry.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public  final String url;
    public final String price;
    public final String description;

    public LeagueEntry(String title, String dynamicUrl, String url, String price, String description){
        this.title= title;
        this.dynamicUrl= Uri.parse(dynamicUrl);
        this.url= url;
        this.price = price;
        this.description=description;
    }
    public static List<LeagueEntry> initLeagueEntryList(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.league);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Error en el archivo json", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Error al cerrar el input stream", exception);
            }
        }
        String jsonLeagueString = writer.toString();
        Gson gson = new Gson();
        Type leagueListType = new TypeToken<ArrayList<LeagueEntry>>() {
        }.getType();

        return gson.fromJson(jsonLeagueString, leagueListType);
      }
    }

