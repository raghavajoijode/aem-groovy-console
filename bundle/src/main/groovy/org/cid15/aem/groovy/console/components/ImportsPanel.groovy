package org.rjs.aem.groovy.console.components

import org.rjs.aem.groovy.console.api.StarImport
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.Model
import org.apache.sling.models.annotations.injectorspecific.OSGiService
import org.rjs.aem.groovy.console.extension.ExtensionService

@Model(adaptables = Resource)
class ImportsPanel {

    @OSGiService
    private ExtensionService extensionService

    Set<StarImport> getStarImports() {
        extensionService.starImports as TreeSet
    }
}
