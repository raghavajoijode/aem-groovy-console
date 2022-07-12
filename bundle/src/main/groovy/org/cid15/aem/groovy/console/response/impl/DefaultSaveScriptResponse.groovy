package org.rjs.aem.groovy.console.response.impl

import groovy.transform.Immutable
import org.rjs.aem.groovy.console.response.SaveScriptResponse

@Immutable
class DefaultSaveScriptResponse implements SaveScriptResponse {

    String scriptName
}
