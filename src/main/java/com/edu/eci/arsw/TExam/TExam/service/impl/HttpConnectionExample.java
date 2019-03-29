/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eci.arsw.TExam.TExam.service.impl;

import com.edu.eci.arsw.TExam.TExam.service.HttpConnect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2110111
 * api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=fde9115f7f57cda0b34af529884fb8c4
 */
public class HttpConnectionExample implements HttpConnect{
    
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String GET_URLEND = "&appid=fde9115f7f57cda0b34af529884fb8c4";  
    private HashMap<String, String> cache = new HashMap();

    @Override
    public String weatherCity(String city) {
        if(cache.containsKey(city)){
            return cache.get(city);
        }else{           
            StringBuffer response = new StringBuffer();
            try {
                URL obj = new URL(GET_URL + city + GET_URLEND);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", USER_AGENT);            
                        
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;                
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }            
            } catch (MalformedURLException ex) {
                Logger.getLogger(HttpConnectionExample.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HttpConnectionExample.class.getName()).log(Level.SEVERE, null, ex);
            }
            cache.put(city, response.toString());
            return cache.get(city);
        }
    }
    
}