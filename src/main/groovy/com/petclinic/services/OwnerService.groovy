package com.petclinic.services


import com.petclinic.dto.Owner
import groovy.transform.CompileStatic

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_CREATED
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class OwnerService {

    private final RequestSpecs requestSpecs

    OwnerService(RequestSpecs requestSpecs) {
        this.requestSpecs = requestSpecs
    }

    List<Owner> getAllOwners() {
        //@formatter:off
        Arrays.asList(given()
                .spec(requestSpecs.basicSpec())
        .when()
                .get(Paths.OWNERS)
        .then()
                .statusCode(SC_OK)
                .extract().as(Owner[].class))
        //@formatter:on
    }

    Owner getOwner(int ownerId) {
        //@formatter:off
        given()
                .spec(requestSpecs.basicSpec())
                .pathParam('ownerId', ownerId)
        .when()
                .get(Paths.OWNER)
        .then()
                .statusCode(SC_OK)
                .extract().response().<Owner>as(Owner)
        //@formatter:on
    }

    Owner addOwner(Owner requestBody) {
        //@formatter:off
        given()
                .spec(requestSpecs.basicSpec())
                .body(requestBody)
        .when()
                .post(Paths.OWNERS)
                .then()
                .statusCode(SC_CREATED)
                .extract().response().<Owner>as(Owner)
        //@formatter:on
    }
}
