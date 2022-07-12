package org.rjs.aem.groovy.console.api.impl

import groovy.transform.TupleConstructor
import org.apache.sling.api.resource.ResourceResolver
import org.rjs.aem.groovy.console.api.JobProperties
import org.rjs.aem.groovy.console.api.context.JobScriptContext

@TupleConstructor
class ScheduledJobScriptContext implements JobScriptContext {

    ResourceResolver resourceResolver

    ByteArrayOutputStream outputStream

    PrintStream printStream

    String jobId

    JobProperties jobProperties

    @Override
    String getScript() {
        jobProperties.script
    }

    @Override
    String getData() {
        jobProperties.data
    }

    @Override
    String getUserId() {
        resourceResolver.userID
    }
}
