package gwtquery.samples.client;

import static com.google.gwt.query.client.GQuery.$;

import java.util.HashMap;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.query.client.js.JsCache;
import com.google.gwt.query.client.js.JsMap;
import com.google.gwt.query.client.js.JsObjectArray;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class JsCollectionVsJavaCollection implements EntryPoint{
  
  public static final int MAX_ITEMS = 100000;
  
  
  public void onModuleLoad() {
    
    Button b = new Button("run test");
    b.addClickHandler(new ClickHandler() {
      
      public void onClick(ClickEvent event) {
        $(".gwt-label").remove();
        testJsMapVsHashMap();       
      }
    });
    
    RootPanel.get().add(b);
    
  }
  

  public void testJsMapVsHashMap() {
    log("Testing jsMap");
    
    log("init phase");
    for (int i = 0; i < MAX_ITEMS; i++){
      new String(""+i);
    }
    double ellapsedTime, totalTime; 
    
    JsCache cache = JsCache.create();
    
    log("Testing cache : put "+MAX_ITEMS+" items in the cache :");
    totalTime = ellapsedTime = Duration.currentTimeMillis();
    for (int i = 0; i < MAX_ITEMS; i++){
      cache.put(new String(""+i), new Object());
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    log("Testing cache : do "+MAX_ITEMS+" get in the cache :");
    ellapsedTime = Duration.currentTimeMillis();
    for (int i = 0 ; i < MAX_ITEMS; i++){
      int random = Random.nextInt(MAX_ITEMS);
      cache.get(new String(""+random));
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    log("Testing cache : do "+MAX_ITEMS+" exist (JsCache.exists() ) in the cache :");
    ellapsedTime = Duration.currentTimeMillis();
    for (int i = 0 ; i < MAX_ITEMS; i++){
      int random = Random.nextInt(MAX_ITEMS);
      cache.exists(new String(""+random));
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    log("Testing cache : get all keys :");
    ellapsedTime = Duration.currentTimeMillis();
    for (String s: cache.keys()) {
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    log("Testing cache : get all values (JsCache.elements() ) :");
    ellapsedTime = Duration.currentTimeMillis();
    for (Object o: cache.elements()) {
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    totalTime = Duration.currentTimeMillis() - totalTime;
    log(" Total : "+ totalTime);
    log("-------------");
    log("");
    
    HashMap<String, Object> hashMap = new HashMap<String, Object>();
    
    log("Testing hashMap : put "+MAX_ITEMS+" items in the map :");
    totalTime = ellapsedTime = Duration.currentTimeMillis();
    for (int i = 0; i < MAX_ITEMS; i++){
      hashMap.put(new String(""+i), new Object());
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    log("Testing hashMap : do "+MAX_ITEMS+" get in the map :");
    ellapsedTime = Duration.currentTimeMillis();
    for (int i = 0 ; i < MAX_ITEMS; i++){
      int random = Random.nextInt(MAX_ITEMS);
      hashMap.get(new String(""+random));
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    log("Testing hashMap : do "+MAX_ITEMS+" containsKey() :");
    ellapsedTime = Duration.currentTimeMillis();
    for (int i = 0 ; i < MAX_ITEMS; i++){
      int random = Random.nextInt(MAX_ITEMS);
      hashMap.containsKey(new String(""+random));
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    log("Testing hashMap : get all keys :");
    ellapsedTime = Duration.currentTimeMillis();
    for (String s: hashMap.keySet()) {
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    log("Testing hashMap : get all values :");
    ellapsedTime = Duration.currentTimeMillis();
    for (Object o : hashMap.values()) {
    }
    ellapsedTime = Duration.currentTimeMillis() - ellapsedTime;
    log(" ellapsed Time : "+ellapsedTime);
    
    totalTime = Duration.currentTimeMillis() - totalTime;
    log(" Total : "+ totalTime);
    log("-------------");
  }




  public void log(String msg) {
    RootPanel.get().add(new Label(msg));
  }


}
