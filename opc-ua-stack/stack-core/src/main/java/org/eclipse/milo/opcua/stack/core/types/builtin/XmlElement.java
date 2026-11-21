/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types.builtin;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public final class XmlElement {
  private final @Nullable String fragment;

  public @Nullable String fragment() {
    return fragment;
  }

  public XmlElement(@Nullable String fragment) {
    this.fragment = fragment;
  }


  public static XmlElement NULL_VALUE = XmlElement.of(null);

  public @Nullable String getFragment() {
    return fragment;
  }

  public String getFragmentOrEmpty() {
    return fragment != null ? fragment : "";
  }

  public static XmlElement of(@Nullable String fragment) {
    return new XmlElement(fragment);
  }

  public boolean isNull() {
    return fragment == null;
  }

  public boolean isNotNull() {
    return !isNull();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof XmlElement)) return false;
    XmlElement other = (XmlElement) o;
    return java.util.Objects.equals(fragment, other.fragment);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(fragment);
  }

  @Override
  public String toString() {
    return "XmlElement[" + fragment + "]";
  }
}
