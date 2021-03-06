/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package com.example.project;

public class ChildThing {

    private ParentThing parentThing;

    public ChildThing(ParentThing parentThing) {
        this.parentThing = parentThing;
    }

    @Override
    public String toString() {
        return "ChildThing, who's parent is " + parentThing.toString();
    }
}
