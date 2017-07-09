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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(Composition.class)
class FirstTest {

	private ChildThing child;

	public FirstTest(ChildThing child) {
		this.child = child;
	}

	@Test
	@DisplayName("My 1st JUnit 5 and Maven and PicoContainer 😎")
	void myFirstTest() {
		assertThat(child.toString(), equalTo("ChildThing, who's parent is ParentThing"));
	}

}
