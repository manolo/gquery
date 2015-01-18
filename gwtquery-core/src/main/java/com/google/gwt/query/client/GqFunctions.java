package com.google.gwt.query.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;

public interface GqFunctions  {
  public interface IsReturnFunction1<T, R>  {
    R call(T t);  
  }
  public interface IsReturnFunction2<T, U, R>  {
    R call(T t, U u);  
  }
  public interface IsReturnFunction3<T, U, V, R>  {
    R call(T t, U u, V v);  
  }
  public interface IsReturnFunction4<T, U, V, W, R>  {
    R call(T t, U u, V v, W w);  
  }
  public interface IsReturnFunction5<T, U, V, W, X, R>  {
    R call(T t, U u, V v, W w, X x);  
  }
  public interface IsReturnFunctionArray<T, R>  {
    R call(T... t);  
  }
  public interface IsVoidFunction<T>  {
    void call(T t);  
  }
  public interface IsVoidFunction2<T, U>  {
    void call(T t, U u);  
  }
  public interface IsVoidFunctionArray<T>  {
    void call(T... t);  
  }
  public interface IsReturnFunction {
    Object call();
  }
  public interface IsEventFunction extends IsReturnFunction1<Event, Boolean> {}
  public interface IsEventDataFunction<T> extends IsReturnFunction2<Event, T, Boolean> {}
  public interface IsEventDataFunction2<T, U> extends IsReturnFunction3<Event, T, U, Boolean> {}
  public interface IsEventDataFunction3<T, U, V> extends IsReturnFunction4<Event, T, U, V, Boolean> {}
  public interface IsEventDataFunction4<T, U, V, W> extends IsReturnFunction5<Event, T, U, V, W, Boolean> {}
  public interface IsEventFunctionVoid extends IsVoidFunction<Event> {}
  public interface IsElementFunction extends IsVoidFunction<Element> {}
  public interface IsElementIndexFunction extends IsVoidFunction2<Integer, Element> {}
  public interface IsElementIndexedFunction extends IsReturnFunction1<Element, Void> {}
  
}
