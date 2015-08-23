/*
 * Copyright 2015 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.nbmindmap.utils;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.apache.commons.io.IOUtils;

public enum Icons {
  DOCUMENT("document16.png"),
  EXPORT("export16.png"),
  IMAGE("image16.png"),
  EXPANDALL("toggle_expand16.png"),
  COLLAPSEALL("toggle16.png"),
  EDITTEXT("text16.png"),
  ADD("add16.png"),
  SOURCE("source16.png"),
  TOPIC("brick16.png"),
  INFO("info16.png"),
  NOTE("note16.png"),
  URL("url16.png"),
  DELETE("delete16.png"),
  OPTIONS("settings16.png"),
  BLUEBALL("blueball16.png"),
  GOLDBALL("goldball16.png"),
  FILE("disk16.png");

  private final ImageIcon icon;

  public ImageIcon getIcon(){
    return this.icon;
  }
  
  private Icons(final String name) {
    final InputStream in = ScalableIcon.class.getClassLoader().getResourceAsStream("com/igormaznitsa/nbmindmap/icons/" + name);
    try {
      this.icon = new ImageIcon(ImageIO.read(in));
    }
    catch (IOException ex) {
      throw new Error("Can't load icon " + name, ex);
    }
    finally {
      IOUtils.closeQuietly(in);
    }
  }
}