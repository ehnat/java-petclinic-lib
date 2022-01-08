package com.petclinic

import com.petclinic.services.OwnerService
import com.petclinic.services.PetService
import com.petclinic.services.VetService
import com.petclinic.services.VisitService

interface PetClinicService {

    OwnerService getOwnerService()

    PetService getPetService()

    VetService getVetService()

    VisitService getVisitService()
}