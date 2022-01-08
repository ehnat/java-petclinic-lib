package com.petclinic

import com.petclinic.config.PetClinicApiConfig
import groovy.transform.CompileStatic

@CompileStatic
class PetClinicServiceFactory {

    static PetClinicService defaultService(PetClinicApiConfig config){
        new PetClinicServiceImpl(config)
    }
}