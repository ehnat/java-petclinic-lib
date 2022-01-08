package com.petclinic

import com.petclinic.config.PetClinicApiConfig
import com.petclinic.services.OwnerService
import com.petclinic.services.PetService
import com.petclinic.services.RequestSpecs
import com.petclinic.services.VetService
import com.petclinic.services.VisitService

class PetClinicServiceImpl implements PetClinicService {

    private final RequestSpecs requestSpecs

    PetClinicServiceImpl(PetClinicApiConfig apiConfig) {
        this.requestSpecs = new RequestSpecs(apiConfig)
    }

    @Override
    OwnerService getOwnerService() {
        new OwnerService(requestSpecs)
    }

    @Override
    PetService getPetService() {
        new PetService(requestSpecs)
    }

    @Override
    VetService getVetService() {
        new VetService(requestSpecs)
    }

    @Override
    VisitService getVisitService() {
        new VisitService(requestSpecs)
    }
}
