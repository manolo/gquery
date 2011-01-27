/*
 * Copyright 2011, The gwtquery team.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.query.client.css;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.HasCssName;
import com.google.gwt.dom.client.Style.Unit;

/**
 * This property set the width of an element's border.
 */
public class BorderWidthProperty extends
    AbstractCssProperty<BorderWidthProperty.LineWidth> implements TakesLength {

  public static class LineWidth implements HasCssName {

    public static LineWidth INHERIT;
    public static LineWidth MEDIUM;
    public static LineWidth THICK;
    public static LineWidth THIN;

    static {
      MEDIUM = new LineWidth("medium");
      THICK = new LineWidth("thick");
      THIN = new LineWidth("thin");
      INHERIT = new LineWidth(CSS.INHERIT_VALUE);

    }

    public static LineWidth length(int l, Unit unit) {
      return new LineWidth("" + l + (unit != null ? unit.getType() : ""));
    }

    public static LineWidth length(Length l) {
      return new LineWidth(l.getCssName());
    }

    private String cssValue;

    private LineWidth(String value) {
      cssValue = value;
    }

    public String getCssName() {
      return cssValue;
    }

  }

  private static final String BORDER_BOTTOM_WIDTH_PROPERTY = "borderBottomWidth";
  private static final String BORDER_LEFT_WIDTH_PROPERTY = "borderLeftWidth";
  private static final String BORDER_RIGHT_WIDTH_PROPERTY = "borderRightWidth";
  private static final String BORDER_TOP_WIDTH_PROPERTY = "borderTopWidth";
  private static final String BORDER_WIDTH_PROPERTY = "borderWidth";

  public static void init() {
    CSS.BORDER_WIDTH = new BorderWidthProperty(BORDER_WIDTH_PROPERTY);
    CSS.BORDER_BOTTOM_WIDTH = new BorderWidthProperty(
        BORDER_BOTTOM_WIDTH_PROPERTY);
    CSS.BORDER_LEFT_WIDTH = new BorderWidthProperty(BORDER_LEFT_WIDTH_PROPERTY);
    CSS.BORDER_RIGHT_WIDTH = new BorderWidthProperty(
        BORDER_RIGHT_WIDTH_PROPERTY);
    CSS.BORDER_TOP_WIDTH = new BorderWidthProperty(BORDER_TOP_WIDTH_PROPERTY);
  }

  private String cssName;

  private BorderWidthProperty(String value) {
    this.cssName = value;
  }

  public String getCssName() {
    return cssName;
  }

  public void set(Style s, Length p) {
    s.setProperty(cssName, p.getCssName());

  }
}