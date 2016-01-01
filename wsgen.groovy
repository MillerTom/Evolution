import groovy.io.FileType

def list = []
def sb = new StringBuffer()
def wsdlCount = 0
def wsdlSuccess = 0
def wsdlFailed = 0

def classPath = project.session.currentProject.compileClasspathElements.join(";")

def dir = new File(project.properties.srcDir)
dir.eachFileRecurse (FileType.FILES) { 
	if(it.name.endsWith('EndpointImpl.java')) { 
        list << it
    }
}

list.each {
  def file = it.path
  
  def sei = it.path.substring(project.properties.srcDir.length()+1, it.path.length()-5)
  sei = sei.replace('\\', '.')
  def wsdlDir = project.build.directory + "/wsdl"
  def wsgenDir = project.build.directory + "/generated-sources/wsgen"
  
  new File(wsdlDir).mkdirs()
  new File(wsgenDir).mkdirs()
    
  def ant = new AntBuilder() // create an antbuilder
  ant.exec(outputproperty:"cmdOut",
  errorproperty: "cmdErr",
  resultproperty:"cmdExit",
  failonerror: "false",
  executable: 'wsgen') {
  	arg(line:sei + " -wsdl -cp " + classPath + " -r " + wsdlDir + " -s " + wsgenDir + " -d " + wsgenDir)
  }
  
  wsdlCount++
  
  if ("${ant.project.properties.cmdExit}" == "1") {
    sb.append(sei).append("\n")
    sb.append("${ant.project.properties.cmdOut}").append("\n")
    wsdlFailed++
  } else {
    wsdlSuccess++
  }
}

log.info ("Total " + wsdlCount + " WSDLs (success:" + wsdlSuccess + ", failed: " + wsdlFailed + ")")

if (sb.length() > 0) {
  log.error ("Failed to generate WSDLs for the following:")
  log.error (sb.toString())
 }
