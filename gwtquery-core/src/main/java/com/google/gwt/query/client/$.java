package com.google.gwt.query.client;

import static com.google.gwt.query.client.GQuery.console;

import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.GqFunctions.IsElementFunction;
import com.google.gwt.query.client.GqFunctions.IsElementIndexFunction;
import com.google.gwt.query.client.GqFunctions.IsEventDataFunction;
import com.google.gwt.query.client.GqFunctions.IsEventDataFunction2;
import com.google.gwt.query.client.GqFunctions.IsEventDataFunction3;
import com.google.gwt.query.client.GqFunctions.IsEventDataFunction4;
import com.google.gwt.query.client.GqFunctions.IsEventFunction;
import com.google.gwt.query.client.GqFunctions.IsEventFunctionVoid;
import com.google.gwt.query.client.GqFunctions.IsReturnFunction;
import com.google.gwt.query.client.GqFunctions.IsReturnFunction1;
import com.google.gwt.query.client.GqFunctions.IsVoidFunction;
import com.google.gwt.query.client.GqFunctions.IsVoidFunction1;
import com.google.gwt.query.client.GqFunctions.IsVoidFunction2;
import com.google.gwt.query.client.plugins.deferred.Deferred;
import com.google.gwt.user.client.Event;

public abstract class $ implements IsReturnFunction {

  public static GQuery $(Object o) {
    return GQuery.$(o);
  }

  public static <T, R> Function[] toFnc(IsReturnFunction1<T, R>...fncs) {
    Function[] ret = new Function[fncs.length];
    for (int i = 0; i < fncs.length; i++) {
      ret[i] = toFnc(fncs[i]);
    }
    return ret;
  }
  public static <T, R> Function[] toFnc(Object...fncs) {
    Function[] ret = new Function[fncs.length];
    for (int i = 0; i < fncs.length; i++) {
      if (fncs[i] instanceof IsVoidFunction) {
        ret[i] = toFnc((IsVoidFunction)fncs[i]);
      } else if (fncs[i] instanceof IsReturnFunction) {
        ret[i] = toFnc((IsReturnFunction)fncs[i]);
      } else if (fncs[i] instanceof IsReturnFunction1) {
        ret[i] = toFnc((IsReturnFunction1)fncs[i]);
      } else {
        console.log("Unknown class type: " + fncs[i]);
      }
    }
    return ret;
  }
  public static Function toFnc(IsReturnFunction1 fnc) {
    return new Function() {
      public Object f(Object... args) {
        return fnc.call(args[0]);
      }
    };
  }
  public static Function toFnc(IsVoidFunction fnc) {
    return fnc instanceof Function ? (Function) fnc : new Function() {
      public  void f() {
        fnc.run();
      };
    };
  }
  public static Function toFnc(IsVoidFunction1 fnc) {
    return fnc instanceof Function ? (Function) fnc : new Function() {
      public  Object f(Object[] args) {
        fnc.run(arguments(0));
        return null;
      };
    };
  }
  public static Function toFnc(IsVoidFunction2 fnc) {
    return fnc instanceof Function ? (Function) fnc : new Function() {
      public  Object f(Object[] args) {
        fnc.run(arguments(0), arguments(1));
        return null;
      };
    };
  }
  public static Function toFnc(IsReturnFunction fnc) {
    return fnc instanceof Function ? (Function) fnc : new Function() {
      public  Object f(Object[] args) {
        return fnc.call();
      };
    };
  }
  public static Function toFnc(IsEventFunction fnc) {
    return new Function() {
      public boolean f(Event e) {
        return fnc.call(e);
      }
    };
  }
  public static Function toFnc(IsEventDataFunction<Object> fnc) {
    return new Function() {
      public boolean f(Event e, Object... arg) {
        return fnc.call(e, arguments(0));
      }
    };
  }
  public static Function toFnc(IsEventDataFunction2<Object, Object> fnc) {
    return new Function() {
      public boolean f(Event e, Object... arg) {
        return fnc.call(e, arguments(0), arguments(1));
      }
    };
  }
  public static Function toFnc(IsEventDataFunction3<Object, Object, Object> fnc) {
    return new Function() {
      public boolean f(Event e, Object... arg) {
        return fnc.call(e, arguments(0), arguments(1), arguments(2));
      }
    };
  }
  public static Function toFnc(IsEventDataFunction4<Object, Object, Object, Object> fnc) {
    return new Function() {
      public boolean f(Event e, Object... arg) {
        return fnc.call(e, arguments(0), arguments(1), arguments(2), arguments(3));
      }
    };
  }
  private Function toFnc(IsEventFunctionVoid fnc) {
    return new Function() {
      public boolean f(Event e) {
        fnc.run(e);
        return true;
      }
    };
  }
  public static Function toFnc(IsElementFunction fnc) {
    return new Function() {
      public void f(Element e) {
        fnc.run(e);
      }
    };
  }
  public static Function toFnc(IsElementIndexFunction fnc) {
    return new Function() {
      public Object f(Element e, int i) {
        fnc.run(i, e);
        return null;
      }
    };
  }
  private GQuery asGq() {
    return (GQuery)this;
  }

