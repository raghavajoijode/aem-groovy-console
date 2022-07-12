# AEM Groovy Console

## Changes
- Plugin 'groovy-eclipse-compiler' upgrated to 3.7.0 from 3.4.0-01
- Plugin 'groovy-eclipse-batch' upgrated to 3.0.8-01 from 2.4.17-01
- Dependency 'org.codehaus.groovy:groovy-all:2.4.15' removed
- Dependency 'org.ow2.asm:[asm, asm-tree, asm-commons, asm-analysis, asm-util]:9.2' added
- Dependency 'org.apache.aries.spifly:org.apache.aries.spifly.dynamic.bundle:1.3.4' added
- Dependency 'org.apache.sling:org.apache.sling.scripting.groovy:1.2.0' added
- Dependency 'org.codehaus.groovy:[groovy, groovy-templates, groovy-json, groovy-all(pom)]:3.0.11' added
- Dependency 'org.spockframework:spock-core:2.2-M1-groovy-3.0' test framework added

- Dependency 'com.icfolson.aem.groovy.extension:aem-groovy-extension-bundle:7.0.0' removed and merged into current project
- Removed embeds from 'all' module, since dependencies are merged into current bundle
- Downgraded vesion of 'org.osgi.service.event' from 1.4.0 to 1.3.1

- AbstractJsonResponseServlet is changed from groovy to java file, since I had issues with JsonBuilder
- Date.format - TODO
