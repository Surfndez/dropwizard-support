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
package org.sonatype.goodies.dropwizard.security;

import javax.annotation.Nullable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * User-name helper.
 *
 * @since 1.0.0
 */
@Deprecated
public final class UsernameHelper
{
  private UsernameHelper() {
    // empty
  }

  /**
   * Extract user-name from given subject.
   *
   * @deprecated Use {@link SubjectHelper#getUsername(Subject)} instead.
   */
  @Nullable
  @Deprecated
  public static String get(@Nullable final Subject subject) {
    if (subject != null) {
      Object principal = subject.getPrincipal();
      if (principal != null) {
        return principal.toString();
      }
    }
    return null;
  }

  /**
   * Extract user-name from current subject.
   *
   * @deprecated Use {@link SubjectHelper#getUsername()}
   */
  @Nullable
  @Deprecated
  public static String get() {
    return get(SecurityUtils.getSubject());
  }
}
