package org.apache.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;

/**
 * This class echoes a string called from JavaScript.
 */
public class EchoPlugin extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {            
  
    try {                 
      if(action.equals("echo")) {
        String message = args.getString(0);
        this.echo(message, callbackContext);
        return true;
      }
      return false;      
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      callbackContext.error(e.getMessage());
      return false;
    }   
  }

  private void echo(String message, CallbackContext callbackContext) {
    if(message != null && message.length() > 0) {
      callbackContext.success(message);
    } else {
      callbackContext.error("Error: Expected one non-empty string argument.");
    }
  }
}
