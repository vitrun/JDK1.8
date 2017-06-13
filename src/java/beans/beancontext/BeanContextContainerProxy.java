/*
 * Copyright (c) 1998, 2002, Oracle and/or its affiliates. All rights reserved.
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

package java.beans.beancontext;

import java.awt.Container;

/**
 * <p>
 * This interface is implemented by BeanContexts' that have an AWT Container
 * associated with them.
 * </p>
 *
 * @author Laurence P. G. Cable
 * @see java.beans.beancontext.BeanContext
 * @see java.beans.beancontext.BeanContextSupport
 * @since 1.2
 */

public interface BeanContextContainerProxy {

  /**
   * Gets the <code>java.awt.Container</code> associated
   * with this <code>BeanContext</code>.
   *
   * @return the <code>java.awt.Container</code> associated with this <code>BeanContext</code>.
   */
  Container getContainer();
}
