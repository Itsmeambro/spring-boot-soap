
> https://howtodoinjava.com/spring-boot/spring-boot-soap-webservice-example/
> endpoint : localhost:port/service/studentDetailsWsdl.wsdl

## Dependancy
    	<dependency>
			<groupId>wsdl4j</groupId>
			<artifactId>wsdl4j</artifactId>
		</dependency>

## Using wsdl file

> https://cxf.apache.org/docs/maven-cxf-codegen-plugin-wsdl-to-java.html

# Code
	<plugin>
	    <groupId>org.apache.cxf</groupId>
	    <artifactId>cxf-codegen-plugin</artifactId>
	    <version>${cxf.version}</version>
	    <executions>
	        <execution>
	            <id>generate-sources</id>
	            <phase>generate-sources</phase>
	            <configuration>
	                <sourceRoot>${project.build.directory}/generated-sources/cxf</sourceRoot>
	                <wsdlOptions>
	                    <wsdlOption>
	                        <wsdl>${basedir}/src/main/resources/myService.wsdl</wsdl>
	                    </wsdlOption>
	                </wsdlOptions>
	            </configuration>
	            <goals>
	                <goal>wsdl2java</goal>
	            </goals>
	        </execution>
	    </executions>
	</plugin>

    		<plugin>
				<groupId>com.sun.xml.ws</groupId>
				<artifactId>jaxws-maven-plugin</artifactId>
				<version>4.0.2</version>
				<executions>
					<execution>
						<goals>
							<goal>wsimport</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<wsdlDirectory>${project.basedir}/src/main/resources/</wsdlDirectory>
					<packageName>com.ambro.soap.ws.client</packageName>
					<sourceDestDir>
						${project.basedir}/src/main/java
					</sourceDestDir>
				</configuration>
			</plugin>
