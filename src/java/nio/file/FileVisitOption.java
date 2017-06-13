/*
 * Copyright (c) 2007, 2010, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.nio.file;

/**
 * Defines the file tree traversal options.
 *
 * @see Files#walkFileTree
 * @since 1.7
 */

public enum FileVisitOption {
  /**
   * Follow symbolic links.
   */
  FOLLOW_LINKS;
}
