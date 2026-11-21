/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core;
import org.eclipse.milo.opcua.stack.core.util.Java8Collections;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.eclipse.milo.opcua.stack.core.util.annotations.Description;

public class StatusCodes extends StatusCodes0 {

  private static final Map<Long, String[]> DESCRIPTIONS;

  static {
    java.util.HashMap<java.lang.Long,java.lang.String[]> descriptions = new HashMap<Long, String[]>();

    for (Field f : StatusCodes.class.getFields()) {
      if (f.isAnnotationPresent(Description.class)) {
        try {
          long code = f.getLong(null);
          String name = f.getName();
          String desc = f.getAnnotation(Description.class).value();

          descriptions.put(code, new String[] {name, desc});
        } catch (IllegalAccessException ignored) {
        }
      }
    }

    DESCRIPTIONS = Java8Collections.mapCopyOf(descriptions);
  }

  /**
   * Lookup information about a StatusCode.
   *
   * @param code the code to lookup.
   * @return a String[] where String[0] contains the name and String[1] contains the description.
   */
  public static Optional<String[]> lookup(long code) {
    String[] desc = DESCRIPTIONS.get(code & 0xFFFF0000L);

    return Optional.ofNullable(desc);
  }
}
