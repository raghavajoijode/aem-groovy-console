package org.cid15.aem.groovy.console.extension.services.impl

import groovy.transform.Synchronized
import groovy.util.logging.Slf4j
import org.cid15.aem.groovy.console.extension.api.MetaClassExtensionProvider
import org.cid15.aem.groovy.console.extension.services.ExtensionService
import org.codehaus.groovy.runtime.InvokerHelper
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Reference
import org.osgi.service.component.annotations.ReferenceCardinality
import org.osgi.service.component.annotations.ReferencePolicy

import java.util.concurrent.CopyOnWriteArrayList

/**
 * This default extension service exposes the set of registered metaclasses while providing for the binding and
 * unbinding of metaclass providers.
 */
@Component(service = ExtensionService, immediate = true)
@Slf4j("LOG")
class DefaultExtensionService implements ExtensionService {

    private volatile List<MetaClassExtensionProvider> metaClassExtensionProviders = new CopyOnWriteArrayList<>()

    @Override
    Set<Class> getMetaClasses() {
        def metaClasses = [] as LinkedHashSet

        metaClassExtensionProviders.each { provider ->
            metaClasses.addAll(provider.metaClasses.keySet())
        }

        metaClasses
    }

    @Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    @Synchronized
    void bindMetaClassExtensionProvider(MetaClassExtensionProvider extension) {
        metaClassExtensionProviders.add(extension)

        LOG.info("added metaclass extension provider = {}", extension.class.name)

        extension.metaClasses.each { clazz, metaClassClosure ->
            clazz.metaClass(metaClassClosure)

            LOG.info("added metaclass for class = {}", clazz.name)
        }
    }

    @Synchronized
    void unbindMetaClassExtensionProvider(MetaClassExtensionProvider extension) {
        metaClassExtensionProviders.remove(extension)

        LOG.info("removed metaclass extension provider = {}", extension.class.name)

        // remove metaclass from registry for each mapped class
        extension.metaClasses.each { clazz, closure ->
            InvokerHelper.metaRegistry.removeMetaClass(clazz)

            LOG.info("removed metaclass for class = {}", clazz.name)

            // ensure that valid metaclasses are still registered
            metaClassExtensionProviders.each {
                def metaClassClosure = it.metaClasses[clazz]

                if (metaClassClosure) {
                    LOG.info("retaining metaclass for class = {} from service = {}", clazz.name, it.class.name)

                    clazz.metaClass(metaClassClosure)
                }
            }
        }
    }
}
