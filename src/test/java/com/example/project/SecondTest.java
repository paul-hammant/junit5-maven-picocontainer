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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(Composition.class)
class SecondTest {

	@Test
	@DisplayName("My 2nd JUnit 5 and Maven and PicoContainer 😎")
	void myFirstTest(ChildThing child) {
		assertThat(child.toString(), equalTo("ChildThing, who's parent is ParentThing"));
	}

}
