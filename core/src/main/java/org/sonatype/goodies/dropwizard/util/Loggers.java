/*
 * Copyright (c) 2018-present Sonatype, Inc. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package org.sonatype.goodies.dropwizard.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Logger utilities.
 *
 * For use in place of {@link LoggerFactory#getLogger(Class)} when target type is expected to be potentially AOP adapted.
 *
 * @since 1.0.0
 */
public final class Loggers
{
  private Loggers() {
    // empty
  }

  /**
   * Helper to create a logger and deal with class-names created by AOP platforms.
   */
  public static Logger getLogger(final Class type) {
    checkNotNull(type);
    return LoggerFactory.getLogger(GuiceEnhanced.dereference(type));
  }

  public static Logger getLogger(final Object obj) {
    checkNotNull(obj);
    return getLogger(obj.getClass());
  }

  public static Logger getLogger(final String name) {
    checkNotNull(name);
    return LoggerFactory.getLogger(name);
  }
}