  public GQuery on(String name, IsEventFunction fnc) {
    return this.on(name, null, null, fnc);
  }
  public <T>GQuery on(String name, IsEventDataFunction<T> fnc) {
    return this.on(name, null, null, fnc);
  }
  public <T, U>GQuery on(String name, IsEventDataFunction2<T, U> fnc) {
    return this.on(name, null, null, fnc);
  }
  public <T, U, V>GQuery on(String name, IsEventDataFunction3<T, U, V> fnc) {
    return this.on(name, null, null, fnc);
  }
  public <T, U, V, W>GQuery on(String name, IsEventDataFunction4<T, U, V, W> fnc) {
    return this.on(name, null, null, fnc);
  }
  public GQuery on(String name, String selector, Object data, IsEventFunction fnc) {
    return asGq().on(name, selector, data, toFnc(fnc));
  }
  public <T>GQuery on(String name, String selector, T data, IsEventDataFunction<T> fnc) {
    return asGq().on(name, selector, data, toFnc((IsEventDataFunction)fnc));
  }
  public <T, U>GQuery on(String name, String selector, T data, IsEventDataFunction2<T, U> fnc) {
    return asGq().on(name, selector, data, toFnc((IsEventDataFunction2)fnc));
  }
  public <T, U, V>GQuery on(String name, String selector, T data, IsEventDataFunction3<T, U, V> fnc) {
    return asGq().on(name, selector, data, toFnc((IsEventDataFunction3)fnc));
  }
  public <T, U, V, W>GQuery on(String name, String selector, T data, IsEventDataFunction4<T, U, V, W> fnc) {
    return asGq().on(name, selector, data, toFnc((IsEventDataFunction4)fnc));
  }

  public GQuery each(IsVoidFunction fnc) {
    return asGq().each(new Function[]{toFnc(fnc)});
  }
  public GQuery each(IsElementFunction fnc) {
    return asGq().each(new Function[]{toFnc(fnc)});
  }
  public GQuery each(IsElementIndexFunction fnc) {
    return asGq().each(new Function[]{toFnc(fnc)});
  }

  public GQuery ready(IsVoidFunction fnc) {
    return asGq().each(fnc);
  }

  /**
   * Provides a way to execute callback Functions based on one or more objects
   * that represent asynchronous events.
   *
   * Arguments can be of any Object, but normally you would pass Promises.
   * In the case you provide a GQuery object it will call the promise() method to return
   * a Promise which will be executed when the queue is resolved.
   * In the case you provide a normal Object, it will return a promise which will be immediately
   * resolved with the object as argument.
   * In the case you provide a Function it will executed and if the f(Object...) method returns
   * a new promise it will be used, otherwise we will use the returned object like in the last case.
   *
   * It Returns a new promise which will be finalized when all of its subordinates finish.
   * In the case of all subordinates are resolved correctly the promise will be resolved
   * otherwise it will be rejected.
   */
//  public static Promise when(Object subordinates) {
//    return Deferred.when(subordinates);
//  }
//  public static Promise when(Promise... subordinates) {
//    return Deferred.when(subordinates);
//  }
//  public static Promise when(Function... subordinates) {
//    return Deferred.when(subordinates);
//  }
//  public static Promise when(GQuery... subordinates) {
//    return Deferred.when(subordinates);
//  }
  public static Promise when(IsReturnFunction fnc) {
    return Deferred.when(toFnc(fnc));
  }
  public static Promise when(IsReturnFunction a, IsReturnFunction b) {
    return Deferred.when(toFnc(a), toFnc(b));
  }
  public static Promise when(IsReturnFunction a, IsReturnFunction b, IsReturnFunction c) {
    return Deferred.when(toFnc(a), toFnc(b), toFnc(c));
  }
  public static Promise when(IsReturnFunction a, IsReturnFunction b, IsReturnFunction c, IsReturnFunction d) {
    return Deferred.when(toFnc(a), toFnc(b), toFnc(c), toFnc(d));
  }

  /**
   * A constructor function that returns a chainable utility object with methods to register
   * multiple callbacks into callback queues, invoke callback queues, and relay the success
   * or failure state of any synchronous or asynchronous function.
   */
  public static Promise.Deferred Deferred() {
    return new Deferred();
  }
  
  public final boolean FALSE = Boolean.FALSE;
  public final boolean TRUE = Boolean.TRUE;
  public final Object NULL = null;

  public Object call() {
    return asGq().promise();
  }
}
