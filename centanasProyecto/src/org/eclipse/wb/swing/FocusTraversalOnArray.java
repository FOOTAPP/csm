/*******************************************************************************
 * Copyright (c) 2011 Google, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Google, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.wb.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

/**
 * Cyclic focus traversal policy based on array of components.
 * <p>
 * This class may be freely distributed as part of any application or plugin.
 * 
 * @author scheglov_ke
 */
public class FocusTraversalOnArray extends FocusTraversalPolicy {
	
	/** The m components. */
	private final Component m_Components[];
	////////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	/**
	 * Instantiates a new focus traversal on array.
	 *
	 * @param components
	 *            the components
	 */
	////////////////////////////////////////////////////////////////////////////
	public FocusTraversalOnArray(Component components[]) {
		m_Components = components;
	}
	////////////////////////////////////////////////////////////////////////////
	//
	// Utilities
	//
	/**
	 * Index cycle.
	 *
	 * @param index
	 *            the index
	 * @param delta
	 *            the delta
	 * @return the int
	 */
	////////////////////////////////////////////////////////////////////////////
	private int indexCycle(int index, int delta) {
		int size = m_Components.length;
		int next = (index + delta + size) % size;
		return next;
	}
	
	/**
	 * Cycle.
	 *
	 * @param currentComponent
	 *            the current component
	 * @param delta
	 *            the delta
	 * @return the component
	 */
	private Component cycle(Component currentComponent, int delta) {
		int index = -1;
		loop : for (int i = 0; i < m_Components.length; i++) {
			Component component = m_Components[i];
			for (Component c = currentComponent; c != null; c = c.getParent()) {
				if (component == c) {
					index = i;
					break loop;
				}
			}
		}
		// try to find enabled component in "delta" direction
		int initialIndex = index;
		while (true) {
			int newIndex = indexCycle(index, delta);
			if (newIndex == initialIndex) {
				break;
			}
			index = newIndex;
			//
			Component component = m_Components[newIndex];
			if (component.isEnabled() && component.isVisible() && component.isFocusable()) {
				return component;
			}
		}
		// not found
		return currentComponent;
	}
	////////////////////////////////////////////////////////////////////////////
	//
	// FocusTraversalPolicy
	//
	/* (non-Javadoc)
	 * @see java.awt.FocusTraversalPolicy#getComponentAfter(java.awt.Container, java.awt.Component)
	 */
	////////////////////////////////////////////////////////////////////////////
	public Component getComponentAfter(Container container, Component component) {
		return cycle(component, 1);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.FocusTraversalPolicy#getComponentBefore(java.awt.Container, java.awt.Component)
	 */
	public Component getComponentBefore(Container container, Component component) {
		return cycle(component, -1);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.FocusTraversalPolicy#getFirstComponent(java.awt.Container)
	 */
	public Component getFirstComponent(Container container) {
		return m_Components[0];
	}
	
	/* (non-Javadoc)
	 * @see java.awt.FocusTraversalPolicy#getLastComponent(java.awt.Container)
	 */
	public Component getLastComponent(Container container) {
		return m_Components[m_Components.length - 1];
	}
	
	/* (non-Javadoc)
	 * @see java.awt.FocusTraversalPolicy#getDefaultComponent(java.awt.Container)
	 */
	public Component getDefaultComponent(Container container) {
		return getFirstComponent(container);
	}
}