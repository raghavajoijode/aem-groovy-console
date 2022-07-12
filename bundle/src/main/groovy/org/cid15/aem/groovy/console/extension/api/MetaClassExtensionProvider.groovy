package org.rjs.aem.groovy.console.extension.api

/**
 * Services may implement this interface to register additional Groovy metaclasses in the OSGi container.
 */
interface MetaClassExtensionProvider {

    /**
     * Get a map containing classes with a closure that defines a metaclass.
     *
     * @return map of classes and their associated metaclass closure
     */
    Map<Class, Closure> getMetaClasses()
}
