package com.petclinic.services

import com.petclinic.dto.Vet

import groovy.transform.CompileStatic
import io.restassured.response.Response

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_CREATED
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class VetService {

    private final RequestSpecs requestSpecs

    VetService(RequestSpecs requestSpecs) {
        this.requestSpecs = requestSpecs
    }

    List<Vet> getAllVets() {
        //@formatter:off
        Arrays.asList(given()
                .spec(requestSpecs.basicSpec())
        .when()
                .get(Paths.VETS)
        .then()
                .statusCode(SC_OK)
                .extract().as(Vet[].class))
        //@formatter:on
    }

    Vet getVet(int vetId) {
        //@formatter:off
        given()
                .spec(requestSpecs.basicSpec())
                .pathParam('vetId', vetId)
        .when()
                .get(Paths.VET)
        .then()
                .statusCode(SC_OK)
                .extract().response().<Vet>as(Vet)
        //@formatter:on
    }

    Response sentGetVetsRequest(String urlEnding = "") {
        //@formatter:off
        given()
                .spec(requestSpecs.basicSpec())
        .when()
                .get("${Paths.VETS}$urlEnding")
        //@formatter:on
    }

    Vet addVet(Vet requestBody) {
        //@formatter:off
        given()
                .spec(requestSpecs.basicSpec())
                .body(requestBody)
        .when()
                .post(Paths.VETS)
        .then()
                .statusCode(SC_CREATED)
                .extract().response().<Vet> as(Vet)
    }
    //@formatter:on
}
