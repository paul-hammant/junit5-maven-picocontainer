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

import org.junit.jupiter.api.extension.*;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.PicoBuilder;
import org.picocontainer.PicoContainer;
import org.picocontainer.behaviors.Caching;

public class Composition implements ParameterResolver, BeforeAllCallback, BeforeTestExecutionCallback {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        ExtensionContext.Store store = extensionContext.getParent().get().getStore();
        PicoContainer pico = (PicoContainer) store.get("childScope");
        Class<?> type = parameterContext.getParameter().getType();
        Object component = pico.getComponent(type);
        return component != null;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        ExtensionContext.Store store = extensionContext.getParent().get().getStore();
        PicoContainer pico = (PicoContainer) store.get("childScope");
        return pico.getComponent(parameterContext.getParameter().getType());
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        ExtensionContext.Store store = extensionContext.getParent().get().getStore();
        DefaultPicoContainer pico = new DefaultPicoContainer(new Caching());
        if (pico.getComponent("parentScope") == null) {
            store.put("parentScope", pico);
            pico.addComponent(ParentThing.class);
        }
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        ExtensionContext.Store store = extensionContext.getParent().get().getStore();
        PicoContainer parent = (PicoContainer) store.get("parentScope");
        if (parent.getComponent("childScope") == null) {
            DefaultPicoContainer child = new DefaultPicoContainer(new Caching(), parent);
            store.put("childScope", child);
            child.addComponent(ChildThing.class);
        }
    }

}
