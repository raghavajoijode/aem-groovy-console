package org.rjs.aem.groovy.console.api

import org.rjs.aem.groovy.console.utils.GroovyScriptUtils
import groovy.transform.Memoized
import groovy.transform.TupleConstructor
import org.apache.sling.event.jobs.Job
import org.rjs.aem.groovy.console.constants.GroovyConsoleConstants

@TupleConstructor
class ActiveJob {

    Job job

    String getFormattedStartTime() {
        job.processingStarted.format(GroovyConsoleConstants.DATE_FORMAT_DISPLAY)
    }

    String getId() {
        job.id
    }

    String getTitle() {
        jobProperties.jobTitle
    }

    String getDescription() {
        jobProperties.jobDescription
    }

    String getScript() {
        GroovyScriptUtils.getScriptPreview(jobProperties.script)
    }

    @Memoized
    JobProperties getJobProperties() {
        JobProperties.fromJob(job)
    }
}
