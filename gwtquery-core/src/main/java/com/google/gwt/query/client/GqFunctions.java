package com.google.gwt.query.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;

public interface GqFunctions  {
  public interface IsReturnFunction<R> extends IsReturnFunction1<Object, R>{
    R call();
    default R call(Object t) {
      return call(t);
    }
  }
  public interface IsReturnFunction1<T, R> extends IsReturnFunction2<T, Object, R>{
    R call(T t);
    default R call(T t, Object u) {
      return call(t);
    }
  }
  public interface IsReturnFunction2<T, U, R> extends IsReturnFunction3<T, U, Object, R>{
    R call(T t, U u);
    default R call(T t, U u, Object v) {
      return call(t, u);
    }
  }
  public interface IsReturnFunction3<T, U, V, R> extends IsReturnFunction4<T, U, V, Object, R> {
    R call(T t, U u, V v);
    default R call(T t, U u, V v, Object w) {
      return call(t, u, v);
    }
  }
  public interface IsReturnFunction4<T, U, V, W, R> extends IsReturnFunction5<T, U, V, W, Object, R>{
    R call(T t, U u, V v, W w);
    default R call(T t, U u, V v, W w, Object x){
      return call(t, u, v, w);
    }
  }
  public interface IsReturnFunction5<T, U, V, W, X, R> {
    R call(T t, U u, V v, W w, X x);
  }
  public interface IsReturnFunctionArray<T, R> {
    R call(T... t);
  }

  public interface IsVoidFunction extends IsVoidFunction1<Object> {
    void run();
    default void run(Object t) {
      run();
    }
  }
  public interface IsVoidFunction1<T> extends IsVoidFunction2<T, Object> {
    void run(T t);
    default void run(T t, Object u) {
      run(t);
    }
  }
  public interface IsVoidFunction2<T, U>  {
    void run(T t, U u);
  }
  public interface IsVoidFunctionArray<T>  {
    void run(T... t);
  }
  public interface IsEventFunction extends IsReturnFunction1<Event, Boolean> {}
  public interface IsEventDataFunction<T> extends IsReturnFunction2<Event, T, Boolean> {}
  public interface IsEventDataFunction2<T, U> extends IsReturnFunction3<Event, T, U, Boolean> {}
  public interface IsEventDataFunction3<T, U, V> extends IsReturnFunction4<Event, T, U, V, Boolean> {}
  public interface IsEventDataFunction4<T, U, V, W> extends IsReturnFunction5<Event, T, U, V, W, Boolean> {}
  public interface IsEventFunctionVoid extends IsVoidFunction1<Event> {}
  public interface IsElementFunction extends IsVoidFunction1<Element> {}
  public interface IsElementIndexFunction extends IsVoidFunction2<Integer, Element> {}
  public interface IsElementIndexedFunction extends IsReturnFunction1<Element, Void> {}

}
