package com.petclinic.config

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder

@Builder
@CompileStatic
class PetClinicApiConfig {

    String baseUrl
}
